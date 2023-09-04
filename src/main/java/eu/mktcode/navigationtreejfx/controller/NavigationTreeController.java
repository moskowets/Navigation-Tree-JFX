package eu.mktcode.navigationtreejfx.controller;

import eu.mktcode.navigationtreejfx.common.DateFormatter;
import eu.mktcode.navigationtreejfx.model.menu.MenuItems;
import eu.mktcode.navigationtreejfx.model.service.ResultGenerator;
import eu.mktcode.navigationtreejfx.view.ValidatedDatePicker;
import eu.mktcode.navigationtreejfx.view.ValidatedTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import static eu.mktcode.navigationtreejfx.NavigationTreeBundleKeys.*;

public class NavigationTreeController implements Initializable {

    @FXML
    private ListView<String> menuPanel;

    @FXML
    private Group dataInputPanel;
    @FXML
    private ValidatedDatePicker inputDate;
    @FXML
    private ValidatedTextField inputName;
    @FXML
    private Label nameLabelText;
    @FXML
    private Label dateLabelText;

    @FXML
    private Group resultPanel;
    @FXML
    private Label resultText;

    private LocalDate minDateConstraint;
    private final DateFormatter dateFormatter = new DateFormatter();
    private final ResultGenerator resultGenerator = new ResultGenerator();
    private final Logger logger = LoggerFactory.getLogger(ResultGenerator.class);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readParameters(resourceBundle);
        addTooltips(resourceBundle);
        loadMenu(resourceBundle);
        setConstraints(resourceBundle);
    }

    private void readParameters(ResourceBundle resourceBundle) {
        minDateConstraint = LocalDate.parse(INPUT_DATE_MIN_DATE_KEY.getValue(resourceBundle),
                DateTimeFormatter.ofPattern(INPUT_DATE_MIN_DATE_FORMAT_KEY.getValue(resourceBundle)));
        logger.info("Parameters reading completed");
    }

    private void setConstraints(ResourceBundle resourceBundle) {
        inputName.setTextRegexp(Pattern.compile(INPUT_NAME_REGEXP_KEY.getValue(resourceBundle)));
        inputDate.setCheckDate((oldValue, newValue)-> {
            if (newValue != null) {
                return (newValue.isAfter(minDateConstraint) && newValue.isBefore(LocalDate.now()));
            }
            return true;
        });
        logger.info("Constraints setting completed");
    }

    private void addTooltips(ResourceBundle resourceBundle) {
        String inputDateTooltipText = String.format(INPUT_DATE_TOOLTIP_KEY.getValue(resourceBundle),
                dateFormatter.toMediumDate(minDateConstraint));
        addTooltip(inputDateTooltipText, inputDate, dateLabelText);
        addTooltip(INPUT_NAME_TOOLTIP_KEY.getValue(resourceBundle), inputName, nameLabelText);
        logger.info("Tooltips adding completed");
    }

    private void addTooltip(String tooltipText, Node... nodes) {
        Tooltip tooltip = new Tooltip(tooltipText);
        for (Node node: nodes) {
            Tooltip.install(node, tooltip);
        }
    }

    private void loadMenu(ResourceBundle resourceBundle) {
        Gson gson = new Gson();
        MenuItems menuItems = gson.fromJson(MENU_ITEMS_NAMES_KEY.getValue(resourceBundle), MenuItems.class);
        //didn't use "of", because sorted map needed
        Map<String, Group> menuMap = new TreeMap<>();
        menuMap.put(menuItems.getDataInputMenu(), dataInputPanel);
        menuMap.put(menuItems.getResultMenu(), resultPanel);
        Map<String, Consumer<ResourceBundle>> onMenuActionMap = Map.of(
                menuItems.getDataInputMenu(), bundle -> logger.info("Input panel opened"),
                menuItems.getResultMenu(), bundle -> {
                    onResultMenuClick(bundle);
                    logger.info("Result panel opened");
                });
        menuPanel.getItems().addAll(menuMap.keySet());
        menuPanel.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            String currentMenuName = menuPanel.getSelectionModel().getSelectedItem();
            Group currentPanel = menuMap.get(currentMenuName);
            menuMap.values().forEach(group -> group.setVisible(false));
            onMenuActionMap.get(currentMenuName).accept(resourceBundle);
            currentPanel.setVisible(true);
        });
        logger.info("Menu loaded");
    }

    private void onResultMenuClick(ResourceBundle bundle) {
        if (inputDate.isLastValueValid() && inputName.isLastValueValid()) {
            resultText.setText(resultGenerator.processValidResult(bundle, inputName.getText(), inputDate.getValue()));
        } else {
            resultText.setText(resultGenerator.processInvalidResult(bundle));
        }
    }
}
package eu.mktcode.navigationtreejfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static eu.mktcode.navigationtreejfx.NavigationTreeBundleKeys.STAGE_TITLE_KEY;


public class NavigationTreeApplication extends Application {

    private static final String NAVIGATION_TREE_VIEW_FXML = "navigation-tree-view.fxml";
    private static final String NAVIGATION_TREE_VIEW_STYLE_SHEET = "navigation-tree-view.css";
    private static final String NAVIGATION_TREE_VIEW_RESOURCE_BUNDLE = "eu.mktcode.navigationtreejfx.view.navigation-tree-view";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NavigationTreeApplication.class.getResource(NAVIGATION_TREE_VIEW_FXML));
        ResourceBundle resourceBundle = ResourceBundle.getBundle(NAVIGATION_TREE_VIEW_RESOURCE_BUNDLE, Locale.getDefault());
        fxmlLoader.setResources(resourceBundle);
        String navigationTreeViewCSS = NavigationTreeApplication.class.getResource(NAVIGATION_TREE_VIEW_STYLE_SHEET).toExternalForm();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(navigationTreeViewCSS);
        stage.setTitle(STAGE_TITLE_KEY.getValue(resourceBundle));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package eu.mktcode.navigationtreejfx.view;

import javafx.scene.Node;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.function.BiPredicate;

public class ValidatedDatePicker extends DatePicker implements Validatable<LocalDate> {

    private boolean isLastValueValid = false;
    private BiPredicate<LocalDate, LocalDate> checkDate;

    public ValidatedDatePicker() {
        this.valueProperty().addListener(this::getListenerConsumer);
    }


    @Override
    public Node getNode() {
        return this;
    }

    @Override
    public boolean isValid(LocalDate oldValue, LocalDate newValue) {
        if (checkDate != null) {
            isLastValueValid = checkDate.test(oldValue, newValue);
            return isLastValueValid;
        }
        return true;
    }

    @Override
    public boolean isLastValueValid() {
        return isLastValueValid;
    }

    public void setCheckDate(BiPredicate<LocalDate, LocalDate> checkDate) {
        this.checkDate = checkDate;
    }
}

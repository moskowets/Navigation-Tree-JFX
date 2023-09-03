package eu.mktcode.navigationtreejfx.view;

import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class ValidatedTextField extends TextField implements Validatable<String> {

    private Pattern textRegexp;
    private boolean isLastValueValid = false;

    public ValidatedTextField() {
        textProperty().addListener(this::getListenerConsumer);
    }

    @Override
    public Node getNode() {
        return this;
    }

    @Override
    public boolean isValid(String oldValue, String newValue) {
        if (textRegexp != null) {
            isLastValueValid = textRegexp.matcher(newValue).matches();
            return isLastValueValid;
        }
        return true;
    }

    @Override
    public boolean isLastValueValid() {
        return isLastValueValid;
    }

    public void setTextRegexp(Pattern textRegexp) {
        this.textRegexp = textRegexp;
    }
}

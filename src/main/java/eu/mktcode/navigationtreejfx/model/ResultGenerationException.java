package eu.mktcode.navigationtreejfx.model;

import java.util.ResourceBundle;

public class ResultGenerationException extends RuntimeException {

    private static ResourceBundle resourceBundle;

    public ResultGenerationException(String cause) {
        super(cause);
    }

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle(ResultGenerationException.class.getName());
        }
        return resourceBundle;
    }
}

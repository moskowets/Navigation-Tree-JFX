package eu.mktcode.navigationtreejfx.model.service.exception;

import java.util.ResourceBundle;

/**
 * Exception class for ResultGenerator service.
 * Exception description are stored in resource bundle and will be loaded using lazy initialization.
 *
 * @author Pavlo Moskovets
 */
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

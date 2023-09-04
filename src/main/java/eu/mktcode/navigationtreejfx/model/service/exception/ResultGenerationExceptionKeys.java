package eu.mktcode.navigationtreejfx.model.service.exception;

import java.util.ResourceBundle;

/**
 * Enum where are stored the keys for ResultGenerationException resource bundle.
 *
 * @author Pavlo Moskovets
 */
public enum ResultGenerationExceptionKeys {

    RESOURCE_BUNDLE_NULL("resourceBundleNullText"),
    NAME_NULL("nameNullText"),
    DATE_NULL("dateNullText");

    private String key;

    ResultGenerationExceptionKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue(ResourceBundle resourceBundle) {
        return resourceBundle.getString(key);
    }

}

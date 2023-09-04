package eu.mktcode.navigationtreejfx.model.exception;

import java.util.ResourceBundle;

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

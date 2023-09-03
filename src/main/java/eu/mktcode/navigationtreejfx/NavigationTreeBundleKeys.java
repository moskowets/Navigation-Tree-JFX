package eu.mktcode.navigationtreejfx;

import java.util.ResourceBundle;

public enum NavigationTreeBundleKeys {
    STAGE_TITLE_KEY("stageTitle"),
    MENU_ITEMS_NAMES_KEY("menuItemsNames"),
    INPUT_DATE_TOOLTIP_KEY("inputDateTooltip"),
    INPUT_DATE_MIN_DATE_KEY("inputDateMinDate"),
    INPUT_DATE_MIN_DATE_FORMAT_KEY("inputDateMinDateFormat"),
    INPUT_NAME_TOOLTIP_KEY("inputNameTooltip"),
    INPUT_NAME_REGEXP_KEY("inputNameRegexp"),
    RESULT_TEXT_FOR_WRONG_INPUT_DATA_KEY("resultTextForWrongInputData"),
    RESULT_TEXT_FORMAT_KEY("resultTextFormat");

    private String key;

    NavigationTreeBundleKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue(ResourceBundle resourceBundle) {
        return resourceBundle.getString(key);
    }
}

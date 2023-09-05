module eu.mktcode.navigationtreejfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.slf4j;

    opens eu.mktcode.navigationtreejfx to javafx.fxml;
    exports eu.mktcode.navigationtreejfx;
    exports eu.mktcode.navigationtreejfx.controller;
    opens eu.mktcode.navigationtreejfx.controller to javafx.fxml, com.google.gson;
    exports eu.mktcode.navigationtreejfx.view to javafx.fxml;
    opens eu.mktcode.navigationtreejfx.model.service.exception to com.google.gson;
    opens eu.mktcode.navigationtreejfx.model.service to com.google.gson;
    opens eu.mktcode.navigationtreejfx.model.menu to com.google.gson;
    exports eu.mktcode.navigationtreejfx.model.service;
}
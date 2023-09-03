package eu.mktcode.navigationtreejfx.view;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

public interface Validatable<T> {
    String RED_BORDER_STYLE_CLASS = "not-valid-field";

    Node getNode();
    boolean isValid(T oldValue, T newValue);
    boolean isLastValueValid();

    default void getListenerConsumer(ObservableValue<? extends T> observableValue, T oldValue, T newValue) {
        if (isValid(oldValue, newValue)) {
            getNode().getStyleClass().remove(RED_BORDER_STYLE_CLASS);
        } else {
            if (!getNode().getStyleClass().contains(RED_BORDER_STYLE_CLASS)) {
                getNode().getStyleClass().add(RED_BORDER_STYLE_CLASS);
            }
        }
    }
}

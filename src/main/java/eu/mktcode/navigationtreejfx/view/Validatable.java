package eu.mktcode.navigationtreejfx.view;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

/**
 * Interface used to extend standard controls with field validation.
 * It highlights with a red colour the border of input field, if input value ist not valid
 *
 * @author Pavlo Moskovets
 *
 * @param <T> type of input value
 */
public interface Validatable<T> {
    String RED_BORDER_STYLE_CLASS = "not-valid-field";

    /**
     * @return the current control
     */
    Node getNode();

    /**
     * In this function is required to implement predicate, is new value valid or not.
     *
     * @param oldValue of the input field
     * @param newValue of the input field
     * @return predicate based on values
     */
    boolean isValid(T oldValue, T newValue);

    /**
     * Used by other classes to query validity status
     *
     * @return <code>true</code> if last entered value was valid, otherwise <code>false</code>
     */
    boolean isLastValueValid();

    /**
     * Function is used as a listener consumer of the input field.
     * When the value changes it changes the colour of the field border.
     *
     * @param oldValue of the input field
     * @param newValue of the input field
     */
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

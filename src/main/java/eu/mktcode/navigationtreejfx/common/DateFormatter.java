package eu.mktcode.navigationtreejfx.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Utility class used to get simple access to format a date using German locale
 *
 * @author Pavlo Moskovets
 */
public class DateFormatter {

    /**
     * @param date date value to format
     * @return string represents the date in German format DD.MM.YYYY
     */
    public String toMediumDate(LocalDate date) {
        //German required by the task
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN).format(date);
    }
}
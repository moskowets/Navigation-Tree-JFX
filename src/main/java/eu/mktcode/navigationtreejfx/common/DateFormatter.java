package eu.mktcode.navigationtreejfx.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatter {

    public String toMediumDate(LocalDate date) {
        //German required by the task
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN).format(date);
    }
}
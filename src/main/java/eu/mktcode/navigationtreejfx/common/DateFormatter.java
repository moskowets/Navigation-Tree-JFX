package eu.mktcode.navigationtreejfx.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatter {
    public String toMediumDate(LocalDate date) {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()).format(date);
    }
}

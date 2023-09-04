package eu.mktcode.navigationtreejfx.model.service;

import eu.mktcode.navigationtreejfx.common.DateFormatter;
import eu.mktcode.navigationtreejfx.model.exception.ResultGenerationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ResourceBundle;

import static eu.mktcode.navigationtreejfx.NavigationTreeBundleKeys.RESULT_TEXT_FORMAT_KEY;
import static eu.mktcode.navigationtreejfx.NavigationTreeBundleKeys.RESULT_TEXT_FOR_WRONG_INPUT_DATA_KEY;
import static eu.mktcode.navigationtreejfx.model.exception.ResultGenerationExceptionKeys.*;

public class ResultGenerator {

    private final DateFormatter dateFormatter = new DateFormatter();
    private final Logger logger = LoggerFactory.getLogger(ResultGenerator.class);

    public String processValidResult(ResourceBundle resourceBundle, String name, LocalDate date) {
        if (resourceBundle == null) {
            final String exceptionText = RESOURCE_BUNDLE_NULL.getValue(ResultGenerationException.getResourceBundle());
            logger.warn(exceptionText);
            throw new ResultGenerationException(exceptionText);
        }
        if (name == null) {
            final String exceptionText = NAME_NULL.getValue(ResultGenerationException.getResourceBundle());
            logger.warn(exceptionText);
            throw new ResultGenerationException(exceptionText);
        }
        if (date == null) {
            final String exceptionText = DATE_NULL.getValue(ResultGenerationException.getResourceBundle());
            logger.warn(exceptionText);
            throw new ResultGenerationException(exceptionText);
        }
        final String result = String.format(RESULT_TEXT_FORMAT_KEY.getValue(resourceBundle), name,
                dateFormatter.toMediumDate(date));
        logger.info("Processed valid result: {}", result);
        return result;
    }

    public String processInvalidResult(ResourceBundle resourceBundle) {
        if (resourceBundle == null) {
            final String exceptionText = RESOURCE_BUNDLE_NULL.getValue(ResultGenerationException.getResourceBundle());
            logger.warn(exceptionText);
            throw new ResultGenerationException(exceptionText);
        }
        final String result = RESULT_TEXT_FOR_WRONG_INPUT_DATA_KEY.getValue(resourceBundle);
        logger.info("Processed invalid result: {}", result);
        return result;
    }
}

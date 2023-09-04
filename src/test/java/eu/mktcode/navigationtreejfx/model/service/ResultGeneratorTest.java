package eu.mktcode.navigationtreejfx.model.service;

import eu.mktcode.navigationtreejfx.model.exception.ResultGenerationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import static eu.mktcode.navigationtreejfx.NavigationTreeBundleKeys.RESULT_TEXT_FORMAT_KEY;
import static eu.mktcode.navigationtreejfx.NavigationTreeBundleKeys.RESULT_TEXT_FOR_WRONG_INPUT_DATA_KEY;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ResultGeneratorTest {

    private static final String defaultName = "Marco Reus";
    private static final LocalDate defaultDate = LocalDate.of(1991, 12, 12);
    private static final ResourceBundle defaultBundle = new ListResourceBundle() {
        @Override
        protected Object[][] getContents() {
            return new Object[0][];
        }
    };
    private final ResultGenerator resultGenerator = new ResultGenerator();
    @Mock
    private ResourceBundle mockBundle;

    @ParameterizedTest
    @MethodSource("processValidResult_throwsResultGenerationException_inputNull_arguments")
    void processValidResult_throwsResultGenerationException_inputNull(ResourceBundle resourceBundle, String name, LocalDate date) {

        assertThrows(ResultGenerationException.class, () -> resultGenerator.processValidResult(resourceBundle, name, date));
    }

    private static Stream<Arguments> processValidResult_throwsResultGenerationException_inputNull_arguments() {
        return Stream.of(Arguments.of(defaultBundle, defaultName, null),
                Arguments.of(defaultBundle, null, defaultDate),
                Arguments.of(null, defaultName, defaultDate),
                Arguments.of(defaultBundle, null, null),
                Arguments.of(null, null, defaultDate),
                Arguments.of(null, defaultName, null),
                Arguments.of(null, null, null));
    }

    @Test
    void processValidResult_returnsFormattedString_inputNotNull() {
        String format = "%s on %s";
        String expected = "Marco Reus on 12.12.1991";
        Mockito.when(mockBundle.getString(RESULT_TEXT_FORMAT_KEY.getKey())).thenReturn(format);
        String actual = resultGenerator.processValidResult(mockBundle, defaultName, defaultDate);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullSource
    void processInvalidResult_throwsResultGenerationException_inputNull(ResourceBundle resourceBundle) {

        assertThrows(ResultGenerationException.class, () -> resultGenerator.processInvalidResult(resourceBundle));
    }

    @Test
    void processInvalidResult_returnsFormattedString_inputNotNull() {
        String expected = "neg result";
        Mockito.when(mockBundle.getString(RESULT_TEXT_FOR_WRONG_INPUT_DATA_KEY.getKey())).thenReturn(expected);
        String actual = resultGenerator.processInvalidResult(mockBundle);
        assertSame(expected, actual);
    }

}

package hometask.testing.roman_numbner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static hometask.testing.roman_numbner.RomanNumber.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class RomanNumberTest {
    private RomanNumber romanNumberConvert;

    @BeforeEach
    void init() {
        romanNumberConvert = new RomanNumber();

    }

    @Test
    void throwExceptionIfRomanStringIsEmpty() {
        try {
            romanNumberConvert.romanToInt("   ");
            fail("Parameter in method \'romanToInt\' is empty ");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void throwExceptionIfRomanStringLenghtNotRange() {
        try {
            romanNumberConvert.romanToInt("I".repeat(16));
            fail("Lenght must be between " + MIN_LENGHT_NUMBER + " to " + MAX_LENGHT_NUMBER);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void throwExceptionIfNumeralNotInRange() {
        try {
            romanNumberConvert.romanToInt("MMMM");
            fail("Numeric must be between " + MIN_VALUE_NUMBER + " and " + MAX_VALUE_NUMBER);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    private static Stream<Arguments> trueConvertNumber() {
        return Stream.of(
                arguments("III", 3),
                arguments("IV", 4),
                arguments("LVIII", 58),
                arguments("XIX", 19),
                arguments("DLV", 555),
                arguments("MCXI", 1111),
                arguments("MMLXXX", 2080),
                arguments("MCMXCIV", 1994),
                arguments("MCLXXXVIII", 1188),
                arguments("MMMDCCXXIV", 3724)
        );
    }

    @ParameterizedTest
    @MethodSource("trueConvertNumber")
    void romanNumberConvertShouldTrue(String str, int numerical) {
        int expected = numerical;
        int actual = romanNumberConvert.romanToInt(str);
        assertEquals(expected, actual);
    }
}
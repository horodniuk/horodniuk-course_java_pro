package hometask.testing.test_unit_hometask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SimpleArrayLibraryTest {
    SimpleArrayLibrary simpleArrayLibrary;

    @BeforeEach
    void init() {
        simpleArrayLibrary = new SimpleArrayLibrary();
    }

    @Test
    void ThrowExceptionIfNumberNotContainsInArray() {
        assertThrows(RuntimeException.class,
                () -> simpleArrayLibrary.getAllElementsAfterNumber(new int[]{1, 2, 3}, 4));
    }

    private static Stream<Arguments> setNumberInNewArrayIsTrue() {
        return Stream.of(
                Arguments.of(new int[]{4}, 4, new int[]{}),
                Arguments.of(new int[]{1, 4, 3, 4, 5, 6}, 4, new int[]{5, 6}),
                Arguments.of(new int[]{1, 4, 2, 3, 5, 6}, 4, new int[]{2, 3, 5, 6}),
                Arguments.of(new int[]{1, 4, 3, 4, 5, 4}, 4, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("setNumberInNewArrayIsTrue")
    void elementsInArrayShouldTrue(int[] inputArray, int searchNumber, int[] expectedArray) {
        int[] input = simpleArrayLibrary.getAllElementsAfterNumber(inputArray, searchNumber);
        Assertions.assertArrayEquals(expectedArray, input);
    }

    private static Stream<Arguments> numberContainsInArrayRandom() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 4, 4, 1, 4}, 1, 4, true),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, 4, false),
                Arguments.of(new int[]{4, 4, 4, 4}, 1, 4, false),
                Arguments.of(new int[]{4, 1, 1, 1}, 1, 4, true)
        );
    }

    @ParameterizedTest
    @MethodSource("numberContainsInArrayRandom")
    void arrayContainsSearchingNumbersShouldTrue(int[] array, int firstNumber, int secondNumber, boolean isContain) {
        boolean expected = isContain;
        boolean actual = simpleArrayLibrary.isArrayContainsSearchingNumbers(array, firstNumber, secondNumber);
        assertEquals(expected, actual);
    }
}
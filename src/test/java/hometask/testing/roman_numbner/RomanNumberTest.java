package hometask.testing.roman_numbner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumberTest {
    RomanNumber romanNumber;

    @Before
    public void createNewVector() {
        romanNumber = new RomanNumber();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeIllegalArgumentExceptionIfParameterIsEmpty() {
        romanNumber.romanToInt("   ");
    }
}
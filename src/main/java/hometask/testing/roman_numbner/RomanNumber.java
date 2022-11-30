package hometask.testing.roman_numbner;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class RomanNumber {
    private final Map<Character, Integer> romanMap;
    {
        romanMap = new LinkedHashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String romanNumber) {
        requireNonNull(romanNumber, "Parameter in method is null");
        requireStringIsEmpty(romanNumber, "Parameter in method is empty");
        requireStringLenght(romanNumber, 1, 15);
        requireStringIsRomanSymbols(romanNumber);

        int resultConvertRomanToInt = romanMap.get(romanNumber.charAt(romanNumber.length() - 1));
        for (int i = 0; i < romanNumber.length() - 1; i++) {
            int currentNumber = romanMap.get(romanNumber.charAt(i));
            int nextNumber = romanMap.get(romanNumber.charAt(i + 1));
            resultConvertRomanToInt = currentNumber >= nextNumber ?
                    resultConvertRomanToInt + currentNumber : resultConvertRomanToInt - currentNumber;
        }
        requireIsNumeralInRange(resultConvertRomanToInt, 1, 3999);
        return resultConvertRomanToInt;
    }

    private static void requireStringLenght(String str, int minLenght, int maxLenght) {
        if (minLenght > str.length() || str.length() > maxLenght) {
            throw new IllegalArgumentException("Lenght String " + str + " is " + str.length() + " but must be between " + minLenght + " and " + maxLenght);
        }
    }

    private static void requireIsNumeralInRange(int number, int startRange, int endRange) {
        if (number < startRange || number > endRange) {
            throw new IllegalArgumentException("Numeric " + number + "must be between " + startRange + " and " + endRange);
        }
    }

    private static void requireStringIsEmpty(String str, String message) {
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void requireStringIsRomanSymbols(String str) {
        String regEx = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (!m.matches()) {
            throw new IllegalArgumentException(
                    "String \'" + str + "\' must contains only the characters" +
                    " ('I', 'V', 'X', 'L', 'C', 'D', 'M')" +
                    " and  six instances where subtraction is used:\n" +
                    "I can be placed before V (5) and X (10) to make 4 and 9. \n" +
                    "X can be placed before L (50) and C (100) to make 40 and 90. \n" +
                    "C can be placed before D (500) and M (1000) to make 400 and 900.");
        }
    }
};

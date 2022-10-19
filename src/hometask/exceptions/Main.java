package hometask.exceptions;

public class Main {
    public static void main(String[] args) {
        // NumberFormatException
        // IllegalArgumentException
        // RuntimeException
        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println(new ArrayValueCalculator().doCalc(array));
        array[0][0] = "text";
        System.out.println(new ArrayValueCalculator().doCalc(array));

    }
}

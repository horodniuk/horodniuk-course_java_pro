package hometask.exceptions;

import hometask.exceptions.exception.ArrayDataException;
import hometask.exceptions.exception.ArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            System.out.println(new ArrayValueCalculator().doCalc(array));
        } catch (ArrayDataException | ArraySizeException e) {
            e.printStackTrace();
        }
    }
}

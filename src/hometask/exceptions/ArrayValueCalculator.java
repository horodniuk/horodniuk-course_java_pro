package hometask.exceptions;

import hometask.exceptions.exception.ArrayDataException;
import hometask.exceptions.exception.ArraySizeException;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArrayDataException, ArraySizeException {
        checkCorrectSizeByArray(array, 4, 4);
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Cell [" + i + "][" + j + "] contains incorrect data  -->" + array[i][j]);
                }
            }
        }
        return result;
    }

    public void checkCorrectSizeByArray(String[][] array, int row, int col) throws ArraySizeException {
        for (String[] strings : array) {
            if (array.length != row || strings.length != col) {
                throw new ArraySizeException("wrong array size");
            }
        }
    }
}

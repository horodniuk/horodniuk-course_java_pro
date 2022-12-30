package hometask.testing.test_unit_hometask;

import java.util.Arrays;

public class SimpleArrayLibrary {
    public int[] getAllElementsAfterNumber(int[] array, int number) {
        int lenghtNewArray = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == number) {
                lenghtNewArray = array.length - 1 - i;
                break;
            }
        }
        if (lenghtNewArray == -1) {
            throw new RuntimeException("array does not contain searching number");
        }
        int[] newArray = new int[lenghtNewArray];
        System.arraycopy(array, array.length - newArray.length, newArray, 0, newArray.length);
        return newArray;
    }

    public boolean isArrayContainsSearchingNumbers(int[] array, int a, int b) {
        return Arrays.stream(array).anyMatch(x -> x == a) && Arrays.stream(array).anyMatch(x -> x == b);
    }
}

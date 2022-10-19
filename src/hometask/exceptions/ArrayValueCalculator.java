package hometask.exceptions;

public class ArrayValueCalculator {

    public int doCalc(String[][] array) {
        int result = 0;
        for (String[] strings : array) {
            for (String string : strings) {
                result += Integer.parseInt(string);
            }
        }
        return result;
    }
}

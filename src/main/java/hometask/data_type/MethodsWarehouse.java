package hometask.data_type;

public class MethodsWarehouse {
    public void printThreeWords(String str1, String str2, String str3) {
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public void checkSumSign(int a, int b) {
        System.out.println((a + b >= 0) ? "Sum is positive" : "The sum is negative");
    }

    public void printColor(int value) {
        if (value <= 0) {
            System.out.println("Red");
        } else if (value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    public void printCompareNumbers(int a, int b) {
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    public boolean isSumWithinTenFromTwenty(int a, int b) {
        return 10 < a + b && a + b <= 20;
    }

    public void printIsPositiveNumber(int a) {
        System.out.println((a >= 0) ? "positive number" : "negative number");
    }

    public boolean isNegative(int a) {
        return a < 0;
    }

    public void printStringNTimes(String str, int n) {
        System.out.println(str.repeat(n));
    }

    public boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}

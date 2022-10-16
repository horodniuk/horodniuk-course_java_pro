package hometask.data_type;

public class HomeWorkApp {
    public static void main(String[] args) {
        MethodsWarehouse obj = new MethodsWarehouse();

        obj.printThreeWords("Orange", "Banana", "Apple");
        obj.checkSumSign(5, 6);
        obj.printColor(-2);
        obj.printCompareNumbers(-2, 4);
        System.out.println(obj.isSumWithinTenFromTwenty(10, 10));
        obj.printIsPositiveNumber(-10);
        System.out.println(obj.isNegative(-1));
        obj.printStringNTimes("java ", 3);
        System.out.println(obj.isLeapYear(2001));
    }
}

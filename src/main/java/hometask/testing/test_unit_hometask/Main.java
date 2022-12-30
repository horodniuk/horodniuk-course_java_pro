package hometask.testing.test_unit_hometask;

public class Main {
    public static void main(String[] args) {
        TestResult testResult = new TestResultParser().getTestResult("src/test/resources/result_test.txt");
        // new TestResultParser().getTestResultByParseFile(new File("src/test/resources/result_test.txt"));
        System.out.println(testResult);
    }
}

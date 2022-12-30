package hometask.testing.test_unit_hometask;

public class TestResult {
    private int totalTest;
    private int successfullyPassedTests;
    private int failedTests;
    private String timeRunningTests;

    public TestResult(int totalTest, int numberSuccessfullyPassedTests, int failedTests, String timeRunningTests) {
        this.totalTest = totalTest;
        this.successfullyPassedTests = numberSuccessfullyPassedTests;
        this.failedTests = failedTests;
        this.timeRunningTests = timeRunningTests;
    }

    @Override
    public String toString() {
        return "TestResult{" +
               "totalTest=" + totalTest +
               ", successfullyPassedTests=" + successfullyPassedTests +
               ", failedTests=" + failedTests +
               ", timeRunningTests='" + timeRunningTests + '\'' +
               '}';
    }
}

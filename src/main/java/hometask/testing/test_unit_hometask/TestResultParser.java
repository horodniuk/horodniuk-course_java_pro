package hometask.testing.test_unit_hometask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class TestResultParser {
    private static final String PARSE_KEY_TOTAL_TEST = "tests found";
    private static final String PARSE_KEY_SUCCESSFULLY_TEST = "tests successful";
    private static final String PARSE_KEY_FAILED_TEST = "tests failed";
    private static final String PARSE_KEY_TIME_RUNNING_TEST = "Data:";

    TestResult getTestResult(String file) {
        return getTestResult(new File(file));
    }

    TestResult getTestResult(Path path) {
        return getTestResult(new File(String.valueOf(path)));
    }

    TestResult getTestResult(File file) {
        int totalTest = getCountTestByParameter(file, PARSE_KEY_TOTAL_TEST);
        int successfullyPassedTests = getCountTestByParameter(file, PARSE_KEY_SUCCESSFULLY_TEST);
        int failedTests = getCountTestByParameter(file, PARSE_KEY_FAILED_TEST);
        String timeRunningTests = getDateByFirstLineTestFile(file, PARSE_KEY_TIME_RUNNING_TEST);
        return new TestResult(
                totalTest,
                successfullyPassedTests,
                failedTests,
                timeRunningTests);
    }

    private int getCountTestByParameter(File file, String searchParameter) {
        int countTestByParameter = 0;
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line = buffer.readLine();
            while (line != null && !line.isEmpty()) {
                line = buffer.readLine();
                if (line.contains(searchParameter)) {
                    countTestByParameter = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                    return countTestByParameter;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countTestByParameter;
    }

    private String getDateByFirstLineTestFile(File file, String firstLineInTestFile) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line = buffer.readLine();
            return line.replaceAll(firstLineInTestFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "unknown data";
    }
}

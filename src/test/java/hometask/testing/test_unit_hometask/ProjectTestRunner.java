package hometask.testing.test_unit_hometask;

import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;


public class ProjectTestRunner {
    void runTestClassByName(String className) {
        runTestClassesByName(className);
    }

    void runTestClassByType(Class clazz) {
        runTestClassesByType(clazz);
    }

    void runTestClassesByName(String... classNames) {
        final ClassSelector[] classSelectors = Stream.of(classNames)
                .map(DiscoverySelectors::selectClass)
                .toArray(ClassSelector[]::new);
        LauncherDiscoveryRequest request = getLauncherDiscoveryRequest(classSelectors);
        launcherExecution(request);
    }

    void runTestClassesByType(Class... clazzes) {
        final ClassSelector[] classSelectors = Stream.of(clazzes)
                .map(DiscoverySelectors::selectClass)
                .toArray(ClassSelector[]::new);
        LauncherDiscoveryRequest request = getLauncherDiscoveryRequest(classSelectors);
        launcherExecution(request);
    }

    void runTestClassesByPackageName(String packageName) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage(packageName))
                .filters(includeClassNamePatterns(".*Test"))
                .build();
        launcherExecution(request);
    }

    private LauncherDiscoveryRequest getLauncherDiscoveryRequest(ClassSelector[] classSelectors) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(classSelectors)
                .filters(includeClassNamePatterns(".*Test"))
                .build();
        return request;
    }

    private void launcherExecution(LauncherDiscoveryRequest request) {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        printToConsole(summary);
        printToFile(summary);
    }

    private void printToConsole(TestExecutionSummary summary) {
        summary.printTo(new PrintWriter(System.out));
    }

    private void printToFile(TestExecutionSummary summary) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("src/test/resources/result_test.txt"))) {
            printWriter.write("Data:" + formatter.format(LocalDateTime.now()));
            summary.printTo(printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

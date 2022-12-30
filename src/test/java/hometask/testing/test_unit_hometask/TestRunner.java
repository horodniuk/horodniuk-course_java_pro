package hometask.testing.test_unit_hometask;

public class TestRunner {
    public static void main(String[] args) {
        ProjectTestRunner projectTestRunner = new ProjectTestRunner();
        projectTestRunner.runTestClassByName("hometask.testing.test_unit_hometask.SimpleMathLibraryTest");
        //  projectTestRunner.runTestClassesByName("hometask.testing.test_unit_hometask.SimpleMathLibraryTest", "hometask.testing.test_unit_hometask.SimpleArrayLibraryTest");
        //  projectTestRunner.runTestClassByType(SimpleMathLibraryTest.class);
        //  projectTestRunner.runTestClassesByType(SimpleMathLibraryTest.class, SimpleArrayLibraryTest.class);
        //  projectTestRunner.runTestClassesByPackageName("hometask.testing.test_unit_hometask");
    }
}

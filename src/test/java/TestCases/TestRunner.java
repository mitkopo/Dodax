package TestCases;

import org.testng.TestNG;

public class TestRunner {
    static TestNG testNG;

    @SuppressWarnings("deprecation")
    public static void main(String[] args){
        testNG = new TestNG();

        testNG.setTestClasses(new Class[]{Login_tests.class});
        testNG.run();
    }
}

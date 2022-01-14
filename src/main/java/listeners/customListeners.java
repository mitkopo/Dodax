package listeners;

import base.ExtentReporter;
import base.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class customListeners extends baseClass implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporter.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {
        // When test method starts
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // If test method is successful
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        String testMethodName = result.getMethod().getMethodName();

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        // If test method is failed
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Ignore this
    }

    @Override
    public void onStart(ITestContext context) {
        // Before <test> tag of xml file

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

public class ExtentReporter {
    public WebDriver driver;
  public static ExtentReports extent;

    public static ExtentReports getReportObject(){
        String path =System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Dodax Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Mitko Popov");
        return extent;
    }
}

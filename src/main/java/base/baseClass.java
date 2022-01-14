package base;

import PageFactory.dodax.homepagePageFactory;
import PageFactory.dodax.loginPageFactory;
import PageFactory.dodax.shoppingCartPageFactory;
import PageFactory.dodax.wishListPageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class baseClass {

    public static WebDriver driver;
    public Properties prop;
    public ExtentReports extent = ExtentReporter.getReportObject();
    public static ExtentTest test;

    public WebDriver initailizeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:src\\main\\java\\base\\data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:exe\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @BeforeTest

    public void initialize() throws IOException {
        driver = initailizeDriver();
        driver.get(prop.getProperty("url"));
    }

    //private static Logger log = LogManager.getLogger(homePage_test.class.getName());
    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\screenShots\\" + testCaseName + ".png";
        System.out.println(destinationFile);
        File finalDestination = new File(destinationFile);
        FileUtils.copyFile(source, finalDestination);
        return destinationFile;
    }

//    @BeforeSuite(alwaysRun = true)
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
//        driver = new ChromeDriver();
//        String baseURL = "https://www.dodax.ca";
//        driver.get(baseURL);
//        driver.manage().window().maximize();


//    }

    //    Moze da ima 2 before test, edniot so atributi i edniot be atributi;
    @BeforeTest(groups = {"logIn"})
    public void setOff() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        loginPageFactory loginPF = new loginPageFactory(driver);
        shoppingCartPageFactory shoppingPF = new shoppingCartPageFactory(driver);


        homepagePF.signUpButton();
        loginPF.logIn();
        homepagePF.clickWishListButton();
        wishListPF.removeWishListItems();
        wishListPF.waitForEmptyWishList();
        homepagePF.openCart();
        shoppingPF.removeShoppingCartItems();
        loginPF.logOut();

    }


    @AfterTest(alwaysRun = true)
    public void logOut() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        try {
            homepagePF.logOut();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {

        driver.quit();

    }


}

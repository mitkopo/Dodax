package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class baseClass {

    public static WebDriver driver;
    //private static Logger log = LogManager.getLogger(homePage_test.class.getName());


    @BeforeSuite
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://www.dodax.ca";
        driver.get(baseURL);
        driver.manage().window().maximize();

    }

//    @BeforeTest
//    public void setOff(){
//        loginPageFactory loginPF = new loginPageFactory(driver);
//        homepagePageFactory homepagePF = new homepagePageFactory(driver);
//    }

    @AfterSuite
    public  void closeBrowser(){
      //  driver.quit();

    }
}

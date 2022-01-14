package base;

import PageFactory.dodax.homepagePageFactory;
import PageFactory.dodax.loginPageFactory;
import PageFactory.dodax.shoppingCartPageFactory;
import PageFactory.dodax.wishListPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class baseClass {

    public static WebDriver driver;
    //private static Logger log = LogManager.getLogger(homePage_test.class.getName());


    @BeforeSuite
    public void setUp() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        loginPageFactory loginPF = new loginPageFactory(driver);

        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://www.dodax.ca";
        driver.get(baseURL);
        driver.manage().window().maximize();


//        homepagePF.clickCookiesPF();
//        loginPF.clickSignUpForFree();
//        loginPF.logIn();
//        wishListPF.removeWishListItems();
//        loginPF.logOut();
    }

    @BeforeTest
    public void setOff(){
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        loginPageFactory loginPF = new loginPageFactory(driver);
        shoppingCartPageFactory shoppingPF = new shoppingCartPageFactory(driver);

        homepagePF.clickCookiesPF();
        homepagePF.signUpButton();
        loginPF.logIn();
        homepagePF.clickWishListButton();
        wishListPF.removeWishListItems();
        wishListPF.waitForEmptyWishList();
        homepagePF.openCart();
        shoppingPF.removeShoppingCartItems();
        loginPF.logOut();

    }

    @AfterTest
    public void logOut(){
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        try{
            homepagePF.logOut();
        } catch (Exception n) {
            n.printStackTrace();
        }
    }

    @AfterSuite
    public  void closeBrowser(){

        driver.quit();

    }



}

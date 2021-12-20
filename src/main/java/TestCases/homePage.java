package TestCases;

import PageObject.dodax.homepagePageFactory;
import PageObject.dodax.noSearchResultFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class homePage {
    static WebDriver driver;
    private static Logger log = LogManager.getLogger(homePage.class.getName());
    homepagePageFactory homepagePF;
    noSearchResultFactory nosearchPF;


    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://www.dodax.ca";
        homepagePF = new homepagePageFactory(driver);
        nosearchPF = new noSearchResultFactory(driver);
        driver.get(baseURL);
        driver.manage().window().maximize();
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    @Test(priority = 0)
    public void privacyPF() {

        homepagePF.setPrivacyPF();
        Set<Cookie> noCookies = driver.manage().getCookies();
        homepagePF.isLoadedPF();
        Set cookiesBeforeClick = homepagePF.getCookies();
        homepagePF.getCookies();
        homepagePF.windowsHandlessChild();
        homepagePF.clickCookiesPF();
        homepagePF.windowsHandlessParent();
        homepagePF.clickCookiesPF();
        homepagePF.getCookies();

        Set cookiesAfterClick = homepagePF.getCookies();
        Assert.assertNotEquals(cookiesBeforeClick, cookiesAfterClick);

        Set<Cookie> cookiess = driver.manage().getCookies();
        Assert.assertNotEquals(noCookies, cookiess);


    }

    @Test(priority = 1)

    public void non_existing_product() {
        homepagePF.searchBoxText("kkttpp");
        homepagePF.pressEnterSearhBox();
        nosearchPF.emptySearchResult();
        nosearchPF.isBackButtonDisplayed();
        nosearchPF.isCarouselDisplayed();
        String urlToCheck = nosearchPF.emptySearchBackButton();
        String bc = nosearchPF.emptySearchBackButton();
        nosearchPF.emptySearchBackButton();
        nosearchPF.clickBackButton();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(urlToCheck, currentURL);
        Assert.assertEquals(bc, nosearchPF.currentURL());

    }


    @Test(priority = 2)
    public void footerLinks() throws InterruptedException {
        homepagePF.linksToClick();

    }

    @Test(priority = 3)
    public void checkDomains() {

        homepagePF.domains();

    }


    @AfterTest

    public void tearDown() {
        driver.quit();
    }


}

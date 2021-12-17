package TestCases;

import PageObject.dodax.SearchResultFactory;
import PageObject.dodax.homepagefactory;
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

public class CookieSet {
    static WebDriver driver;
    private static Logger log = LogManager.getLogger(CookieSet.class.getName());
    homepagefactory homepagePF;
    noSearchResultFactory nosearchPF;
    SearchResultFactory searchPF;
    //homepage hp = new homepage(driver);


    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://www.dodax.ca";
        homepagePF = new homepagefactory(driver);
        nosearchPF = new noSearchResultFactory(driver);
        driver.get(baseURL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    @Test(priority = 0)
    public void privacyPF() {

        homepagePF.setPrivacyPF();
        Set<Cookie> noCookies = driver.manage().getCookies();
        homepagePF.isLoadedPF();
        Set<Cookie> cookiesBeforeClick = homepagePF.getCookies();
        homepagePF.getCookies();
        homepagePF.windowsHandlessChild();
        homepagePF.clickCookiesPF();
        homepagePF.windowsHandlessParent();
        homepagePF.clickCookiesPF();
        homepagePF.getCookies();
        Set<Cookie> cookiesAfterClick = homepagePF.getCookies();
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
        String urlToCheck = nosearchPF.isLoaded();
        String bc = nosearchPF.isLoaded();
        nosearchPF.isLoaded();
        nosearchPF.clickBackButton();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(urlToCheck, currentURL);
        Assert.assertEquals(bc, nosearchPF.currentURL());

    }


    @Test(priority = 2)
    public void footerLinks() throws InterruptedException {
        homepagePF.linksToClick1();
    }

    @Test(priority = 3)
    public void checkDomains() throws InterruptedException {

        homepagePF.domains();

    }

    @AfterTest

    public void tearDown() {
        driver.quit();
    }
}

package TestCases;

import PageObject.dodax.homepage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class CookieSet {
    static WebDriver driver;
    homepage hp = new homepage(driver);


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://www.dodax.ca";
        driver.get(baseURL);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void privacy() {
        homepage hp = new homepage(driver);

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
        hp.privacyp().click();
        boolean isLoaded = hp.copyRight().isDisplayed();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        hp.cookies().click();
        Set<Cookie> cookiess = driver.manage().getCookies();
        Assert.assertNotEquals(cookies, cookiess);


    }
}

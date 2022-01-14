package TestCases;

import PageFactory.dodax.homepagePageFactory;
import PageFactory.dodax.noSearchResultFactory;
import base.baseClass;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HomePage_tests extends baseClass {
//    WebDriver driver;
    //private static Logger log = LogManager.getLogger(homePage.class.getName());


    @Test(priority = 0, groups = {"noLogin"})
    public void privacyPF() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);


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

    @Test(priority = 1, groups = {"noLogin"})

    public void non_existing_product() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        noSearchResultFactory nosearchPF = new noSearchResultFactory(driver);

        homepagePF.searchBoxText("kkttpp");
        homepagePF.pressEnterSearhBox();
        nosearchPF.emptySearchResult();
        nosearchPF.isBackButtonDisplayed();
        nosearchPF.isCarouselDisplayed();
        nosearchPF.emptySearchBackButton();
        String urlBefore = nosearchPF.emptySearchBackButton();
        nosearchPF.clickBackButton();
        Assert.assertEquals(urlBefore, nosearchPF.currentURL());
    }


    @Test(priority = 2, groups = {"noLogin"})
    public void footerLinks() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);

        Assert.assertTrue(homepagePF.linksToClick());

    }

    @Test(priority = 3, groups = {"noLogin"})
    public void checkDomains() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);

        Assert.assertTrue(homepagePF.domains());

    }



}




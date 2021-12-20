package PageObject.dodax;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class homepagePageFactory {

    WebDriver driver;

    @FindBy(css = "a.c-cookiesDisclaimer__link")
    WebElement privacyPF;

    @FindBy(css = "button[data-qa='cookiesAgreementAcceptBtn']")
    WebElement cookiesPF;

    @FindBy(css = "div.ft-copyright")
    WebElement copyrightPF;

    @FindBy(css = "input")
    WebElement searchBox;

    @FindBy(xpath = "//div[@class='ft-footer__column col-12 col-sm-6']//a")
    List<WebElement> footerlinks;

    @FindBy(xpath = "//ul[@class='list-unstyled d-flex flex-wrap fs-16']//a")
    List<WebElement> domains;

    @FindBy(css = "[data-qa=\"headerUserAccountPopUpLogoutLink\"]")
    WebElement logOutButton;

    @FindBy(css = "[data-qa=\"headerCategoriesOpenBtnDesktop\"]")
    WebElement categoryS1;

    @FindBy(css = "[data-qa=\"headerCategoriesTreeTitleLink\"]")
    WebElement categoryS2;



    public homepagePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPrivacyPF() {
        privacyPF.click();

    }

    public void clickCookiesPF() {
        cookiesPF.click();
    }


    public boolean isLoadedPF() {
        return copyrightPF.isDisplayed();
    }

    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();

    }

//    public static String getMainWindowHandle(WebDriver driver) {
//        String window;
//        return  window = driver.getWindowHandle();
//    }
//
//    public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
//        String cHandle = driver.getWindowHandle();
//        String newWindowHandle = null;
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        if (allWindowHandles.size() > 1) {
//            for (String allHandlers : allWindowHandles) {
//                if (!allHandlers.equals(cHandle))
//                    newWindowHandle = allHandlers;
//            }
//            driver.switchTo().window(newWindowHandle);
//             }}

    public void windowsHandlessChild() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
    }

    //
    public void windowsHandlessParent() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        //String childId = it.next();
        driver.switchTo().window(parentId);
    }

    public void searchBoxText(String text) {
        searchBox.sendKeys(text);

    }

    public void pressEnterSearhBox() {
        searchBox.sendKeys(Keys.ENTER);

    }



    public String currentURL() {
        return driver.getCurrentUrl();
    }

    public void linksToClick() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String sfooterLinks;
        for (int i = 0; footerlinks.size() > i; i++) {

            sfooterLinks = footerlinks.get(i).getAttribute("href");
            executor.executeScript("arguments[0].click();", footerlinks.get(i));
            Set<String> windows = driver.getWindowHandles();
            int windowsSize = windows.size();
            if (windowsSize > 1) {

                windowsHandlessChild();

                if (currentURL().equals(sfooterLinks)) {
                    // Assert.assertEquals(currentURL(),secondLinks);
                    driver.close();
                    windowsHandlessParent();
                }
            }
          else  currentURL().equals(sfooterLinks);
        }
    }

    public void domains() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String domainLinks;
        for (int i = 0; domains.size() > i; i++) {
            domainLinks = domains.get(i).getAttribute("href");
            executor.executeScript("arguments[0].click();", domains.get(i));
            if (currentURL().equals(domainLinks)){
            driver.navigate().back();
            }
        }
    }
    public void logOut(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",logOutButton);
    }
    public void openCategory(){
        categoryS1.click();
        categoryS2.click();
    }
}





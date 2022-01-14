package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class homepagePageFactory {

    public WebDriver driver;

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
    WebElement categoryTree;

    @FindBy(css = "[data-qa=\"headerCategoriesTreeBtnAll\"]")
    WebElement backToAllCategories;

    @FindBy(css = "[data-qa=\"headerCategoriesTreeTitleLink\"]")
    WebElement categoryS2;

    @FindBy(css = "[data-id=\"050C7861CF\"]")
    WebElement categoryMovies;

    @FindBy(xpath = "//div[@class=\"js-hd-nav__levelContent\"]//b")
    WebElement subCatShowAllProducts;

    @FindBy(css = "[data-qa=\"headerWishlistLink\"]")
    WebElement wishListButton;

    @FindBy(css = "[class=\"hd-header__container js-bodyScroller__padding\"]")
    WebElement obseleteClick;

    @FindBy(css = "[class=\"hd-counter__content js-hd-counter__content a-bounceIn\"]")
    WebElement cartButtonCounter;

    @FindBy(css = "[data-qa=\"headerShoppingCartLink\"]")
    WebElement cartButton;

    @FindBy(css = "[data-qa=\"headerWishlistCounter\"]")
    WebElement wishListCounter;

    @FindBy(css = "[data-qa=\"headerUserNotLoggedIn\"]")
    WebElement signUpButton;

    @FindBy(css = "[data-qa=\"headerShoppingCartPopUpShoppingCartPageLink\"]")
    WebElement openCartButton;




    public homepagePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void setPrivacyPF() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(privacyPF);
//        privacyPF.click();

    }

    public void clickCookiesPF() {
//        cookiesPF.click();
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(cookiesPF);
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

    public void signUpButton(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(signUpButton);
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

    public Boolean linksToClick() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String sfooterLinks;
        Boolean equals = null;
        try {
            for (int i = 0; footerlinks.size() > i; i++) {

                sfooterLinks = footerlinks.get(i).getAttribute("href");
                executor.executeScript("arguments[0].click();", footerlinks.get(i));
                Set<String> windows = driver.getWindowHandles();
                int windowsSize = windows.size();
                if (windowsSize > 1) {

                    windowsHandlessChild();

                    if (currentURL().equals(sfooterLinks)) {
                        // Assert.assertEquals(currentURL(),secondLinks);
                        System.out.println("If block The link is good ");
                        System.out.println(driver.getCurrentUrl());
                        System.out.println(sfooterLinks);
                        driver.close();
                        windowsHandlessParent();
                        equals = true;
                    }
                }
                if (currentURL().equals(sfooterLinks)) {
                    equals = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Problem");
            equals = false;
        }
        return equals;
    }


    public boolean domains() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String domainLinks;

        Boolean equals = null;
        try {
            for (int i = 0; domains.size() > i; i++) {
                domainLinks = domains.get(i).getAttribute("href");

                executor.executeScript("arguments[0].click();", domains.get(i));

                if (currentURL().contains(domainLinks)) {
                    System.out.println("The link is good");
                    driver.navigate().back();
                    equals = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            equals = false;
        }
        return equals;

    }

    public void logOut() {
        driverUtils dU = new driverUtils(driver);
        try {
            dU.jsClick(logOutButton);
//            executor.executeScript("arguments[0].click();", logOutButton);
        } catch (NoSuchElementException e){
            System.out.println("User is logged out");
        }

    }

    public void openCategoryAll() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(categoryTree);
        dU.jsClick(categoryS2);
//        categoryTree.click();
//        categoryS2.click();
    }

    public void test2() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", categoryS2);
    }

    public void openCategory() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(categoryTree);
//        categoryTree.click();
    }

    public void openCatMovies() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(categoryMovies);
//        categoryMovies.click();
    }

    public void openAllSubCatTree() {
        driverUtils driverUtils = new driverUtils(driver);
        driverUtils.jsClick(subCatShowAllProducts);
//        subCatShowAllProducts.click();
    }

    public void waitForTree() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(subCatShowAllProducts));
    }

    public void clickWishListButton() {
        driverUtils driverUtils = new driverUtils(driver);
        driverUtils.jsClick(wishListButton);
//        wishListButton.click();
    }

    public void clickBackToAllcat() {
        driverUtils driverUtils = new driverUtils(driver);
        driverUtils.jsClick(backToAllCategories);
//        backToAllCategories.click();
    }

    public void moveToBottom() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void obsoleteClick() {
        obseleteClick.click();
    }

    public boolean cartButtonCounter() {
        Boolean bc = null;
        try {
            bc = cartButton.isDisplayed();
            return bc;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cart is 0");
            bc = false;

        }
        return bc;
    }
    public void clickCartButton() {
        driverUtils driverUtils = new driverUtils(driver);
        driverUtils.jsClick(cartButton);
//        cartButton.click();
    }

    public String getWishListCounter(){
        return wishListCounter.getText();
    }

    public String getWishListHref(){
        driverUtils dU = new driverUtils(driver);
        return dU.getHref(wishListButton);
    }
    public void waitForWishListCounter(){
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(wishListCounter);
    }

    public void openCart(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(openCartButton);
    }
}






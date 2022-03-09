package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class searchResultFactory {
    public WebDriver driver;

    @FindBy(css = "[data-qa=\"searchResultPageContentSortingSelect\"]")
    WebElement sortDropDown;

    @FindBy(css = "[data-qa=\"searchResultPageContent\"]")
    List<WebElement> searchResultList;

    @FindBy(css = "[data-qa=\"searchResultPageContent\"]>div>a")
    WebElement firstSearchResult;

    @FindBy(css = "[data-qa=\"headerSearchBtnClear\"]")
    WebElement clearSearchBox;

    @FindBy(css = "[class=\"btn-reset js-c-buttonAddToCart c-buttonAddToCartIconType c-frontOfPack__linkClickable\"]")
    WebElement addToCart;

    @FindBy(css = "[data-qa=\"headerShoppingCartLink\"]")
    WebElement viewCart;

    @FindBy(css = "[data-qa=\"headerShoppingCartPopUpCheckoutLink\"]")
    WebElement checkout;




    public searchResultFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstSearchResultList() {
//        driverUtils dU = new driverUtils(driver);
//        dU.jsClick(searchResultList.get(0));
        searchResultList.get(0).click();
    }

    public void clickFirstSearchResult(){
        driverUtils dU = new driverUtils(driver);
//        String href = firstSearchResult.getAttribute("href");
        dU.jsClick(firstSearchResult);
//        firstSearchResult.click();
    }

    public void clearSearchBox(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(clearSearchBox);
    }

    public boolean isDropDownDisplayed(){
        return sortDropDown.isDisplayed();
    }
    public void waitForDropDown(){
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(sortDropDown);
    }

    public void addToCart(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(addToCart);
    }

    public void viewCart(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(viewCart);
    }

    public void clickChekout(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(checkout);
    }
}

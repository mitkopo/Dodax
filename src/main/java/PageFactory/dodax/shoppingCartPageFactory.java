package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class shoppingCartPageFactory {
    WebDriver driver;


    @FindBy(css = "[class=\"ch-cartPageItem__headingLink text-break\"]")
    WebElement shoppingCartItem;

    @FindBy(css = "[class=\"d-flex align-items-center align-items-md-start justify-content-between justify-content-sm-start flex-row flex-md-column\"]>:last-child")
    List<WebElement> removeShoppingCartItem;

    @FindBy(css = "[class=\"d-flex align-items-center align-items-md-start justify-content-between justify-content-sm-start flex-row flex-md-column\"]>:first-of-type")
    WebElement wishButton;

    @FindBy(css = "[data-qa=\"loginModalBtnUserRedirect\"]")
    WebElement loginPopUp;

    @FindBy(css = "[class=\"d-md-flex d-lg-block justify-content-end\"]>:first-child")
    List<WebElement> prices;

    @FindBy(css = "span[title=\"ADD TO WISHLIST\"]")
    WebElement wishListUpdate;

    @FindBy(css = "[class=\"c-wishlistToggler js-c-wishlistToggler btn-reset c-wishlistToggler--small c-wishlistToggler--active\"]")
    WebElement wishListAddItemUpdate;

    public shoppingCartPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String cartItemText() {
        return shoppingCartItem.getText();
    }

    public void removeShoppingCartItems() {
        driverUtils dU = new driverUtils(driver);
        int i;

        for (WebElement element : removeShoppingCartItem) {
            dU.jsClick(element);
        }
    }

    public void clickAddToWishList() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(wishButton);
    }

    public void waitForLogInPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(loginPopUp));
    }

    public void waitForWishListRemoveItemUpdate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wishListUpdate));
    }

    public void clickLogInPopUp() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(loginPopUp);
    }

    public void waitForWishListAddItemUpdate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wishListAddItemUpdate));
    }

    public double sumTotalPrice() {
        double sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            String text = prices.get(i).getText();
            double[] foo = new double[prices.size()];
            foo[i] = Double.parseDouble(text);
            sum = sum + foo[i];

            return sum;
        }
        System.out.println(sum);
        return sum;
    }

}

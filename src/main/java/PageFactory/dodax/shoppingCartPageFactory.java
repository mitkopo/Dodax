package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class shoppingCartPageFactory {
    WebDriver driver;


    @FindBy(css = "[class=\"ch-cartPageItem__headingLink text-break\"]")
    WebElement shoppingCartItem;

    @FindBy(css = "[class=\"icon-trash fs-18 btn-trash__icon ch-cartPageItem__trashIcon\"]")
    List<WebElement> removeShoppingCartItem;

    @FindBy(css = "[class=\"d-flex align-items-center align-items-md-start justify-content-between justify-content-sm-start flex-row flex-md-column\"]>:first-of-type")
    WebElement wishButton;

    @FindBy(css = "[data-qa=\"loginModalBtnUserRedirect\"]")
    WebElement loginPopUp;

    @FindBy(css = "[class=\"d-md-flex d-lg-block justify-content-end\"]>:first-child")
    List<WebElement> prices;

    @FindBy(css = "button[data-qa*='wishlist']")
    WebElement wishListUpdate;

    @FindBy(css = "button[data-qa*='wishlist']")
    WebElement wishListAddItemUpdate;

    @FindBy(css = "[data-qa-price-total]")
    WebElement totalPrice;

    @FindBy(css = "h2[data-qa-item-price]")
    List<WebElement> priceAndQuantaty;

    @FindBy(css = "[data-qa=\"cartPageItemQuantity__increase\"]")
    List<WebElement> quantatyPlus;

    @FindBy(css = "[class=\"l-main js-ch-cart js-c-loadingOverlay js-bodyScroller__padding mt-4 mt-lg-5 c-loadingOverlay\"]")
    WebElement loadedPage;

    public shoppingCartPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String cartItemText() {
        return shoppingCartItem.getText();
    }

    public void removeShoppingCartItems() {
        driverUtils dU = new driverUtils(driver);

        for (int i = 0; i < removeShoppingCartItem.size(); i++) {
            dU.jsClick(removeShoppingCartItem.get(i));


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

    public void waitForWishListRemoveItemUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wishListUpdate));
    }

    public void clickLogInPopUp() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(loginPopUp);
    }

    public void waitForWishListAddItemUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wishListAddItemUpdate));
    }

    public List<Double> sumTotalEachProductPrice() {
        driverUtils dU = new driverUtils(driver);
        List<Double> total = new ArrayList<>();
        for (double i = 0; priceAndQuantaty.size() > i; i++) {
            double price = dU.getDouble(priceAndQuantaty.get((int) i).getAttribute("data-qa-item-price"));
            double quantaty = dU.getDouble(priceAndQuantaty.get((int) i).getAttribute("data-qa-quantity"));
            total.add(price * quantaty);

        }
        return total;
    }
    public double sumTotalPrice() {


        double totalPrice = sumTotalEachProductPrice().stream().mapToDouble(Double::doubleValue).sum();

        DecimalFormat f = new DecimalFormat("#.##");
        double bc = Double.parseDouble(f.format(totalPrice));
        return bc;

    }
    public double totalPrice() {
        driverUtils dU = new driverUtils(driver);
        return dU.getDouble(totalPrice.getAttribute("data-qa-price-total"));
    }

    public void pressRandomPlusQuantatyButton() {
        driverUtils dU = new driverUtils(driver);
        Random rnd = new Random();
        int i = rnd.nextInt(quantatyPlus.size());

        dU.jsClick(quantatyPlus.get(i));
    }

    public List<Double> prices() {

        driverUtils dU = new driverUtils(driver);
        List<Double> total = new ArrayList<>();
        for (double i = 0; priceAndQuantaty.size() > i; i++) {
            double price = dU.getDouble(priceAndQuantaty.get((int) i).getAttribute("data-qa-item-price"));
            total.add(price);
        }
        return total;
    }

    public List<Double> eachProductTotalPrice(){
        driverUtils dU = new driverUtils(driver);
        List<Double> total = new ArrayList<>();
        for (double i = 0; priceAndQuantaty.size() > i; i++) {
            double price = dU.getDouble(priceAndQuantaty.get((int) i).getAttribute("data-qa-total-price"));
            total.add(price);
        }
        return total;
    }
}
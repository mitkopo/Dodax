package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class productDetailsPageFactory {
    WebDriver driver;


    @FindBy(css = "[data-qa=\"productDetailspageSideBoxBtnsAddToCart\"]")
    WebElement addToCart;

    @FindBy(css = "[data-qa=\"productDetailsPageQtyBtnPlus\"]")
    WebElement qtyBtnPlus;

    @FindBy(css = "[data-qa=\"cartPopupItemsQty\"]")
    WebElement cartItemSize;

    @FindBy(css = "[data-qa=\"productDetailspageSideBoxBtnsGoToCart\"]")
    WebElement viewShoppingCart;

    @FindBy(css = "[class=\"c-wishlistToggler js-c-wishlistToggler btn-reset c-wishlistToggler--withBorder\"]")
    WebElement wishButton;

    @FindBy(css = "[data-qa=\"loginModalBtnUserRedirect\"]")
    WebElement wishLoginButton;

    @FindBy(css = "main[data-product-id]")
    WebElement dataProductId;

    @FindBy(xpath = "//div[.='Release date:']/following-sibling::*")
    WebElement releaseDate;

    @FindBy(css = "button.c-buttonAddToCart--success")
    WebElement realWaitForCart;

    @FindBy(css = "main[data-product-price]")
    WebElement productPrice;

    public productDetailsPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isAddToCartDisplayed() {
        return addToCart.isDisplayed();

    }

    public void quantatyPlusButton() {
        qtyBtnPlus.click();
    }

    public void addToCartButton() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(addToCart);
//        addToCart.click();
    }

    public String getCartItemSize() {
        String cartSize = cartItemSize.getText();
        return cartSize;

    }

    public boolean iSCartItemSizeDisplayed() {
        return cartItemSize.isEnabled();
    }

    public void waitForCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(cartItemSize));
    }

    public void viewShoppingCart() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(viewShoppingCart);

    }

    public String pageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public void clickWishButton() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(wishButton);
        // wishButton.click();
    }

    public void clickWishLoginButton() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(wishLoginButton);
//        wishLoginButton.click();
    }

    public void waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wishLoginButton));
    }

    public String getDataProductId() {
        String bc = dataProductId.getAttribute("data-product-id");
        return bc;
    }

    public String getReleaseDate() {
        try {
            String bc = releaseDate.getText();
            return bc;

        } catch (NoSuchElementException e) {
            System.out.println("No release date");


        }

        return null;
    }

    public void waitForAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(realWaitForCart));
    }

    public double getItemPrice(){
        double price = Double.parseDouble(productPrice.getAttribute("data-product-price"));
        return price;
    }

}
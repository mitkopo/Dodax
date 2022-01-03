package PageFactory.dodax;

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

    @FindBy(css = "[data-qa=\"shoppingCartProductLinkDesktop-5SV0AJ4QUFK\"]")
    WebElement shoppingCartItem;

    @FindBy(css = "[title=\"ADD TO WISHLIST\"]")
    WebElement wishButton;

    @FindBy(css = "[data-qa=\"loginModalBtnUserRedirect\"]")
    WebElement wishLoginButton;

    @FindBy(css = "[data-product-id]")
    WebElement dataProductId;

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
        addToCart.click();
    }

    public String getCartItemSize() {
        String cartSize = cartItemSize.getText();
        return cartSize;

    }

    public boolean iSCartItemSizeDisplayed() {
        return cartItemSize.isDisplayed();
    }

    public void waitForCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(cartItemSize));
    }

    public void viewShoppingCart() {
        viewShoppingCart.click();
    }

    public String pageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public void clickWishButton() {
        wishButton.click();
    }

    public void clickWishLoginButton() {
        wishLoginButton.click();
    }

    public void waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wishLoginButton));
    }

    public String getDataProductId() {
        String bc = dataProductId.getAttribute("data-product-id");
        return bc;
    }


}
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

    public void clickAddToWishList(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(wishButton);
    }
    public void waitForLogInPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(loginPopUp));
    }

    public void clickLogInPopUp(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(loginPopUp);
    }

}



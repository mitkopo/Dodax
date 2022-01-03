package PageFactory.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shoppingCartPageFactory {
    WebDriver driver;

    @FindBy(css = "[data-qa=\"headerShoppingCartLink\"]")
    WebElement cartButton;

    @FindBy(css = "[data-qa=\"shoppingCartProductLinkDesktop-5SV0AJ4QUFK\"]")
    WebElement shoppingCartItem;

    public shoppingCartPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public String cartItemText() {
        return shoppingCartItem.getText();
    }

}

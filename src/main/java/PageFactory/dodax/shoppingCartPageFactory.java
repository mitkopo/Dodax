package PageFactory.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shoppingCartPageFactory {
    WebDriver driver;


    @FindBy(css = "[class=\"ch-cartPageItem__headingLink text-break\"]")
    WebElement shoppingCartItem;

    public shoppingCartPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String cartItemText() {
        return shoppingCartItem.getText();
    }

}

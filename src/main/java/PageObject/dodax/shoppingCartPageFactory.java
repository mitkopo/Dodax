package PageObject.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shoppingCartPageFactory {
    WebDriver driver;

    @FindBy (css = "[data-qa=\"headerShoppingCartLink\"]")
    WebElement cartButton;

    public shoppingCartPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartButton(){
        cartButton.click();
    }

}

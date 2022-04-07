package PageFactory.dodax;

import base.baseClass;
import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkoutPageFactory extends baseClass {
    public WebDriver driver;

    @FindBy(css = "[data-qa=\"checkoutItemShippingAddressDeleteBtn\"]")
    List<WebElement> deleteButtons;

    @FindBy(css = "[data-qa=\"checkoutItemShippingAddressSelect\"]")
    List<WebElement> changeDeliveryAddress;

    @FindBy(css = "[data-qa=\"checkoutAddressesContainer\"]>div>address:nth-child(2)")
    WebElement secondAddress;


    public checkoutPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void deleteAllItemsCheckout(){
        driverUtils dU= new driverUtils(driver);
        for(WebElement element:deleteButtons){
            dU.jsClick(element);
        }
    }

    public void changeDeliveryAddress(){
        driverUtils dU = new driverUtils(driver);
        for(int i = 1; i == changeDeliveryAddress.size();){
            dU.jsClick(changeDeliveryAddress.get(i));
        }
    }

    public void waitForNewAddress(){
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(secondAddress);
    }

}

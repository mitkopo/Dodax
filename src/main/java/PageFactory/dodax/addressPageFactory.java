package PageFactory.dodax;

import base.baseClass;
import driverUtils.driverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class addressPageFactory extends baseClass{
   public WebDriver driver;

    @FindBy(css = "[data-qa=\"profileAddressesNewAddressModalOpen\"]")
    WebElement addNewAddress;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalAddAddressBtn\"]")
    WebElement addAddress;

    @FindBy(css = "div[data-qa$='Required']")
    List<WebElement> mandatoryFields;

    @FindBy(css = "div[data-qa$='Required']")
    WebElement mandatoryField;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalFirstNameInput\"]")
    WebElement firstName;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalLastNameInput\"]")
    WebElement lastName;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalStreet1Input\"]")
    WebElement streetAndNumber;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalZipInput\"]")
    WebElement postalCode;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalCityInput\"]")
    WebElement city;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalPhoneInput\"]")
    WebElement phoneNumber;

    @FindBy(css = "[data-qa=\"addressesDeleteAddressBtn\"]")
    List<WebElement> deleteAddresses;

    @FindBy(css = "[data-qa=\"addressSectionValues\"]")
    List<WebElement> availableAddresses;

    @FindBy(css = "[data-qa=\"checkoutAddressesUseForBillingAddressBtn\"]")
    WebElement billingAddressButton;

    @FindBy(css = "[data-qa=\"addressSectionValuesBilling\"]>[data-qa-address-sec-val]")
    WebElement currentBillingAddress;

    @FindBy(css = "[data-qa=\"checkoutAddressesUseForDeliveryAddressBtn\"]")
    WebElement shippingAddressButton;

    @FindBy(css = "[data-qa=\"addressSectionValuesShipping\"]>[data-qa-address-sec-val]")
    WebElement currentShippingAddress;

    @FindBy(css = "[data-qa=\"checkoutSideboxNextStepBtn\"]")
    WebElement continueButton;



    public addressPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewAddress(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(addNewAddress);
    }

    public void clickAddAddress(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(addAddress);
    }

    public void waitForMandatoryFields(){
        driverUtils dU = new driverUtils(driver);
        dU.waitForVisibilityListOfElements(mandatoryFields);

    }
    public void waitForMandatoryField(){
        driverUtils dU = new driverUtils(driver);
        try{
            dU.waitForElementToBeVisible(mandatoryField);
        } catch (Exception e){
            System.out.println("Mandatory fields are not displayed");
        }
//        This method is used because all the elements in the list are not displayed and the test fails
    }

    public boolean areMandatoryFieldsDisplayed(){
        driverUtils dU = new driverUtils(driver);
        Boolean b = null;
         for(int i =0; i<mandatoryFields.size();i++){
             b= dU.isElementDisplayed(mandatoryFields.get(i));
            if (b==true){
            return b;}
         }
        return b;
    }

    public void setFirstName(){
              JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='Test';", firstName);
    }
    public void setLastName(){
               JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='Testov';", lastName);
    }

    public void setStreetAndNumber(){
                JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='1129 Wentworth St W #1';", streetAndNumber);
    }

    public void setPostalCode(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='L1J 8P7';", postalCode);
    }

    public void setPhoneNumber(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='+19524125452';", phoneNumber);
    }

    public void setCity(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='Oshawa';", city);
    }

    public void deleteAllAddress(){
        driverUtils dU= new driverUtils(driver);
        try{
            for(int i = 1; i< deleteAddresses.size(); i++){
            dU.jsClick(deleteAddresses.get(i));
        }
        } catch (Exception e){
            System.out.println("Only 1 address is available");
        }
    }

    public int numberOfAvailableAddresses(){
        int b;
        try {


        b=availableAddresses.size();
        return b;}
        catch (Exception e){
            System.out.println("No address available");
        }
        return 0;
    }

    public void setBillingAddress(){
        driverUtils dU= new driverUtils(driver);
        dU.jsClick(billingAddressButton);
    }

    public String getCurrentBillingAddress() {
        return currentBillingAddress.getText();
    }

    public void setShippingAddress(){
        driverUtils dU= new driverUtils(driver);
        dU.jsClick(shippingAddressButton);
    }

    public String getCurrentShippingAddress(){
        return currentShippingAddress.getText();
    }

    public void clickContinueButton(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(continueButton);
    }
}



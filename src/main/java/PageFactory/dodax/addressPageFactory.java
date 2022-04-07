package PageFactory.dodax;

import base.baseClass;
import dataDriven.ExcelUtillity;
import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class addressPageFactory extends baseClass {
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

    @FindBy(css = "[data-qa=\"AddressessModal\"]>div")
    WebElement modal;

    @FindBy(css = "[data-is-main-billing-address=\"false\"][data-is-main-shipping-address=\"true\"]")
    WebElement changedBillingAddress;

    @FindBy(css = "[class=\"js-c-errorModal__content\"]>[class=\"text-center\"]")
    WebElement errorMessage;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalFirstNameInputErrorRequired\"]")
    WebElement firstNameNotification;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalLastNameInputErrorRequired\"]")
    WebElement lastNameNotification;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalStreet1InputErrorRequired\"]")
    WebElement streetNotification;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalZipInputErrorRequired\"]")
    WebElement postCodeNotification;

    @FindBy(css = "[data-qa=\"checkoutAddressesModalCityInputErrorRequired\"]")
    WebElement cityNotification;

    @FindBy(css = "data-qa=\"checkoutAddressesModalPhoneInputErrorRequired\"")
    WebElement mobileNotification;


    public addressPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewAddress() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(addNewAddress);
    }

    public void clickAddAddress() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(addAddress);
    }

    public void waitForMandatoryField() {
        driverUtils dU = new driverUtils(driver);
        try {
            dU.waitForElementToBeVisible(mandatoryField);
        } catch (Exception e) {
            System.out.println("Mandatory fields are not displayed");
        }
//        This method is used because all the elements in the list are not displayed and the areNotificationsDisplayed fails
    }


    public boolean areMandatoryFieldsDisplayed() {
        driverUtils dU = new driverUtils(driver);
        Boolean b = null;
        for (int i = 0; i < mandatoryFields.size(); i++) {
            b = dU.isElementDisplayed(mandatoryFields.get(i));
            if (b == true) {
                return b;
            }
        }
        return b;
    }

    public String setFirstName(String text) {
        firstName.sendKeys(text);
        return null;
    }


    public String setLastName(String text) {
        lastName.sendKeys(text);
        return null;
    }


    public String setStreetAndNumber(String text) {
        streetAndNumber.sendKeys(text);
        return null;
    }


    public String setPostalCode(String text) {

        postalCode.sendKeys(text);
        return null;
    }


    public Object setPhoneNumber(String text) {

        phoneNumber.sendKeys(text);
        return null;
    }


    public Object setCity(String text) {
        city.sendKeys(text);
        return null;
    }



    public void deleteAllAddress() {
        driverUtils dU = new driverUtils(driver);
        try {
            for (int i = 1; i < deleteAddresses.size(); i++) {
                dU.jsClick(deleteAddresses.get(i));
            }
        } catch (Exception e) {
            System.out.println("Only 1 address is available");
        }
    }

    public int numberOfAvailableAddresses() {
        int b;
        try {
            b = availableAddresses.size();
            return b;
        } catch (Exception e) {
            System.out.println("No address available");
        }
        return 0;
    }

    public void setBillingAddress() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(billingAddressButton);
    }

    public String getCurrentBillingAddress() {
        return currentBillingAddress.getText();
    }

    public void setShippingAddress() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(shippingAddressButton);
    }

    public String getCurrentShippingAddress() {
        return currentShippingAddress.getText();
    }

    public void clickContinueButton() {
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(continueButton);
    }

    public void waitForModal() {
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(modal);
    }

    public void waitForBillingButton() {
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(billingAddressButton);
    }

    public void waitForChangedAddress() {
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(changedBillingAddress);
    }

    public void waitForErrorMessage() {
        driverUtils dU = new driverUtils(driver);
        dU.waitForElementToBeVisible(errorMessage);
    }

    public boolean isErrorMessageDisplayed() {
        driverUtils dU = new driverUtils(driver);
        return dU.isElementDisplayed(errorMessage);
    }

    public void E2EAddress() {
        waitForModal();
        setFirstName(ExcelUtillity.getCellData(1, 0).toString());
        setLastName(ExcelUtillity.getCellData(1, 1).toString());
        setStreetAndNumber(ExcelUtillity.getCellData(1, 2).toString());
        setPostalCode(ExcelUtillity.getCellData(1, 3).toString());
        setCity(ExcelUtillity.getCellData(1, 4).toString());
        setPhoneNumber(ExcelUtillity.getCellData(1, 5).toString());
    }

    public boolean areNotificationsDisplayed() {
        driverUtils dU = new driverUtils(driver);

        Boolean b = null;
        List<WebElement> listOfNotificationElements = new ArrayList<WebElement>();
        listOfNotificationElements.add(firstNameNotification);
        listOfNotificationElements.add(lastNameNotification);
        listOfNotificationElements.add(streetNotification);
        listOfNotificationElements.add(postCodeNotification);
        listOfNotificationElements.add(cityNotification);
        listOfNotificationElements.add(mobileNotification);

      for(WebElement element:listOfNotificationElements) {
          b= dU.isElementDisplayed(element);
          return b;

        }
        return b;


}}



package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import dataDriven.ExcelUtillity;
import driverUtils.driverUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Adresses_Checkout_tests extends baseClass {

    @BeforeTest
    public void setupTestData () {
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtillity.setExcelFileSheet("Sheet1");
    }

//    public Adresses_Checkout_tests loginWithTestNG(XSSFRow row){
//
//    }

    @Test(groups = {"address"})
    public void address_with_empty_mandatory_fields() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.clickAvatarPopUpMenu();
        homepagePF.clickAvatarPopUpAddress();
        addressPF.deleteAllAddress();
        addressPF.clickAddNewAddress();
        addressPF.clickAddAddress();
        addressPF.waitForMandatoryField();
        Assert.assertTrue(addressPF.areMandatoryFieldsDisplayed());
        Assert.assertTrue(addressPF.areNotificationsDisplayed());
    }

    @Test(groups = {"address"})
    public void setBillingAddress()  {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.clickAvatarPopUpMenu();
        homepagePF.clickAvatarPopUpAddress();
        addressPF.deleteAllAddress();
        addressPF.clickAddNewAddress();
        addressPF.E2EAddress();
        int b = addressPF.numberOfAvailableAddresses();
        addressPF.clickAddAddress();
        addressPF.waitForBillingButton();
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());
        String c = addressPF.getCurrentBillingAddress();
        addressPF.setBillingAddress();
        addressPF.waitForChangedAddress();
        Assert.assertNotEquals(c, addressPF.getCurrentBillingAddress());
    }

    @Test(groups = {"NoDeleteAddress"})
    public void setShippingAddress() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.clickAvatarPopUpMenu();
        homepagePF.clickAvatarPopUpAddress();
        int b = addressPF.numberOfAvailableAddresses();
        addressPF.clickAddNewAddress();
         addressPF.E2EAddress();
        addressPF.clickAddAddress();
        addressPF.waitForBillingButton();
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());
        String c = addressPF.getCurrentShippingAddress();
        addressPF.setShippingAddress();
        addressPF.waitForChangedAddress();
        Assert.assertNotEquals(c, addressPF.getCurrentShippingAddress());
    }

    @Test(groups = {"NoDeleteAddress"})
    public void addDuplicateAddress() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.clickAvatarPopUpMenu();
        homepagePF.clickAvatarPopUpAddress();
        int b = addressPF.numberOfAvailableAddresses();
        addressPF.clickAddNewAddress();
        addressPF.E2EAddress();
        addressPF.clickAddAddress();
        addressPF.waitForBillingButton();
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());
        addressPF.clickAddNewAddress();
        addressPF.E2EAddress();
        addressPF.clickAddAddress();
        addressPF.waitForErrorMessage();
        Assert.assertTrue(addressPF.isErrorMessageDisplayed());
    }

    @Test
    public void checkoutCreateAddress() throws InterruptedException {

        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        shoppingCartPageFactory shoppingPF = new shoppingCartPageFactory(driver);
        checkoutPageFactory checkoutPF = new checkoutPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.openCategory();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.addToCartButton();
        productPF.waitForCart();
        productPF.viewShoppingCart();
        shoppingPF.clickCheckoutButton();
        addressPF.clickAddNewAddress();
        int b = addressPF.numberOfAvailableAddresses();
        addressPF.clickAddNewAddress();
        addressPF.E2EAddress();
        addressPF.clickAddAddress();
        checkoutPF.waitForNewAddress();
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());

    }

    @Test
    public void checkoutDeleteAllItems() throws InterruptedException {

        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        shoppingCartPageFactory shoppingPF = new shoppingCartPageFactory(driver);
        checkoutPageFactory checkoutPF = new checkoutPageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        String homepage = homepagePF.currentURL();
        loginPF.notloggedIn();
         loginPF.logIn();
        homepagePF.openCategory();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.addToCartButton();
        homepagePF.openCategory();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.addToCartButton();
        productPF.waitForCart();
        productPF.viewShoppingCart();
        shoppingPF.clickCheckoutButton();
        if (addressPF.numberOfAvailableAddresses() == 0) {
            addressPF.setFirstName(ExcelUtillity.getCellData(1,1).toString());
            addressPF.setLastName(ExcelUtillity.getCellData(1,1).toString());
            addressPF.setStreetAndNumber(ExcelUtillity.getCellData(1,1).toString());
            addressPF.setPostalCode(ExcelUtillity.getCellData(1,1).toString());
            addressPF.setCity(ExcelUtillity.getCellData(1,1).toString());
            addressPF.setPhoneNumber(ExcelUtillity.getCellData(1,1).toString());
            addressPF.clickAddAddress();
           checkoutPF.waitForNewAddress();
            addressPF.clickContinueButton();
        } else {
            addressPF.clickContinueButton();
        }
        checkoutPF.deleteAllItemsCheckout();
        dU.waitForUrlToLoad(homepage);
        homepagePF.waitForCopyright();
        Assert.assertEquals(homepagePF.currentURL(), homepage);
    }

    @Test

    public void checkoutItemTwoDifferentAddresses() {

        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);
        checkoutPageFactory checkoutPF = new checkoutPageFactory(driver);
        noSearchResultFactory noSearchPF = new noSearchResultFactory(driver);
        searchResultFactory searchPF = new searchResultFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.searchBoxText("VVBBSAJ6E4Q");
        homepagePF.pressEnterSearhBox();
        if (noSearchPF.isBackButtonDisplayed() == false) {
            searchPF.addToCart();
            searchPF.clearSearchBox();
            homepagePF.searchBoxText("VN3FPQVMSB1");
            homepagePF.pressEnterSearhBox();
            if (noSearchPF.isBackButtonDisplayed() == false) {
                searchPF.addToCart();
            } else if (noSearchPF.isBackButtonDisplayed() == true) {
                searchPF.clearSearchBox();
                homepagePF.searchBoxText("GSOQKVJTQGL");
                homepagePF.pressEnterSearhBox();
                searchPF.addToCart();
            }
        } else if (noSearchPF.isBackButtonDisplayed() == true) {
            searchPF.clearSearchBox();
            homepagePF.searchBoxText("VN3FPQVMSB1");
            homepagePF.pressEnterSearhBox();
            searchPF.addToCart();
        }

        searchPF.viewCart();
        searchPF.clickChekout();
        if (addressPF.numberOfAvailableAddresses() > 1) {
            addressPF.clickContinueButton();
            checkoutPF.changeDeliveryAddress();

        }
    }

}

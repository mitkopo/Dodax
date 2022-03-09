package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Adresses_Checkout_tests extends baseClass {

    @Test(groups = {"address"})
    public void address_with_empty_mandatory_fields() throws InterruptedException {
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
    }

    @Test(groups = {"address"})
    public void setBillingAddress() throws InterruptedException {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.clickAvatarPopUpMenu();
        homepagePF.clickAvatarPopUpAddress();
        addressPF.deleteAllAddress();
        int b = addressPF.numberOfAvailableAddresses();
        addressPF.clickAddNewAddress();
        addressPF.setFirstName();
        addressPF.setLastName();
        addressPF.setStreetAndNumber();
        addressPF.setPostalCode();
        addressPF.setCity();
        addressPF.setPhoneNumber();
        addressPF.clickAddAddress();
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());
        String c = addressPF.getCurrentBillingAddress();
        addressPF.setBillingAddress();
        Thread.sleep(3000);
        Assert.assertNotEquals(c, addressPF.getCurrentBillingAddress());
    }

    @Test(groups = {"address"})
    public void setShippingAddress() throws InterruptedException {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.clickAvatarPopUpMenu();
        homepagePF.clickAvatarPopUpAddress();
        int b = addressPF.numberOfAvailableAddresses();
        addressPF.clickAddNewAddress();
        addressPF.setFirstName();
        addressPF.setLastName();
        addressPF.setStreetAndNumber();
        addressPF.setPostalCode();
        addressPF.setCity();
        addressPF.setPhoneNumber();
        addressPF.clickAddAddress();
        Thread.sleep(3000);
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());
        String c = addressPF.getCurrentShippingAddress();
        addressPF.setShippingAddress();
        Thread.sleep(3000);
        Assert.assertNotEquals(c, addressPF.getCurrentShippingAddress());
    }

    @Test
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
        addressPF.setFirstName();
        addressPF.setLastName();
        addressPF.setStreetAndNumber();
        addressPF.setPostalCode();
        addressPF.setCity();
        addressPF.setPhoneNumber();
        addressPF.clickAddAddress();
        Assert.assertNotEquals(b, addressPF.numberOfAvailableAddresses());
        addressPF.clickAddNewAddress();
        addressPF.setFirstName();
        addressPF.setLastName();
        addressPF.setStreetAndNumber();
        addressPF.setPostalCode();
        addressPF.setCity();
        addressPF.setPhoneNumber();
        addressPF.clickAddAddress();
//        missing steps for Check that validation error message is shown
//        (saying that the address with the same data is already saved)
//        The modal is not closing after clicking on AddAddress

    }

    @Test
    public void checkoutCreateAddress() throws InterruptedException {

        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        shoppingCartPageFactory shoppingPF = new shoppingCartPageFactory(driver);

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
        addressPF.setFirstName();
        addressPF.setLastName();
        addressPF.setStreetAndNumber();
        addressPF.setPostalCode();
        addressPF.setCity();
        addressPF.setPhoneNumber();
        addressPF.clickAddAddress();
        Thread.sleep(3000);
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
            addressPF.setFirstName();
            addressPF.setLastName();
            addressPF.setStreetAndNumber();
            addressPF.setPostalCode();
            addressPF.setCity();
            addressPF.setPhoneNumber();
            addressPF.clickAddAddress();
            Thread.sleep(3000);
            addressPF.clickContinueButton();
        } else {
            addressPF.clickContinueButton();
        }
        checkoutPF.deleteAllItemsCheckout();

    }

    @Test

    public void checkoutItemTwoDifferentAddresses() {

        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        addressPageFactory addressPF = new addressPageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        shoppingCartPageFactory shoppingPF = new shoppingCartPageFactory(driver);
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
            if (noSearchPF.isBackButtonDisplayed() == false){
                searchPF.addToCart();
            } else if (noSearchPF.isBackButtonDisplayed() == true){
                searchPF.clearSearchBox();
                homepagePF.searchBoxText("GSOQKVJTQGL");
                homepagePF.pressEnterSearhBox();
                searchPF.addToCart();
            }
        }
        else if (noSearchPF.isBackButtonDisplayed()==true){
            searchPF.clearSearchBox();
            homepagePF.searchBoxText("VN3FPQVMSB1");
            homepagePF.pressEnterSearhBox();
            searchPF.addToCart();
        }

        searchPF.viewCart();
        searchPF.clickChekout();
        if(addressPF.numberOfAvailableAddresses()>1){
            addressPF.clickContinueButton();
            checkoutPF.changeDeliveryAddress();

        }
    }

}

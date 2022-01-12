package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import driverUtils.driverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCart_tests extends baseClass {

    @Test
    public void addAndRemoveProducts() throws InterruptedException {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        shoppingCartPageFactory shoppingCartPF = new shoppingCartPageFactory(driver);
        loginPageFactory loginPF = new loginPageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        homepagePF.openCategory();
        homepagePF.openCatMovies();
        homepagePF.waitForTree();
        homepagePF.openAllSubCatTree();
        String urlToCheck = catPF.getRandProducthref();
        Assert.assertEquals(urlToCheck,catPF.currentURL());
        productPF.addToCartButton();
        productPF.waitForCart();
        productPF.viewShoppingCart();
        String urlBeforeLogin = dU.currentURL();

        Integer beforeLogIn = dU.checkCounter(homepagePF.getWishListCounter());
        shoppingCartPF.clickAddToWishList();
        shoppingCartPF.waitForLogInPopUp();
        shoppingCartPF.clickLogInPopUp();
        loginPF.logIn();
        Assert.assertEquals(urlBeforeLogin,dU.currentURL());

        Integer beforeRemovingItem = dU.checkCounter(homepagePF.getWishListCounter());
        Assert.assertNotEquals(beforeLogIn,beforeRemovingItem);
        shoppingCartPF.clickAddToWishList();
        shoppingCartPF.waitForWishListRemoveItemUpdate();
        Thread.sleep(3000);
        //shoppingCartPF.waitForWishListAddItemUpdate();

        Integer afterRemovingItem = dU.checkCounter(homepagePF.getWishListCounter());
        Assert.assertNotEquals(beforeRemovingItem, afterRemovingItem);
        shoppingCartPF.clickAddToWishList();
        shoppingCartPF.waitForWishListAddItemUpdate();
        Assert.assertNotEquals(afterRemovingItem, dU.checkCounter(homepagePF.getWishListCounter()));



    }

    @Test
    public void checkValues(){
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        shoppingCartPageFactory shoppingCartPF = new shoppingCartPageFactory(driver);
        loginPageFactory loginPF = new loginPageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.addToCartButton();
        productPF.waitForAddToCart();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.addToCartButton();
        productPF.waitForAddToCart();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.addToCartButton();
        productPF.waitForAddToCart();
        productPF.viewShoppingCart();

    }

}

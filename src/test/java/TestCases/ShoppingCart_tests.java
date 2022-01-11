package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import driverUtils.driverUtils;
import org.openqa.selenium.By;
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
//    System.out.println("Test "+ driver.findElement(By.cssSelector("[data-qa=\"headerWishlistCounter\"]")).getText());
        Integer beforeLogIn = dU.checkCounter(homepagePF.getWishListCounter());
        shoppingCartPF.clickAddToWishList();
        shoppingCartPF.waitForLogInPopUp();
        shoppingCartPF.clickLogInPopUp();
        loginPF.logIn();
        Assert.assertEquals(urlBeforeLogin,dU.currentURL());
        System.out.println("Test "+ driver.findElement(By.cssSelector("[data-qa=\"headerWishlistCounter\"]")).getText());
        Integer beforeRemovingItem = dU.checkCounter(homepagePF.getWishListCounter());
        Assert.assertNotEquals(beforeLogIn,beforeRemovingItem);
        shoppingCartPF.clickAddToWishList();
        Thread.sleep(3000);
        System.out.println("Test "+ driver.findElement(By.cssSelector("[data-qa=\"headerWishlistCounter\"]")).getText());
        Integer afterRemovingItem = dU.checkCounter(homepagePF.getWishListCounter());
        Thread.sleep(3000);
        Assert.assertNotEquals(beforeRemovingItem, afterRemovingItem);
        shoppingCartPF.clickAddToWishList();
        Thread.sleep(3000);
        Assert.assertNotEquals(afterRemovingItem, dU.checkCounter(homepagePF.getWishListCounter()));
        System.out.println("Test "+ driver.findElement(By.cssSelector("[data-qa=\"headerWishlistCounter\"]")).getText());


    }

}

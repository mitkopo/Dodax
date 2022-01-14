package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import driverUtils.driverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

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
        Assert.assertEquals(urlToCheck, catPF.currentURL());
        productPF.addToCartButton();
        productPF.waitForCart();
        productPF.viewShoppingCart();
        String urlBeforeLogin = dU.currentURL();

        Integer beforeLogIn = dU.checkCounter(homepagePF.getWishListCounter());
        shoppingCartPF.clickAddToWishList();
        shoppingCartPF.waitForLogInPopUp();
        shoppingCartPF.clickLogInPopUp();
        loginPF.logIn();
        Assert.assertEquals(urlBeforeLogin, dU.currentURL());

        Integer beforeRemovingItem = dU.checkCounter(homepagePF.getWishListCounter());
        Assert.assertNotEquals(beforeLogIn, beforeRemovingItem);
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
    public void checkValues() throws InterruptedException {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);

        shoppingCartPageFactory shoppingCartPF = new shoppingCartPageFactory(driver);



        homepagePF.openCategoryAll();
        catPF.randomCategory();
        Thread.sleep(3000);
        catPF.clickRandomProduct();
        List<Double> prices = new ArrayList<>();
        Thread.sleep(3000);
        prices.add(productPF.getItemPrice());
        productPF.addToCartButton();
        productPF.waitForAddToCart();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        Thread.sleep(3000);
        catPF.clickRandomProduct();
        Thread.sleep(3000);
        prices.add(productPF.getItemPrice());
        productPF.addToCartButton();
        productPF.waitForAddToCart();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        Thread.sleep(3000);
        catPF.clickRandomProduct();
        Thread.sleep(3000);
        prices.add(productPF.getItemPrice());
//        productPF.quantatyPlusButton();
        productPF.addToCartButton();
        productPF.waitForAddToCart();
        productPF.viewShoppingCart();
        System.out.println(prices);
        double f = 0;
        for (int i = 0; i < prices.size(); i++) {
            f += prices.get(i);
        }
        DecimalFormat g = new DecimalFormat("#.##");
        double sum = Double.parseDouble(g.format(f));


        // each product item price is equal :
        assertTrue(prices.size() == shoppingCartPF.prices().size() && prices.containsAll(shoppingCartPF.prices()) && shoppingCartPF.prices().containsAll(prices));

        //total price of items is equal total price displayed
        Assert.assertEquals(sum, shoppingCartPF.totalPrice());

        //updating random quantaty
        shoppingCartPF.pressRandomPlusQuantatyButton();

        //each product total price is eqaual to the price displayed
        Assert.assertEquals(shoppingCartPF.sumTotalEachProductPrice(),shoppingCartPF.eachProductTotalPrice());

        //Total price of items is equal to total price displayed:
        Assert.assertEquals(shoppingCartPF.totalPrice(), shoppingCartPF.sumTotalPrice());


    }

}

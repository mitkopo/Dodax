package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import driverUtils.driverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishList_tests extends baseClass {

    @Test(groups = {"logIn"})
    public void addToWishList() throws InterruptedException {
        loginPageFactory loginPF= new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);

        loginPF.notloggedIn();
        try {
            loginPF.logIn();
        } finally {


            homepagePF.openCategoryAll();
            catPF.randomCategory();
            catPF.clickRandomProduct();
            String productId = productPF.getDataProductId();
            productPF.clickWishButton();
            homepagePF.waitForWishListCounter();
        Thread.sleep(1000);
            //Тhis thread sleep is implemented because the site it takes some time to
//        product to be displayed in My wishlist
            homepagePF.clickWishListButton();

            Assert.assertEquals(wishListPF.getFirstWishListProductDetails(), productId);
            homepagePF.logOut();

        }
    }


    @Test(groups = "logIn")
    public void emptyTheWishList() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        driverUtils dU = new driverUtils(driver);

        loginPF.notloggedIn();
        try {
            loginPF.logIn();
        } finally {
            homepagePF.openCategoryAll();
            catPF.randomCategory();
            catPF.waitForFirstSearchResultToLoad();
            String url = catPF.getRandProducthref();
            dU.waitForUrlToLoad(url);
            productPF.clickWishButton();
            productPF.waitForRemoveFromWishListButton();
            String wishListHref = homepagePF.getWishListHref();
            homepagePF.clickWishListButton();
            dU.waitForUrlToLoad(wishListHref);
            wishListPF.removeWishListItems();
            wishListPF.waitForEmptyWishList();
            Assert.assertTrue(wishListPF.isWishListEmpty());


        }
    }
}

package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishList_tests extends baseClass {

    @Test
    public void addToWishList(){
        loginPageFactory loginPF= new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        String productId = productPF.getDataProductId();
        productPF.clickWishButton();
        homepagePF.clickWishListButton();
        Assert.assertEquals(wishListPF.getFirstWishListProductDetails(),productId);


    }


    @Test
    public void emptyTheWishList(){
        loginPageFactory loginPF= new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.logIn();
        homepagePF.openCategoryAll();
        catPF.randomCategory();
        catPF.clickRandomProduct();
        productPF.clickWishButton();
        homepagePF.clickWishListButton();
        wishListPF.removeWishListItems();



    }

}

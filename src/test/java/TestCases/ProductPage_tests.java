package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPage_tests extends baseClass {

    @Test
    public void viewPPD(){
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);

        homepagePF.openCategory();
        homepagePF.openCatMovies();
        homepagePF.waitForTree();
        homepagePF.openAllSubCatTree();
        String urlToCheck = catPF.getRandProducthref();

      Assert.assertEquals(urlToCheck,catPF.currentURL());
        System.out.println(urlToCheck);
        System.out.println(catPF.currentURL());

    }

    @Test
    public void addToCart()   {

        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        searchResultFactory searchPF = new searchResultFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        shoppingCartPageFactory shopingCardPF = new shoppingCartPageFactory(driver);

        homepagePF.searchBoxText("A2R4V574SMF");
        homepagePF.pressEnterSearhBox();
        searchPF.clickFirstSearchResultList();
        Assert.assertTrue(productPF.isAddToCartDisplayed());
        String itemCartSizeBeforeAdd = productPF.getCartItemSize() ;
        productPF.quantatyPlusButton();
        String product = productPF.pageTitle();
        System.out.println(product);
        productPF.addToCartButton();
        productPF.waitForCart();
        productPF.iSCartItemSizeDisplayed();
        Assert.assertFalse(itemCartSizeBeforeAdd.equals(productPF.getCartItemSize()));
        productPF.viewShoppingCart();
        shopingCardPF.removeShoppingCartItems();
        Assert.assertTrue(product.contains(shopingCardPF.cartItemText()));
    }


    @Test
    public void addToWishList()  {
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        loginPageFactory logInPF = new loginPageFactory(driver);
        homepagePageFactory homePF = new homepagePageFactory(driver);
        wishListPageFactory wishPF = new wishListPageFactory(driver);


        viewPPD();
        productPF.clickWishButton();
        productPF.waitForElement();
        String product= productPF.getDataProductId();
        productPF.clickWishLoginButton();
        logInPF.logIn();

        homePF.clickWishListButton();
        Assert.assertEquals(product,wishPF.getFirstWishListProductDetails());

    }
}

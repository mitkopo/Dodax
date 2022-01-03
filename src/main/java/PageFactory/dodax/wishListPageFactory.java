package PageFactory.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wishListPageFactory {
    WebDriver driver;

    @FindBy(css = "[class=\"l-productsList__item up-wishlistPageItem clearfix js-up-wishlistPageItem\"]")
    WebElement firstWishListProduct;

    public wishListPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public String getFirstWishListProductDetails(){
        String bc = firstWishListProduct.getAttribute("data-product-id");
       return bc;
    }
}

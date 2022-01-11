package PageFactory.dodax;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class wishListPageFactory {
    WebDriver driver;

    @FindBy(css = "[class=\"l-productsList__item up-wishlistPageItem clearfix js-up-wishlistPageItem\"]")
    WebElement firstWishListProduct;

    @FindBy(css = "[class=\"up-wishlistPageItem__titleLink fs-15 fs-lg-18 text-break\"]")
    WebElement wishListItemText;


    @FindBy(css = "[class=\"w-100 d-flex justify-content-between flex-column flex-md-row align-items-end\"]>:first-child")
    List<WebElement> removeWishListItems;



    public wishListPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public String getFirstWishListProductDetails(){
        String bc = firstWishListProduct.getAttribute("data-product-id");
       return bc;
    }

    public void removeWishListItems(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        for (WebElement element : removeWishListItems) {
            executor.executeScript("arguments[0].click();", element);
        }

    }



}

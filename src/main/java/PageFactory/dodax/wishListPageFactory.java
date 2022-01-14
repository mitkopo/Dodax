package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class wishListPageFactory {
    WebDriver driver;

    @FindBy(css = "[class=\"l-productsList__item up-wishlistPageItem clearfix js-up-wishlistPageItem\"]")
    WebElement firstWishListProduct;

    @FindBy(css = "[class=\"up-wishlistPageItem__titleLink fs-15 fs-lg-18 text-break\"]")
    WebElement wishListItemText;


    @FindBy(css = "div[class=\"up-wishlistPageItem__btnsWrapper\"]>div>button[data-qa]>i")
    List<WebElement> removeWishListItems;

    @FindBy(css = "img[src*='emptyWishlist-21cdaf0353a8fcc89c61a2426a96c4e4.png']")
    WebElement emptyWishList;



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
        System.out.println(removeWishListItems.size());
        for (WebElement element : removeWishListItems) {
            executor.executeScript("arguments[0].click();", element);
        }

    }

    public boolean isWishListEmpty(){
        return emptyWishList.isDisplayed();
    }

    public void waitForEmptyWishList(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(emptyWishList));
    }

    public void emptyWishList(){
        loginPageFactory loginPF= new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);
        productDetailsPageFactory productPF = new productDetailsPageFactory(driver);
        wishListPageFactory wishListPF = new wishListPageFactory(driver);
        driverUtils dU = new driverUtils(driver);


        homepagePF.clickWishListButton();

        wishListPF.removeWishListItems();
        wishListPF.waitForEmptyWishList();

    }
}
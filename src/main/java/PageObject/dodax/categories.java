package PageObject.dodax;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class categories {
    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"cat-categories\"]//a")
    List<WebElement> allCategories;

    @FindBy(css = "[class=\"img-fluid\"]")
    List <WebElement> products;
    public categories(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void randomCategory(){
        Random rnd = new Random();
        int i = rnd.nextInt(allCategories.size());
       // allCategories.get(i).click();
       JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",allCategories.get(i));
    }
    public void randomProduct(){
        Random rnd = new Random();
        int i = rnd.nextInt(products.size());
       // products.get(i).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",products.get(i));
        //executor.executeScript("arguments[0].click();",products.get(i));
    }

}

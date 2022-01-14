package driverUtils;

import base.baseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class driverUtils extends baseClass {
     WebDriver driver;

    public driverUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Date dateFormat(String element) throws ParseException {

        String trydate = element;
        if (trydate == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
            String obsoleteDate = "May 1, 2015";
            Date date2 = formatter.parse(obsoleteDate);
            return date2;
        } else if (trydate != null) {

            String date = element;
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
            Date date1 = formatter.parse(date);
            return date1;
        }
        return null;
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String currentURL() {
        return driver.getCurrentUrl();
    }

    public Integer checkCounter(String counter) {
        int foo;
        try {
            foo = Integer.parseInt(counter);
        } catch (NumberFormatException e) {
            foo = 0;
        }
        return foo;
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public double getDouble(String element) {
        double totalPrices = Double.parseDouble(element);
        return totalPrices;

    }
    public void waitForUrlToLoad(String URL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains(URL));
    }

    public String getHref(WebElement element){
       return element.getAttribute("href");
    }

    public void waitForVisibilityListOfElements(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

}

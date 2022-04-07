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

//This method is used to format dates;
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

//    This method performs click on a element, all the clicks are done this way because it throws and error when using .click();
    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

//This method gets the current URL;
    public String currentURL() {
        return driver.getCurrentUrl();
    }

//This method is used for parsing the value of the item cart counter from String to int;
    public Integer checkCounter(String counter) {
        int foo;
        try {
            foo = Integer.parseInt(counter);
        } catch (NumberFormatException e) {
            foo = 0;
        }
        return foo;
    }


//This method is used for waiting for element to be visible;
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


//This method is used to parse ammount from String to double;
    public double getDouble(String element) {
        double totalPrices = Double.parseDouble(element);
        return totalPrices;

    }

//    Waiting for a certain URL to load, it can get input from user for a URL to load or insert a string from href;
    public void waitForUrlToLoad(String URL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains(URL));
    }
//This method is used to get the Href from an element (if there is href in the element);
    public String getHref(WebElement element){
       return element.getAttribute("href");
    }
//This method waits for a list of elements to be displayed
    public void waitForVisibilityListOfElements(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));

    }
//This method returns True or Falls if a element is a displayed
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }


    //This method waits for a element to become clickable
    public void isClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}

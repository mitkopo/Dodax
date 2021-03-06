package driverUtils;

import base.baseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String currentURL(){
        return driver.getCurrentUrl();
    }

    public Integer checkCounter(String counter){
       int foo;
        try {
            foo = Integer.parseInt(counter);
        }
        catch (NumberFormatException e) {
            foo = 0;
        }
return foo; }
}

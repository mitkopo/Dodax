package PageObject.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultFactory {
    WebDriver driver;

    @FindBy(css="[data-qa=\"searchResultPageContentSortingSelect\"]")
        WebElement sortDropDown;

    public SearchResultFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, SearchResultFactory.class);
    }

    public boolean isDisplayedSortDropDown() {



        Assert.assertNull(sortDropDown.isDisplayed());

        return true;
    }
}

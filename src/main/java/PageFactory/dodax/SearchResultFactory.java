package PageFactory.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultFactory {
    WebDriver driver;

    @FindBy(css = "[data-qa=\"searchResultPageContentSortingSelect\"]")
    WebElement sortDropDown;

    @FindBy(css = "[data-qa=\"searchResultPageContent\"]")
    List<WebElement> searchResultList;



    public SearchResultFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFisrtSearchResult() {
        searchResultList.get(0).click();
    }


}

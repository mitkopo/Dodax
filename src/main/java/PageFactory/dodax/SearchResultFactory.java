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

    @FindBy(css = "div[class='c-frontOfPack js-c-frontOfPack js-c-fopOffer c-frontOfPack--list']:first-of-type>div.c-frontOfPack__imageWrapper")
    WebElement firstSearchResult;




    public SearchResultFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstSearchResultList() {
        searchResultList.get(0).click();
    }

    public void clickFirstSearchResult(){
        firstSearchResult.click();
    }
}

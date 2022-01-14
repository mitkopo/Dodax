package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class searchResultFactory {
    WebDriver driver;

    @FindBy(css = "[data-qa=\"searchResultPageContentSortingSelect\"]")
    WebElement sortDropDown;

    @FindBy(css = "[data-qa=\"searchResultPageContent\"]")
    List<WebElement> searchResultList;

    @FindBy(css = "div[class='c-frontOfPack js-c-frontOfPack js-c-fopOffer c-frontOfPack--list']:first-of-type>div.c-frontOfPack__imageWrapper")
    WebElement firstSearchResult;

    @FindBy(css = "[data-qa=\"headerSearchBtnClear\"]")
    WebElement clearSearchBox;




    public searchResultFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstSearchResultList() {
//        driverUtils dU = new driverUtils(driver);
//        dU.jsClick(searchResultList.get(0));
        searchResultList.get(0).click();
    }

    public void clickFirstSearchResult(){
        firstSearchResult.click();
    }

    public void clearSearchBox(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(clearSearchBox);
    }

    public boolean isDropDownDisplayed(){
        return sortDropDown.isDisplayed();
    }
    public void waitForDropDown(){
        driverUtils dU = new driverUtils(driver);
        dU.waitForElement(sortDropDown);
    }

}

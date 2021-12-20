package PageObject.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class noSearchResultFactory {
    WebDriver driver;

    @FindBy(css="[data-qa=emptySearchResultPageTextMessage]")
    WebElement emptySearchResult;

    @FindBy(css="[data-qa=advertisingCarouselSection]")
    WebElement carousel;

    @FindBy(css="[data-qa=emptySearchResultPageGoBackBtn]")
    WebElement emptySearchBackButton;


    public noSearchResultFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Object currentURL(){
        Object currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public boolean isBackButtonDisplayed(){
        return emptySearchBackButton.isDisplayed();
    }

    public boolean isCarouselDisplayed(){
        return carousel.isDisplayed();
    }

    public void clickBackButton(){
        emptySearchBackButton.click();
    }

    public boolean emptySearchResult(){
        return emptySearchResult.isDisplayed();
    }
    public String emptySearchBackButton(){
        return emptySearchBackButton.getAttribute("href");



    }

}


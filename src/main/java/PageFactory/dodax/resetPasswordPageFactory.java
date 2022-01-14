package PageFactory.dodax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class resetPasswordPageFactory {
    WebDriver driver;

    @FindBy(css = "[data-qa=\"resetPasswordInputEmail\"]")
    WebElement resetPassInput;

    @FindBy(css = "[data-qa=\"resetPasswordBtnSubmit\"]")
    WebElement passResetButton;

    @FindBy(css = "[data-qa=\"resetPasswordStep2Heading\"]")
    WebElement resetPassMsg;

    public resetPasswordPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void emailInput(String text){
        resetPassInput.sendKeys(text);
    }
    public void clickPassResetButton(){
        passResetButton.click();
    }
    public boolean isEmailMessageDisplayed(){
        return  resetPassMsg.isDisplayed();
    }
    public void waitElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(resetPassMsg));
    }
}

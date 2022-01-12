package PageFactory.dodax;

import driverUtils.driverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registrationPageFactory {
    WebDriver driver;

    @FindBy(css = "[data-qa=\"registerInputFirstName\"]")
    WebElement inputFirstName;

    @FindBy(css = "[data-qa=\"registerInputFamilyName\"]")
    WebElement inputLastName;

    @FindBy(css = "[data-qa=\"registerInputEmail\"]")
    WebElement inputEmail;

    @FindBy(css = "[data-qa=\"inputNewPassword\"]")
    WebElement inputPass;

    @FindBy(css = "[data-qa=\"registerBtnSubmit\"]")
    WebElement registerButton;

    @FindBy(css= "[class=\"custom-control custom-checkbox\"]>div")
    WebElement checkBoxMessage;

    public registrationPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputFirstName(String text){
        inputFirstName.sendKeys(text);
    }

    public void inputLastName(String text){
        inputLastName.sendKeys(text);
    }

    public void inputEmail(String text){
        inputEmail.sendKeys(text);
    }

    public void inputPass(String text){
        inputPass.sendKeys(text);
    }
    public void clickRegisterButton(){
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(registerButton);

    }

    public boolean checkBoxMessage(){
        return checkBoxMessage.isDisplayed();
    }
}

package PageObject.dodax;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {
    WebDriver driver;

    @FindBy(css = "[data-qa=\"headerUserNotLoggedIn\"]")
    WebElement notLogged;

    @FindBy(css = "[data-qa=\"loginInputEmail\"]")
    WebElement emailInput;

    @FindBy(css = "[data-qa=\"inputPassword\"]")
    WebElement passInput;

    @FindBy(css = "[data-qa=\"loginBtnSubmit\"]")
    WebElement loginButton;

    @FindBy(css = "[data-qa=\"loginPasswordRecoveryLink\"]")
    WebElement forgotpassButton;

    public loginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void notloggedIn() {
        notLogged.click();
    }

    public void emailInput(String text){
        emailInput.sendKeys(text);
    }

    public void passInput(String text) {
        passInput.sendKeys(text);
    }

    public void loginButton(){
        loginButton.click();
    }

    public boolean isLoggedIn(){
       return notLogged.isDisplayed();
    }

    public void verifyLogIn(){
        try {
            notLogged.isDisplayed();
            System.out.println("User is not logged");

        } catch (NoSuchElementException e) {
            System.out.println("User is logged In");

        }
    }
    public String getCurrentUrl(){
      return  driver.getCurrentUrl();
    }
    public String geturrentUrl(){
        return  driver.getCurrentUrl();
    }

    public void clickForgotpassButton(){
        forgotpassButton.click();
    }
}

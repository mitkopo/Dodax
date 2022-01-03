package PageFactory.dodax;

import base.baseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPageFactory extends baseClass {
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

    @FindBy(css = "[data-qa=\"signUpLink\"]")
    WebElement signUp;

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
    public String urlAfterLogin(){
      return  driver.getCurrentUrl();
    }

    public void clickForgotpassButton(){
        forgotpassButton.click();
    }

    public void clickSignUpForFree(){
        signUp.click();
    }
    public String urlBeforeLogIn() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }


    public void e2eLoginOnSamePage(){
       urlBeforeLogIn();
        notloggedIn();
       emailInput("botearnasp@gmail.com");
        passInput("Popokatepeltel1@");
        loginButton();
        urlAfterLogin();
        Assert.assertEquals(urlBeforeLogIn(),urlAfterLogin());
        verifyLogIn();
    }

    public void logIn(){
        emailInput("botearnasp@gmail.com");
        passInput("Popokatepeltel1@");
        loginButton();
    }
}

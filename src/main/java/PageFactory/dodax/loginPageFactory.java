package PageFactory.dodax;

import base.baseClass;
import driverUtils.driverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        driverUtils dU = new driverUtils(driver);
        dU.jsClick(loginButton);
//        loginButton.click();
    }


    public boolean verifyLogIn(){
        Boolean b;
        try {
            if(notLogged.isDisplayed());
            System.out.println("User is not logged");
            b=false;

        } catch (NoSuchElementException e) {
            b=true;
            System.out.println("User is logged In");

        }
        return b;  }
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


    public boolean e2eLoginOnSamePage(){
        Boolean b;
        String urlBeforeLogin = urlBeforeLogIn();
        notloggedIn();
        emailInput("botearnasp@gmail.com");
        passInput("Popokatepeltel1@");
        loginButton();
        urlAfterLogin();
        b= urlBeforeLogin.equals(urlAfterLogin());
        return b;
    }

    public void logIn(){
        emailInput("botearnasp@gmail.com");
        passInput("Popokatepeltel1@");
        loginButton();
    }
}

package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_tests extends baseClass {



    @Test
    public void successfulLogin() throws InterruptedException {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);


        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        loginPF.verifyLogIn();
        Thread.sleep(3000);
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();
    }

    @Test
    public void verifyLoginOnSamePage() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory categoryPF = new categoriesPageFactory(driver);

        Assert.assertTrue(loginPF.e2eLoginOnSamePage());
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();


        homepagePF.openCategoryAll();
        Assert.assertTrue(loginPF.e2eLoginOnSamePage());
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();

        homepagePF.openCategoryAll();
        categoryPF.randomCategory();
        Assert.assertTrue(loginPF.e2eLoginOnSamePage());
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();


        homepagePF.clickCartButton();;
        Assert.assertTrue(loginPF.e2eLoginOnSamePage());
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();


        homepagePF.openCategoryAll();
        categoryPF.randomCategory();
        categoryPF.getRandProduct();

        loginPF.urlBeforeLogIn();
        Assert.assertTrue(loginPF.e2eLoginOnSamePage());
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();
    }


    @Test
    public void resetPassword() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        resetPasswordPageFactory resetPassPF = new resetPasswordPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.clickForgotpassButton();
        resetPassPF.emailInput("testitytt@gmail.com");
        resetPassPF.clickPassResetButton();
        resetPassPF.waitElement();
        Assert.assertTrue(resetPassPF.isEmailMessageDisplayed());
    }

    @Test
    public void registerNewAccount() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        registrationPageFactory registerPF = new registrationPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.clickSignUpForFree();
        registerPF.inputFirstName("Test");
        registerPF.inputLastName("Testorovski");
        registerPF.inputEmail("avazalijam@gmail.com");
        registerPF.inputPass("Popokatepetel123!@");
        registerPF.clickRegisterButton();
        Assert.assertTrue(registerPF.checkBoxMessage());
    }
}







package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_tests extends baseClass {



    @Test
    public void test1() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);

        homepagePF.clickCookiesPF();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        loginPF.verifyLogIn();
        homepagePF.logOut();
    }

    @Test
    public void test2() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory categoryPF = new categoriesPageFactory(driver);
        shoppingCartPageFactory shopingCardPF = new shoppingCartPageFactory(driver);

        loginPF.e2eLoginOnSamePage();
        homepagePF.logOut();


        homepagePF.openCategoryAll();
        loginPF.e2eLoginOnSamePage();
        homepagePF.logOut();

        homepagePF.openCategoryAll();
        categoryPF.randomCategory();
        loginPF.e2eLoginOnSamePage();
        homepagePF.logOut();


        shopingCardPF.clickCartButton();
        loginPF.e2eLoginOnSamePage();
        homepagePF.logOut();


        homepagePF.openCategoryAll();
        categoryPF.randomCategory();
        categoryPF.getRandProduct();

        loginPF.urlBeforeLogIn();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        loginPF.urlAfterLogin();
        Assert.assertEquals(loginPF.urlBeforeLogIn(), loginPF.urlAfterLogin());
        loginPF.verifyLogIn();
        homepagePF.logOut();
    }


    @Test
    public void test3() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        resetPasswordPageFactory resetPassPF = new resetPasswordPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.clickForgotpassButton();
        resetPassPF.emailInput("testitytt@gmail.com");
        resetPassPF.clickPassResetButton();
        resetPassPF.waitElement();
        resetPassPF.isEmailMessageDisplayed();
    }

    @Test
    public void test4() {
        loginPageFactory loginPF = new loginPageFactory(driver);
        registrationPageFactory registerPF = new registrationPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.clickSignUpForFree();
        registerPF.inputFirstName("Test");
        registerPF.inputLastName("Testorovski");
        registerPF.inputEmail("avazalijam@gmail.com");
        registerPF.inputPass("Popokatepetel123!@");
        registerPF.clickRegisterButton();
        registerPF.checkBoxMessage();
    }
}







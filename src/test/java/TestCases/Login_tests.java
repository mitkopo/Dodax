package TestCases;

import PageFactory.dodax.*;
import base.baseClass;
import base.testData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_tests extends baseClass {



    @Test(dataProvider = "user&pass", dataProviderClass = testData.class,groups = {"logIn"})
    public void successfulLogin(String user, String pass) {
        loginPageFactory loginPF = new loginPageFactory(driver);
        homepagePageFactory homepagePF = new homepagePageFactory(driver);


        loginPF.notloggedIn();
        loginPF.emailInput(user);
        loginPF.passInput(pass);
        loginPF.loginButton();
        loginPF.verifyLogIn();
        Assert.assertTrue(loginPF.verifyLogIn());
        homepagePF.logOut();
    }

    @Test(groups = {"logIn"})
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


    @Test(dataProvider = "emailReset", dataProviderClass = testData.class)
    public void resetPassword(String email) {
        loginPageFactory loginPF = new loginPageFactory(driver);
        resetPasswordPageFactory resetPassPF = new resetPasswordPageFactory(driver);

        loginPF.notloggedIn();
        loginPF.clickForgotpassButton();
        resetPassPF.emailInput(email);
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







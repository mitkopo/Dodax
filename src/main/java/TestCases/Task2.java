package TestCases;

import PageObject.dodax.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
    static WebDriver driver;
    loginPageFactory loginPF;
    homepagefactory homepagePF;
    categories categoryPF;
    shoppingCart scPF;
    resetPasswordPageFactory resetPassPF;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://www.dodax.ca";


        loginPF = new loginPageFactory(driver);
        homepagePF = new homepagefactory(driver);
        categoryPF = new categories(driver);
        scPF = new shoppingCart(driver);
        resetPassPF = new resetPasswordPageFactory(driver);


        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        loginPF.verifyLogIn();
        homepagePF.logOut();
    }

    @Test
    public void test2() {
        String beforeLogin = loginPF.getCurrentUrl();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        String afterLogin = loginPF.getCurrentUrl();
        Assert.assertEquals(beforeLogin, afterLogin);
        loginPF.verifyLogIn();
        homepagePF.logOut();


        homepagePF.openCategory();
        String beforeLogin1 = loginPF.getCurrentUrl();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        String afterLogin1 = loginPF.getCurrentUrl();
        Assert.assertEquals(beforeLogin1, afterLogin1);
        loginPF.verifyLogIn();
        homepagePF.logOut();

        homepagePF.openCategory();
        categoryPF.randomCategory();
        String beforeLogin2 = loginPF.getCurrentUrl();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        String afterLogin2 = loginPF.getCurrentUrl();
        Assert.assertEquals(beforeLogin2, afterLogin2);
        loginPF.verifyLogIn();
        homepagePF.logOut();


        scPF.clickCartButton();
        String beforeLogin3 = loginPF.getCurrentUrl();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        String afterLogin3 = loginPF.getCurrentUrl();
        Assert.assertEquals(beforeLogin3, afterLogin3);
        loginPF.verifyLogIn();
        homepagePF.logOut();


        homepagePF.openCategory();
        categoryPF.randomCategory();
        categoryPF.randomProduct();
        String beforeLogin4 = loginPF.getCurrentUrl();
        loginPF.notloggedIn();
        loginPF.emailInput("botearnasp@gmail.com");
        loginPF.passInput("Popokatepeltel1@");
        loginPF.loginButton();
        String afterLogin4 = loginPF.getCurrentUrl();
        Assert.assertEquals(beforeLogin4, loginPF.getCurrentUrl());
        loginPF.verifyLogIn();
        homepagePF.logOut();
    }


    @Test
    public void test3()  {

        loginPF.notloggedIn();
        loginPF.clickForgotpassButton();
        resetPassPF.emailInput("testitytt@gmail.com");
        resetPassPF.clickPassResetButton();
        resetPassPF.waitElement();
        resetPassPF.isEmailMessageDisplayed();
    }


    @AfterTest

    public void tearDown() {
        // driver.quit();
    }

}







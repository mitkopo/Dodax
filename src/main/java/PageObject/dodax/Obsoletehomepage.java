package PageObject.dodax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Obsoletehomepage {
    WebDriver driver;

    public Obsoletehomepage(WebDriver driver) {
        this.driver = driver;
    }

    By privacypolicy = By.cssSelector("a.c-cookiesDisclaimer__link");


    public WebElement privacyp() {
        return driver.findElement(privacypolicy);

    }

    By cookies = By.cssSelector("button[data-qa='cookiesAgreementAcceptBtn']");

    public WebElement cookies() {
        return driver.findElement(cookies);

    }

    By copyRight = By.cssSelector("div.ft-opyright");

    public WebElement copyRight() {
        return driver.findElement(copyRight);
    }
}

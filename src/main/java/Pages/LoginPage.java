package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    public static final String loginPageUrl = "https://mail.google.com/";
    public static final String emailAddressInputId = "identifierId";
    public static final String identifierNextBtnXPath = "//div[@id='identifierNext']/div/button";
    public static final String passwordInputXPath = "//input[@name='Passwd']";
    public static final String passwordNextBtnXPath = "//div[@id='passwordNext']/div/button";

    public InboxPage handleSignIn(String login, String password) {
        driver.get(loginPageUrl);
        driver.findElement(By.id(emailAddressInputId)).sendKeys(login);
        driver.findElement(By.xpath(identifierNextBtnXPath)).click();
        driver.findElement(By.xpath(passwordInputXPath)).sendKeys(password);
        driver.findElement(By.xpath(passwordNextBtnXPath)).click();
        return new InboxPage();
    }
}

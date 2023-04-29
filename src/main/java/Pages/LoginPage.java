package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    public static final String loginPageUrl = "https://accounts.google.com/signin";
    public static final String emailAddressInputId = "identifierId";
    public static final String identifierNextBtnXPath = "//div[@id='identifierNext']/div/button";
    public static final String passwordInputXPath = "//input[@name='Passwd']";
    public static final String passwordNextBtnXPath = "//div[@id='passwordNext']/div/button";

    public InboxPage handleSignIn() {
        String login = "gctester51@gmail.com";
        String password = "P4sSw0rD_51";

        driver.get(loginPageUrl);
        driver.findElement(By.id(emailAddressInputId)).sendKeys(login);
        driver.findElement(By.xpath(identifierNextBtnXPath)).click();
        driver.findElement(By.xpath(passwordInputXPath)).sendKeys(password);
        driver.findElement(By.xpath(passwordNextBtnXPath)).click();
        driver.navigate().to(InboxPage.inboxPageUrl);
        return new InboxPage();
    }
}

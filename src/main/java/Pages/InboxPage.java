package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;

public class InboxPage extends BaseTest {
    public static final String inboxPageUrl = "https://mail.google.com/";
    public static final String createBtnXPath = "//div[contains(text(),'Compose')]";
    public static final String recipientsInputXPath = "//input[@role='combobox']";
    public static final String recipient = "gctester51@gmail.com";
    public static final String subjectInputName = "subjectbox";
    public static final String subject = "My automated message";
    public static final String messageBodyInputCssSelector = "div[role='textbox']";
    public static final String messageBody = "Hello World";
    public static final String sendBtnXPath = "//div[text()='Send']";
    public static final String refreshInboxBtnCssSelector = "div[aria-label='Refresh']";
    public static final String emailPreviewLinkXPath = "//div[@role='link'][";

    public InboxPage handleSendingMessage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath(createBtnXPath)).click();
        driver.findElement(By.xpath(recipientsInputXPath)).click();
        driver.findElement(By.xpath(recipientsInputXPath)).sendKeys(recipient);
        driver.findElement(By.name(subjectInputName)).sendKeys(subject);
        driver.findElement(By.cssSelector(messageBodyInputCssSelector)).sendKeys(messageBody);
        driver.findElement(By.xpath(sendBtnXPath)).click();
        return this;
    }

    public EmailPreviewPage openEmail(int linkIndex) {
        driver.findElement(By.xpath(emailPreviewLinkXPath + linkIndex + "]")).click();
        return new EmailPreviewPage();
    }
}

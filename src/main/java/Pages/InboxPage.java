package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;

public class InboxPage extends BaseTest {
    public static final String recipient = "gctester51@gmail.com";
    public static final String subject = "My automated message";
    public static final String messageBody = "Hello World";

    public final String createBtnXPath = "//div[contains(text(),'Compose')]";
    public final String recipientsInputXPath = "//input[@role='combobox']";
    public final String subjectInputName = "subjectbox";
    public final String messageBodyInputCssSelector = "div[role='textbox']";
    public final String sendBtnXPath = "//div[text()='Send']";
    public final String emailPreviewLinkXPath = "//div[@role='link'][";

    public InboxPage handleSendingMessage() throws InterruptedException {
        Thread.sleep(5000);//5s wait for Inbox to load all elements
        driver.findElement(By.xpath(createBtnXPath)).click();
        driver.findElement(By.xpath(recipientsInputXPath)).click();
        driver.findElement(By.xpath(recipientsInputXPath)).sendKeys(recipient);
        driver.findElement(By.name(subjectInputName)).sendKeys(subject);
        driver.findElement(By.cssSelector(messageBodyInputCssSelector)).sendKeys(messageBody);
        Thread.sleep(1000);//1s wait for all fields to be filled before sending the message
        driver.findElement(By.xpath(sendBtnXPath)).click();
        return this;
    }

    public EmailPreviewPage openEmail(int linkIndex) throws InterruptedException {
        Thread.sleep(2000);//2s wait for sent email to show up in the Inbox
        driver.findElement(By.xpath(emailPreviewLinkXPath + linkIndex + "]")).click();
        return new EmailPreviewPage();
    }
}

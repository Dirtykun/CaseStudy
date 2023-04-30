package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

public class EmailPreviewPage extends BaseTest {
    public static String emailSubjectXPath = "//h2[@class='hP']";
    public static String emailBodyCssSelector = "div[class='a3s aiL '] div[dir='ltr']";

    public EmailPreviewPage subjectVerification() {
        String subject = driver.findElement(By.xpath(emailSubjectXPath)).getText();
        Assert.assertEquals(subject, InboxPage.subject, "Incorrect subject was displayed");
        try {
            writer.write("The test passed: \"" + subject + "\" was displayed");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public EmailPreviewPage emailBodyVerification() {
        String messageBody = driver.findElement(By.cssSelector(emailBodyCssSelector)).getText();
        Assert.assertEquals(messageBody, InboxPage.messageBody, "Incorrect message body was displayed");
        try {
            writer.write("The test passed: \"" + messageBody + "\" was displayed");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}

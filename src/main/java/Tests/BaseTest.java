package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static BufferedWriter writer;

    @BeforeTest
    public void testStart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        try {
            writer = new BufferedWriter(new FileWriter("src/main/resources/Results/CaseStudy.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void testEnd() {
        driver.close();
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

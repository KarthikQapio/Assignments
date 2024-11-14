package Base.Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.accessibility.AccessibleRelation;
import java.time.Duration;

public class LoginPage extends BaseClass {

    // Declare WebDriver as a class-level variable
    public static WebDriver driver;

    public void launchBrowser() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        // Implicit wait for better synchronization
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test
    public void LaunchBrowserandElements(WebElement element) throws InterruptedException {
        // Scroll down the page using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
        Thread.sleep(5000);

    }

    @AfterTest
    public void Teardown() {
        // Check if driver is initialized before attempting to close
        if (driver != null) {
            driver.quit(); // Close all browser windows and end the session
        }
    }
}
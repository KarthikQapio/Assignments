package Base.Pages;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsHomePage {
    public static WebDriver driver;

    @BeforeTest(enabled = true)
    public void launchBrowser() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        // Implicit wait for better synchronization
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));


    }

    @Test
    public void clickOnAlertsPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Alerts, Frame & Windows']")));
        element.click();
    }

    public void clickOnBrowserwindowsButton() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();

    }

    public void clickOnNewTab() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(5000);
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().back();
    }

    public void clickOnNewWindow() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().back();

    }

    public void clickOnNewWindowMessageTab() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='messageWindowButton']"))).click().perform();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().back();
        Thread.sleep(3000);
    }

    public void clickOnAlertsButton() throws InterruptedException {
        driver.navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,550)");
        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void clickOnfiveSecondsAlertButton() {

        WebElement alertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnConfirmButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='confirmButton']"))).click().perform();
//        WebElement alertButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
//        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnPromptButton() throws InterruptedException {
        WebElement alertButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("karthik");
        promptAlert.accept();
        Thread.sleep(3000);
    }

    public void clickOnFrames() throws InterruptedException {
        driver.navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']")).click();
        Thread.sleep(4000);
        driver.switchTo().frame("frame1");
        WebElement sampleText = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println("Text inside the frame: " + sampleText.getText());
    }

    public void handleNestedFrames() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"))).click().perform();
//        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(4000);
        driver.switchTo().frame("frame1");
        WebElement sampleText = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
        System.out.println("Text inside the frame: " + sampleText.getText());
    }

    @AfterTest
    public void Teardown() {
        // Check if driver is initialized before attempting to close
        if (driver != null) {
            driver.quit(); // Close all browser windows and end the session
        }

    }
}

package Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsHomepage {
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
    public void LaunchBrowserandElements() throws InterruptedException {
        // Scroll down the page using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Elements']")));
        element.click();
    }

    public void clickonTextButton() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
    }

    public void enterFullName() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
        driver.findElement(By.xpath("//input[@id='userName']")).click();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Karthik----");
    }

    public void enterEmailId() {
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("dash998893@gmail.com");
    }

    public void enterCurrentAddress() {
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Bangalore");
    }

    public void enterPermanantAddress() {
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Hyderabad");
    }

    public void clickOnElementsCheckBox() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
    }

    public void clickOnPlusButton() {
        driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']")).click();
    }

    public void clickOnAllCheckBox() {
        driver.findElement(By.xpath("//span[@class='rct-checkbox']//*[name()='svg']")).click();
    }

    public void cickOnradioButton() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']")).click();
    }

    public void SelectYesInRadioButton() {
        driver.findElement(By.xpath("//label[text()='Yes']")).click();
    }

    public void clickOnWebTablesButtonAndAddTheMembers() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']")).click();
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Karthik");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("67896789h");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Karuii@gmail.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("345600");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Hotel");
        driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();

    }

    public void clickOnAllButtonsInElementsPage() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

    }

    public void clickOnLinks() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']")).click();
        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();
        Thread.sleep(5000);
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().back();
    }

    public void clickOnBrokenLinks() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-6']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//a[text()='Click Here for Valid Link']")).click();
        driver.navigate().back();
    }

    public void clickOnUploadAndDownloadButton() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-7']")).click();
        driver.findElement(By.xpath("//a[@id='downloadButton']")).click();
        Thread.sleep(4000);
        WebElement fileinput = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        fileinput.sendKeys("C:\\Users\\karthik.nagendrappa\\OneDrive - QAPITOL QA\\Documents\\Screenshot 2024-04-22 174212.png");
    }

    @AfterTest
    public void Teardown() {
        // Check if driver is initialized before attempting to close
        if (driver != null) {
            driver.quit(); // Close all browser windows and end the session
        }
    }
}
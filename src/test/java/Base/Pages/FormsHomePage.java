package Base.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormsHomePage {

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
    public void clickOnFormsPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Forms']")));
        element.click();
    }

    public void clickOnPracticeForm() {
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
    }

    public void fillThePracticeForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("karthiiiiiiii");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("gowdaaa");
    }

    public void enteremailidInformsPage() {
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("karthik@gmail.com");

    }

    public void clickOnRadioButton() throws InterruptedException {
        driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();

    }

    public void enterMobileNumber() {
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("9865679876");

    }
    public void enterDateOfBirth() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)");
        Thread.sleep(3000);
       WebElement date= driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
       date.click();
       driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();
       driver.findElement(By.xpath("//option[text()='2000']")).click();
       driver.findElement(By.xpath("//option[text()='June']")).click();
       driver.findElement(By.xpath("//div[text()='13']")).click();
       Thread.sleep(5000);



    }
    public void selectHobbies(){
        driver.findElement(By.xpath("//label[text()='Music']")).click();
    }
    public void selectPicture(){
        WebElement fileinput = driver.findElement(By.xpath( "//input[@id='uploadPicture']"));
        fileinput.sendKeys("C:\\Users\\karthik.nagendrappa\\OneDrive - QAPITOL QA\\Documents\\Screenshot 2024-04-22 174212.png");
    }
    public void currrentAddress(){
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("highway side and Metroside");
    }
    public void selectState() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Select State')]"))).click().perform();
        driver.findElement(By.xpath("//div[text()='Haryana']")).click();
        Thread.sleep(3000);
    }
    public void selectCity(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Select City')]"))).click().perform();
        driver.findElement(By.xpath("//div[text()='Panipat']")).click();

    }
    public void clickOnSubmitButton(){
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }
    public void closeTheSubmittingFOrm(){
        driver.findElement(By.xpath("//button[text()='Close']")).sendKeys(Keys.CONTROL,Keys.SUBTRACT);
    }



    @AfterTest
    public void Teardown() {
        // Check if driver is initialized before attempting to close
        if (driver != null) {
            driver.quit(); // Close all browser windows and end the session
        }
    }
}
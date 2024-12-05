package Base.Pages;

import com.beust.ah.A;
import org.apache.poi.xddf.usermodel.chart.AxisCrossBetween;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class WidgetsHomePage {
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @BeforeTest(enabled = true)
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

    }

    @Test
    public void clickOnWidgetsButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Widgets']")));
        element.click();
    }

    public void clickOnAccordionButton() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(By.xpath("//div[@id='section1Heading']")).click();
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(By.xpath("//div[@id='section2Heading']")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(By.xpath("//div[@id='section3Heading']")).click();
    }

    public void clickOnAutoCompleteButton() {
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
    }

    public void enterMultipleColourNames() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
        Actions actions = new Actions(driver);
        WebElement multipleColourInput = driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']"));
        String[] colors = {"Red", "Green", "Blue"};
        for (String color : colors) {
            multipleColourInput.sendKeys(color);
            multipleColourInput.sendKeys(Keys.RETURN);
            Thread.sleep(1000);
        }
    }

    public void enterSingleColourName() throws InterruptedException {
        WebElement multipleColourInput = driver.findElement(By.xpath("//input[@id='autoCompleteSingleInput']"));
        String[] colors = {"Red"};
        for (String color : colors) {
            multipleColourInput.sendKeys(color);
            multipleColourInput.sendKeys(Keys.RETURN);
            Thread.sleep(1000);

        }
    }

    public void clickOnDatePicker() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void SelectTheDAte() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)");
        WebElement date = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
        date.click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();
        driver.findElement(By.xpath("//option[text()='2000']")).click();
        driver.findElement(By.xpath("//option[text()='June']")).click();
        driver.findElement(By.xpath("//div[text()='13']")).click();

    }

    public void SelectDateAndTime() {
        WebElement date = driver.findElement(By.xpath("//div[@id='dateAndTimePicker']"));
        date.click();
        driver.findElement(By.xpath("//div[@aria-label='Choose Friday, May 16th, 2003']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='16:00']")).click();


    }

    public void clickOnSliderButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void slideTheSlider() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//input[@type='range']")).click();

    }

    public void clickOnProgressBarButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }

    public void clickOnStartButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
    }

    public void clickOnTabs() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickOnOrigin() {
        driver.findElement(By.xpath("//a[@id='demo-tab-origin']")).click();
    }

    public void clickOnToolTips() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-6']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void MouseOverTheElement() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        WebElement tooltipElement = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tooltipElement).perform();
        WebElement tooltip = driver.findElement(By.xpath("//div[contains(@class, 'tooltip-inner') and text()='You hovered over the Button']"));
        String tooltipText = tooltip.getText();
        System.out.println("Tooltip text is: " + tooltipText);


    }

    public void clickOnMenuButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-7']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickOnMainItemButton() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        Thread.sleep(1000);
        WebElement subItem = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        actions.moveToElement(subItem).perform();
        WebElement subSubItem = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        subSubItem.click();

    }

    public void selectMenuButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickOnSelectValue() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        WebElement tooltipElement = driver.findElement(By.xpath("//div[text()='Select Option']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tooltipElement).click().perform();
        Thread.sleep(3000);
        WebElement OptionValue = driver.findElement(By.xpath("//div[text()='Group 2, option 1']"));
        OptionValue.click();

    }

    public void selectOne() throws InterruptedException {
        Thread.sleep(4000);
        WebElement tooltipElement = driver.findElement(By.xpath("//div[text()='Select Title']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tooltipElement).click().perform();
        Thread.sleep(3000);
        WebElement OptionValue = driver.findElement(By.xpath("//div[text()='Dr.']"));
        OptionValue.click();
    }

    public void selectOldStyleMenu() throws InterruptedException {
        Thread.sleep(2000);
        WebElement tooltipElement = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tooltipElement).click().perform();
        Thread.sleep(3000);
        WebElement OptionValue = driver.findElement(By.xpath("//option[text()='Black']"));
        OptionValue.click();

    }

    @AfterTest
    public void Teardown() {
        if (driver != null) {
            driver.quit(); //

        }
    }
}

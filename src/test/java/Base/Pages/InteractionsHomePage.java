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

public class InteractionsHomePage {
    WebDriver driver;

    @BeforeTest(enabled = true)
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test
    public void clickOnInteractionsButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Interactions']")));
        element.click();
    }

    public void clickOnSortableButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void DragTheListItems() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement itemTwo = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Two']"));
        WebElement itemSix = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Six']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(itemTwo)
                .moveToElement(itemSix)
                .release()
                .perform();
        System.out.println("Successfully done");
    }

    public void DragTheGridItems() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(By.xpath("//a[@id='demo-tab-grid']")).click();
        WebElement itemTwo = driver.findElement(By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action'][normalize-space()='Two']"));
        WebElement itemSix = driver.findElement(By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action'][normalize-space()='Four']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(itemTwo)
                .moveToElement(itemSix)
                .release()
                .perform();
        System.out.println("Successfully done");
    }

    public void clickOnResizable() {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }

    public void resizeTheTextBox() {
        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle)
                .moveByOffset(100, 50)
                .release()
                .perform();
    }

    public void clickOnDroppable() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(3000);
    }

    public void SampleDragAndDrop() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(2000);
        // Locate the "Drag me" element
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElement = driver.findElement(By.xpath("//div[@id='droppable']"));

        // Perform drag-and-drop action using Actions class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();

        String dropText = dropElement.getText();
        if (dropText.equals("Dropped!")) {
            System.out.println("Drag and Drop successful!");
        } else {
            System.out.println("Drag and Drop failed!");
        }

    }

    public void dragTheAceptbutton() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(3000);
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement dropElement = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//p[contains(text(),'Drop here')]"));

        // Perform drag-and-drop action using Actions class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();

    }

    public void DragTheNotAcceptable() throws InterruptedException {
        Thread.sleep(2000);
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        WebElement dropElement = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));

        // Perform drag-and-drop action using Actions class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).perform();
    }

    @AfterTest
    public void Teardown() {
        if (driver != null) {
            driver.quit(); //
        }
    }
}
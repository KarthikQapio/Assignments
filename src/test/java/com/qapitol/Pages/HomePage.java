package com.qapitol.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Random;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAdminModule() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);
    }

    public void clickOnJobModule() {
        driver.findElement(By.xpath("//span[text()='Job ']")).click();


    }

    public void clickOnJobTitlesButton() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Job Titles']")).click();
        Thread.sleep(3000);
    }

    public void clickOnAddButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")).click();
        Thread.sleep(3000);
    }

    public void enterDuplicateJobTitle() {
        driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).sendKeys("Broker");
    }

    public void clickAndEnterJobTitle() {
        String randomJobTitle = "Job-" + new Random().nextInt(1000);
        WebElement firstInput = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        firstInput.sendKeys(randomJobTitle);
        firstInput.sendKeys(Keys.CONTROL, "a");  // Select all text
        firstInput.sendKeys(Keys.CONTROL, "c");

    }

    public void clickAndEnterJobDescription() {
        driver.findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys("I want To learn Java and Selenium");
    }

    public void clickOnSaveButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    public void getErrorMessageText() {
        WebElement element = driver.findElement(By.xpath("//span[text()='Required']"));
        String actualText = element.getText();
        String expectedText = "Required";
        Assert.assertEquals(actualText, expectedText, "The text does not match!");

    }

    public void getAlreadyExistsText() {
        WebElement element = driver.findElement(By.xpath("//span[text()='Already exists']"));
        String actualText = element.getText();
        String expectedText = "Already exists";
        Assert.assertEquals(actualText, expectedText, "The text does not match!");
    }

    public void clickOnJobCategoriesButton() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Job Categories']")).click();
        Thread.sleep(4000);
    }

    public void clickOnAddButtonInJobCategories() throws InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(3000);

    }
    public void enterJobCategoriesName(){
        String randomJobTitle = "Categories-" + new Random().nextInt(1000);
        WebElement firstInput = driver.findElement(By.xpath(" driver.findElement(By.xpath(\"//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        firstInput.sendKeys(randomJobTitle);
    }
}

package org.example.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registrationpage extends AbstractFacebookPage{
    WebDriver driver;
    public void registerPage() throws InterruptedException {
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.facebook.com");
                driver.manage().window().maximize();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Create new account']"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='First name']"))).sendKeys("Jackone");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Surname']"))).sendKeys("sparrow");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@aria-label='Day']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='3']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@aria-label='Month']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Oct']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='year']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='2012']"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Mobile number or email address']"))).sendKeys("Hjectory");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='New password']"))).sendKeys("567898765r");
            }
        }



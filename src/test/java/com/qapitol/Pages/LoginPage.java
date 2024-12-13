//package com.qapitol.Pages;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class LoginPage {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        Thread.sleep(5000);
//    }
//    public void EnterUsername() throws InterruptedException {
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin12345");
////      driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
//    }
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
package com.qapitol.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }
    public void clickLogin() throws InterruptedException {
        driver.findElement(By.xpath(" //button[text()=' Login ']")).click();
//        Thread.sleep(5000);
    }
}



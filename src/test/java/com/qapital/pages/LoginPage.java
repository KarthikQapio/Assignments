package com.qapital.pages;

import com.qapital.base.BaseClass;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

    public void login(String username, String password) {

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }
}

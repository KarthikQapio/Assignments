package com.qapital.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;

    public static void initialize() throws IOException {
        FileReader file = new FileReader(new File("C:\\Users\\karthik.nagendrappa\\OneDrive - QAPITOL QA\\Book 6.xlsx"));
        properties = new Properties();
        properties.load(file);
        driver = new ChromeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
    public static void quit(){
        driver.quit();
    }
}

package com.qapital.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qapital.base.BaseClass;
import com.qapital.pages.LoginPage;
import com.qapital.util.ReadExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTestCase {
    private static final Logger logger = (Logger) LogManager.getLogger(LoginPage.class);
        //LogManager.getLogger(LoginPageTestCase.class);

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    LoginPage loginPage;
    @BeforeTest
    public void setUp() throws IOException {
        Theme Theme = null;
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Keyword driven Report");

        BaseClass.initialize();
        logger.debug("Entered into SetUp");
        loginPage = new LoginPage();
    }

    @DataProvider(name = "data")
    public Object[][] loginData() throws IOException {
       Object[][] data =  ReadExcel.getData();

       return data;
    }

    @Test(dataProvider = "data")
    public void testLogin(String user,
                          String pass) throws IOException, InterruptedException {

        ExtentTest text = extent.createTest("Execution of Keyword Drivern Testing")
                .assignAuthor("Karthik").assignCategory("Automation Test").assignDevice("Window");

        text.info("Initization of Script");
        loginPage.login(user,pass);
        String expected = "QAPit0l";
        text.pass("Validation completed");
        String actual = "QAPit0l";
        Assert.assertEquals(actual,expected,"This is not same");
    }
    @AfterTest
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        BaseClass.quit();

        extent.flush();
    }
}


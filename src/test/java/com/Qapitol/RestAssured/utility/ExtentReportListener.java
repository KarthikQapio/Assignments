package com.Qapitol.RestAssured.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

    public static void setupReport() {
        sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }
    public static ExtentTest getTest() {
        return test;
    }
}

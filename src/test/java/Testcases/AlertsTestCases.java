package Testcases;

import Base.Pages.AlertsHomePage;
import org.testng.annotations.Test;

public class AlertsTestCases {


    AlertsHomePage alerts = new AlertsHomePage();
    @Test
    public void clickOnAlertsAndFramespage() throws InterruptedException {
        alerts.launchBrowser();
        alerts.clickOnAlertsPage();
        alerts.clickOnBrowserwindowsButton();
        alerts.clickOnNewTab();
        alerts.clickOnBrowserwindowsButton();
        alerts.clickOnNewWindow();
        alerts.clickOnBrowserwindowsButton();
        alerts.clickOnNewWindowMessageTab();
        alerts.clickOnAlertsButton();
        alerts.clickOnfiveSecondsAlertButton();
        Thread.sleep(3000);
        alerts.clickOnConfirmButton();
        Thread.sleep(3000);
        alerts.clickOnPromptButton();
        alerts.clickOnFrames();
//        alerts.handleNestedFrames();
        alerts.Teardown();

    }
}

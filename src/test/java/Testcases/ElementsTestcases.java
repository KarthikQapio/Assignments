package Testcases;

import Base.BaseClass;
import Base.Pages.ElementsHomepage;
import Base.Pages.LoginPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ElementsTestcases  {
    BaseClass base = new BaseClass();
    ElementsHomepage elementsHomepage = new ElementsHomepage();
    LoginPage login = new LoginPage();

    @Test(enabled = true)
    @Description("Tc-01 Open the elements Page and Test All Features  ")
    public void clickOnElementsPageAndTestTextBoxEveryFeatures() throws InterruptedException {
        elementsHomepage.launchBrowser();
        elementsHomepage.LaunchBrowserandElements();
        elementsHomepage.clickonTextButton();
        Thread.sleep(5000);
        elementsHomepage.enterFullName();
        elementsHomepage.enterEmailId();
        elementsHomepage.enterCurrentAddress();
        elementsHomepage.enterPermanantAddress();
        elementsHomepage.clickOnElementsCheckBox();
        elementsHomepage.clickOnPlusButton();
        elementsHomepage.clickOnAllCheckBox();
        elementsHomepage.cickOnradioButton();
        elementsHomepage.SelectYesInRadioButton();
        elementsHomepage.clickOnWebTablesButtonAndAddTheMembers();
        elementsHomepage.clickOnAllButtonsInElementsPage();
        elementsHomepage.clickOnLinks();
        elementsHomepage.clickOnBrokenLinks();
        elementsHomepage.clickOnUploadAndDownloadButton();

    }
}

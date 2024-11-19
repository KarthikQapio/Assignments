package Testcases;

import Base.Pages.FormsHomePage;
import Base.Pages.WidgetsHomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class WidgetsTestcases {
    WidgetsHomePage widget = new WidgetsHomePage();

    @Test
    @Description("TC-4 verify that widgetsPage and Test all features")
    public void clickOnWidgetsPageAndTestAllFeatures() throws InterruptedException {
        widget.launchBrowser();
        widget.clickOnWidgetsButton();
        widget.clickOnAccordionButton();
        widget.clickOnAutoCompleteButton();
        widget.enterMultipleColourNames();
        widget.enterSingleColourName();
        widget.clickOnDatePicker();
        widget.SelectTheDAte();
        widget.clickOnSliderButton();
        widget.slideTheSlider();
        widget.clickOnProgressBarButton();
        widget.clickOnStartButton();
        widget.clickOnTabs();
        widget.clickOnOrigin();
        widget.clickOnToolTips();
        widget.MouseOverTheElement();
        widget.clickOnMenuButton();
        widget.clickOnMainItemButton();
        widget.selectMenuButton();
        widget.clickOnSelectValue();
        widget.selectOne();
        widget.selectOldStyleMenu();
        widget.Teardown();

    }
}

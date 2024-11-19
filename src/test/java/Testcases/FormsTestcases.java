package Testcases;

import Base.Pages.ElementsHomepage;
import Base.Pages.FormsHomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class FormsTestcases {
    FormsHomePage forms = new FormsHomePage();
    ElementsHomepage elementsHomepage = new ElementsHomepage();



    @Test
    @Description("Tc-02 Open the Forms Page and Test every Features As Expected ")
    public void OpenFormsPageAndTestAllFeatures() throws InterruptedException {
        forms.launchBrowser();
        forms.clickOnFormsPage();
        forms.clickOnPracticeForm();
        forms.fillThePracticeForm();
        forms.enteremailidInformsPage();
        forms.enterMobileNumber();
        forms.clickOnRadioButton();
        forms.enterDateOfBirth();
        forms.selectHobbies();
        forms.selectPicture();
        forms.currrentAddress();
        forms.selectState();
        forms.selectCity();
        forms.clickOnSubmitButton();
        forms.closeTheSubmittingFOrm();
        forms.Teardown();


    }
}

package com.qapitol.tests;

import com.qapitol.Pages.HomePage;
import com.qapitol.Pages.LoginPage;
import com.qapitol.base.Baseclass;
import org.testng.annotations.Test;

public class AdminTestcases extends Baseclass {

    @Test(enabled = false,
            description = "Tc-01 Verify the ability to add a new job title.")
    public void enterJobTitleAndClickOnSaveChanges() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();
        Thread.sleep(3000);
        home.clickOnAdminModule();
        home.clickOnJobModule();
        home.clickOnJobTitlesButton();
        home.clickOnAddButton();
        home.clickAndEnterJobTitle();
        home.clickAndEnterJobDescription();
        Thread.sleep(2000);
        home.clickOnSaveButton();

    }

    @Test(enabled = false,
            description = "Tc-02 Verify adding a job title with no data entered.")
    public void verifyThatWithoutEnterAnyDataAndCLickOnSaveButton() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();
        Thread.sleep(3000);
        home.clickOnAdminModule();
        home.clickOnJobModule();
        home.clickOnJobTitlesButton();
        home.clickOnAddButton();
        Thread.sleep(3000);
        home.clickOnSaveButton();
        home.getErrorMessageText();

    }

    @Test(enabled = false,
            description = "Verify adding a duplicate job title.")
    public void enterDuplicateJobTitleAndClickOnSaveChanges() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();
        Thread.sleep(3000);
        home.clickOnAdminModule();
        home.clickOnJobModule();
        home.clickOnJobTitlesButton();
        home.clickOnAddButton();
        home.enterDuplicateJobTitle();
        home.clickAndEnterJobDescription();
        Thread.sleep(2000);
        home.clickOnSaveButton();
        home.getAlreadyExistsText();
    }

    @Test(enabled = true,
            description = "Verify the ability to add a new Job categories .")
    public void verifyAndAddJobCategoriesAndClickOnSaveButton() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();
        Thread.sleep(3000);
        home.clickOnAdminModule();
        home.clickOnJobModule();
        home.clickOnJobCategoriesButton();
        home.clickOnAddButtonInJobCategories();
        home.enterJobCategoriesName();


    }

}

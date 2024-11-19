package Testcases;

import Base.Pages.InteractionsHomePage;
import org.testng.annotations.Test;

public class InteractionsTestcases {
    InteractionsHomePage interaction = new InteractionsHomePage();
    @Test
    public void clickOnInteractionPageAndTestAllFeatures(){
        interaction.launchBrowser();
        interaction.clickOnInteractionsButton();
        interaction.clickOnSortableButton();
        interaction.DragTheListItems();
        interaction.DragTheGridItems();
//        interaction.Teardown();
    }
}

package Testcases;

import Base.Pages.InteractionsHomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class InteractionsTestcases {
    InteractionsHomePage interaction = new InteractionsHomePage();
    @Test
    @Description("Hiii Hello")
    public void clickOnInteractionPageAndTestAllFeatures() throws InterruptedException {
        interaction.launchBrowser();
        interaction.clickOnInteractionsButton();
        interaction.clickOnSortableButton();
        interaction.DragTheListItems();
        interaction.DragTheGridItems();
        interaction.clickOnResizable();
        interaction.resizeTheTextBox();
        interaction.clickOnDroppable();
        interaction.SampleDragAndDrop();
        interaction.dragTheAceptbutton();
        interaction.DragTheNotAcceptable();
        interaction.Teardown();
    }
}

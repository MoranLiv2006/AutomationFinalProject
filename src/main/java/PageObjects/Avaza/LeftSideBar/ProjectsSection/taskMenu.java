package PageObjects.Avaza.LeftSideBar.ProjectsSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class taskMenu
{
    @FindBy(how = How.ID, using = "new-task-title")
    public WebElement input_taskTitle;

    @FindBy(how = How.CSS, using = "div[class='fr-element fr-view']")
    public WebElement input_taskDescription;

    @FindBy(how = How.XPATH, using = "//form[@id='create-task-form']//button[@type='submit']")
    public WebElement btn_save;

}

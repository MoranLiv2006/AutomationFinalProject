package PageObjects.Avaza.Mobile.Sidebar.Projects.ProjectPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class taskMenuPageMobile
{
    @FindBy(how = How.ID, using = "new-task-title")
    public WebElement txt_taskTitle;

    @FindBy(how = How.XPATH, using = "//*[@text='\\n']")
    public WebElement txt_taskDescription;

    @FindBy(how = How.XPATH, using = "//*[@text='Save']")
    public WebElement btn_saveTask;
}

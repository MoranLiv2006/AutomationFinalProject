package PageObjects.Avaza.Mobile.Sidebar.Projects.ProjectPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class projectPageMobile
{
    @FindBy(how = How.ID, using = "project-title")
    public WebElement txt_projectHeader;

    @FindBy(how = How.XPATH, using = "//*[@contentDescription='Add task']")
    public WebElement btn_newTask;

    @FindBy(how = How.XPATH, using = "//*[@text='Success']")
    public WebElement popup_doneMsg;

    @FindBy(how = How.ID, using = "tasklist-vertical")
    public WebElement table_tasksTable;
}

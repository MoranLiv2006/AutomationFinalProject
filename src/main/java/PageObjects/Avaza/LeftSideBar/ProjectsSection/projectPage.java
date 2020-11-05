package PageObjects.Avaza.LeftSideBar.ProjectsSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class projectPage
{
    @FindBy(how = How.CSS, using = "span[id='project-title']")
    public WebElement txt_projectHeader;

    @FindBy(how = How.CSS, using = "a[class='add-task-inline-link']")
    public WebElement btn_addNewTask;

    @FindBy(how = How.ID, using = "new-task-inline-title")
    public WebElement input_newTaskInput;

    @FindBy(how = How.CSS, using = "h4[class='ui-pnotify-title']")
    public WebElement popup_doneMsg;

    @FindBy(how = How.XPATH, using = "//div[@class='task-group-body sortable2 ui-sortable']/div")
    public List<WebElement> rows_tasks;

    @FindBy(how = How.CSS, using = "button[class='btn btn-success add-task-link  hidden-xs hidden-sm mytasks-hide']")
//    @FindBy(how = How.CSS, using = "a[href='#']")
    public WebElement btn_addNewTaskUpperButton;

    @FindBy(how = How.CSS, using = "div[class='vertical-center task-handle ui-sortable-handle']")
    public List<WebElement> rows_draggableTasks;
}

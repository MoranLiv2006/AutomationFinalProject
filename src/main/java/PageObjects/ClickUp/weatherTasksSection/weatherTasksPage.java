package PageObjects.ClickUp.weatherTasksSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class weatherTasksPage
{
    @FindBy(how = How.CSS, using = "cu-task-row[class='cu-task-row ng-star-inserted']")
    public List<WebElement> weatherTasksRows;

    @FindBy(how = How.CSS, using = "div[class='cu-task-list-footer__add-text']")
    public WebElement btn_newTask;

    @FindBy(how = How.CLASS_NAME, using = "cu-task-row-new__input")
    public WebElement txt_newTaskField;
}

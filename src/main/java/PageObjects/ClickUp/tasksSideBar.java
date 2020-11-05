package PageObjects.ClickUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class tasksSideBar
{
    @FindBy(how = How.LINK_TEXT, using = "Automation Bot's Space")
    public WebElement dropdown_tasksHeadLine;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Weather')]")
    public WebElement btn_weatherTasks;

}

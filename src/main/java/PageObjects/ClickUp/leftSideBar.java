package PageObjects.ClickUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class leftSideBar
{
    @FindBy(how = How.CSS, using = "div[class='cu-avatar cu2-spaces-bar__avatar cu2-spaces-bar__avatar_workspace ng-star-inserted']")
    public WebElement btn_profile;

    @FindBy(how = How.CSS, using = "a[href='https://app.clickup.com/3757143/v/l/li/16415314']")
    public WebElement btn_tasks;


}

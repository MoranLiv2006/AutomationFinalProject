package PageObjects.ClickUp.profileMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class profileSideBar
{
//    @FindBy(how = How.CSS, using = "a[href='https://app.clickup.com/3757143/v/l/li/16415314']")
    @FindBy(how = How.CLASS_NAME, using = "cu-nav-sts__back")
    public WebElement btn_back;

}

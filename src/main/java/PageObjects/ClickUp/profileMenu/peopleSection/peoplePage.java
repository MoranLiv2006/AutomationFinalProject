package PageObjects.ClickUp.profileMenu.peopleSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class peoplePage
{
    @FindBy(how = How.CSS, using = "div[class='cu-sts__title']")
    public WebElement txt_header;

    @FindBy(how = How.XPATH, using = "//div[@class='cu-tms-user ng-star-inserted']")
    public List<WebElement> peopleRows;

    @FindBy(how = How.CSS, using = "input[placeholder='Invite by email (multiple lines and CSV accepted)']")
    public WebElement txt_inviteByEmail;

    @FindBy(how = How.CSS, using = "button[class='cu-btn cu-btn_md cu-tms-form__btn']")
    public WebElement btn_invite;

    @FindBy(how = How.CSS, using = "div[class='toast__success-header ng-star-inserted']")
    public WebElement msg_succsess;
}

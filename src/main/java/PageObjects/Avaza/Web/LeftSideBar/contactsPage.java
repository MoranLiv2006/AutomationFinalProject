package PageObjects.Avaza.Web.LeftSideBar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class contactsPage
{
    @FindBy(how = How.CLASS_NAME, using = "standard-page-title")
    public WebElement txt_contactsHeader;

    @FindBy(how = How.XPATH, using = "//table[@id='team-table']/tbody/tr")
    public List<WebElement> rows_contactList;

    @FindBy(how = How.CSS, using = "div[class='btn btn-success flat pull-right add-team-contact']")
    public WebElement btn_addUser;

    @FindBy(how = How.ID, using = "Email")
    public WebElement input_emailInput;

    @FindBy(how = How.ID, using = "FirstName")
    public WebElement input_firstNameInput;

    @FindBy(how = How.ID, using = "LastName")
    public WebElement input_lastNameInput;

    @FindBy(how = How.CSS, using = "button[class='btn btn-success pull-right save-button']")
    public WebElement btn_save;

    @FindBy(how = How.CSS, using = "div[class='alert ui-pnotify-container alert-success ui-pnotify-shadow']")
    public WebElement popup_popupWindow;

    @FindBy(how = How.CSS, using = "h4[class='ui-pnotify-title']")
    public WebElement popup_msgTitle;

    @FindBy(how = How.CSS, using = "a[class='btn dropdown-toggle expander']")
    public List<WebElement> rows_userOptions;

    @FindBy(how = How.CSS, using = "a[class='delete-user']")
    public WebElement btn_deleteUser;
}

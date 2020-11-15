package PageObjects.Avaza.Mobile.Sidebar.Contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class contactsPageMobile
{
    @FindBy(how = How.LINK_TEXT, using = "  Add User")
    public WebElement btn_addUser;

    @FindBy(how = How.ID, using = "Email")
    public WebElement input_emailInput;

    @FindBy(how = How.ID, using = "FirstName")
    public WebElement input_firstNameInput;

    @FindBy(how = How.ID, using = "LastName")
    public WebElement input_lastNameInput;

    @FindBy(how = How.LINK_TEXT, using = "Save")
    public WebElement btn_saveUser;

    ////*[@contentDescription='contact#' and ./parent::*[./parent::*[./parent::*[@id='user-16988']]]]
    //*[@contentDescription='Delete']
}

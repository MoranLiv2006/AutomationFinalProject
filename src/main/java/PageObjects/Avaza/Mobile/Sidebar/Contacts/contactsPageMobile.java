package PageObjects.Avaza.Mobile.Sidebar.Contacts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
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

//    @FindBy(how = How.XPATH, using = "//*[@contentDescription='contact#' and ./parent::*[./parent::*[./parent::*[@text='Test User']]]]")
    @FindBy(how = How.XPATH, using = "//*[@contentDescription='contact#' and @text='Test User']")
    public WebElement btn_rowOption;

    @FindBy(how = How.XPATH, using = "//*[@contentDescription='Delete']")
    public WebElement btn_deleteUser;

    //

    //

    ////*[ and ]
    //*[@contentDescription='Delete']
}

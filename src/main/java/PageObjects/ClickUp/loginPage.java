package PageObjects.ClickUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage
{
    @FindBy(how = How.ID, using = "email-input")
    public WebElement txt_emailInput;

    @FindBy(how = How.ID, using = "password-input")
    public WebElement txt_passwordInput;

    @FindBy(how = How.ID, using = "login-submit")
    public WebElement btn_login;
}

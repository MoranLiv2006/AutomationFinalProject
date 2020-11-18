package PageObjects.Avaza.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage
{
    @FindBy(how = How.ID, using = "Email")
    public WebElement input_emailInput;

    @FindBy(how = How.ID, using = "Password")
    public WebElement input_passwordInput;

    @FindBy(how = How.CSS, using = "input[class='btn btn-primary btn-lg']")
    public WebElement btn_login;
}



package PageObjects.Avaza.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(how = How.CSS, using = "div[class='get-started-header text-center']")
    public WebElement txt_welcomeMsg;
}

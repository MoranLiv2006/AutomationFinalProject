package PageObjects.ClickUp.profileMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class profileMenu
{
    @FindBy(how = How.CSS, using = "a[class='people ng-star-inserted']")
    public WebElement btn_people;
}

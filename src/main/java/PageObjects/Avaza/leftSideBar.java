package PageObjects.Avaza;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class leftSideBar
{
    @FindBy(how = How.CLASS_NAME, using = "li-contacts")
    public WebElement btn_contacts;

    @FindBy(how = How.CSS, using = "li[class='scoop-hasmenu li-projects']")
    public WebElement btn_projects;

    @FindBy(how = How.CSS, using = "a[href='/project']")
    public WebElement btn_allProjects;

    @FindBy(how = How.CSS, using = "a[title='AVAZA']  img")
    public WebElement img_avazaAvatar;


}

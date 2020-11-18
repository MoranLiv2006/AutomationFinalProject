package PageObjects.Avaza.Web.LeftSideBar.ProjectsSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class projectsPage
{
    @FindBy(how = How.ID, using = "project-14398")
    public WebElement btn_weatherProject;

    @FindBy(how = How.ID, using = "project-14933")
    public WebElement btn_chuckNOrrisProject;

    @FindBy(how = How.CSS, using = "div[class='standard-page-title']")
    public WebElement txt_projectsHeader;
}

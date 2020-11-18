package PageObjects.Avaza.Mobile.Sidebar.Projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class projectsPage
{
    @FindBy(how = How.LINK_TEXT, using = "Weather")
    public WebElement btn_weatherPrject;

    @FindBy(how = How.LINK_TEXT, using = "Chuck Norris jokes")
    public WebElement btn_chuckNorrisJokesPrject;

    @FindBy(how = How.XPATH, using = "//*[@text='Projects']")
    public WebElement txt_projectsHeader;
}

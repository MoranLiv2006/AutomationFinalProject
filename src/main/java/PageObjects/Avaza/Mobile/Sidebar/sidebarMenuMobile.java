package PageObjects.Avaza.Mobile.Sidebar;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class sidebarMenuMobile
{
    @FindBy(how = How.XPATH, using = "//*[@contentDescription='Contacts']")
    public WebElement btn_contacts;

    @FindBy(how = How.XPATH, using = "//*[@text='All Tasks']")
    public WebElement btn_allTasks;

    @FindBy(how = How.XPATH, using = "//*[@contentDescription='All Projects']")
    public WebElement btn_allProjects;

    @FindBy(how = How.LINK_TEXT, using = "AVAZA")
    public WebElement btn_homePage;
}

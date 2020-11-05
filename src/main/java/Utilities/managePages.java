package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        loginPage = PageFactory.initElements(driver, PageObjects.Avaza.loginPage.class);
        mainPage = PageFactory.initElements(driver, PageObjects.Avaza.mainPage.class);
        leftSideBar = PageFactory.initElements(driver, PageObjects.Avaza.leftSideBar.class);
        contactsPage = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.contactsPage.class);
        projectsPage = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.ProjectsSection.projectsPage.class);
        projectPage = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.ProjectsSection.projectPage.class);
        taskMenu = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.ProjectsSection.taskMenu.class);
    }
}

package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        clickupLoginPage = PageFactory.initElements(driver, PageObjects.ClickUp.loginPage.class);
        clickupLeftSideBar = PageFactory.initElements(driver, PageObjects.ClickUp.leftSideBar.class);
        profileMenu = PageFactory.initElements(driver, PageObjects.ClickUp.profileMenu.profileMenu.class);
        peoplePage = PageFactory.initElements(driver, PageObjects.ClickUp.profileMenu.peopleSection.peoplePage.class);
        profileSideBar = PageFactory.initElements(driver, PageObjects.ClickUp.profileMenu.profileSideBar.class);
        tasksSideBar = PageFactory.initElements(driver, PageObjects.ClickUp.tasksSideBar.class);
        weatherTasksPage = PageFactory.initElements(driver, PageObjects.ClickUp.weatherTasksSection.weatherTasksPage.class);

        loginPage = PageFactory.initElements(driver, PageObjects.Avaza.loginPage.class);
        mainPage = PageFactory.initElements(driver, PageObjects.Avaza.mainPage.class);
        leftSideBar = PageFactory.initElements(driver, PageObjects.Avaza.leftSideBar.class);
        contactsPage = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.contactsPage.class);
        projectsPage = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.ProjectsSection.projectsPage.class);
        projectPage = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.ProjectsSection.projectPage.class);
        taskMenu = PageFactory.initElements(driver, PageObjects.Avaza.LeftSideBar.ProjectsSection.taskMenu.class);
    }
}

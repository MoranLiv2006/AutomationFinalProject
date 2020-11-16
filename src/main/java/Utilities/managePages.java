package Utilities;

import PageObjects.Avaza.Mobile.Sidebar.Projects.ProjectPage.taskMenuPageMobile;
import PageObjects.Avaza.Mobile.mainPageMobile;
import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        //Web
        loginPage = PageFactory.initElements(driver, PageObjects.Avaza.Web.loginPage.class);
        mainPage = PageFactory.initElements(driver, PageObjects.Avaza.Web.mainPage.class);
        leftSideBar = PageFactory.initElements(driver, PageObjects.Avaza.Web.leftSideBar.class);
        contactsPage = PageFactory.initElements(driver, PageObjects.Avaza.Web.LeftSideBar.contactsPage.class);
        projectsPage = PageFactory.initElements(driver, PageObjects.Avaza.Web.LeftSideBar.ProjectsSection.projectsPage.class);
        projectPage = PageFactory.initElements(driver, PageObjects.Avaza.Web.LeftSideBar.ProjectsSection.projectPage.class);
        taskMenu = PageFactory.initElements(driver, PageObjects.Avaza.Web.LeftSideBar.ProjectsSection.taskMenu.class);

        //Mobile
        sidebarMenuMobile = PageFactory.initElements(mobileDriver, PageObjects.Avaza.Mobile.Sidebar.sidebarMenuMobile.class);
        contactsPageMobile = PageFactory.initElements(mobileDriver, PageObjects.Avaza.Mobile.Sidebar.Contacts.contactsPageMobile.class);
        projectsPageMobile = PageFactory.initElements(mobileDriver, PageObjects.Avaza.Mobile.Sidebar.Projects.projectsPage.class);
        projectPageMobile = PageFactory.initElements(mobileDriver, PageObjects.Avaza.Mobile.Sidebar.Projects.ProjectPage.projectPageMobile.class);
        taskMenuPageMobile = PageFactory.initElements(mobileDriver, taskMenuPageMobile.class);
        allTasksPageMobile = PageFactory.initElements(mobileDriver, PageObjects.Avaza.Mobile.Sidebar.AllTasks.allTasksPageMobile.class);
    }

    public static void initApp()
    {
//        mainPageMobile = PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
        mainPageMobile = new mainPageMobile(mobileDriver);
//        sidebarMenuMobile = new sidebarMenuMobile(mobileDriver);
//        contactsPageMobile = PageFactory.initElements(mobileDriver, PageObjects.Avaza.Mobile.Sidebar.Contacts.contactsPageMobile.class);
    }
}

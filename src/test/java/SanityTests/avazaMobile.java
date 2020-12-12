package SanityTests;

import Extenstions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class avazaMobile extends commonOps
{
    @Test(priority = 0, description = "Test01: Successful Loing to Avaza mobile app.")
    @Description("Test Description: Checking successful login to Avaza mobile app.")
    public static void test01_successfulLogin()
    {
        verifications.textInElement(mainPageMobile.txt_welcomeMsg, "Welcome to Avaza, the cloud business platform.");
    }

    @Test(priority = 1, description = "Test02: Weather task.")
    @Description("Test Description: Adding new user to the contacts list and verifying the contacts list has grown.")
    public static void test02_addNewWeatherTask()
    {
        mobileFlows.openSidebar();
        mobileFlows.goToProjectsMenu();
        verifications.textInElement(projectsPageMobile.txt_projectsHeader, "Projects");
        mobileFlows.goToWeatherProject();
        verifications.textInElement(projectPageMobile.txt_projectHeader, "Weather");
        mobileFlows.writeWeatherTaskWithDescription();
        verifications.textInElement(projectPageMobile.popup_doneMsg, "Success");
    }

    @Test(priority = 2, description = "Test03: Chuck Norris joke task.")
    @Description("Test Description: Adding new user to the contacts list and verifying the contacts list has grown.")
    public static void test03_addNewChuckNorrisJokeTask()
    {
        mobileFlows.openSidebar();
        mobileFlows.goToProjectsMenu();
        verifications.textInElement(projectsPageMobile.txt_projectsHeader, "Projects");
        mobileFlows.goToChuckNorrisProject();
        verifications.textInElement(projectPageMobile.txt_projectHeader, "Chuck Norris jokes");
        mobileFlows.writeChuckNorrisTaskWithDescription();
        verifications.textInElement(projectPageMobile.popup_doneMsg, "Success");
    }

    @Test(priority = 3, description = "Test04: Swipe to the see the tasks that recently created.")
    @Description("Test Description: Navigate to the all tasks page and swipe to the bottom of the page the see the tasks that you just created.")
    public static void test04_swipeVertically3TimesInTasksPage()
    {
        mobileFlows.openSidebar();
        mobileFlows.goToAllTasksMenu();
        mobileFlows.swiptDown3TimesInAllTasks();
    }
}

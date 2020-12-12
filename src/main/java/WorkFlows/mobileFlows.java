package WorkFlows;

import Utilities.commonOps;
import Extenstions.uiActions;
import Extenstions.mobileActions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utilities.helperMethods.*;

public class mobileFlows extends commonOps
{
    @Step("Opening the sidebar by click the icon.")
    public static void openSidebar()
    {
       uiActions.click(mainPageMobile.btn_sideBarMenu);
    }

    @Step("Opening the Projects menu by clicking the Projects button.")
    public static void goToProjectsMenu()
    {
        uiActions.click(sidebarMenuMobile.btn_allProjects);
    }

    @Step("Navigate to Weather project in the projects menu by clicking the Weather project button.")
    public static void goToWeatherProject()
    {
        uiActions.click(projectsPageMobile.btn_weatherPrject);
    }

    @Step("Navigate to Chuck Norris Jokes project in the projects menu by clicking the Chuck Norris Jokes project button.")
    public static void goToChuckNorrisProject()
    {
        uiActions.click(projectsPageMobile.btn_chuckNorrisJokesPrject);
    }

    @Step("Navigate to All Tasks menu by clicking the button.")
    public static void goToAllTasksMenu()
    {
        uiActions.click(sidebarMenuMobile.btn_allTasks);
    }

    @Step("Navigate back to the main page of the app after finishing successfully test.")
    public static void backToHomePage()
    {
        openSidebar();
        uiActions.click(sidebarMenuMobile.btn_homePage);
        wait.until(ExpectedConditions.visibilityOf(mainPageMobile.txt_welcomeMsg));
    }

    @Step("Writing new task in Weather project - each task contain headline and description as weather of Rishon Le Zion (My hometown) in the current time.")
    public static void writeWeatherTaskWithDescription()
    {
        uiActions.click(projectPageMobile.btn_newTask);
        uiActions.updateText(taskMenuPageMobile.txt_taskTitle, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " (Mobile)");
        uiActions.click(taskMenuPageMobile.txt_taskDescription);
        uiActions.updateText(taskMenuPageMobile.txt_taskDescription, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " Temperature: " + getWeatherInformation().get(1) + ", Feels like: " + getWeatherInformation().get(2));
        mobileDriver.hideKeyboard();
        uiActions.click(taskMenuPageMobile.btn_saveTask);
    }

    @Step("Writing new task in Chuck Norris Jokes project - each task contain headline and description as joke about Chuck Norris, imported by chucknorris.io api.")
    public static void writeChuckNorrisTaskWithDescription()
    {
        uiActions.click(projectPageMobile.btn_newTask);
        uiActions.updateText(taskMenuPageMobile.txt_taskTitle, getChuckNorrisJoke() + " " + getTimeAndDate() + " (Mobile)");
        uiActions.click(taskMenuPageMobile.txt_taskDescription);
        uiActions.updateText(taskMenuPageMobile.txt_taskDescription, getTimeAndDate() + " (Mobile)");
        mobileDriver.hideKeyboard();
        uiActions.click(taskMenuPageMobile.btn_saveTask);
    }

    @Step("Swipe to the bottom of the tasks page.")
    public static void swiptDown3TimesInAllTasks()
    {
        mobileActions.swipeVerticalNumberOfTimes(projectPageMobile.table_tasksTable, 3);
    }
}

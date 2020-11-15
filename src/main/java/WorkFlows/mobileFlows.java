package WorkFlows;

import Extenstions.dbActions;
import Utilities.commonOps;
import Extenstions.uiActions;
import io.qameta.allure.Step;

import java.util.List;

import static Utilities.helperMethods.*;

public class mobileFlows extends commonOps
{
    public static void openSidebar()
    {
       uiActions.click(mainPageMobile.btn_sideBarMenu);
    }

    public static void openContactsMenu()
    {
        openSidebar();
        uiActions.click(sidebarMenuMobile.btn_contacts);
    }

    public static void goToProjectsMenu()
    {
        try
        {
            uiActions.click(sidebarMenuMobile.btn_allProjects);
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        System.out.println("Error: " + e);
        }
    }

    public static void goToWeatherProject()
    {
        uiActions.click(projectsPageMobile.btn_weatherPrject);
    }

    public static void goToChuckNorrisProject()
    {
        uiActions.click(projectsPageMobile.btn_chuckNorrisJokesPrject);
    }

    public static void backToHomePage()
    {
//        openSidebar();
        uiActions.click(sidebarMenuMobile.btn_homePage);
    }

    @Step("Adding new user to the contacts list")
    public static void avazaAddNewUser()
    {
        List<String> newUserDetails = dbActions.getSecondContactDetails("SELECT email, first_name, last_name FROM Contacts WHERE id='2'");
        uiActions.click(contactsPageMobile.btn_addUser);
        uiActions.updateText(contactsPageMobile.input_emailInput, newUserDetails.get(0));
        uiActions.updateText(contactsPageMobile.input_firstNameInput, newUserDetails.get(1));
        uiActions.updateText(contactsPageMobile.input_lastNameInput, newUserDetails.get(2));
//        driver.swipe(contactsPageMobile.input_lastNameInput.getRect().getX(), contactsPageMobile.input_lastNameInput.getRect().getY(), contactsPageMobile.btn_saveUser.getRect().getX(), contactsPageMobile.btn_saveUser.getRect().getY(), 100);
//        driver.swipe(contactsPageMobile.input_lastNameInput.getRect().getX(), contactsPageMobile.input_lastNameInput.getRect().getY(), contactsPageMobile.btn_saveUser.getRect().getX(), contactsPageMobile.btn_saveUser.getRect().getY(), 100);
        uiActions.click(contactsPageMobile.btn_saveUser);
    }

    public static void writeWeatherTaskWithDescription()
    {
        uiActions.click(projectPageMobile.btn_newTask);
        uiActions.updateText(taskMenuPageMobile.txt_taskTitle, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " (Mobile)");
        uiActions.updateText(taskMenuPageMobile.txt_taskDescription, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " Temperature: " + getWeatherInformation().get(1) + ", Feels like: " + getWeatherInformation().get(2));

        try
        {
            uiActions.click(taskMenuPageMobile.btn_saveTask);
            System.out.println("ddd");
            Thread.sleep(500);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void writeChuckNorrisTaskWithDescription()
    {
        uiActions.click(projectPageMobile.btn_newTask);
        uiActions.updateText(taskMenuPageMobile.txt_taskTitle, getChuckNorrisJoke() + " " + getTimeAndDate() + " (Mobile)");
        uiActions.updateText(taskMenuPageMobile.txt_taskDescription, getTimeAndDate() + " (Front Side)");
        uiActions.click(taskMenuPageMobile.btn_saveTask);
    }




}

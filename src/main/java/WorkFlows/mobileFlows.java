package WorkFlows;

import Extenstions.dbActions;
import Utilities.commonOps;
import Extenstions.uiActions;
import Extenstions.mobileActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

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
//        mobileDriver.findElement(By.xpath("//*[@contentDescription='Contacts']")).click();
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

    public static void goToAllTasksSection()
    {
        uiActions.click(sidebarMenuMobile.btn_allTasks);
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
        openSidebar();
        uiActions.click(sidebarMenuMobile.btn_homePage);
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Step("Adding new user to the contacts list")
    public static void avazaAddNewUser()
    {
        List<String> newUserDetails = dbActions.getSecondContactDetails("SELECT email, first_name, last_name FROM Contacts WHERE id='2'");
        uiActions.click(contactsPageMobile.btn_addUser);
        uiActions.updateText(contactsPageMobile.input_emailInput, newUserDetails.get(0));
        uiActions.updateText(contactsPageMobile.input_firstNameInput, newUserDetails.get(1));
        uiActions.updateText(contactsPageMobile.input_lastNameInput, newUserDetails.get(2));
        mobileActions.swiptToBottom();
        uiActions.click(contactsPageMobile.btn_saveUser);
    }

    @Step("Deleting the new user from the contacts list.")
    public static void avazaDeleteUser()
    {
        System.out.println(mobileDriver.findElements(By.xpath("//*[@class='android.view.View']")).size());
        uiActions.click(contactsPageMobile.btn_rowOption);
        uiActions.click(contactsPageMobile.btn_deleteUser);

        Alert popup = mobileDriver.switchTo().alert();
        popup.accept();
        mobileDriver.switchTo().defaultContent();
    }

    public static void writeWeatherTaskWithDescription()
    {
        uiActions.click(allTasksPageMobile.btn_newTask);
        uiActions.updateText(taskMenuPageMobile.txt_taskTitle, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " (Mobile)");
        mobileDriver.hideKeyboard();
        uiActions.click(taskMenuPageMobile.txt_taskDescription);
        uiActions.updateText(taskMenuPageMobile.txt_taskDescription, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " Temperature: " + getWeatherInformation().get(1) + ", Feels like: " + getWeatherInformation().get(2));
        mobileDriver.hideKeyboard();
        try
        {
            Thread.sleep(1000);
            uiActions.click(taskMenuPageMobile.btn_saveTask);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        mobileFlows.openSidebar();
    }

    public static void writeChuckNorrisTaskWithDescription()
    {
        uiActions.click(allTasksPageMobile.btn_newTask);
        uiActions.click(projectPageMobile.btn_newTask);
        uiActions.updateText(taskMenuPageMobile.txt_taskTitle, getChuckNorrisJoke() + " " + getTimeAndDate() + " (Mobile)");
        uiActions.updateText(taskMenuPageMobile.txt_taskDescription, getTimeAndDate() + " (Front Side)");
        uiActions.click(taskMenuPageMobile.btn_saveTask);
    }

    public static void addTasksOfBothKinds()
    {
        writeWeatherTaskWithDescription();
        writeChuckNorrisTaskWithDescription();
    }






}

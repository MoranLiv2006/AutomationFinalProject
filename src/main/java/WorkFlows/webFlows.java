package WorkFlows;

import Extenstions.dbActions;
import Extenstions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static Utilities.helperMethods.*;

public class webFlows extends commonOps
{
    @Step("Login Avaza Flow")
    public static void avazeLogin(String email, String password)
    {
        uiActions.updateText(loginPage.input_emailInput, email);
        uiActions.updateText(loginPage.input_passwordInput, password);
        uiActions.click(loginPage.btn_login);
    }

    @Step("Login Avaza Flow with credentials from DB.")
    public static void avazeLoginWithDB()
    {
        List<String> loginCredentials = dbActions.getLoginCredentials("SELECT user_email, user_password FROM Credentials WHERE id='1'");

        uiActions.updateText(loginPage.input_emailInput, loginCredentials.get(0));
        uiActions.updateText(loginPage.input_passwordInput, loginCredentials.get(1));
        uiActions.click(loginPage.btn_login);
    }

    @Step("Login Avaza Flow")
    public static void avazaContactsList()
    {
        uiActions.click(leftSideBar.btn_contacts);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='team-table']/tbody/tr"), 1));
    }

    @Step("Adding new user to the contacts list")
    public static void avazaAddNewUser()
    {
        List<String> newUserDetails = dbActions.getSecondContactDetails("SELECT email, first_name, last_name FROM Contacts WHERE id='2'");

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='team-table']/tbody/tr"), 1));
        uiActions.click(contactsPage.btn_addUser);
        uiActions.updateText(contactsPage.input_emailInput, newUserDetails.get(0));
        uiActions.updateText(contactsPage.input_firstNameInput, newUserDetails.get(1));
        uiActions.updateText(contactsPage.input_lastNameInput, newUserDetails.get(2));
        uiActions.click(contactsPage.btn_save);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.popup_popupWindow));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='team-table']/tbody/tr"), 2));
    }

    @Step("Deleting the new user from the contacts list table")
    public static void deleteTheNewUser()
    {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='team-table']/tbody/tr"), 2));
        uiActions.click(contactsPage.rows_userOptions.get(contactsPage.rows_userOptions.size()-1));
        uiActions.click(contactsPage.btn_deleteUser);

        Alert popup = driver.switchTo().alert();
        popup.accept();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(contactsPage.popup_popupWindow));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='team-table']/tbody/tr"), 1));
    }

    @Step("Navigate to the projects page")
    public static void getInsideProjectsPage()
    {
        uiActions.mouseHoverElements(leftSideBar.btn_projects, leftSideBar.btn_allProjects);
    }

    @Step("Navigate to project called Weather")
    public static void goToWeatherProject()
    {
        try
        {
            Thread.sleep(1000);
            uiActions.click(projectsPage.btn_weatherProject);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }

    @Step("Navigate to project called Chuck Norris jokes")
    public static void goToChuckNorrisProject()
    {
        try
        {
            Thread.sleep(1000);
            uiActions.click(projectsPage.btn_chuckNOrrisProject);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }

    @Step("Adding new weather task to the tasks list inside the project, writing the task headline and description")
    public static void writeWeatherTaskWithDescription() throws InterruptedException
    {
        Thread.sleep(1000);
        uiActions.click(projectPage.btn_addNewTaskUpperButton);
        uiActions.updateText(taskMenu.input_taskTitle, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " (Front Side)");
        uiActions.updateText(taskMenu.input_taskDescription, "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " Temperature: " + getWeatherInformation().get(1) + ", Feels like: " + getWeatherInformation().get(2));
        uiActions.click(taskMenu.btn_save);
    }

    @Step("Adding new chuck-norris-joke task to the tasks list inside the project, writing the task headline and description")
    public static void writeChuckNorrisTaskWithDescription()
    {
        uiActions.click(projectPage.btn_addNewTaskUpperButton);
        uiActions.updateText(taskMenu.input_taskTitle, getChuckNorrisJoke() + " " + getTimeAndDate() + " (Front Side)");
        uiActions.updateText(taskMenu.input_taskDescription, getTimeAndDate() + " (Front Side)");
        uiActions.click(taskMenu.btn_save);
    }



    @Step("Drag and drop between tasks")
    public static void draggingAndSwitchingTasksPlaces()
    {
        WebElement draggable = projectPage.rows_draggableTasks.get(5);
        WebElement droppable = projectPage.rows_draggableTasks.get(2);
        action.dragAndDrop(draggable, droppable).build().perform();
    }


}

package WorkFlows;

import Extenstions.dbActions;
import Extenstions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static Utilities.helperMethods.*;



public class webFlows extends commonOps
{


    public static void login(String email, String password)
    {
        uiActions.updateText(clickupLoginPage.txt_emailInput, email);
        uiActions.updateText(clickupLoginPage.txt_passwordInput, password);
        uiActions.click(clickupLoginPage.btn_login);
    }

    public static void viewPeopleOnWorkspace()
    {
        uiActions.click(clickupLeftSideBar.btn_profile);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='cu-user-settings-menu-v2__body-column ng-star-inserted']"))));
        uiActions.click(profileMenu.btn_people);
    }

    public static void invitePeopleViaEmail(String email)
    {
        uiActions.updateText(peoplePage.txt_inviteByEmail, email);
        uiActions.click(peoplePage.btn_invite);
    }

    //TODO:Continue with send date and time and connect the openweather API.
    public static void bla() throws InterruptedException
    {
        uiActions.click(profileSideBar.btn_back);
//        driver.findElement(By.cssSelector("a[href='https://app.clickup.com/3757143/v/l/li/16415314?pr=3872269']")).click();
//        uiActions.click(driver.findElement(By.cssSelector("a[href='https://app.clickup.com/3757143/v/l/li/16415314?pr=3872269']")));
//        uiActions.click(driver.findElement(By.xpath("//cu-folderless[@class='cu-folderless ng-tns-c87-29 ng-trigger ng-trigger-loadingEnter ng-star-inserted']//cu-nav-section[1]")));
        uiActions.click(tasksSideBar.dropdown_tasksHeadLine);
//        uiActions.click(tasksSideBar.btn_weatherTasks);


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String date1= dateFormat.format(date);
        System.out.println(date1);

//        System.out.println("Size before creating: " +weatherTasksPage.weatherTasksRows.size());
//        System.out.println("Last row before creating: " + weatherTasksPage.weatherTasksRows.get(weatherTasksPage.weatherTasksRows.size()-1).getText());
        if (weatherTasksPage.weatherTasksRows.size() >= 1)
        {
            uiActions.click(weatherTasksPage.btn_newTask);
        }
        uiActions.updateTextWithKey(weatherTasksPage.txt_newTaskField, date1,Keys.ENTER);
//        System.out.println("Size after creating: " + weatherTasksPage.weatherTasksRows.size());
//        System.out.println("Last row after creating: " + weatherTasksPage.weatherTasksRows.get(weatherTasksPage.weatherTasksRows.size()-1).getText());
        Thread.sleep(3000);

    }

    public static void deletingTheLastRow()
    {
        uiActions.click(profileSideBar.btn_back);
        driver.findElement(By.cssSelector("a[href='https://app.clickup.com/3757143/v/l/li/16415314?pr=3872269']")).click();
        action.contextClick(weatherTasksPage.weatherTasksRows.get(weatherTasksPage.weatherTasksRows.size()-1)).perform();
        uiActions.click(driver.findElement(By.cssSelector("div[class='nav-menu-item__icon nav-menu-item__icon_remove icon']")));
    }

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

    @Step("Avaza adding new user to the contacts list")
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
    public static void writeWeatherTaskWithDescription()
    {
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

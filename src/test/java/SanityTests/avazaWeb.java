package SanityTests;

import Extenstions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class avazaWeb extends commonOps
{
    @Test(priority = 0, description = "Test01: Login to Avaza website with credentials.")
    @Description("Test Description: Login to Avaza Web Application.")
    public void test01_login()
    {
        webFlows.avazeLoginWithDB();
        verifications.textInElement(mainPage.txt_welcomeMsg, "Welcome to Avaza, the cloud business platform.\nLet's get your business up and running. View all support articles");
    }

    @Test(priority = 1, description = "Test02: Verify default users.")
    @Description("Test Description: Verifies the default number of users. (Should be 1)")
    public void test02_verifyYouAreTheOnlyUser()
    {
        webFlows.avazaContactsList();
        verifications.textInElement(contactsPage.txt_contactsHeader, "Contacts");
        verifications.numbersOfElements(contactsPage.rows_contactList, 1);
    }


    @Test(priority = 2, description = "Test03: Add and verify new user.")
    @Description("Test Description: Adding new user to the contacts list and verifying the contacts list has grown.")
    public void test03_addAndVerifyNewUser()
    {
        webFlows.avazaContactsList();
        webFlows.avazaAddNewUser();
        verifications.textInElement(contactsPage.popup_msgTitle, "Done");
        verifications.numbersOfElements(contactsPage.rows_contactList, 2);
    }

    @Test(priority = 3, description = "Test04: Delete and verify users.")
    @Description("Test Description: Deleting the user that I just added and making sure the contacts list return to his origin size.")
    public void test04_deleteAndVerifyTheNewUser()
    {
        webFlows.avazaContactsList();
        webFlows.deleteTheNewUser();
        verifications.textInElement(contactsPage.popup_msgTitle, "Done");
        verifications.numbersOfElements(contactsPage.rows_contactList, 1);
    }

    @Test(priority = 4, description = "Adding new task to Weather project.")
    @Description("Test Description: Adding new task to Weather project, each task should contain weather information of Rishon Le-Zion city at the time of the test.")
    public void test05_addNewWeatherTask()
    {
        webFlows.getInsideProjectsPage();
        verifications.textInElement(projectsPage.txt_projectsHeader, "Projects");
        webFlows.goToWeatherProject();
        verifications.textInElement(projectPage.txt_projectHeader, "Weather");
        webFlows.writeWeatherTaskWithDescription();
        verifications.textInElement(projectPage.popup_doneMsg, "Success");
        webFlows.draggingAndSwitchingTasksPlaces();
    }

    @Test(priority = 5, description = "Adding new task to Chuck Norris jokes project.")
    @Description("Test Description: Adding new task to Chuck Norris joke project, each task should contain the joke and the current date and time.")
    public void test06_addNewChuckNorrisJokeTask()
    {
        webFlows.getInsideProjectsPage();
        verifications.textInElement(projectsPage.txt_projectsHeader, "Projects");
        webFlows.goToChuckNorrisProject();
        verifications.textInElement(projectPage.txt_projectHeader, "Chuck Norris jokes");
        webFlows.writeChuckNorrisTaskWithDescription();
        verifications.textInElement(projectPage.popup_doneMsg, "Success");
        webFlows.draggingAndSwitchingTasksPlaces();
    }

    @Test(priority = 6, description = "Verify left side avatar image")
    @Description("Test Description: Verifing that the left side Avaza avatar image isn't change between tests")
    public void test07_visualTestingOfTheAvatar()
    {
        verifications.VisualElement(leftSideBar.img_avazaAvatar, "avazaAvatar");
    }









}

package SanityTests;

import Extenstions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class avazaMobile extends commonOps
{
//    @Test(priority = 0, description = "Test01: Successful Loing to Avaza mobile app.")
//    @Description("Test Description: Checking successful login to Avaza mobile app.")
//    public static void test01_successfulLogin()
//    {
//        verifications.textInElement(mainPageMobile.txt_welcomeMsg, "Welcome to Avaza, the cloud business platform.");
//        System.out.println(driver.findElement(By.xpath("//*[@text='Welcome to Avaza, the cloud business platform.']")).getText());
//        WorkFlows.mobileFlows.openSidebar();
//        WorkFlows.mobileFlows.goToProjectsMenu();
//        WorkFlows.mobileFlows.goToChuckNorrisProject();
//
//        Thread.sleep(5000);
//        System.out.println("poo");
//    }

//    @Test(priority = 1, description = "Test02: Add and verify new user.")
//    @Description("Test Description: Adding new user to the contacts list and verifying the contacts list has grown.")
//    public static void test02_avazaAddNewUser()
//    {
//        mobileFlows.openContactsMenu();
//        mobileFlows.avazaAddNewUser();
//    }

    @Test(priority = 2, description = "Test02: Weather task.")
    @Description("Test Description: Adding new user to the contacts list and verifying the contacts list has grown.")
    public static void test03_addNewWeatherTask()
    {
        mobileFlows.openSidebar();
        mobileFlows.goToProjectsMenu();
//        verifications.textInElement(projectsPageMobile.txt_projectsHeader, "Projects");
        mobileFlows.goToWeatherProject();
        verifications.textInElement(projectPageMobile.txt_projectHeader, "Weather");
        mobileFlows.writeWeatherTaskWithDescription();
//        verifications.textInElement(projectPage.popup_doneMsg, "Success");

    }

    @Test(priority = 2, description = "Test03: Chuck Norris joke task.")
    @Description("Test Description: Adding new user to the contacts list and verifying the contacts list has grown.")
    public static void test04_addNewChuckNorrisJokeTask()
    {
        mobileFlows.openSidebar();
        mobileFlows.goToProjectsMenu();
//        verifications.textInElement(projectsPageMobile.txt_projectsHeader, "Projects");
        mobileFlows.goToChuckNorrisProject();
        verifications.textInElement(projectPageMobile.txt_projectHeader, "Chuck Norris jokes");
        mobileFlows.writeChuckNorrisTaskWithDescription();
//        verifications.textInElement(projectPage.popup_doneMsg, "Success");

    }


}

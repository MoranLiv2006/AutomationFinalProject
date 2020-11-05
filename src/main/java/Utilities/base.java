package Utilities;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static String Platform;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static PageObjects.ClickUp.loginPage clickupLoginPage;
    public static PageObjects.ClickUp.leftSideBar clickupLeftSideBar;
    public static PageObjects.ClickUp.profileMenu.profileMenu profileMenu;
    public static PageObjects.ClickUp.profileMenu.peopleSection.peoplePage peoplePage;
    public static PageObjects.ClickUp.profileMenu.profileSideBar profileSideBar;
    public static PageObjects.ClickUp.tasksSideBar tasksSideBar;
    public static PageObjects.ClickUp.weatherTasksSection.weatherTasksPage weatherTasksPage;

    public static PageObjects.Avaza.loginPage loginPage;
    public static PageObjects.Avaza.mainPage mainPage;
    public static PageObjects.Avaza.leftSideBar leftSideBar;
    public static PageObjects.Avaza.LeftSideBar.contactsPage contactsPage;
    public static PageObjects.Avaza.LeftSideBar.ProjectsSection.projectsPage projectsPage;
    public static PageObjects.Avaza.LeftSideBar.ProjectsSection.projectPage projectPage;
    public static PageObjects.Avaza.LeftSideBar.ProjectsSection.taskMenu taskMenu;


}

package Utilities;

import PageObjects.Avaza.Mobile.Sidebar.Projects.ProjectPage.taskMenuPageMobile;
import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    protected static AppiumDriver mobileDriver;
    public static PageObjects.Avaza.Mobile.mainPageMobile mainPageMobile;

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

    public static DesiredCapabilities desireCab = new DesiredCapabilities();

    //Web page objects
    public static PageObjects.Avaza.Web.loginPage loginPage;
    public static PageObjects.Avaza.Web.mainPage mainPage;
    public static PageObjects.Avaza.Web.leftSideBar leftSideBar;
    public static PageObjects.Avaza.Web.LeftSideBar.contactsPage contactsPage;
    public static PageObjects.Avaza.Web.LeftSideBar.ProjectsSection.projectsPage projectsPage;
    public static PageObjects.Avaza.Web.LeftSideBar.ProjectsSection.projectPage projectPage;
    public static PageObjects.Avaza.Web.LeftSideBar.ProjectsSection.taskMenu taskMenu;

    //Mobile page objects
//    public static PageObjects.Avaza.Mobile.mainPageMobile mainPageMobile;
    public static PageObjects.Avaza.Mobile.Sidebar.sidebarMenuMobile sidebarMenuMobile;
    public static PageObjects.Avaza.Mobile.Sidebar.Contacts.contactsPageMobile contactsPageMobile;
    public static PageObjects.Avaza.Mobile.Sidebar.Projects.projectsPage projectsPageMobile;
    public static PageObjects.Avaza.Mobile.Sidebar.Projects.ProjectPage.projectPageMobile projectPageMobile;
    public static taskMenuPageMobile taskMenuPageMobile;

}

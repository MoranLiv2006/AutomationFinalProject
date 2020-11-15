package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import PageObjects.Avaza.Mobile.*;

public class commonOps extends base
{
    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeriver();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        driver.manage().window().maximize();
//        driver.get("https://www.newegg.com/global/il-en/");
//        driver.get("https://automation126379.monday.com/");
//        driver.get("https://app.clickup.com/login");
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);

    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initEdgeriver()
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("AvazaAPIURL");
        httpRequest = RestAssured.given().auth().oauth2(getData("AvazaAPIToken"));
    }

    public static void initMobile()
    {
        desireCab.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        desireCab.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        desireCab.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            mobileDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desireCab);
        }
        catch (Exception e)
        {
            System.out.println("Cannot connect to appium server, see details: " + e);
        }
        managePages.initApp();
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName)
    {
        Platform = PlatformName;
        if (Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(Platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(Platform.equalsIgnoreCase("api"))
            initAPI();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        managePages.init();
        manageDB.initDBConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
    }

    @AfterMethod
    public void afterMethod()
    {
        if (Platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
//        else if(Platform.equalsIgnoreCase("mobile"))
//            WorkFlows.mobileFlows.backToHomePage();
    }

    @AfterClass
    public void closeSession()
    {
        manageDB.closeDBConnection();
        if (!Platform.equalsIgnoreCase("api"))
        {
            if(!Platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }

    }
}

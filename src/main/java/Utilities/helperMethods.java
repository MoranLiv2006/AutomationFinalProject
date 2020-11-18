package Utilities;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import javax.imageio.ImageIO;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class helperMethods extends commonOps
{
    public static void takeElementScreenShot(WebElement imageElement, String imageName)
    {
        imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageElement);
//        imageScreenShot = new AShot().takeScreenshot(driver, imageElement);
        try
        {
            ImageIO.write(imageScreenShot.getImage(), "png", new File(getData("ImageRepo") + imageName +".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error writing image file, see details: " + e);
        }
    }

    @Step("Get weather information from OpenWeatherMapAPI.")
    public static List<String> getWeatherInformation()
    {
        RequestSpecification httpRequest;
        Response response;

        String url = getData("OpenWeatherMapTokenAPIURL");
        String city = "Rishon LeZiyyon, IL";
        String APIKey = getData("OpenWeatherMapToken");
        String units = "metric";

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        response = httpRequest.get("?q=" + city + "&appid=" + APIKey + "&units=" + units);

        JsonPath jp = response.jsonPath();

        List<String> paramsList = new ArrayList<String>();
        paramsList.add(jp.get("name").toString());
        paramsList.add(jp.get("main.temp").toString());
        paramsList.add(jp.get("main.feels_like").toString());

        return paramsList;
    }

    @Step("Get new Chuck Norris joke from the api.")
    public static String getChuckNorrisJoke()
    {
        RequestSpecification httpRequest;
        Response response;

        String url = getData("ChuckNorrisJokesAPIURL");

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        response = httpRequest.get();

        JsonPath jp = response.jsonPath();

        return jp.get("value").toString();
    }

    @Step("Get the computer current time and date.")
    public static String getTimeAndDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


}

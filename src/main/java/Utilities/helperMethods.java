package Utilities;

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

    public static List<String> getRecipeInformation()
    {
//        RequestSpecification httpRequest;
//        Response response;

        String url = "https://api.spoonacular.com/recipes/random";
        String APIKey = "e337d976eee14d2b9eccf3f520cc3939";
        String numberOfRecipes = "1";

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        response = httpRequest.get("?apiKey=" + APIKey + "&number=" + numberOfRecipes);
//        response.prettyPrint();

        JsonPath jp = response.jsonPath();

        List<String> paramsList = new ArrayList<String>();
        paramsList.add(jp.get("recipes.title").toString());
        paramsList.add(jp.get("recipes.summary").toString());
        paramsList.add(jp.get("recipes.instructions").toString());
        paramsList.add(jp.get("recipes.sourceUrl").toString());

        return paramsList;
    }

    public static String getChuckNorrisJoke()
    {
        RequestSpecification httpRequest;
        Response response;

        String url = getData("ChuckNorrisJokesAPIURL");

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        response = httpRequest.get();
//        response.prettyPrint();

        JsonPath jp = response.jsonPath();

        return jp.get("value").toString();
    }

    public static String getTimeAndDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


}

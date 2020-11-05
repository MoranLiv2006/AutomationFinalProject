package Helpers;

import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class temp extends commonOps
{
    public String openWeatherMapurl = "http://api.openweathermap.org/data/2.5/weather";
    public String Avazaurl = "https://api.avaza.com/";
    public String city = "Rishon LeZiyyon, IL";
//    public String APIKey = "e24d6bd1b67f9ac5d4a8e5343632fbac";
    public String units = "metric";
    RequestSpecification AvazaRequest;
//    RequestSpecification openWeatherMapRequest;
    Response avazaResponse;
//    Response openWeatherMapresponse;

    @Test
    public void testing()
    {
//        JSONObject params = new JSONObject();
//        params.put("ProjectIDFK","14398");
//        params.put("SectionIDFK","30914");
//        params.put("Title","Offispaces");
//        params.put("Description","Ben & & Alex are gays :D");




        //Before Class
        RestAssured.baseURI = getData("AvazaAPIURL");
//        RestAssured.baseURI = openWeatherMapurl;
        AvazaRequest = RestAssured.given().auth().oauth2(getData("AvazaAPIToken"));
//        openWeatherMapRequest = RestAssured.given();



//        openWeatherMapresponse = openWeatherMapRequest.get("?q=" + city + "&appid=" + getData("OpenWeatherMapToken") + "&units=" + units);
        //Get
        avazaResponse = AvazaRequest.get("api/Task/");
        //Post
//        avazaResponse = AvazaRequest.post("api/Task");
        //PUT
//        avazaResponse = AvazaRequest.put("api/Task/");
//        avazaResponse = AvazaRequest.delete("api/Task/?TaskID=103035");
//        avazaResponse.prettyPrint();
        System.out.println(avazaResponse.statusCode());
//        openWeatherMapresponse.prettyPrint();
        JsonPath jp = avazaResponse.jsonPath();
//        System.out.println(jp.get("Tasks.TaskID"));
        ArrayList ddd = jp.get("Tasks.TaskID");
        System.out.println(ddd);
        System.out.println(ddd.size());
        Random rand = new Random();
        int rr = rand.nextInt(ddd.size());
        System.out.println("Index: " + rr + " contains: " + ddd.get(rr));


    }

    @Test
    public static void multipleBase()
    {
        RequestSpecification httpRequest;
        Response response;

        String openWeatherMapUrl = "https://api.spoonacular.com/recipes/random";
        String APIKey = "e337d976eee14d2b9eccf3f520cc3939";
        String numberOfRecipes = "1";

        RestAssured.baseURI = openWeatherMapUrl;
        httpRequest = RestAssured.given();

        response = httpRequest.get("?apiKey=" + APIKey + "&number=" + numberOfRecipes);
        response.prettyPrint();

        JsonPath jp = response.jsonPath();

        List<String> paramsList = new ArrayList<String>();
        paramsList.add(jp.get("title").toString());
        paramsList.add(jp.get("summary").toString());
        paramsList.add(jp.get("instructions").toString());
        paramsList.add(jp.get("sourceUrl").toString());
//
//        return paramsList;

    }

    @Test
    public static String getChuckNorrisJoke()
    {
        RequestSpecification httpRequest;
        Response response;

        String openWeatherMapUrl = "https://api.chucknorris.io/jokes/random";
        String APIKey = "739d02af9a4da0aea3e88f0f8c51d07a";
        String lang = "en";

        RestAssured.baseURI = openWeatherMapUrl;
        httpRequest = RestAssured.given();

        response = httpRequest.get();
        response.prettyPrint();

        JsonPath jp = response.jsonPath();

        return jp.get("value");
    }

    @Test
    public static void getTasksIDs()
    {
        System.out.println(apiFlows.getTasksInformation("Tasks.TaskID"));

        List<String> array = new ArrayList<String>();

//        array.addAll(apiFlows.getTasksInformation("Tasks.TaskID"));
//        array.addAll(apiFlows.getTasksInformation("Tasks"));


        System.out.println(array.size());
//
//        List al = Arrays.asList(apiFlows.getTasksInformation("Tasks.TaskID"));
//        System.out.println(al);


    }
}

package WorkFlows;

import Extenstions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Random;
import static Utilities.helperMethods.*;

public class apiFlows extends commonOps
{
    @Step("Get projects information from the server.")
    public static String getProjectsInformation(String JPath)
    {
        Response response = apiActions.get("api/Project");
//        response.prettyPrint();
        return apiActions.extractFromJson(response, JPath);
    }

    @Step("Get tasks information from the server.")
    public static String getTasksInformation(String JPath)
    {
        Response response = apiActions.get("api/Task");
//        response.prettyPrint();
        return apiActions.extractFromJson(response, JPath);
    }

    @Step("Post task data to server.")
    public static void postTaskData(String ProjectIDFK, String SectionIDFK)
    {
        if(ProjectIDFK == "14398")
        {
            requestParams.put("ProjectIDFK", ProjectIDFK);
            requestParams.put("SectionIDFK", SectionIDFK);
            requestParams.put("Title", "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " (Server Side)");
            requestParams.put("Description", "Weather information for: " + getWeatherInformation().get(0) + " on: " + getTimeAndDate() + " Temperature: " + getWeatherInformation().get(1) + ", Feels like: " + getWeatherInformation().get(2));
            apiActions.post(requestParams, "api/Task");
        }
        else
        {
            requestParams.put("ProjectIDFK", ProjectIDFK);
            requestParams.put("SectionIDFK", SectionIDFK);
            requestParams.put("Title", getChuckNorrisJoke() + " " + getTimeAndDate() + " (Server Side)");
            requestParams.put("Description", getTimeAndDate() + " (Server Side)");
            apiActions.post(requestParams, "api/Task");
        }
    }

    @Step("Delete task from the server.")
    public static void deleteTask()
    {
        apiActions.delete(getTaskIdToDelete(),"api/Task");
    }

    @Step("Get the randomize TaskID to delete.")
    public static String getTaskIdToDelete()
    {
        Response response = apiActions.get("api/Task");
        JsonPath jp = response.jsonPath();

        ArrayList arrayIndex = jp.get("Tasks.TaskID");

        Random rand = new Random();
        int randomIndex = rand.nextInt(arrayIndex.size());

        System.out.println("Index: " + randomIndex + " contains: " + arrayIndex.get(randomIndex));
        return arrayIndex.get(randomIndex).toString();

    }

}

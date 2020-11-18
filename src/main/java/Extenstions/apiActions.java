package Extenstions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends commonOps
{
    @Step("Get data from server.")
    public static Response get(String paramValues)
    {
        response = httpRequest.get(paramValues);
        return response;
    }

    @Step("Extract value from json format.")
    public static String extractFromJson(Response response, String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post data to server.")
    public static void post(JSONObject params, String pathToPostOnServer)
    {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(pathToPostOnServer);
    }

    @Step("Delete data from server.")
    public static void delete(String idToDelete, String pathToDeleteOnServer)
    {
        response = httpRequest.delete(pathToDeleteOnServer+"/?TaskID="+idToDelete);
    }
}

package SanityTests;

import Extenstions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class avazaAPI extends commonOps
{
    @Test(priority = 0, description = "Test01: Get projects information from the server")
    @Description("Test Description: Getting all the projects from the Avaza server.")
    public void test01_getProjectsNameFromServerAndVerify()
    {
        verifications.verifyTextFromAPIServer(apiFlows.getProjectsInformation("Projects[0].Title"), "Chuck Norris jokes");
        verifications.verifyTextFromAPIServer(apiFlows.getProjectsInformation("Projects[1].Title"), "Weather");
    }

    @Test(priority = 1, description = "Test02: Post new task to server")
    @Description("Test Description: Creating new task direct to the server with Post request and verify the tasks count before and after the post request.")
    public void test02_postTasksToServerAndVerify()
    {
        String tasksBeforePost = apiFlows.getTasksInformation("TotalCount");
        System.out.println("Before: " + tasksBeforePost);

        apiFlows.postTaskData("14398", "30914");
        apiFlows.postTaskData("14933", "32336");

        int expectedValue = Integer.valueOf(tasksBeforePost);
        verifications.verifyTextFromAPIServer(apiFlows.getTasksInformation("TotalCount"), String.valueOf(expectedValue+2));

        System.out.println("After: " + apiFlows.getTasksInformation("TotalCount"));
    }

    @Test(priority = 2, description = "Test03: Delete task from server")
    @Description("Test Description: Deleting task direct from the server with Delete request.")
    public void test03_deleteTaskFromServerAndVerify()
    {
        String tasksBeforeDelete = apiFlows.getTasksInformation("TotalCount");
        System.out.println("Before: " + tasksBeforeDelete);
        apiFlows.deleteTask();

        int expectedValue = Integer.valueOf(tasksBeforeDelete);
        verifications.verifyTextFromAPIServer(apiFlows.getTasksInformation("TotalCount"), String.valueOf(expectedValue-1));

        System.out.println("After: " + apiFlows.getTasksInformation("TotalCount"));
    }

}

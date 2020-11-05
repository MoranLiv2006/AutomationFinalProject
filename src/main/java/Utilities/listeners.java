package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener
{
    public void onTestStart(ITestResult test)
    {
        System.out.println(" --- Starting Test: " + test.getName() + " --- ");
    }

    public void onTestSuccess(ITestResult test)
    {
        System.out.println(" --- Test: " + test.getName() + " Passed --- ");
    }

    public void onTestFailure(ITestResult test)
    {

        System.out.println(" --- Test: " + test.getName() + " Failed --- ");
        if (!Platform.equalsIgnoreCase("api"))
            saveScreenshot();
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

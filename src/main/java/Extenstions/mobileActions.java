package Extenstions;

import Utilities.commonOps;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mobileActions extends commonOps
{
    @Step("Tap on Element")
    public static void tap(MobileElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Tap on Element")
    public static void hide()
    {
//        driver.hideKeyboard();

    }
}

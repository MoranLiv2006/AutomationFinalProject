package Extenstions;

import Utilities.commonOps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class mobileActions extends commonOps
{
    @Step("Swipe down in mobile.")
    public static void verticalSwipe(WebElement fromElement, WebElement toElement)
    {
        wait.until(ExpectedConditions.visibilityOf(fromElement));
        wait.until(ExpectedConditions.visibilityOf(toElement));
        mobileDriver.swipe(toElement.getRect().x, toElement.getRect().y, fromElement.getRect().x, fromElement.getRect().y, 200);
    }

//    @Step("Swipe down in mobile.")
//    public static void verticalSwipeToElement(WebElement elementToSwipeTo)
//    {
//        while(elementToSwipeTo.getSize()==0)
//        {
//        int size = mobileDriver.manage().window().getSize();
//        int starty = (int) (elementToSwipeTo.getSize().height * 0.80);
//        int endy = (int) (elementToSwipeTo.getSize().height * 0.20);
//        int startx = elementToSwipeTo.getSize().width / 2;
//        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
//
//        mobileDriver.swipe(startx, starty, startx, endy, 3000);
//        Thread.sleep(2000);
//        mobileDriver.swipe(startx, endy, startx, starty, 3000);
//        Thread.sleep(2000);
//        }
//    }

    public static void swiptToBottom()
    {
        Dimension dim = mobileDriver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.80);
        int bottom_y = (int)(height*0.20);
        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
        TouchAction ts = new TouchAction(mobileDriver);
        ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
    }

}

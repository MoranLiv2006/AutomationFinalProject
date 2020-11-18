package Extenstions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class mobileActions extends commonOps
{
    @Step("Swipe down 3 times from a particular element.")
    public static void threeTimesVerticalSwipe(WebElement startElem)
    {
        wait.until(ExpectedConditions.visibilityOf(startElem));
        Dimension dim = mobileDriver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.80);
        int bottom_y = (int)(height*0.20);
        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
        for(int i=0 ; i<3 ; i++)
        {
            mobileDriver.swipe(x, top_y, x,bottom_y, 200);
        }
    }
}

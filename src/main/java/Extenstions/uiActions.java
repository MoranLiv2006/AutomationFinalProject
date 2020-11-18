package Extenstions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class uiActions extends commonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Sending text to text-field")
    public static void updateText(WebElement elem, String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Hover the mouse on a certain Element inorder to click secondary element")
    public static void mouseHoverElements(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

//    @Step("Sending text to text-field and then press a certain key")
//    public static void updateTextWithKey(WebElement elem, String value, Keys key)
//    {
//        wait.until(ExpectedConditions.visibilityOf(elem));
//        elem.sendKeys(value, key);
//    }


}

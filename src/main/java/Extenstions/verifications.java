package Extenstions;

import static org.testng.Assert.*;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class verifications extends commonOps
{

    @Step("Verify the text in element is the same as expected text")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify the page title is the same as expected text")
    public static void pageTitle(WebElement elem, String expectedTitle)
    {
       wait.until(ExpectedConditions.visibilityOf(elem));
       assertEquals(driver.getTitle(), expectedTitle);
    }
//    public static void textInElementWhileHover(WebElement elemHover, WebElement txtElem, String expectedValue)
//    {
//       wait.until(ExpectedConditions.visibilityOf(elemHover));
//       uiActions.mouseHoverElement(elemHover);
//       wait.until(ExpectedConditions.visibilityOf(txtElem));
//       assertEquals(txtElem.getText(), expectedValue);
//    }

    @Step("Verify the amount of element in a list is the same as expected amount")
    public static void numbersOfElements(List<WebElement> elems, int expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        assertEquals(elems.size(), expectedValue);
    }

    public static void elementExist(WebElement elem)
    {
        assertTrue(elem.isEnabled());
    }

    public static void elementNotExist(WebElement elem)
    {
        assertFalse(elem.isDisplayed());
    }

    @Step("Verify Element visually")
    public static void VisualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("ImageRepo") + expectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file: " + e);
        }
        Screenshot imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imgDiff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images are not the same");
    }

    @Step("Verify text with text")
    public static void text(String actualText, String expectedText)
    {
        assertEquals(actualText, expectedText, "error");
    }
}

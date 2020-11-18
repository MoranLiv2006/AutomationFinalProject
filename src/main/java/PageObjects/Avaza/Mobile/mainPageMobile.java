package PageObjects.Avaza.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class mainPageMobile
{
    private AppiumDriver mobileDriver;

    public mainPageMobile(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @FindBy(how = How.XPATH, using = "//*[@text='Welcome to Avaza, the cloud business platform.']")
    public WebElement txt_welcomeMsg;

    @FindBy(how = How.XPATH, using = "//*[@text='\uF0C9']")
    public AndroidElement btn_sideBarMenu;
}

package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

public class visualTesting extends commonOps
{
    @Test
    public void createScreenShot()
    {
        webFlows.avazeLogin(getData("userEmail"), getData("userPassword"));
        helperMethods.takeElementScreenShot(leftSideBar.img_avazaAvatar, "avazaAvatar");
    }
}

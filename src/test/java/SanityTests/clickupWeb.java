package SanityTests;

import Extenstions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

public class clickupWeb extends commonOps
{
    @Test(priority = 0)
    public void test01()
    {
        webFlows.login(getData("userEmail"), getData("userPassword"));
    }

//    @Test(priority = 1)
//    public void test02() throws InterruptedException
//    {
//        webFlows.viewPeopleOnWorkspace();
//        verifications.textInElement(peoplePage.txt_header, "Learn more\nManage people");
//    }
//
//    @Test(priority = 2)
//    public void test03()
//    {
//        verifications.numbersOfElements(peoplePage.peopleRows, 1);
//    }
//
//    @Test(priority = 3)
//    public void test04()
//    {
//        webFlows.invitePeopleViaEmail("Automation@test.com");
//        verifications.textInElement(peoplePage.msg_succsess, "Invite Sent!");
//    }
//
//    @Test(priority = 4)
//    public void test05()
//    {
//        verifications.numbersOfElements(peoplePage.peopleRows, 2);
//    }

    @Test(priority = 5)
    public void test06() throws InterruptedException
    {
        webFlows.viewPeopleOnWorkspace();
        Thread.sleep(5000);
        webFlows.bla();
//        webFlows.deletingTheLastRow();
        Thread.sleep(3000);
//
    }
}

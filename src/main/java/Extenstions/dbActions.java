package Extenstions;

import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps
{
    @Step("Getting the avaza login credentials from the DB.")
    public static List<String> getLoginCredentials(String query)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        return credentials;
    }

    @Step("Getting the second user details from the DB.")
    public static List<String> getSecondContactDetails(String query)
    {
        List<String> contactDetails = new ArrayList<String>();
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
            contactDetails.add(rs.getString(1));
            contactDetails.add(rs.getString(2));
            contactDetails.add(rs.getString(3));
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        return contactDetails;
    }
}

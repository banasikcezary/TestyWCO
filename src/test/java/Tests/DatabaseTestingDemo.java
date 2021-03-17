package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseTestingDemo extends TestBase{



    public String test(String lastDate, String newDate) {
        String key=null;
        do{
        try {
            String query = "SELECT sms_code FROM vpabx.sms_storage WHERE expires >= '"+lastDate+"' AND expires <= '"+newDate+"'";
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {

    key=(res.getString(1));



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        }while(key == null);

        return key;
    }


}
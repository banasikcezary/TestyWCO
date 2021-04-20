//package Tests;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import java.sql.*;
//import java.util.Properties;
//
//public class DatabaseTestingDemo extends TestBase {
////
////    // Connection object
////    static Connection con = null;
////    // Statement object
////    public static Statement stmt;
////    // Constant for Database URL
////    public static String DB_URL = "jdbc:mysql://localhost:8040";
////    // Constant for Database Username
////    public static String DB_USER = "root";
////    // Constant for Database Password
////    public static String DB_PASSWORD = "Bond007$";
//
//
//
//    public String test(String lastDate, String newDate) {
//        String key = null;
//
//        try{
//            String query = "SELECT sms_code FROM vpabx.sms_storage WHERE expires >= '" + lastDate + "' AND expires <= '" + newDate + "'";
//// Get the contents of userinfo table from DB
//            ResultSet res = stmt.executeQuery(query);
//// Print the result untill all the records are printed
//// res.next() returns true if there is any next record else returns false
//            while (res.next()) {
//
//                key = (res.getString(1));
//
//
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        return key;
//    }

//    @BeforeMethod
//    public void setUp() throws Exception {
//        try {
//            // Make the database connection
//            String dbClass = "com.mysql.jdbc.Driver";
//            Class.forName(dbClass).newInstance();
//            // Get connection to DB
//            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            // Statement object to send the SQL statement to the Database
//            stmt = con.createStatement();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public String test(String lastDate, String newDate) {
//        String key = null;
//        do {
//            try {
//                String query = "SELECT sms_code FROM vpabx.sms_storage WHERE expires >= '" + lastDate + "' AND expires <= '" + newDate + "'";
//                ResultSet res = stmt.executeQuery(query);
//
//                while (res.next()) {
//
//                    key = (res.getString(1));
//
//
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }}
//            while (key == null) ;
//
//            return key;
//        }





//}



//    public String test(String lastDate, String newDate) {
//        try {
//            Class.forName("ccom.mysql.jdbc.Driver");
//
//            Connection conn = getConnection();
//            Statement stmt = conn.createStatement();
//            String key = null;
//            do {
//                try {
//                    String query = "SELECT sms_code FROM vpabx.sms_storage WHERE expires >= '"+lastDate+"' AND expires <= '"+newDate+"'";
//                    ResultSet res = stmt.executeQuery(query);
//                    while (res.next()) {
//                        key=(res.getString(1));
////                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } while (key == null);
//            return key;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public static Connection getConnection() throws SQLException {
//        Properties connectionProps = new Properties();
//        connectionProps.put("root", "DB_USERNAME");
//        connectionProps.put("Bond007$", "DB_PASSWORD");
//        return DriverManager.getConnection("jdbc:mysql://localhost:8040", connectionProps);
//    }

package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseTestingDemo extends TestBase {

    public String test(String lastDate, String newDate) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
            String key = null;
            do {
                try {
                    String query = "SELECT sms_code FROM vpabx.sms_storage WHERE expires >= '"+lastDate+"' AND expires <= '"+newDate+"'";
                    ResultSet res = stmt.executeQuery(query);
                    while (res.next()) {
                        key=(res.getString(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (key == null);
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Connection getConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("root", "DB_USERNAME");
        connectionProps.put("Bond007$", "DB_PASSWORD");
        return DriverManager.getConnection("jdbc:mysql://localhost:8040", connectionProps);
    }
}
package Tests;

import java.sql.*;
import java.util.Properties;

public class DatabaseTestingDemo extends TestBase{

    public String test(String lastDate, String newDate) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
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
        connectionProps.put("user", "DB_USERNAME");
        connectionProps.put("password", "DB_PASSWORD");
        return DriverManager.getConnection("DB_URL", connectionProps);
    }
}
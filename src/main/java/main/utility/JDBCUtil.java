package main.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection getConnection() throws SQLException {
        String hostNPort = "103.171.85.233:3306";
        String database = "ParkirDB";
        String user = "user";
        String password = "pass";

        return DriverManager.getConnection("jdbc:mysql://" + hostNPort + "/" + database + "?useSSL=false", user, password);
    }
}

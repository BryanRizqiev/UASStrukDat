package main;

import main.utility.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {

    private static final String INSERT_SQL = "INSERT INTO vehicles"
            + "  (nopol, type, color) VALUES "
            + " (?, ?, ?);";

    public static void main(String[] args) {

        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, "AG_12345_DZKY");
            preparedStatement.setString(2, "Mobil");
            preparedStatement.setString(3, "Hitam");
            preparedStatement.executeUpdate();
            System.out.println("Success");
        } catch (SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}

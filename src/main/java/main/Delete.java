package main;

import main.utility.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    private static final String DELETE_SQL = "DELETE FROM vehicles WHERE nopol = ?;";

    public static void main(String[] args) {

        try(Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_SQL);
            ) {
            preparedStatement.setString(1, "AG_1_ASU");
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                System.out.println("Penghapusan berhasil");
            } else {
                System.out.println("Data tidak ada");
            }
        } catch (SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}

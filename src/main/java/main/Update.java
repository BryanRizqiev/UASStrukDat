package main;

import main.utility.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    private static final String UPDATE_SQL = "UPDATE vehicles SET nopol = ? WHERE nopol = ?";

    public static void main(String[] args) {

        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, "AG_1_ASU");
            preparedStatement.setString(2, "AG_1_AARR");
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                System.out.println("Pengubahan berhasil");
            } else {
                System.out.println("Data tidak ada");
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}

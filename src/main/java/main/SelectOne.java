package main;

import main.utility.JDBCUtil;

import java.sql.*;

public class SelectOne {

    public static void main(String[] args) {

        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM vehicles WHERE nopol = ? LIMIT 1");
            preparedStatement.setString(1, "AG_1_AA");
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Data tidak ada");
            }
            while (rs.next()) {
                int kode = rs.getInt("id");
                String nopol = rs.getString("nopol");
                System.out.println("kode karcis: " + kode + ", nopol:" + nopol);
            }

            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}


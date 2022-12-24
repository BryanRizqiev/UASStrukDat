package main;

import main.controller.VehicleController;
import main.model.Vehicle;
import main.utility.JDBCUtil;

import java.sql.*;

public class Select {

    public static void main(String[] args) {

        VehicleController vController = new VehicleController(4);

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM vehicles WHERE is_out = 0");
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Data tidak ada");
            }
            while (rs.next()) {
                int kode = rs.getInt("id");
                String nopol = rs.getString("nopol");
                String type = rs.getString("type");
                String color = rs.getString("color");
                String nameOrBrand = rs.getString("name_or_brand");
                int pay = rs.getInt("pay");
                boolean isOut = rs.getBoolean("is_out");
                Timestamp inTime = Timestamp.valueOf(rs.getString("in_time"));
                vController.push(new Vehicle(kode, nopol, type, color, nameOrBrand, pay, isOut, inTime));
            }
        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        // buat class query pakai static dan final
        vController.pop("AG_1_AA");

        try {
            Vehicle vec = vController.getData("AG_123_AA");
            System.out.println(vec.getInTime());
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}

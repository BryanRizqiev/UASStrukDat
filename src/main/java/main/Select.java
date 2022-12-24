package main;

import main.controller.VehicleController;
import main.model.Vehicle;
import main.utility.JDBCUtil;

import java.sql.*;
import java.util.Arrays;

public class Select {

    public static void main(String[] args) {

        VehicleController vController = new VehicleController(3);

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
                String inTime = rs.getString("in_time");
                String outTime = rs.getString("out_time");
                vController.push(new Vehicle(kode, nopol, type, color, nameOrBrand, pay, isOut, inTime, outTime));
            }
        } catch (SQLException sqlException) {
            System.out.println("Error: " + sqlException.getMessage());
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        vController.print();
        vController.pop("AG_1_AA");
        vController.print();
        vController.printArr();
    }
}

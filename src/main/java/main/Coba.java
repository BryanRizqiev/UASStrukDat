package main;

import main.controller.VehicleController;
import main.model.Vehicle;
import main.utility.SQLCommand;

import javax.swing.*;
import java.sql.Timestamp;

// kurang sorting dan searching di sistem dan gui
public class Coba {

    public static void main(String[] args) {

        try {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // init (query all)
            VehicleController vController = new VehicleController(50);

            SQLCommand.all(vController);
            vController.printArr();

            // in
//            SQLCommand.create("AG_0084_YNTKTS", "Motor", "Merah", "", vController);
//            vController.printArr();

            // query single
            Vehicle vehicle = SQLCommand.getByNopol("AG_0084_YNTKTS");
//            System.out.println("Jam server: " + vehicle.getInTime()); // in lalu bandingkan
            timestamp.setHours(timestamp.getHours() - 7); // jam e server kurleb // bisa ditambah setMinute
//            System.out.println("Jam kene: " + timestamp);

            // out



        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}

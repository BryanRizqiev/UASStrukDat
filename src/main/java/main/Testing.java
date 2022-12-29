package main;

import main.controller.VehicleController;
import main.model.Vehicle;
import main.utility.SQLCommand;

import javax.swing.*;
import java.sql.Timestamp;

// kurang sorting dan searching di sistem dan gui
public class Testing {

    public static long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
    {
        long milliseconds1 = oldTime.getTime();
        long milliseconds2 = currentTime.getTime();

        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffHours;
    }

    public static void main(String[] args) {

        try {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // init (query all)
            VehicleController vController = new VehicleController(50);
            SQLCommand.getAll(vController);

            // in
            SQLCommand.create("AG_0084_YNTKTS", "Motor", "Merah", "", vController);
            vController.printArr();

            // query single
            Vehicle vehicle = SQLCommand.getByNopol("AG_T4MB4H_WS");

            // lama parkir
            timestamp.setHours(timestamp.getHours() - 7);
            int different = (int) compareTwoTimeStamps(vehicle.getInTime(), timestamp);
            different = Math.abs(different);
            System.out.println(different);

            // out
            SQLCommand.updateIsOut("AG_0084_YNTKTS", vController);

//            vController.printArr();
//            Sorting.sort(vController.getDatas());
//            vController.printArr();
//            Vehicle vec = Searching.binarySearch(vController.getDatas(), "AG_1276_AA", VehicleController.lengthArr(vController.getDatas()));
//            System.out.println(vec.getNopol() + " || " + vec.getInTime().getHours());

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}

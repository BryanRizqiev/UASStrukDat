package main;

import main.controller.VehicleController;
import main.utility.SQLCommand;

import javax.swing.*;

// kurang sorting dan searching di sistem dan gui
public class Testing {

    public static void main(String[] args) {

        try {

//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // init (query all)
            VehicleController vController = new VehicleController(5);

            SQLCommand.getAll(vController);
//            vController.printArr();

            // in
//            SQLCommand.create("AG_0084_YNTKTS", "Motor", "Merah", "", vController);
//            vController.printArr();

            // query single
//            Vehicle vehicle = SQLCommand.getByNopol("AG_0084_YNTKTS");
//            System.out.println("Jam server: " + vehicle.getInTime()); // in lalu bandingkan
//            timestamp.setHours(timestamp.getHours() - 7); // jam e server kurleb // bisa ditambah setMinute
//            System.out.println("Jam kene: " + timestamp);

            // out
//            SQLCommand.updateIsOut("AG_0084_YNTKTS", vController);

            vController.printArr();
//            Sorting.sort(vController.getDatas());
//            vController.printArr();
//            Sorting.quickSort(vController.getDatas(), 0, 12);
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

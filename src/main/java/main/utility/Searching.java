package main.utility;

import main.controller.VehicleController;
import main.model.Vehicle;

public class Searching {

    public static Vehicle binarySearch(Vehicle[] vehicles, String key, int length) {

        // method binary search mengembalikan model Vehicle

        int first = 0, last = length - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            int result = key.compareTo(vehicles[mid].getNopol());

            if (result == 0) {
                return vehicles[mid];
            }
            if (result > 0) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return null;
    }

    public static Vehicle linearSearch(Vehicle[] vehicles, String key, int length) {

        // method lienear search mengembalikan model Vehicle

        for (int i = 0; i < length; i++) {
            if (vehicles[i].getNopol().equals(key)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public static Vehicle search(Vehicle[] vehicles, String nopol, boolean isSort) {

        // method utama search dimana menentukan algoritma searching yang akan dipakai, parameter isSort berguna untuk mengetahui apakah array sudah disorting

        int length = VehicleController.lengthArr(vehicles);

        if (length > 200) {
            if (!isSort) {
                Sorting.sort(vehicles);
            }
            return binarySearch(vehicles, nopol, length);
        } else {
            return linearSearch(vehicles, nopol, length);
        }
    }

    public static Vehicle search(Vehicle[] vehicles, String nopol) {

        // method utama search dimana menentukan algoritma searching yang akan dipakai

        int length = VehicleController.lengthArr(vehicles);

        if (length > 200) {
            Sorting.sort(vehicles);
            return binarySearch(vehicles, nopol, length);
        } else {
            return linearSearch(vehicles, nopol, length);
        }
    }
}

package main.utility;

import main.controller.VehicleController;
import main.model.Vehicle;

public class Searching {

    public static Vehicle binarySearch(Vehicle[] vehicles, String key, int length) {
        int first = 0, last = length - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            int result = key.compareTo(vehicles[mid].getNopol());

            if (result == 0) {
                return vehicles[mid];
            }
            // penentu asc sort or desc sort
            if (result > 0) {
                first = mid + 1;
            }
            else {
                last = mid - 1;
            }
        }
        return null;
    }

    public static Vehicle linearSearch(Vehicle[] vehicles, String key, int length) {
        for (int i = 0; i < length; i++) {
            if (vehicles[i].getNopol().equals(key)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public static Vehicle search(Vehicle[] vehicles, String nopol, boolean isSort) {

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

        int length = VehicleController.lengthArr(vehicles);

        if (length > 200) {
            Sorting.sort(vehicles);
            return binarySearch(vehicles, nopol, length);
        } else {
            return linearSearch(vehicles, nopol, length);
        }
    }
}

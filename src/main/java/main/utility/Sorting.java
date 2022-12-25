package main.utility;

import main.controller.VehicleController;
import main.model.Vehicle;

public class Sorting {

    private static int partition(Vehicle[] arr, int start, int end) {

        String pivot = arr[end].getNopol();
        int i = start - 1;
        Vehicle temp;

        for (int j = start; j <= end-1; j++) {
            if (arr[j].getNopol().compareTo(pivot) < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

    private static void quickSort(Vehicle[] arr, int start, int end) {

        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }

    private static void insertionSort(Vehicle[] arr, int length) {

        for (int i = 1; i < length; i++) {
            Vehicle temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getNopol().compareTo(temp.getNopol()) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void sort(Vehicle[] vehicles) {

        int length = VehicleController.lengthArr(vehicles);

        if (vehicles.length > 100) {
            quickSort(vehicles, 0, length-1);
        } else {
            insertionSort(vehicles, length);
        }
    }
}

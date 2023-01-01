package main.controller;

import main.model.Vehicle;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.Arrays;

public class VehicleController {

    private Vehicle[] arr;
    private int top, capacity;

    public VehicleController(int size) {
        arr = new Vehicle[size];
        capacity = size;
        top = -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String peek() {
        return arr[top].getNopol();
    }

    public int count() {
        return top + 1;
    }

    public int size() {
        return capacity;
    }

    public void clear() {
        arr = new Vehicle[capacity];
        top = -1;
    }

    public void push(Vehicle vehicle) throws Exception {
        if (isFull()) {
            throw new Exception("Parkir penuh");
        } else {
            arr[++top] = vehicle;
            System.out.println("Push elemen " + vehicle + " berhasil");
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong/underflow");
            return;
        }
        arr[top] = null;
        --top;
    }

    public void pop(String nopol) throws Exception {
        if (isEmpty()) {
            System.out.println("Stack kosong/underflow");
            return;
        }
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                arr[top] = null;
                --top;
                return;
            }
        }

        throw new Exception("Data tidak ada");
    }

    public void pop(int id) throws Exception {
        if (isEmpty()) {
            System.out.println("Stack kosong/underflow");
            return;
        }
        for (int i = 0; i <= top; i++) {
            if (arr[i].getId() == id) {
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                arr[top] = null;
                --top;
                return;
            }
        }

        throw new Exception("Data tidak ada");
    }

    private int getTop() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i-1;
            }
        }
        return arr.length;
    }

    public void insertOrReplaceData(Vehicle[] arr) {
        this.arr = arr;
        top = getTop();
    }

    public Vehicle[] getDatas() {
        return arr;
    }

    public Vehicle[] fetchDatas() {
        Vehicle[] vehicles = new Vehicle[count()];
        if (count() >= 0) System.arraycopy(arr, 0, vehicles, 0, count());
        return vehicles;
    }
    
    public Vehicle getData(String nopol) throws Exception {
        // ini bisa pakai binary search
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
                return arr[i];
            }
        }
        throw new Exception("Data tidak ada");
    }

    public boolean isExist(String nopol) {
        // ini bisa pakai searching
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExist(int id) {
        // ini bisa pakai searching
        for (int i = 0; i <= top; i++) {
            if (arr[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public void printArr() {
        System.out.println(Arrays.toString(arr));
    }

    // bisa diperbaiki
    public static int lengthArr(Vehicle[] vehicles) {
        int i = 0;
        int length = -1;
        for (Vehicle vehicle: vehicles) {
            if (vehicle == null) {
                length = i;
                break;
            }
            i++;
        }
        return length;
    }


    public static void main(String[] args) throws Exception {

        VehicleController vController = new VehicleController(10);

        try {
            vController.push(new Vehicle(1, "A", "B", "C", "D", 2, false, new Timestamp(System.currentTimeMillis())));
            vController.push(new Vehicle(2, "B", "B", "C", "D", 2, false, new Timestamp(System.currentTimeMillis())));
            vController.push(new Vehicle(3, "C", "B", "C", "D", 2, false, new Timestamp(System.currentTimeMillis())));
            vController.push(new Vehicle(4, "D", "B", "C", "D", 2, false, new Timestamp(System.currentTimeMillis())));
            vController.push(new Vehicle(5, "E", "B", "C", "D", 2, false, new Timestamp(System.currentTimeMillis())));

            Vehicle[] vehicles = vController.fetchDatas();

            System.out.println(Arrays.toString(vehicles));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}

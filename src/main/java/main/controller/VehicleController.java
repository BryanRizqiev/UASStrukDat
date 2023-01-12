package main.controller;

import main.model.Vehicle;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.Arrays;

public class VehicleController {

    // membuat array dari model Vehicle
    private Vehicle[] arr;
    private int top, capacity;

    // construktor dengan parameter size (ukuran stack)
    public VehicleController(int size) {
        // inisialisasi array Vehicle dengan array kosong sepanjang variabel size
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

    // mengambil data teratas
    public String peek() {
        return arr[top].getNopol();
    }

    public int count() {
        return top + 1;
    }

    public int size() {
        return capacity;
    }

    // mengosongkan stack
    public void clear() {
        arr = new Vehicle[capacity];
        top = -1;
    }

    // push model Vehicle ke array Vehicle, jika stack penuh melempar Exception
    public void push(Vehicle vehicle) throws Exception {
        if (isFull()) {
            throw new Exception("Parkir penuh");
        } else {
            arr[++top] = vehicle;
            System.out.println("Push elemen " + vehicle + " berhasil");
        }
    }

    // pop model Vehicle teratas stack
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong/underflow");
            return;
        }
        arr[top] = null;
        --top;
    }

    // pop model Vehicle dari stack berdasarkan nopol
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

    // pop model Vehicle dari stack berdasarkan nopol
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

    // mengambil index top jika data dalam stack diperbarui
    private int getTop() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i-1;
            }
        }
        return arr.length;
    }

    // mengisi atau mengganti semua data dalam stack
    public void insertOrReplaceData(Vehicle[] arr) {
        this.arr = arr;
        top = getTop();
    }

    // mengambil array dalam stack
    public Vehicle[] getDatas() {
        return arr;
    }

    // mengambil semua data dalam stack
    public Vehicle[] fetchDatas() {
        Vehicle[] vehicles = new Vehicle[count()];
        if (count() >= 0) System.arraycopy(arr, 0, vehicles, 0, count());
        return vehicles;
    }

    // mengambil satu data model Vehicle pada stack berdasarkan nopol
    public Vehicle getData(String nopol) {
        // ini bisa pakai binary search
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
                return arr[i];
            }
        }
        return null;
    }

    // mengambil satu data model Vehicle pada stack berdasarkan id
    public Vehicle getData(int id) {
        for (int i = 0; i <= top; i++) {
            if (arr[i].getId() == id) {
                return arr[i];
            }
        }
        return null;
    }

    // mengecek apakah salah satu model Vehicle ada dalam stack berdasarkan nopol
    public boolean isExist(String nopol) {
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
                return true;
            }
        }
        return false;
    }

    // mengecek apakah salah satu model Vehicle ada dalam stack berdasarkan nopol id
    public boolean isExist(int id) {
        for (int i = 0; i <= top; i++) {
            if (arr[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    // meng-print di console semua data dalam stack, ini berguna saat development maupun debugging
    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public void changeCapacity(int newCapacity) {
        arr = new Vehicle[capacity];
        capacity = newCapacity;

    }

    // meng-print di console semua data array dalam stack, ini berguna saat development maupun debugging
    public void printArr() {
        System.out.println(Arrays.toString(arr));
    }

    // mengambil panjang array terbaru berdasarkan data yang tidak null
    public static int lengthArr(Vehicle[] vehicles) {
        int i = 0;
        int length = -1;
        for (Vehicle vehicle: vehicles) {
            if (vehicle == null) {
                length = i;
                break;
            } else {
                length = i + 1;
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

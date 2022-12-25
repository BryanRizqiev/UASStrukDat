package main.controller;

import main.model.Vehicle;

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

    public void pop(String nopol) {
        if (isEmpty()) {
            System.out.println("Stack kosong/underflow");
            return;
        }
        boolean isExist = false;
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
                isExist = true;
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                arr[top] = null;
                --top;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Gak enek");
        }
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
        // ini bisa pakai binary search
        for (int i = 0; i <= top; i++) {
            if (arr[i].getNopol().equals(nopol)) {
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

}

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
            System.err.println("Stack kosong/underflow");
            System.exit(1);
        }
        --top;
    }

    public void pop(String nopol) {
        if (isEmpty()) {
            System.err.println("Stack kosong/underflow");
            System.exit(1);
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

    public void insertOrReplaceData(Vehicle[] arr) {
        this.arr = arr;
    }

    public Vehicle[] getDatas() {
        return arr;
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

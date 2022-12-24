package main.utility;

import java.util.Arrays;

public class StackParkir {

    private Object[] arr;
    private int top, capacity;

    public StackParkir(int size) {
        arr = new Object[size];
        capacity = size;
        top = -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        return (int) arr[top];
    }

    public int count() {
        return top + 1;
    }

    public void push(int num) {
        if (isFull()) {
            System.err.println("Stack penuh/overflow");
            System.exit(1);
        } else {
            arr[++top] = num;
            System.out.println("Push elemen " + num + " berhasil");
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.err.println("Stack kosong/underflow");
            System.exit(1);
        }
        --top;
    }

    public void pop(int num) {
        if (isEmpty()) {
            System.err.println("Stack kosong/underflow");
            System.exit(1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(num)) {
                for (int j = i+1; j < arr.length; j++) {
                    arr[j-1] = arr[j];
                }
                arr[top] = null;
                break;
            }
        }
        --top;
    }

    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        StackParkir stackParkir = new StackParkir(5);

        stackParkir.push(5);
        stackParkir.push(6);
        stackParkir.push(7);
        stackParkir.push(8);
        stackParkir.pop(7);
        System.out.println(Arrays.toString(stackParkir.arr));
        System.out.println(stackParkir.peek());
        System.out.println(stackParkir.count());
        System.out.println(stackParkir.count());
        System.out.println(stackParkir.capacity);
        stackParkir.print();
    }
}

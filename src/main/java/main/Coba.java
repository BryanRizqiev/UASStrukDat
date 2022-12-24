package main;

import java.sql.Timestamp;
import java.util.Calendar;

public class Coba {

    public static void main(String[] args) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.getMonth());;
    }
}

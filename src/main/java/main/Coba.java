package main;

import main.utility.SQLCommand;

public class Coba {

    public static void main(String[] args) throws Exception {

        int totalRows = SQLCommand.countData();
        System.out.println(totalRows);
    }
}

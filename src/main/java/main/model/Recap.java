package main.model;

public class Recap {

    private int id;
    private int totalIncome;
    private int totalVehicles;
    private String monthName;
    private int year;

    public Recap(int id, int totalIncome, int totalVehicles, String monthName, int year) {
        this.id = id;
        this.totalIncome = totalIncome;
        this.totalVehicles = totalVehicles;
        this.monthName = monthName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getTotalVehicles() {
        return totalVehicles;
    }

    public void setTotalVehicles(int totalVehicles) {
        this.totalVehicles = totalVehicles;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
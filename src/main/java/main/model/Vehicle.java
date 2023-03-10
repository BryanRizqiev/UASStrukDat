package main.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

// methodnya kurang
public class Vehicle {

    // model kendaraan

    private int id;
    private String nopol;
    private String type;
    private String color;
    private String nameOrBrand;
    private int pay;
    private boolean isOut;
    private Timestamp inTime;
    private Timestamp outTime;

    public Vehicle(int id, String nopol, String type, String color, String nameOrBrand, int pay, boolean isOut, Timestamp inTime) {
        this.id = id;
        this.nopol = nopol;
        this.type = type;
        this.color = color;
        this.nameOrBrand = nameOrBrand;
        this.pay = pay;
        this.isOut = isOut;
        this.inTime = inTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNameOrBrand() {
        return nameOrBrand;
    }

    public void setNameOrBrand(String nameOrBrand) {
        this.nameOrBrand = nameOrBrand;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public Vector<Object> getDataVehicleOut() {
        Vector<Object> data = new Vector<>();
        data.add(nopol);
        data.add(type);
        data.add(color);
        data.add(nameOrBrand);
        data.add(pay);
        data.add((outTime == null) ? "" : new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(outTime));
        return data;
    }

    @Override
    public String toString() {
        return this.nopol;
    }
}

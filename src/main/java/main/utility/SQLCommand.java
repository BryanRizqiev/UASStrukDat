package main.utility;

import main.controller.VehicleController;
import main.model.Vehicle;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLCommand {

    // benahin cronjob, jadi pakai tabel rekap, select is_out // benahin tabel
    private static Connection conn;
    private static final String CREATE = "INSERT INTO vehicles (nopol, type, color, name_or_brand) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM vehicles WHERE is_out = 0 ORDER BY in_time ASC;";
    private static final String SELECT_ALL_QUERY_IS_OUT = "SELECT * FROM vehicles WHERE is_out = 1 ORDER BY in_time ASC;";
    private static final String SELECT_ONE_QUERY_BY_NOPOL = "SELECT * FROM vehicles WHERE nopol = ? AND is_out = 0 LIMIT 1;";
    private static final String SELECT_ONE_QUERY_BY_ID = "SELECT * FROM vehicles WHERE id = ? AND is_out = 0 LIMIT 1;";
    private static final String UPDATE_OUT_BY_NOPOL = "UPDATE vehicles SET is_out = 1, out_time = ? WHERE is_out = 0 AND nopol = ? LIMIT 1;";
    private static final String UPDATE_OUT_BY_ID = "UPDATE vehicles SET is_out = 1 WHERE is_out = 0 AND id = ?;";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Timestamp ts = new Timestamp(System.currentTimeMillis());

    public static Vehicle create(String nopol, String type, String color, String name_or_brand, VehicleController vController) throws Exception {
        if (vController.isFull()) {
            throw new Exception("Parkir penuh");
        }
        try {
            Vehicle vehicle;
            String[] returned = {"id"};
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(CREATE, returned);
            stmnt.setString(1, nopol);
            stmnt.setString(2, type);
            stmnt.setString(3, color);
            stmnt.setString(4, name_or_brand);
            stmnt.executeUpdate();

            ResultSet rs = stmnt.getGeneratedKeys();
            if (rs.next()) {
                // get id and get by id
                vehicle = getById(rs.getInt(1));
            } else {
                throw new Exception("Tidak tau error apa");
            }

            rs.close();
            stmnt.close();
            conn.close();

            vController.push(vehicle);

            return vehicle;
        } catch (SQLException exception) {
            throw new Exception(exception);
        }
    }

    public static boolean isExist(String nopol) {
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(SELECT_ONE_QUERY_BY_NOPOL);
            stmnt.setString(1, nopol);
            ResultSet res = stmnt.executeQuery();

            res.close(); stmnt.close(); conn.close();

            return res.next() && res.getInt(1) > 0;

        } catch (SQLException e) {
            Logger.getLogger(SQLCommand.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    // rs.close() jangan lupa
    public static void getAll(VehicleController vController) throws Exception {
        try {
            vController.clear();
            if (countData() > vController.size()) {
                throw new Exception("Kapasitas tempat parkir (stack) tidak mencukupi");
            }
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(SELECT_ALL_QUERY);
            ResultSet rs = stmnt.executeQuery();

            if (!rs.next()) {
                throw new Exception("Data tidak ada");
            }

            while (rs.next()) {
                if (vController.isFull()) {
                    throw new Exception("Parkir penuh");
                }
                int kode = rs.getInt("id");
                String nopol = rs.getString("nopol");
                String type = rs.getString("type");
                String color = rs.getString("color");
                String nameOrBrand = (rs.getString("name_or_brand") == null ? "" : rs.getString("name_or_brand"));
                int pay = rs.getInt("pay");
                boolean isOut = rs.getBoolean("is_out");
                Timestamp inTime = Timestamp.valueOf(rs.getString("in_time"));
                vController.push(new Vehicle(kode, nopol, type, color, nameOrBrand, pay, isOut, inTime));
            }

            rs.close();
            stmnt.close();
            conn.close();

            System.out.println("Success get all datas");
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public static void getAllIsOut(ArrayList<Vehicle> lists) throws Exception {
        try {
            lists.clear();

            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(SELECT_ALL_QUERY_IS_OUT);
            ResultSet rs = stmnt.executeQuery();

            if (!rs.next()) {
                throw new Exception("Data tidak ada");
            }

            while (rs.next()) {
                int kode = rs.getInt("id");
                String nopol = rs.getString("nopol");
                String type = rs.getString("type");
                String color = rs.getString("color");
                String nameOrBrand = (rs.getString("name_or_brand") == null ? "" : rs.getString("name_or_brand"));
                int pay = rs.getInt("pay");
                boolean isOut = rs.getBoolean("is_out");
                Timestamp inTime = Timestamp.valueOf(rs.getString("in_time"));
                String outTimeStr = rs.getString("out_time");
                Timestamp outTime = (outTimeStr == null) ? null : Timestamp.valueOf(outTimeStr);
                Vehicle vehicle = new Vehicle(kode, nopol, type, color, nameOrBrand, pay, isOut, inTime);
                vehicle.setOutTime(outTime);
                lists.add(vehicle);
            }

            rs.close();
            stmnt.close();
            conn.close();

            System.out.println("Success get all datas is out");
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public static Vehicle getByNopol(String nopolParam) throws Exception {
        Vehicle vehicle;
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(SELECT_ONE_QUERY_BY_NOPOL);
            stmnt.setString(1, nopolParam);
            ResultSet rs = stmnt.executeQuery();

            if (!rs.next()) {
                throw new Exception("Data tidak ada");
            }

            int kode = rs.getInt("id");
            String nopol = rs.getString("nopol");
            String type = rs.getString("type");
            String color = rs.getString("color");
            String nameOrBrand = (rs.getString("name_or_brand") == null ? "" : rs.getString("name_or_brand"));
            int pay = rs.getInt("pay");
            boolean isOut = rs.getBoolean("is_out");
            Timestamp inTime = Timestamp.valueOf(rs.getString("in_time"));
            vehicle = new Vehicle(kode, nopol, type, color, nameOrBrand, pay, isOut, inTime);

            rs.close();
            stmnt.close();
            conn.close();

            return vehicle;
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public static Vehicle getById(int id) throws Exception {
        Vehicle vehicle;
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(SELECT_ONE_QUERY_BY_ID);
            stmnt.setInt(1, id);
            ResultSet rs = stmnt.executeQuery();

            if (!rs.next()) {
                throw new Exception("Data tidak ada");
            }

            int kode = rs.getInt("id");
            String nopol = rs.getString("nopol");
            String type = rs.getString("type");
            String color = rs.getString("color");
            String nameOrBrand = (rs.getString("name_or_brand") == null ? "" : rs.getString("name_or_brand"));
            int pay = rs.getInt("pay");
            boolean isOut = rs.getBoolean("is_out");
            Timestamp inTime = Timestamp.valueOf(rs.getString("in_time"));
            vehicle = new Vehicle(kode, nopol, type, color, nameOrBrand, pay, isOut, inTime);

            rs.close();
            stmnt.close();
            conn.close();

            return vehicle;
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public static void update() {

    }

    public static void updateIsOut(String nopol, VehicleController vController) throws Exception {

        Timestamp now = new Timestamp(System.currentTimeMillis());
        now.setHours(now.getHours() - 7);

        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(UPDATE_OUT_BY_NOPOL);
            stmnt.setTimestamp(1, now);
            stmnt.setString(2, nopol);
            int affected = stmnt.executeUpdate();
            if (affected == 0) {
                throw new Exception("Tidak ada update");
            }

            vController.pop(nopol);
            stmnt.close();
            conn.close();

            System.out.println("Success");
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public static void updateIsOut(int id, VehicleController vController) throws Exception {
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(UPDATE_OUT_BY_ID);
            stmnt.setInt(1, id);
            int affected = stmnt.executeUpdate();
            if (affected == 0) {
                throw new Exception("Tidak ada update");
            }

            vController.pop(id);
            stmnt.close();
            conn.close();

            System.out.println("Success");
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    // kurang refactor
    public static int countData() throws Exception {
        int totalRows;
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement stmnt = conn.prepareStatement("SELECT COUNT(id) AS total FROM vehicles WHERE is_out = 0;");
            ResultSet rs = stmnt.executeQuery();
            if (!rs.next()) {
                throw new Exception("Tidak tau error apa");
            }

            totalRows = rs.getInt("total");

            rs.close();
            stmnt.close();
            conn.close();

            return totalRows;
        } catch (SQLException exception) {
            throw new Exception(exception.getMessage());
        }
    }
}

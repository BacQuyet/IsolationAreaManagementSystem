/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Area;
import entity.Patient;
import entity.Room;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import utils.Utils;

public class PatientDAO implements DAO<Patient> {

    private final String SQL_INSERT = "INSERT INTO dbo.patient\n"
            + "(\n"
            + "    full_name,\n"
            + "    age,\n"
            + "    gender,\n"
            + "    address,\n"
            + "    partpost,\n"
            + "    phone,\n"
            + "    region,\n"
            + "    suspicion_level,\n"
            + "    time_in,\n"
            + "    time_out,\n"
            + "    room_id,\n"
            + "    area_id,\n"
            + "    account_id\n"
            + ")\n"
            + "VALUES\n"
            + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    Connection conn = DBcontext.getConnection();

    @Override
    public List<Patient> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Patient> qq = new ArrayList<>();
            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setPatientName(rs.getString("full_name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setAddress(rs.getString("address"));
                p.setPassport(rs.getString("partpost"));
                p.setPhoneNumber(rs.getInt("phone"));
                p.setRegion(rs.getString("region"));
                p.setSuspicionLevel(rs.getString("suspicion_level"));
                p.setTimeIn(rs.getTimestamp("time_in"));
                p.setTimeOut(rs.getTimestamp("time_out"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * GET PATIENT BY PATIENT_ID
     *
     * @param id patient_id
     * @return Patient
     */
    @Override
    public Patient get(int id) {
        String sql = "SELECT * from patient where patient_id = " + id;
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    /**
     * GET PATIENT BY ACCOUNT_ID
     *
     * @param id
     * @return Patient
     */
    public Patient getPatientByAccountId(int id) {
        String sql = "SELECT * from patient where account_id = " + id;
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public Patient getPatientByRoom(int id) {
        String sql = "SELECT * from patient where room_id = " + id;
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    /**
     * GET LIST OF PATIENTS IN GIVEN DAY DURATION
     *
     * @param duration number of days
     * @return list of patients
     */
    public int getPatientsInDuration(int duration) {
        String sql = "SELECT * FROM dbo.patient\n"
                + "WHERE DATEDIFF(DAY, time_in, GETDATE()) < " + duration;
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq.size();
    }

    /**
     * GEt NUMBER OF PATIENTS IN 1 CERTAIN DATE
     *
     * @param date
     * @return NUMBER OF PATIENTS IN CERTAIN DATE
     */
    public int getNuPatientsInDate(String date) {
        String sql = "SELECT * FROM dbo.patient\n"
                + "WHERE CONVERT(VARCHAR(10), time_in, 103) = '" + date + "'";
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq.size();
    }

    /**
     * GET TOTAL PATIENTS IN THE SYSTEM
     *
     * @return NUMBER OF PATIENTS
     */
    public int getTotalPatients() {
        String sql = "SELECT COUNT(*) AS Num FROM dbo.patient";
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("Num");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public void create(Patient p) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, p.getPatientName());
            prep.setInt(2, p.getAge());
            prep.setString(3, p.getGender());
            prep.setString(4, p.getAddress());
            prep.setString(5, p.getPassport());
            prep.setInt(6, p.getPhoneNumber());
            prep.setString(7, p.getRegion());
            prep.setString(8, p.getSuspicionLevel());
            prep.setTimestamp(9, (java.sql.Timestamp) p.getTimeIn());
            prep.setTimestamp(10, null);
            prep.setInt(11, p.getRoom().getRoomId());
            prep.setInt(12, p.getArea().getAreaId());
            prep.setInt(13, 30); // valid account id
            prep.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Patient t, Hashtable<String, String> my_dict) {
        if (!my_dict.isEmpty()) {
            String sql_update = "Update patient set ";
            try (
                    PreparedStatement prep = conn.prepareStatement(sql_update);) {
                String change = "";
                for (String key : my_dict.keySet()) {
                    String value = my_dict.get(key);
                    try {
                        int values = Integer.parseInt(value);
                        change += key + " = " + values + ",";
                    } catch (Exception e) {
                        change += key + " = '" + value + "',";
                    }
                }
                change = change.substring(0, change.length() - 1);
                sql_update += change + " where patient_id = " + t.getPatientId();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }
    }

    public List<Patient> getListAll(int offset, int noOfRecords) {
        String sql = "SELECT * FROM patient p\n"
                + "join room  r on p.room_id = r.room_id\n"
                + "join area a on p.area_id = a.area_id\n"
                + "ORDER BY patient_id\n"
                + "OFFSET " + offset + " ROWS FETCH NEXT " + noOfRecords + " ROWS ONLY";
        //System.out.println("sql " + sql);
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Patient> qq = new ArrayList<>();
            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setPatientName(rs.getString("full_name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setAddress(rs.getString("address"));
                p.setPassport(rs.getString("partpost"));
                p.setPhoneNumber(rs.getInt("phone"));
                p.setRegion(rs.getString("region"));
                p.setSuspicionLevel(rs.getString("suspicion_level"));
                p.setTimeIn(rs.getTimestamp("time_in"));
                p.setTimeOut(rs.getTimestamp("time_out"));
                p.setRoomName(rs.getString("room_name"));
                p.setAreaName(rs.getString("area_name"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getNoOfRecord(int areaId) {
        try {
            String sql = "SELECT COUNT(*) AS NoOfRecords FROM dbo.patient WHERE area_id = " + areaId;
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            rs.next();
            return rs.getInt("NoOfRecords");
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Patient> getList(int offset, int noOfRecords, int areaId) {
        String sql = "SELECT * FROM dbo.patient\n"
                + "WHERE area_id = " + areaId + "\n"
                + "ORDER BY patient_id\n"
                + "OFFSET " + offset + " ROWS FETCH NEXT " + noOfRecords + " ROWS ONLY";
        //System.out.println("sql " + sql);
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void delete(Patient t) {
        try {
            String sql = "DELETE FROM dbo.patient WHERE patient_id = " + t.getPatientId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAll() {
        String sql = "SELECT * from patient";
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public void discharge(Patient patient) {
        Hashtable<String, String> hashTable = new Hashtable<>();
        String timeOut = Utils.getToday();
        hashTable.put("time_out", timeOut);
        update(patient, hashTable);
    }

    public List<Patient> SearchByKey(String key) {

        String sql = "SELECT * from patient where full_name like '%" + key + "%'";
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }
}

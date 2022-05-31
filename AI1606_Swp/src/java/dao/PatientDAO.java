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
     *  GET TOTAL PATIENTS IN THE SYSTEM
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
    public void create(Patient t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void delete(Patient t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

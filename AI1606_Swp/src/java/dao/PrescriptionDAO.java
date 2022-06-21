/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Presciption;
import entity.Report;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X1 Carbon Gen 7
 */
public class PrescriptionDAO implements DAO<Presciption>{
    
    PatientDAO patient = new PatientDAO();
    DoctorDAO doctor = new DoctorDAO();
    MedicienDAO medicien = new MedicienDAO();
    
    Connection conn = DBcontext.getConnection();

    @Override
    public List<Presciption> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Presciption> qq = new ArrayList<>();
            while (rs.next()) {
                Presciption re = new Presciption();
                re.setPresciptionId(rs.getInt("id_prescription"));
                re.setPresciptionName(rs.getString("medicine_name"));
                re.setCreateDate(rs.getTimestamp("create_date"));
                re.setPatient(patient.get(rs.getInt("id_patient")));
                re.setDoctor(doctor.get(rs.getInt("id_doctor")));
                re.setMedicine(medicien.get(rs.getInt("id_medicine")));
                re.setQuantity(rs.getInt("quantity"));
                qq.add(re);
            }
            return qq;
        } catch (SQLException ex) {
            Logger.getLogger(PrescriptionDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
        return null;
    }

    @Override
    public Presciption get(int id) {
        String sql = "select * from prescription where id_prescription = " + id;
        List<Presciption> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Presciption> getAll() {
        String sql = "select * from prescription order by create_date desc";
        List<Presciption> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(Presciption t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Presciption t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Presciption t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List getIndex(int index1, int index2, int id) {
        String sql = "SELECT * FROM (\n"
                + "    SELECT *, ROW_NUMBER() OVER (ORDER BY id_prescription) AS RowNum\n"
                + "    FROM [dbo].[prescription] \n"
                + ") AS MyDerivedTable\n"
                + "WHERE MyDerivedTable.RowNum BETWEEN " + index1 + " AND " + index2;
        if (id > 0) {
            sql = "SELECT * FROM (\n"
                    + "    SELECT *, ROW_NUMBER() OVER (ORDER BY id_prescription) AS RowNum\n"
                    + "    FROM [dbo].[prescription] WHERE id_patient = " + id + "\n"
                    + ") AS MyDerivedTable\n"
                    + "WHERE MyDerivedTable.RowNum BETWEEN " + index1 + " AND " + index2;
        }
        List<Presciption> prescription = new ArrayList<>();
        prescription = parse(sql);
        return prescription;
    }
    
    public int getNoOfRecord(int id) {
        String sql = "SELECT COUNT(*) AS Num FROM [dbo].[prescription]";
        if (id > 0) {
            sql += " WHERE id_patient = " + id;
        }
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("Num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrescriptionDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
        return 0;
    }
    
    public List<Presciption> SearchByKey(String key) {
        
        String sql = "SELECT * from presciption where medicine_name like '%" + key + "%'";
        List<Presciption> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }
    
}

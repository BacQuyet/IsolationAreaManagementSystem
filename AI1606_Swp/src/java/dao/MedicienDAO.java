/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Medicine;
import entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class MedicienDAO implements DAO<Medicine>{

    Connection conn = DBcontext.getConnection();
    
    @Override
    public List<Medicine> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Medicine> qq = new ArrayList<>();
            while (rs.next()) {
                Medicine p = new Medicine();
                p.setMedicienId(rs.getInt("id_medicine"));
                p.setName(rs.getString("medicine_name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setImage(rs.getString("image"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Medicine get(int id) {
        String sql = "SELECT * from medicine where id_medicine = " + id;
        List<Medicine> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Medicine> getAll() {
        String sql = "SELECT * from medicine";
        List<Medicine> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(Medicine t) {
        String SQL_INSERT = "INSERT INTO [dbo].[medicine]\n"
                + "           ([medicine_name]\n"
                + "           ,[quantity]\n"
                + "           ,[image])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getName());
            prep.setInt(2, t.getQuantity());
            prep.setString(3, t.getImage());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MedicienDAO.class.getName()).log(Level.SEVERE, SQL_INSERT, ex);
        }
    }

    @Override
    public void update(Medicine t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Medicine t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

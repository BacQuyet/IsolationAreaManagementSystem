/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Nurse;
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

public class NurseDAO implements DAO<Nurse> {

    Connection conn = DBcontext.getConnection();
    AccountDAO acc = new AccountDAO();
    AreaDAO area = new AreaDAO();
    private final String SQL_INSERT = "INSERT INTO [dbo].[nurse]\n"
            + "           ([name_nurse]\n"
            + "           ,[phone]\n"
            + "           ,[fullname]\n"
            + "           ,[id_account]\n"
            + "           ,[address]\n"
            + "           ,[id_area])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?)";

    @Override
    public List<Nurse> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Nurse> nurse = new ArrayList<>();
            while (rs.next()) {
                Nurse r = new Nurse();
                r.setId_nurse(rs.getInt("id_nurse"));
                r.setName_nurse(rs.getString("name_nurse"));
                r.setPhone(rs.getInt("phone"));
                r.setId_account(acc.get(rs.getInt("id_account")));
                r.setAddress(rs.getString("address"));
                r.setId_area(area.get(rs.getInt("id_area")));
                r.setFullName(rs.getString("fullname"));
                nurse.add(r);
            }
            return nurse;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
        return null;
    }

    @Override
    public Nurse get(int account_id) {
        try {

            String sql = "SELECT * FROM dbo.nurse\n"
                    + "WHERE id_account = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, account_id);
            ResultSet rs = sttm.executeQuery();
            Nurse nurse = new Nurse();
            while (rs.next()) {
                nurse.setId_nurse(rs.getInt("id_nurse"));
                nurse.setName_nurse(rs.getString("name_nurse"));
                nurse.setPhone(rs.getInt("phone"));
                nurse.setFullName(rs.getString("fullname"));
                nurse.setId_account(acc.get(rs.getInt("id_account")));
                nurse.setAddress(rs.getString("address"));
                nurse.setId_area(area.get(rs.getInt("id_area")));
            }
            return nurse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public int getNoOfRecord() {
        String sql = "SELECT COUNT(*) AS Num FROM [dbo].[nurse]";
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("Num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
        return 0;
    }
   public List getIndex(int index1, int index2) {
        String sql = "SELECT * FROM (\n"
                + "    SELECT *, ROW_NUMBER() OVER (ORDER BY id_nurse) AS RowNum\n"
                + "    FROM [dbo].[nurse] "
                + ") AS MyDerivedTable\n"
                + "WHERE MyDerivedTable.RowNum BETWEEN " + index1 + " AND " + index2;
        List<Nurse> nurse = new ArrayList<>();
        nurse = parse(sql);
        return nurse;
    }

    public Nurse getByID(int id_nurse) {

        try {
            String sql = "SELECT * FROM dbo.nurse\n"
                    + "WHERE id_nurse = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, id_nurse);
            ResultSet rs = sttm.executeQuery();
            Nurse nurse = new Nurse();
            while (rs.next()) {
                nurse.setId_nurse(rs.getInt("id_nurse"));
                nurse.setName_nurse(rs.getString("name_nurse"));
                nurse.setPhone(rs.getInt("phone"));
                nurse.setFullName(rs.getString("fullname"));
                nurse.setId_account(acc.get(rs.getInt("id_account")));
                nurse.setAddress(rs.getString("address"));
                nurse.setId_area(area.get(rs.getInt("id_area")));
            }
            return nurse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


// fix bug update
    @Override
    public void update(Nurse t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nurse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Nurse t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getName_nurse());
            prep.setInt(2, t.getPhone());
            prep.setString(3, t.getFullName());
            prep.setInt(4, t.getId_account().getAccountId());
            prep.setString(5, t.getAddress());
            prep.setInt(6, t.getId_area().getAreaId());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Nurse t) {
             try {
            String sql = "delete from nurse where id_nurse = " + t.getId_nurse();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }

    }

}

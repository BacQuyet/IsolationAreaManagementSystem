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
    public Nurse getNurseByAccountId(int id) {
        String sql = "SELECT * from nurse where id_account = " + id;
        List<Nurse> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }
    @Override
    public Nurse get(int account_id) {
        try {

            String sql = "SELECT * FROM dbo.nurse\n"
                    + "WHERE id_nurse = ?";
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
    
       public void updateAccountNurse(Nurse d) {
        String sql = "UPDATE [dbo].[nurse]\n"
                + "   SET [fullname] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[address] = ?\n"
                + " WHERE [id_account] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, d.getFullName());
            pre.setInt(2, d.getPhone());
            pre.setString(3, d.getAddress());
            pre.setInt(4, d.getAccount_id());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NurseDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
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
   public int countPageSize(String key) {
        try {
            String query = "select Count(*) as Num from nurse where fullname like '%" + key + "%'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("Num");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
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
    public List<Nurse> SearchNurseByKey(String key, int offset, int noOfRecords) {

        String sql = "SELECT * from nurse where fullname like ? ORDER BY fullname OFFSET "+offset+" ROWS FETCH NEXT "+noOfRecords+" ROWS ONLY";
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, "%" + key + "%");
            ResultSet rs = sttm.executeQuery();
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
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

// fix bug update
    @Override
    public void update(Nurse t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void updateNurse(Nurse n) {
        String sql = "UPDATE nurse SET "
                + "name_nurse = ?, phone = ?, id_account = ?, address = ?, id_area = ?, fullname = ? "
                + "WHERE id_nurse = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, n.getName_nurse());
            pre.setInt(2, n.getPhone());
            pre.setInt(3, n.getId_account().getAccountId());
            pre.setString(4, n.getAddress());
            pre.setInt(5, n.getId_area().getAreaId());
            pre.setString(6, n.getFullName());
            pre.setInt(7, n.getId_nurse());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
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
    public static void main(String[] args) {
        NurseDAO dao = new NurseDAO();
        //dao.updateAccountNurse(new Nurse(1231231234, "nam", "nam", 1002));
        List<Nurse> list = new ArrayList<>();
        list = dao.SearchNurseByKey("thanh", 2, 1);
        System.out.println(list);
    }

}

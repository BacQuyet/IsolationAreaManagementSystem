/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Nurse;
import entity.TypeAccount;
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
import utils.Utils;

public class AccountDAO implements DAO<Account> {

    private final String SQL_INSERT = "INSERT INTO dbo.account\n"
            + "(\n"
            + "    id_type,\n"
            + "    username,\n"
            + "    password,\n"
            + "    avatar,\n"
            + "    email\n"
            + ")\n"
            + "VALUES\n"
            + "(?,?,?,?,?)";

    private final Connection conn = DBcontext.getConnection();
    private final TypeDAO accountTypeDAO = new TypeDAO();
    private final PatientDAO patientDAO = new PatientDAO();
    private final Utils utils = new Utils();

    @Override
    public List<Account> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Account> qq = new ArrayList<>();
            while (rs.next()) {
                Account p = new Account();
                p.setAccountId(rs.getInt("account_id"));
                p.setUserName(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                int accountTypeId = rs.getInt("id_type");
                p.setAvatar(rs.getString("avatar"));
                p.setEmail(rs.getString("email"));
                p.setType(accountTypeDAO.get(accountTypeId));
                p.setPatient(patientDAO.getPatientByAccountId(rs.getInt("account_id")));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void updateAccount(Account d) {
        String sql = "UPDATE [dbo].[account]\n"
                + "   SET [email] = ?\n"
                + " WHERE account_id =?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, d.getEmail());
            pre.setInt(2, d.getAccountId());
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }
    @Override
    public Account get(int id) {
        String sql = "Select * from account where account_id = " + id;
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    public Account find(String username) {
        String sql = "select * from account where username = '" + username + "'";
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    /**
     * Find account by username and password
     *
     * @param username
     * @param password
     * @return Account
     */
    public Account findByUsernamePassword(String username, String password) {
        String sql = "select * from account where username = '" + username + "' and password = '" + password + "';";
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    /**
     * Find Account by username
     *
     * @param username
     * @param email
     * @return Account
     */
    public Account findByUsernameEmail(String username, String email) {
        String sql = "select * from account where username = '" + username + "' and email ='" + email + "'";;
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    /**
     * Find Account by patient_id
     *
     * @param patientId
     * @return Account
     */
    public Account findAccountByPatientId(int patientId) {
        String sql = "select * from account where patient_id = " + patientId;
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    /**
     * Get Nurse by account_id
     *
     * @param account_id
     * @return Nurse
     */
    @Override
    public void create(Account t) {
        try (
                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setInt(1, t.getType().getAccountTypeId());
            prep.setString(2, t.getUserName());
            prep.setString(3, t.getPassword());
            prep.setString(4, t.getAvatar());
            prep.setString(5, t.getEmail());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account t, Hashtable<String, String> my_dict) {
        String sql_update = "Update account set ";
        if (!my_dict.isEmpty()) {
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
                sql_update += change + " where account_id = " + t.getAccountId();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }
    }

    public void updateForgot(Account t) {
        try {
            String sql = "UPDATE dbo.account SET password = '" + "' WHERE username = '" + t.getUserName() + "'";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateForgots(Account t, String pass) {
        try {
            String sql = "UPDATE dbo.account SET password = '" + pass + "' WHERE username = '" + t.getUserName() + "'";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Account a = new Account("thanhhduy", "123456", "a", "a", new TypeAccount(2));
        AccountDAO d = new AccountDAO();
        d.create(a);
    }

    @Override
    public void delete(Account t) {
        try {
            String sql = "delete from account where account_id = " + t.getAccountId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }
    
}

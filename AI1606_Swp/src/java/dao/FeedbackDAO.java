/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class FeedbackDAO implements DAO<Feedback>{
    Connection conn = DBcontext.getConnection();
    @Override
    public List<Feedback> parse(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Feedback get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Feedback> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Feedback t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Feedback t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Feedback t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Feedback> getAllFeedback(int offset, int noOfRecords) {
        ArrayList<Feedback> lst = new ArrayList<>();
        try {
                String query = "SELECT * FROM feedback ORDER BY create_date DESC "
                    + "OFFSET " + offset + " ROWS FETCH NEXT " + noOfRecords + " ROWS ONLY";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback re = new Feedback();
                re.setFeedback_id(rs.getInt("feedback_id"));
                re.setContent(rs.getString("content"));
                re.setCreateDate(rs.getTimestamp("create_date"));
                re.setPatient_id(rs.getInt("patient_id"));
                lst.add(re);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int countPage() {
        try {
            String query = "select Count(*) as Num from feedback";
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
    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();
        List<Feedback> list = new ArrayList<>();
        list = dao.getAllFeedback(2, 2);
        System.out.println(dao.countPage());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Area;
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


public class AreaDAO implements DAO<Area> {

    Connection conn = DBcontext.getConnection();
     
    @Override
    public List<Area> parse(String sql) {
         try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Area> qq = new ArrayList<>();
            while (rs.next()) {
                Area p = new Area();
                p.setAreaId(rs.getInt("area_id"));
                p.setAreaName(rs.getString("area_name"));
                p.setAreaAddress(rs.getString("area_address"));
                p.setContact(rs.getString("contact"));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Area get(int id) {
        String sql = "select * from area where area_id = " + id;
        List<Area> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Area> getAll() {
        String sql = "SELECT * FROM area";
        List<Area> area = new ArrayList<>();
        area = parse(sql);
        return area;
    }

    @Override
    public void create(Area t) {
        String sql = "INSERT INTO area"
                + " ([area_name],[area_address],[contact]) VALUES (?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, t.getAreaName());
            pre.setString(2, t.getAreaAddress());
            pre.setString(3, t.getContact());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }

    @Override
    public void delete(Area t) {
        String sql = "DELETE FROM [dbo].[area] WHERE area_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, t.getAreaId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }

    @Override
    public void update(Area t, Hashtable<String, String> my_dict) {
        
    }
    public void updateArea(Area a) {
        String sql = "UPDATE area SET "
                + "area_name = ?, area_address = ?, contact = ? "
                + "WHERE area_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, a.getAreaName());
            pre.setString(2, a.getAreaAddress());
            pre.setString(3, a.getContact());
            pre.setInt(4, a.getAreaId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;
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

public class RoomDAO implements DAO<Room> {

    Connection conn = DBcontext.getConnection();
    AreaDAO area = new AreaDAO();
    /**
     * GET TOTAL BED IN THE SYSTEM
     * 
     * @return total bed
     */
    public int getAllBed() {
        String sql = "SELECT SUM(bed_number) as Num FROM dbo.room" ;
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("Num");
            }
        } catch (SQLException ex) {
            
        }
        return 0;
    }

    @Override
    public List<Room> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Room> room = new ArrayList<>();
            while (rs.next()) {
                Room r = new Room();
                r.setRoomId(rs.getInt("room_id"));
                r.setRoomName(rs.getString("room_name"));
                r.setBedNumber(rs.getInt("bed_number"));
                r.setArea(area.get(rs.getInt("area_id")));
                r.setNote(rs.getString("note"));
                room.add(r);
            }
            return room;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
        return null;
    }

    @Override
    public Room get(int id) {
        String sql = "SELECT * FROM [dbo].[room] WHERE room_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setRoomId(rs.getInt("room_id"));
                r.setRoomName(rs.getString("room_name"));
                r.setBedNumber(rs.getInt("bed_number"));
                r.setArea(area.get(rs.getInt("area_id")));
                r.setNote(rs.getString("note"));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
        return null;
    }

    @Override
    public List<Room> getAll() {
        String sql = "SELECT * FROM room";
        List<Room> room = new ArrayList<>();
        room = parse(sql);
        return room;
    }

    @Override
    public void create(Room r) {
        String sql = "INSERT INTO room"
                + " ([room_name],[bed_number],[note],[area_id]) VALUES (?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, r.getRoomName());
            pre.setInt(2, r.getBedNumber());
            pre.setString(3, r.getNote());
            pre.setInt(4, r.getArea().getAreaId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }
    
    public void createRoom(Room r) {
        
        String sql = "INSERT INTO room"
                + " ([room_name],[bed_number],[note],[area_id]) VALUES (?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, r.getRoomName());
            pre.setInt(2, r.getBedNumber());
            pre.setString(3, r.getNote());
            pre.setInt(4, r.getArea().getAreaId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }

    @Override
    public void update(Room t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Room r) {
        String sql = "DELETE FROM [dbo].[room] WHERE room_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, r.getRoomId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, sql, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import QuanLyBanHangHelper.OracleJDBCConnection;
import QuanLyBanHangModel.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Linh
 */
public class HoaDon_Dao {
    public boolean insert(HoaDon hd)  throws Exception {
        String SQL = "insert into HoaDon(soHD, NGHD, MAKH, MANV,TRIGIA ) values(?,?,?,?,?)";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setInt(1, hd.getSoHD());
            ps.setDate(2,(Date)hd.getNGHD());
            ps.setString(3,hd.getMaKH());
            ps.setString(4, hd.getMaNV());
            ps.setLong(5, hd.getTriGia());
            return ps.executeUpdate() >0;
        }        
    }
    
      public HoaDon find(int SOHD) throws Exception {
        String SQL = "select * from HoaDon where SOHD =?";
        
        
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        try{
       ps.setInt(1, SOHD);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           HoaDon hd = new HoaDon();
            hd.setMaNV(rs.getString("manv"));
            hd.setSoHD(rs.getInt("sohd"));
            hd.setNGHD(rs.getDate("NGHD"));
            hd.setMaKH(rs.getString("MAKH"));
            hd.setTriGia(rs.getLong("TRIGIA"));
            return hd;
       }
       
      
        }
         catch (SQLException ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
      
    public boolean update(HoaDon hd)  throws Exception {
        String SQL = "update HoaDon set  NGHD = ?, MAKH = ?, MANV=?,TRIGIA=? where SOHD = ?";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setInt(5, hd.getSoHD());
            ps.setDate(1, (Date)hd.getNGHD());
            ps.setString(2, hd.getMaKH());
            ps.setString(3, hd.getMaNV());
            ps.setLong(4, hd.getTriGia());
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String SOHD) throws Exception {
        String SQL = "delete from HoaDon where SOHD=?";
    try(   
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, SOHD);
       return ps.executeUpdate() >0;
        }
    }
    
}

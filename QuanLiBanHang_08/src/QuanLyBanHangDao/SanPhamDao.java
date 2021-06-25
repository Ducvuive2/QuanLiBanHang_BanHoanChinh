/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import QuanLyBanHangHelper.OracleJDBCConnection;
import QuanLyBanHangModel.SanPham;

/**
 *
 * @author Nguyen Linh
 */
public class SanPhamDao {
     public boolean insert(SanPham SP)  throws Exception {
        String SQL = "insert into SANPHAM values(?,?,?,?,?)";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, SP.getMaSP());
            ps.setString(2, SP.getTenSP());
            ps.setString(3, SP.getDVT());
            ps.setString(4, SP.getNuocSX());
            ps.setLong(5, SP.getGia());
          
               
            return ps.executeUpdate() >0;
        }        
    }
    
      public SanPham find(String MASP) throws Exception {
        String SQL = "select * from SANPHAM where MaSP =?";
        
        try(
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MASP);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           SanPham SP = new SanPham();
           SP.setMaSP(rs.getString("maSP"));
           SP.setTenSP(rs.getString("TENSP"));
           SP.setDVT(rs.getString("DVT"));
           SP.setNuocSX(rs.getString("NuocSX"));
           SP.setGia(rs.getLong("Gia"));
           
           return SP;
       }
       
       return null;
        }
    }
      
    public boolean update(SanPham SP)  throws Exception {
        String SQL = "update SanPham set TENSP =?, DVT=?, NUOCSX=?, GIA=? WHERE MASP =?";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(5, SP.getMaSP());
            ps.setString(1, SP.getTenSP());
            ps.setString(2, SP.getDVT());
            ps.setString(3, SP.getNuocSX());
            ps.setLong(4, SP.getGia());
               
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaSP) throws Exception {
        String SQL = "delete from SANPHAM where masp=?";
    try(   
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaSP);
       return ps.executeUpdate() >0;
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import QuanLyBanHangHelper.OracleJDBCConnection;
import QuanLyBanHangModel.KhachHang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class KhachHangDao {
    public boolean insert(KhachHang KH)  throws Exception {
        String SQL = "insert into KhachHang(maKH, hoTen, DCHI, SODT, NGSINH, DOANHSO, NGDK) values(?,?,?,?,?,?,?)";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, KH.getMAKH());
            ps.setString(2, KH.getHOTEN());
            ps.setString(3, KH.getDCHI());
            ps.setString(4, KH.getSODT());
            ps.setDate(5,(Date) KH.getNGSINH());
            ps.setLong(6,(long) KH.getDOANHSO());
            ps.setDate(7,(Date) KH.getNGDK());
               
            return ps.executeUpdate() >0;
        }        
    }
    
      public KhachHang find(String MAKH) throws Exception {
        String SQL = "select * from KHACHHANG where MAKH =?";
        
        try(
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MAKH);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           KhachHang KH = new KhachHang();
            KH.setMAKH(rs.getString(1));
            KH.setHOTEN(rs.getString(2));
            KH.setNGSINH(rs.getDate(5));
            KH.setDCHI(rs.getString(3));
            KH.setSODT(rs.getString(4));
            KH.setDOANHSO(rs.getLong(6));
            KH.setNGDK(rs.getDate(7));
            
            return KH;
            
       }
       
       return null;
        }
    }
      
    public boolean update(KhachHang KH)  throws Exception {
        String SQL = "update KHACHHANG set  hoTen=?, DCHI=?, SODT=?, NGSINH=?, DOANHSO=?, NGDK=? where maKH = ?";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(7, KH.getMAKH());
            ps.setString(1, KH.getHOTEN());
            ps.setString(2, KH.getDCHI());
            ps.setString(3, KH.getSODT());
            ps.setDate(4,(Date) KH.getNGSINH());
            ps.setLong(5, KH.getDOANHSO());
            ps.setDate(6,(Date) KH.getNGDK());
               
            return ps.executeUpdate() >0;
               
            
        }        
    }
    
    public boolean delete(String MaKH) throws Exception {
        String SQL = "delete from KHACHHANG where MAKH=?";
    try(   
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaKH);
       return ps.executeUpdate() >0;
        }
    }
}


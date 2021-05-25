/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import QuanLyBanHangHelper.OracleJDBCConnection;
import QuanLyBanHangModel.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nguyen Linh
 */
public class NhanVienDao {
    public boolean insert(NhanVien NV)  throws Exception {
        String SQL = "insert into NhanVien(maNV, hoTen, ngVL, gioiTinh, CMND, diaChi, soDT, password ) values(?,?,?,?,?,?,?,?)";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, NV.getMaNV());
            ps.setString(2, NV.getHoTen());
            ps.setDate(3, (Date) NV.getNgVL());
            ps.setString(4, NV.getGioiTinh());
            ps.setString(5, NV.getCMND());
            ps.setString(6, NV.getDiaChi());
            ps.setString(7, NV.getSoDT());
            ps.setString(8, NV.getPass());
               
            return ps.executeUpdate() >0;
        }        
    }
    
      public NhanVien find(String MANV) throws Exception {
        String SQL = "select * from NHANVIEN where MANV =?";
        
        try(
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MANV);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           NhanVien NV = new NhanVien();
            NV.setMaNV(rs.getString("manv"));
            NV.setHoTen(rs.getString("hoten"));
            NV.setNgVL(rs.getDate("ngvl"));
            NV.setGioiTinh(rs.getString("gioitinh"));
            NV.setCMND(rs.getString("cmnd"));
            NV.setDiaChi(rs.getString("diachi"));
            NV.setSoDT(rs.getString("sodt"));
            NV.setPass(rs.getString("password"));
            return NV;
       }
       
       return null;
        }
    }
      
    public boolean update(NhanVien NV)  throws Exception {
        String SQL = "update NhanVien set  hoTen = ?, ngVL = ?, gioiTinh=?, CMND=?, diaChi=?, soDT=?, password=? where manv = ?";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
           ps.setString(8, NV.getMaNV());
            ps.setString(1, NV.getHoTen());
            ps.setDate(2, (Date) NV.getNgVL());
            ps.setString(3, NV.getGioiTinh());
            ps.setString(4, NV.getCMND());
            ps.setString(5, NV.getDiaChi());
            ps.setString(6, NV.getSoDT());
            ps.setString(7, NV.getPass());
               
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaNV) throws Exception {
        String SQL = "delete from NHANVIEN where manv=?";
    try(   
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaNV);
       return ps.executeUpdate() >0;
        }
    }
    
}

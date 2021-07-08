/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import Database.Database;
import QuanLyBanHangModel.NhanVien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nguyen Linh
 */
public class NhanVienDao {
    public boolean insert(NhanVien NV) {

        String SQL = "insert into NhanVien(maNV, hoTen, ngVL, gioiTinh, CMND, diaChi, soDT,userID, password,loaiNV ) values(?,?,?,?,?,?,?,?,?,?)";


        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);

        ) {
            ps.setString(1, NV.getMANV());
            ps.setString(2, NV.getHOTEN());
            ps.setDate(3, new java.sql.Date(NV.getNGVL().getTime()));
            ps.setString(4, NV.getGIOITINH());
            ps.setString(5, NV.getCMND());
            ps.setString(6, NV.getDIACHI());
            ps.setString(7, NV.getSODT());

            ps.setString(8, NV.getUSERID());
            ps.setString(9, NV.getPASSWORD());
            ps.setString(10, NV.getLOAINV());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public NhanVien find(String MANV) throws Exception {
        String SQL = "select * from NHANVIEN where MANV =?";


        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        try {
            ps.setString(1, MANV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NhanVien NV = new NhanVien();
                NV.setMANV(rs.getString("manv"));
                NV.setHOTEN(rs.getString("hoten"));
                NV.setNGVL(rs.getDate("ngvl"));
                NV.setGIOITINH(rs.getString("gioitinh"));
                NV.setCMND(rs.getString("cmnd"));
                NV.setDIACHI(rs.getString("diachi"));
                NV.setSODT(rs.getString("sodt"));

                NV.setUSERID(rs.getString("userid"));
                NV.setPASSWORD(rs.getString("password"));
                NV.setLOAINV(rs.getString("sodt"));

                return NV;
            }


        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(NhanVien NV) throws Exception {

        String SQL = "update NhanVien set  hoTen = ?, ngVL = ?, gioiTinh=?,CMND=?, diaChi=?,soDT=?,userId=?,password=?,"
                + "loaiNV=? "
                + "where manv = ?";


        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);

        ) {
            ps.setString(10, NV.getMANV());
            ps.setString(1, NV.getHOTEN());
            ps.setDate(2, new java.sql.Date(NV.getNGVL().getTime()));
            ps.setString(3, NV.getGIOITINH());
            ps.setString(4, NV.getCMND());
            ps.setString(5, NV.getDIACHI());
            ps.setString(6, NV.getSODT());
            ps.setString(7, NV.getUSERID());
            ps.setString(8, NV.getPASSWORD());
            ps.setString(9, NV.getLOAINV());
            return ps.executeUpdate() > 0;
        }
    }

//       public boolean update2(NhanVien NV)  throws Exception {
//        String SQL = "update NhanVien set   diaChi=?, soDT=?, password=? where manv = ?";
//        
//        try(
//             Connection conn = Database.getConnection();
//             PreparedStatement ps = conn.prepareStatement(SQL);
//        
//            ){
//            ps.setString(4, NV.getMaNV());
//            ps.setString(1, NV.getDiaChi());
//            ps.setString(2, NV.getSoDT()); 
//            ps.setString(3, NV.getPassword()); 
//            ps.setString(7, NV.getUserID());
//            ps.setString(8, NV.getPassword());
//            ps.setString(9,NV.getLoaiNV());
//
//            return ps.executeUpdate() >0;
//        }        
//    }


    public boolean update2(NhanVien NV) {
        String SQL = "update NhanVien set   diaChi=?, soDT=?, password=? where manv = ?";

        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);

        ) {
            ps.setString(4, NV.getMANV());
            ps.setString(1, NV.getDIACHI());
            ps.setString(2, NV.getSODT());
            ps.setString(3, NV.getPASSWORD());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


    public boolean delete(String MaNV) throws Exception {
        String SQL = "delete from NHANVIEN where manv=?";
        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, MaNV);
            return ps.executeUpdate() > 0;
        }
    }

}

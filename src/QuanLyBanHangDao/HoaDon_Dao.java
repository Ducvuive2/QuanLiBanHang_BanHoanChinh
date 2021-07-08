/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import Database.Database;
import QuanLyBanHangModel.GioHang;
import QuanLyBanHangModel.HoaDon;
import QuanLyBanHangModel.KhachHang;
import QuanLyBanHangModel.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nguyen Linh
 */
public class HoaDon_Dao {
    public boolean insert(HoaDon hd) throws Exception {
        String SQL = "insert into HoaDon(soHD, NGHD, MAKH, MANV,TRIGIA ) values(?,?,?,?,?)";

        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);

        ) {
            ps.setInt(1, hd.getSOHD());
            ps.setDate(2, (Date) hd.getNGHD());
            ps.setString(3, hd.getMAKH());
            ps.setString(4, hd.getMANV());
            ps.setLong(5, hd.getTRIGIA());
            return ps.executeUpdate() > 0;
        }
    }

    public HoaDon find(int SOHD) throws Exception {
        String SQL = "select * from HoaDon where SOHD =?";


        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        try {
            ps.setInt(1, SOHD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMANV(rs.getString("manv"));
                hd.setSOHD(rs.getInt("sohd"));
                hd.setNGHD(rs.getDate("NGHD"));
                hd.setMAKH(rs.getString("MAKH"));
                hd.setTRIGIA(rs.getInt("TRIGIA"));
                return hd;
            }


        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(HoaDon hd) throws Exception {
        String SQL = "update HoaDon set  NGHD = ?, MAKH = ?, MANV=?,TRIGIA=? where SOHD = ?";

        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);

        ) {
            ps.setInt(5, hd.getSOHD());
            ps.setDate(1, (Date) hd.getNGHD());
            ps.setString(2, hd.getMAKH());
            ps.setString(3, hd.getMANV());
            ps.setLong(4, hd.getTRIGIA());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String SOHD) throws Exception {
        String SQL = "delete from HoaDon where SOHD=?";
        try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, SOHD);
            return ps.executeUpdate() > 0;
        }
    }

    public static String muaHang(ArrayList<GioHang> list, KhachHang kh, NhanVien nv) {
        CallableStatement cstmt = null;
        Connection connection = null;
        Integer sohd = null;
        String SQL = " INSERT  HOADON (MAKH,MANV,NGHD,TRIGIA)VALUES (?,?,?,?)";
        try {

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, kh.getMAKH());
            ps.setString(2, nv.getMANV());
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            Integer trigia = list.stream()
                    .mapToInt(a -> (a.getSanpham().getGIA() * a.getSoluong()))
                    .sum();
            ps.setInt(4, trigia);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {

            cstmt = connection.prepareCall("{? =CALL getSOHD}");


            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeQuery();
            sohd = cstmt.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            String[] words1 = throwables.toString().split("ORA:");
            String StrTemp1 = words1[1];
            String[] words2 = StrTemp1.split("ORA");
            String StrTemp2 = words2[0];
            return StrTemp2;
        }

        SQL = " INSERT CTHD (SOHD, MASP, SL) VALUES (?,?,?)";
        try {
            for (GioHang gh : list) {
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);

                ps.setInt(1, sohd);
                ps.setString(2, gh.getSanpham().getMASP());
                ps.setInt(3, gh.getSoluong());
                ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "Thành công";

    }
}

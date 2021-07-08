
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import Database.Database;
import QuanLyBanHangModel.KhachHang;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author HP
 */
public class KhachHangDao {
    public static boolean  insert(KhachHang KH)  {
        String SQL = "insert into KhachHang(maKH, hoTen, DCHI, SODT, NGSINH, DOANHSO, NGDK) values(?,?,?,?,?,?,?)";

        try   {
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);


            ps.setString(1, KH.getMAKH());
            ps.setString(2, KH.getHOTEN());
            ps.setString(3, KH.getDCHI());
            ps.setString(4, KH.getSODT());
            ps.setDate(5, (Date) KH.getNGSINH());
            ps.setLong(6, (long) KH.getDOANHSO());
            ps.setDate(7, (Date) KH.getNGDK());

            return ps.executeUpdate() > 0;
        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
    }

    public static ArrayList<KhachHang> find(String MAKH) {
        String SQL = "select * from KHACHHANG where MAKH =?";
        ArrayList<KhachHang> list = new ArrayList<>();

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, MAKH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHang KH = new KhachHang();
                KH.setMAKH(rs.getString(1));
                KH.setHOTEN(rs.getString(2));
                KH.setNGSINH(rs.getDate(5));
                KH.setDCHI(rs.getString(3));
                KH.setSODT(rs.getString(4));
                KH.setDOANHSO(rs.getInt(6));
                KH.setNGDK(rs.getDate(7));
                list.add(KH);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static ArrayList<KhachHang> queryAll() {
        String SQL = "select * from KHACHHANG ";
        ArrayList<KhachHang> list = new ArrayList<>();

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHang KH = new KhachHang();
                KH.setMAKH(rs.getString(1));
                KH.setHOTEN(rs.getString(2));
                KH.setNGSINH(rs.getDate(5));
                KH.setDCHI(rs.getString(3));
                KH.setSODT(rs.getString(4));
                KH.setDOANHSO(rs.getInt(6));
                KH.setNGDK(rs.getDate(7));

                list.add(KH);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static boolean update(KhachHang KH)  {
        String SQL = "update KHACHHANG set  hoTen=?, DCHI=?, SODT=?, NGSINH=?, DOANHSO=?, NGDK=? where maKH = ?";

        try  {
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);


            ps.setString(7, KH.getMAKH());
            ps.setString(1, KH.getHOTEN());
            ps.setString(2, KH.getDCHI());
            ps.setString(3, KH.getSODT());
            ps.setDate(4, (Date) KH.getNGSINH());
            ps.setLong(5, KH.getDOANHSO());
            ps.setDate(6, (Date) KH.getNGDK());

            return ps.executeUpdate() > 0;


        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
    }

    public static String delete(String MaKH) {
        String SQL = "delete from KHACHHANG where MAKH=?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, MaKH);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            String[] mess = throwables.toString().split("ORA");
            String word = mess[1];
            String[] mess2 = word.split("ORA");
            return mess2[1];
        }
        return "Thành công";

    }
}


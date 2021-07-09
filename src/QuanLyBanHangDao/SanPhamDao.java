/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Database.Database;
import QuanLyBanHangModel.SanPham;
import Util.MyConvert;

/**
 * @author Nguyen Linh
 */
public class SanPhamDao {
    public static boolean insert(SanPham SP) {
        String SQL = "insert into SANPHAM values(?,?,?,?,?)";

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);


            ps.setString(1, SP.getMASP());
            ps.setString(2, SP.getTENSP());
            ps.setString(3, SP.getDVT());
            ps.setString(4, SP.getNUOCSX());
            ps.setInt(5, SP.getGIA());

            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static ArrayList<SanPham> find(SanPham sp) {

        boolean preNode = false;
        ArrayList<SanPham> list = new ArrayList<>();
        String sqlQuery = " select * from SANPHAM where ";

        if (sp.getMASP() != null && !sp.getMASP().isEmpty()) {
            sqlQuery += "MASP LIKE ('%'||'" + sp.getMASP() + "'||'%') ";
            preNode = true;
        }
        if (sp.getTENSP() != null && !sp.getTENSP().isEmpty()) {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " TENSP LIKE ('%'||'" + sp.getTENSP() + "'||'%') ";
            preNode = true;
        }

        if (sp.getDVT() != null && !sp.getDVT().equals("Lựa chọn")) {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " DVT LIKE ('%'||'" + sp.getDVT() + "'||'%') ";
            preNode = true;
        }
        if (sp.getNUOCSX() != null && !sp.getNUOCSX().equals("Lựa chọn")) {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " NUOCSX LIKE ('%'||'" + sp.getNUOCSX() + "'||'%') ";
            preNode = true;
        }

        if (sp.getGIA() != null&&sp.getGIA()!=Integer.MIN_VALUE) {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " GIA = " + MyConvert.parseIntToString(sp.getGIA()) + "  ";
            preNode = true;
        }


        sqlQuery += " ORDER BY MASP";

        try {
            PreparedStatement preparedStatementShow = Database.getConnection().prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();
            while (rs.next()) {

                SanPham SP = new SanPham();
                SP.setMASP(rs.getString("MASP"));
                SP.setTENSP(rs.getString("TENSP"));
                SP.setDVT(rs.getString("DVT"));
                SP.setNUOCSX(rs.getString("NuocSX"));
                SP.setGIA(rs.getInt("Gia"));

                list.add(SP);

            }
        } catch (SQLException e) {
        }
        System.out.println("ketuqa:"+list.toString());


        return list;

    }

    public static ArrayList<SanPham> queryBySP(SanPham sp) {

        boolean preNode = false;
        ArrayList<SanPham> list = new ArrayList<>();
        String sqlQuery =
                "SELECT * from SANPHAM " +
                        "where ";

        if (sp.getMASP() != null&&!sp.getMASP().isEmpty()) {
            sqlQuery += " MASP LIKE ('%'||'" + String.valueOf(sp.getMASP()) + "'||'%') ";
            preNode = true;
        }
        if (sp.getTENSP() != null && !sp.getTENSP().isEmpty()) {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " TENSP LIKE ('%'||'" + sp.getTENSP() + "'||'%') ";
            preNode = true;
        }
        if (!sp.getDVT().equals("Lựa chọn"))
        {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " DVT LIKE ('%'||'" + sp.getDVT() + "'||'%') ";
            preNode = true;
        }
        if (!sp.getNUOCSX().equals("Lựa chọn"))
        {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += " NUOCSX LIKE ('%'||'" + sp.getDVT() + "'||'%') ";
            preNode = true;
        }
        if (sp.getGIA() != null&& sp.getGIA()!=Integer.MIN_VALUE) {
            if (preNode == true) sqlQuery += " AND ";
            sqlQuery += "GIA = " + String.valueOf(sp.getMASP()) + "  ";
            preNode = true;
        }

        sqlQuery += " ORDER BY MASP";

        try {
            PreparedStatement preparedStatementShow = Database.getConnection().prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMASP(rs.getString("MASP"));
                SP.setTENSP(rs.getString("TENSP"));
                SP.setDVT(rs.getString("DVT"));
                SP.setNUOCSX(rs.getString("NuocSX"));
                SP.setGIA(rs.getInt("Gia"));
                list.add(SP);
            }
        } catch (SQLException e) {
        }
        System.out.println("ketqua:"+ list.toString());


        return list;
    }

    public static ArrayList<SanPham> queryAllSanPhamByLoai(String loai) {
        String SQL = "select * from SANPHAM  ";
        ArrayList<SanPham> list = new ArrayList<>();

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMASP(rs.getString("MASP"));
                SP.setTENSP(rs.getString("TENSP"));
                SP.setDVT(rs.getString("DVT"));
                SP.setNUOCSX(rs.getString("NuocSX"));
                SP.setGIA(rs.getInt("Gia"));
                String[] words = SP.getTENSP().split("\\s");
                String StrTemp = words[0];

                if (StrTemp.equals(loai)) {
                    list.add(SP);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    public static ArrayList<SanPham> queryAllSanPham() {
        String SQL = "select * from SANPHAM order by masp";
        ArrayList<SanPham> list = new ArrayList<>();

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMASP(rs.getString("MASP"));
                SP.setTENSP(rs.getString("TENSP"));
                SP.setDVT(rs.getString("DVT"));
                SP.setNUOCSX(rs.getString("NuocSX"));
                SP.setGIA(rs.getInt("Gia"));
                list.add(SP);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static HashMap<SanPham, Integer> querySPtheoNgay(Date startDate, Date endDate) {
        String SQL = "select SANPHAM.MASP, TENSP, DVT, NUOCSX, GIA, SUM(CTHD.SL) SOLUONG " +
                "from SANPHAM JOIN CTHD ON SANPHAM.MASP=CTHD.MASP JOIN HOADON ON HOADON.SOHD=CTHD.SOHD " +
                "where TO_DATE(NGHD,'dd/MM/yyyy')>=TO_DATE(?,'dd/MM/yyyy') AND TO_DATE(NGHD,'dd/MM/yyyy')<=TO_DATE(?,'dd/MM/yyyy') " +
                "GROUP BY SANPHAM.MASP, TENSP, DVT, NUOCSX, GIA " +
                "ORDER By SOLUONG";


        HashMap<SanPham, Integer> mapSP = new HashMap<>();

        Connection conn = Database.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMASP(rs.getString("MASP"));
                SP.setTENSP(rs.getString("TENSP"));
                SP.setDVT(rs.getString("DVT"));
                SP.setNUOCSX(rs.getString("NuocSX"));
                SP.setGIA(rs.getInt("Gia"));
                mapSP.put(SP, rs.getInt("SOLUONG"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return mapSP;

    }

    public static HashMap<SanPham, Integer> querySPtheoNgayvaLoai(Date startDate, Date endDate, String loai) {
        String SQL = "select SANPHAM.MASP, TENSP, DVT, NUOCSX, GIA, SUM(CTHD.SL) SOLUONG " +
                "from SANPHAM JOIN CTHD ON SANPHAM.MASP=CTHD.MASP JOIN HOADON ON HOADON.SOHD=CTHD.SOHD " +
                "where TO_DATE(NGHD,'dd/MM/yyyy')>=TO_DATE(?,'dd/MM/yyyy') AND TO_DATE(NGHD,'dd/MM/yyyy')<=TO_DATE(?,'dd/MM/yyyy') " +
                "GROUP BY SANPHAM.MASP, TENSP, DVT, NUOCSX, GIA ";

        HashMap<SanPham, Integer> mapSP = new HashMap<>();
        Connection conn = Database.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMASP(rs.getString("MASP"));
                SP.setTENSP(rs.getString("TENSP"));
                SP.setDVT(rs.getString("DVT"));
                SP.setNUOCSX(rs.getString("NuocSX"));
                SP.setGIA(rs.getInt("Gia"));

                String[] words = SP.getTENSP().split("\\s");
                String StrTemp = words[0];

                if (StrTemp.equals(loai)) {
                    mapSP.put(SP, rs.getInt("SOLUONG"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return mapSP;

    }

    public static boolean update(SanPham SP) {
        String SQL = "update SanPham set TENSP =?, DVT=?, NUOCSX=?, GIA=? WHERE MASP =?";

        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);


            ps.setString(1, SP.getTENSP());
            ps.setString(2, SP.getDVT());
            ps.setString(3, SP.getNUOCSX());
            ps.setLong(4, SP.getGIA());
            ps.setString(5, SP.getMASP());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static String delete(SanPham sanPham) {
        String SQL = "delete from SANPHAM where masp=?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, sanPham.getMASP());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if (throwables.toString().contains("ORA-02292")) return "Không thể xoá vì có dữ liệu khác đang liên kết \n (Ràng buộc khoá ngoại)";
        }
        return "Thành công";

    }
}

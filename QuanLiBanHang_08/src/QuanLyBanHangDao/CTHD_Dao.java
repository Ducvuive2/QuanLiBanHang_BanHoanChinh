/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangDao;

import QuanLyBanHangHelper.OracleJDBCConnection;
import QuanLyBanHangModel.CTHD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class CTHD_Dao {
    public boolean insert(CTHD cthd)  throws Exception {
        String SQL = "insert into CTHD(maSP,soHD,SL ) values(?,?,?)";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, cthd.getMaSP());
            ps.setInt(2, cthd.getSoHD());
            ps.setInt(3, cthd.getSL());
            return ps.executeUpdate() >0;
        }        
    }
    
      public  ArrayList<CTHD> find(int soHD) throws Exception {
          ArrayList<CTHD> cthds = new ArrayList<CTHD>();
          String SQL = "select * from CTHD where sohd= ?";
          Connection conn = OracleJDBCConnection.getJDBCConnection();
          PreparedStatement ps = conn.prepareStatement(SQL);
        try{
          System.out.println(soHD);      
          ps.setInt(1,soHD);
          ResultSet rs = ps.executeQuery();
         if(rs.next()){
           CTHD cthd = new CTHD();
            System.out.println(rs.getString("masp"));
            cthd.setMaSP(rs.getString("masp"));
            cthd.setSoHD(rs.getInt("sohd"));
            cthd.setSL(rs.getInt("sl"));
            cthds.add(cthd);
            System.out.println("QuanLyBanHangDao.CTHD_Dao.find()"+cthds.size());
            //return cthd;    
       }
            System.out.println("QuanLyBanHangDao dfsfsdffas"+ cthds.size());
        return cthds;
        }catch(Exception e){
             //JOptionPane.showMessageDialog(  e.getMessage());
             //e.printStackTrace();
             //System.out.println("QuanLyBanHang.QuanLyHoaDon.list_CTHDMouseClicked()");
        }
        return null;
    }
    public boolean update(CTHD NV)  throws Exception {
        String SQL = "update CTHD set SL =?,masp=? where sohd = ?";
        
        try(
             Connection conn = OracleJDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){

             ps.setInt(3, NV.getSoHD());
             ps.setString(2,NV.getMaSP());
             ps.setInt(1,NV.getSL());
             return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaNV) throws Exception {
        String SQL = "delete from CTHD where Masp=?,sohd=?";
    try(   
        Connection conn = OracleJDBCConnection.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaNV);
       return ps.executeUpdate() >0;
        }
    }

}

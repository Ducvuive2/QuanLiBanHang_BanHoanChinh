/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangModel;

import java.util.Date;

/**
 *
 * @author PC
 */
public class HoaDon {
     private int soHD;
     private Date NGHD;
     private String maKH,maNV;
     private long triGia;

    public HoaDon() {
    }

    public HoaDon(int soHD, Date NGHD, String maKH, String maNV, long triGia) {
        this.soHD = soHD;
        this.NGHD = NGHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.triGia = triGia;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public Date getNGHD() {
        return NGHD;
    }

    public void setNGHD(Date NGHD) {
        this.NGHD = NGHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public long getTriGia() {
        return triGia;
    }

    public void setTriGia(long triGia) {
        this.triGia = triGia;
    }
     
     
}

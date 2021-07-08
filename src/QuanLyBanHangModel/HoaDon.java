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
     private Integer SOHD;
     private Date NGHD;
     private String MAKH,MANV;
     private Integer TRIGIA;

    public HoaDon() {
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "SOHD=" + SOHD +
                ", NGHD=" + NGHD +
                ", MAKH='" + MAKH + '\'' +
                ", MANV='" + MANV + '\'' +
                ", TRIGIA=" + TRIGIA +
                '}';
    }

    public HoaDon(Integer SOHD, Date NGHD, String MAKH, String MANV, Integer TRIGIA) {
        this.SOHD = SOHD;
        this.NGHD = NGHD;
        this.MAKH = MAKH;
        this.MANV = MANV;
        this.TRIGIA = TRIGIA;
    }

    public Integer getSOHD() {
        return SOHD;
    }

    public void setSOHD(Integer SOHD) {
        this.SOHD = SOHD;
    }

    public Date getNGHD() {
        return NGHD;
    }

    public void setNGHD(Date NGHD) {
        this.NGHD = NGHD;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public Integer getTRIGIA() {
        return TRIGIA;
    }

    public void setTRIGIA(Integer TRIGIA) {
        this.TRIGIA = TRIGIA;
    }
     
     
}

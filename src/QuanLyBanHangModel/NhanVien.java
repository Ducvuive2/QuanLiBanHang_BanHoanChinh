/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangModel;

import java.util.Date;

/**
 *
 * @author Nguyen Linh
 */
public class NhanVien {
    private String MANV, HOTEN, GIOITINH, CMND, DIACHI, SODT, PASSWORD,USERID,LOAINV;
    private Date NGVL;

    public NhanVien() {
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "MANV='" + MANV + '\'' +
                ", HOTEN='" + HOTEN + '\'' +
                ", GIOITINH='" + GIOITINH + '\'' +
                ", CMND='" + CMND + '\'' +
                ", DIACHI='" + DIACHI + '\'' +
                ", SODT='" + SODT + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", USERID='" + USERID + '\'' +
                ", LOAINV='" + LOAINV + '\'' +
                ", NGVL=" + NGVL +
                '}';
    }

    public NhanVien(String MANV, String HOTEN, String GIOITINH, String CMND, String DIACHI, String SODT, String PASSWORD, String USERID, String LOAINV, Date NGVL) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.GIOITINH = GIOITINH;
        this.CMND = CMND;
        this.DIACHI = DIACHI;
        this.SODT = SODT;
        this.PASSWORD = PASSWORD;
        this.USERID = USERID;
        this.LOAINV = LOAINV;
        this.NGVL = NGVL;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSODT() {
        return SODT;
    }

    public void setSODT(String SODT) {
        this.SODT = SODT;
    }

    public String getPASSWORD() {
        
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getLOAINV() {
        return LOAINV;
    }

    public void setLOAINV(String LOAINV) {
        this.LOAINV = LOAINV;
    }

    public Date getNGVL() {
        return NGVL;
    }

    public void setNGVL(Date NGVL) {
        this.NGVL = NGVL;
    }
    

}

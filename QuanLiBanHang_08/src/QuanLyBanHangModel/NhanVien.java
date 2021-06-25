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
    private String maNV, hoTen, gioiTinh, CMND, diaChi, soDT, password,userID,loaiNV;
    private Date ngVL;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String gioiTinh, String CMND, String diaChi, String soDT, String password, String userID, String loaiNV, Date ngVL) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.CMND = CMND;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.password = password;
        this.userID = userID;
        this.loaiNV = loaiNV;
        this.ngVL = ngVL;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getPassword() {
        
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }

    public Date getNgVL() {
        return ngVL;
    }

    public void setNgVL(Date ngVL) {
        this.ngVL = ngVL;
    }
    

}

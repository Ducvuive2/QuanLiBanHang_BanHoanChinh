/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangModel;

/**
 *
 * @author Nguyen Linh
 */
public class SanPham {
    String MaSP, TenSP, DVT, NuocSX;
    long gia;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String DVT, String NuocSX, long gia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DVT = DVT;
        this.NuocSX = NuocSX;
        this.gia = gia;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getNuocSX() {
        return NuocSX;
    }

    public void setNuocSX(String NuocSX) {
        this.NuocSX = NuocSX;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
    
}

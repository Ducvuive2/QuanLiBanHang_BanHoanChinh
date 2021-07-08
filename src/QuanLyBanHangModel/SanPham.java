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
    private String MASP, TENSP, DVT, NUOCSX;
    private Integer GIA;

    public SanPham() {
    }

    public SanPham(String MASP, String TENSP, String DVT, String NUOCSX, Integer GIA) {
        this.MASP = MASP;
        this.TENSP = TENSP;
        this.DVT = DVT;
        this.NUOCSX = NUOCSX;
        this.GIA = GIA;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "MASP='" + MASP + '\'' +
                ", TENSP='" + TENSP + '\'' +
                ", DVT='" + DVT + '\'' +
                ", NUOCSX='" + NUOCSX + '\'' +
                ", GIA=" + GIA +
                '}';
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getNUOCSX() {
        return NUOCSX;
    }

    public void setNUOCSX(String NUOCSX) {
        this.NUOCSX = NUOCSX;
    }

    public Integer getGIA() {
        return GIA;
    }

    public void setGIA(Integer GIA) {
        this.GIA = GIA;
    }
    
}

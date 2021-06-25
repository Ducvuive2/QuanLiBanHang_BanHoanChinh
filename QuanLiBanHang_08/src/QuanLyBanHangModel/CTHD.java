/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangModel;


/**
 *
 * @author PC
 */
public class CTHD {
    private String maSP;
    private int soHD,SL;

    public CTHD() {
    }

    public CTHD(String maSP, int soHD, int SL) {
        this.maSP = maSP;
        this.soHD = soHD;
        this.SL = SL;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }
    
    
    
}

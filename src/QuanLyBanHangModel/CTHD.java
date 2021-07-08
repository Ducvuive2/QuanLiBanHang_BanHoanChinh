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
    private String MASP;
    private Integer SOHD,SL;

    public CTHD() {
    }

    @Override
    public String toString() {
        return "CTHD{" +
                "MASP='" + MASP + '\'' +
                ", SOHD=" + SOHD +
                ", SL=" + SL +
                '}';
    }

    public CTHD(String MASP, Integer SOHD, Integer SL) {
        this.MASP = MASP;
        this.SOHD = SOHD;
        this.SL = SL;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public Integer getSOHD() {
        return SOHD;
    }

    public void setSOHD(Integer SOHD) {
        this.SOHD = SOHD;
    }

    public Integer getSL() {
        return SL;
    }

    public void setSL(Integer SL) {
        this.SL = SL;
    }
    
    
    
}

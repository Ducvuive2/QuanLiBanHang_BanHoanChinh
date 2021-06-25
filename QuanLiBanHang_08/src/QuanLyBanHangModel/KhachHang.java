/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHangModel;

import java.util.Date;
//import java.sql.Date;




/**
 *
 * @author HP
 */
public class KhachHang {
    String MAKH,HOTEN,DCHI,SODT;
    long DOANHSO;
   
    Date NGSINH,NGDK;

    public KhachHang() {
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getDCHI() {
        return DCHI;
    }

    public void setDCHI(String DCHI) {
        this.DCHI = DCHI;
    }

    public String getSODT() {
        return SODT;
    }

    public void setSODT(String SODT) {
        this.SODT = SODT;
    }

    public long getDOANHSO() {
        return DOANHSO;
    }

    public void setDOANHSO(long DOANHSO) {
        this.DOANHSO = DOANHSO;
    }

    public Date getNGSINH() {
        return NGSINH;
    }

    public void setNGSINH(Date NGSINH) {
        this.NGSINH = NGSINH;
    }

    public Date getNGDK() {
        return NGDK;
    }

    public void setNGDK(Date NGDK) {
        this.NGDK = NGDK;
    }
    
    
    
}

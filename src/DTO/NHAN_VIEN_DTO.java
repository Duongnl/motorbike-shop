/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class NHAN_VIEN_DTO {
    private String MA_NV, USERNAME, PASS, HO_TEN, GIOI_TINH, DIA_CHI, CHUC_VU, GMAIL, GHI_CHU, NGAY_NGHI;
    private int SDT, TRANG_THAI;

    public NHAN_VIEN_DTO() {
//        MA_NV = null;
//	USERNAME = null;
//	PASS = "123456";
//	HO_TEN = null;
//	DIA_CHI = null;
//	CHUC_VU = null;
//	SDT = 0;
//	GMAIL = null;
//	GHI_CHU = null;
//	TRANG_THAI = 0;
//	NGAY_NGHI = null;
    }

    public NHAN_VIEN_DTO(String mA_NV, String uSERNAME, String pASS, String hO_TEN, String gIOI_TINH, String dIA_CHI, String cHUC_VU, String gMAIL, String gHI_CHU, String nGAY_NGHI, int sDT, int tRANG_THAI) {
        this.MA_NV = mA_NV;
        this.USERNAME = uSERNAME;
        this.PASS = pASS;
        this.HO_TEN = hO_TEN;
        this.GIOI_TINH = gIOI_TINH;
        this.DIA_CHI = dIA_CHI;
        this.CHUC_VU = cHUC_VU;
        this.GMAIL = gMAIL;
        this.GHI_CHU = gHI_CHU;
        this.NGAY_NGHI = nGAY_NGHI;
        this.SDT = sDT;
        this.TRANG_THAI = tRANG_THAI;
    }

    public String getMA_NV() {
        return MA_NV;
    }

    public void setMA_NV(String mA_NV) {
        this.MA_NV = mA_NV;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String uSERNAME) {
        this.USERNAME = uSERNAME;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String pASS) {
        this.PASS = pASS;
    }

    public String getHO_TEN() {
        return HO_TEN;
    }

    public void setHO_TEN(String hO_TEN) {
        this.HO_TEN = hO_TEN;
    }

    public String getGIOI_TINH() {
        return GIOI_TINH;
    }
    
    public void setGIOI_TINH(String gIOI_TINH) {
        this.GIOI_TINH = gIOI_TINH;
    }
    
    public String getDIA_CHI() {
        return DIA_CHI;
    }

    public void setDIA_CHI(String dIA_CHI) {
        this.DIA_CHI = dIA_CHI;
    }

    public String getCHUC_VU() {
        return CHUC_VU;
    }

    public void setCHUC_VU(String cHUC_VU) {
        this.CHUC_VU = cHUC_VU;
    }

    public String getGMAIL() {
        return GMAIL;
    }

    public void setGMAIL(String gMAIL) {
        this.GMAIL = gMAIL;
    }

    public String getGHI_CHU() {
        return GHI_CHU;
    }

    public void setGHI_CHU(String gHI_CHU) {
        this.GHI_CHU = gHI_CHU;
    }

    public String getNGAY_NGHI() {
        return NGAY_NGHI;
    }

    public void setNGAY_NGHI(String nGAY_NGHI) {
        this.NGAY_NGHI = nGAY_NGHI;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int sDT) {
        this.SDT = sDT;
    }

    public int getTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(int tRANG_THAI) {
        this.TRANG_THAI = tRANG_THAI;
    }
    
    
}

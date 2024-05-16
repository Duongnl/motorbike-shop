package DTO;

public class XE_MAY_DTO {
    
    private String MA_XE;
    private String TEN_XE;
    private long GIA;
    private String MA_LOAI;
    private String MA_MAU;
    private String MA_HANG;
    private String SO_KHUNG;
    private String DUNG_TICH;
    private int TON_KHO;
    private int TRANG_THAI;
    private String THOI_GIAN_BH;
    
    private String TEN_LOAI_XE;
    private String TEN_HANG;
    private String TEN_MAU;
    private long TONG_TIEN;
    private long GIA_NHAP;

    
    

    public XE_MAY_DTO() {
        MA_XE = null;
        TEN_XE = null;
        GIA = 0;
        MA_LOAI = null;
        MA_MAU = null;
        MA_HANG = null;
        SO_KHUNG = null;
        DUNG_TICH = null;
        TON_KHO = 0;
        TRANG_THAI = 0;
        THOI_GIAN_BH = null;
        TEN_LOAI_XE = null;
        TEN_HANG = null;
        TEN_MAU = null;
        TONG_TIEN = 0;
        GIA_NHAP= 0;
        
    }
    
    
    public long getGIA_NHAP() {
        return GIA_NHAP;
    }


    public void setGIA_NHAP(long gIA_NHAP) {
        GIA_NHAP = gIA_NHAP;
    }


    public XE_MAY_DTO(String mA_XE, String tEN_XE, int gIA, String mA_LOAI, String mA_MAU, String mA_HANG,
            String sO_KHUNG, String dUNG_TICH, int tON_KHO, int tRANG_THAI, String tHOI_GIAN_BH ,  String tEN_LOAI_XE, String tEN_HANG, String tEN_MAU, long tONG_TIEN, long gIA_NHAP) {
        MA_XE = mA_XE;
        TEN_XE = tEN_XE;
        GIA = gIA;
        MA_LOAI = mA_LOAI;
        MA_MAU = mA_MAU;
        MA_HANG = mA_HANG;
        SO_KHUNG = sO_KHUNG;
        DUNG_TICH = dUNG_TICH;
        TON_KHO = tON_KHO;
        TRANG_THAI = tRANG_THAI;
        THOI_GIAN_BH = tHOI_GIAN_BH;
        TEN_LOAI_XE = tEN_LOAI_XE;
        TEN_HANG = tEN_HANG;
        TEN_MAU = tEN_MAU;
        TONG_TIEN = tONG_TIEN;
        GIA_NHAP = gIA_NHAP;
    }


    public String getTEN_LOAI_XE() {
        return TEN_LOAI_XE;
    }


    public void setTEN_LOAI_XE(String tEN_LOAI_XE) {
        TEN_LOAI_XE = tEN_LOAI_XE;
    }


    public String getTEN_HANG() {
        return TEN_HANG;
    }


    public void setTEN_HANG(String tEN_HANG) {
        TEN_HANG = tEN_HANG;
    }


    public String getTEN_MAU() {
        return TEN_MAU;
    }


    public void setTEN_MAU(String tEN_MAU) {
        TEN_MAU = tEN_MAU;
    }


    public String getMA_XE() {
        return MA_XE;
    }


    public void setMA_XE(String mA_XE) {
        MA_XE = mA_XE;
    }


    public String getTEN_XE() {
        return TEN_XE;
    }


    public void setTEN_XE(String tEN_XE) {
        TEN_XE = tEN_XE;
    }


    public long getGIA() {
        return GIA;
    }


    public void setGIA(long gIA) {
        GIA = gIA;
    }


    public String getMA_LOAI() {
        return MA_LOAI;
    }


    public void setMA_LOAI(String mA_LOAI) {
        MA_LOAI = mA_LOAI;
    }


    public String getMA_MAU() {
        return MA_MAU;
    }


    public void setMA_MAU(String mA_MAU) {
        MA_MAU = mA_MAU;
    }


    public String getMA_HANG() {
        return MA_HANG;
    }


    public void setMA_HANG(String mA_HANG) {
        MA_HANG = mA_HANG;
    }


    public String getSO_KHUNG() {
        return SO_KHUNG;
    }


    public void setSO_KHUNG(String sO_KHUNG) {
        SO_KHUNG = sO_KHUNG;
    }


    public String getDUNG_TICH() {
        return DUNG_TICH;
    }


    public void setDUNG_TICH(String dUNG_TICH) {
        DUNG_TICH = dUNG_TICH;
    }


    public int getTON_KHO() {
        return TON_KHO;
    }


    public void setTON_KHO(int tON_KHO) {
        TON_KHO = tON_KHO;
    }


    public int getTRANG_THAI() {
        return TRANG_THAI;
    }


    public void setTRANG_THAI(int tRANG_THAI) {
        TRANG_THAI = tRANG_THAI;
    }


    public String getTHOI_GIAN_BH() {
        return THOI_GIAN_BH;
    }


    public void setTHOI_GIAN_BH(String tHOI_GIAN_BH) {
        THOI_GIAN_BH = tHOI_GIAN_BH;
    }


    public long getTONG_TIEN() {
        return TONG_TIEN;
    }


    public void setTONG_TIEN(long tONG_TIEN) {
        TONG_TIEN = tONG_TIEN;
    }

    
    @Override
    public String toString() {
        return MA_XE +"-"+TEN_XE;
    }

    



}

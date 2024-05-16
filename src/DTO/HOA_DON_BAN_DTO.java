package DTO;

public class HOA_DON_BAN_DTO {
    private String MA_HDB;
    private String MA_KH;
    private String MA_NV;
    private String NGAY_LAP;
    private long THANH_TOAN;

    private String TEN_KH;
    private String TEN_NV;
    private String DIA_CHI;
    
    
    public HOA_DON_BAN_DTO() {
        MA_HDB = null;
        MA_KH = null;
        MA_NV = null;
        NGAY_LAP = null;
        THANH_TOAN = 0;
        TEN_KH = null;
        TEN_NV = null;
        DIA_CHI = null;
        }
    
    
    public HOA_DON_BAN_DTO(String mA_HDB, String mA_KH, String mA_NV, String nGAY_LAP, long tHANH_TOAN, String tEN_KH,
            String tEN_NV, String dIA_CHI) {
        MA_HDB = mA_HDB;
        MA_KH = mA_KH;
        MA_NV = mA_NV;
        NGAY_LAP = nGAY_LAP;
        THANH_TOAN = tHANH_TOAN;
        TEN_KH = tEN_KH;
        TEN_NV = tEN_NV;
        DIA_CHI = dIA_CHI;
    }


    public String getMA_HDB() {
        return MA_HDB;
    }


    public void setMA_HDB(String mA_HDB) {
        MA_HDB = mA_HDB;
    }


    public String getMA_KH() {
        return MA_KH;
    }


    public void setMA_KH(String mA_KH) {
        MA_KH = mA_KH;
    }


    public String getMA_NV() {
        return MA_NV;
    }


    public void setMA_NV(String mA_NV) {
        MA_NV = mA_NV;
    }


    public String getNGAY_LAP() {
        return NGAY_LAP;
    }


    public void setNGAY_LAP(String nGAY_LAP) {
        NGAY_LAP = nGAY_LAP;
    }


    public long getTHANH_TOAN() {
        return THANH_TOAN;
    }


    public void setTHANH_TOAN(long tHANH_TOAN) {
        THANH_TOAN = tHANH_TOAN;
    }


    public String getTEN_KH() {
        return TEN_KH;
    }


    public void setTEN_KH(String tEN_KH) {
        TEN_KH = tEN_KH;
    }


    public String getTEN_NV() {
        return TEN_NV;
    }


    public void setTEN_NV(String tEN_NV) {
        TEN_NV = tEN_NV;
    }


    public String getDIA_CHI() {
        return DIA_CHI;
    }


    public void setDIA_CHI(String dIA_CHI) {
        DIA_CHI = dIA_CHI;
    }

    

    
    
    



}

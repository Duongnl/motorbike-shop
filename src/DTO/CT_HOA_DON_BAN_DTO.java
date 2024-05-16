package DTO;

public class CT_HOA_DON_BAN_DTO {
    private String MA_CTHDB;
    private String MA_HDB;
    private String MA_XE;
    private long GIA;
    private int SO_LUONG;

    private String TEN_XE;
    private long GIA_NHAP;
    private String NGAY_LAP;
    private String THANG_NAM;
    

    public CT_HOA_DON_BAN_DTO() {
        MA_CTHDB = null;
        MA_HDB = null;
        MA_XE = null;
        GIA = 0;
        SO_LUONG = 0;
        TEN_XE = null;
        GIA_NHAP = 0;
        NGAY_LAP = null;
        THANG_NAM = null;
        }



    public CT_HOA_DON_BAN_DTO(String mA_CTHDB, String mA_HDB, String mA_XE, long gIA, int sO_LUONG, String tEN_XE,
            long gIA_NHAP, String nGAY_LAP, String tHANG_NAM) {
        MA_CTHDB = mA_CTHDB;
        MA_HDB = mA_HDB;
        MA_XE = mA_XE;
        GIA = gIA;
        SO_LUONG = sO_LUONG;
        TEN_XE = tEN_XE;
        GIA_NHAP = gIA_NHAP;
        THANG_NAM = tHANG_NAM;
    }



    public String getMA_CTHDB() {
        return MA_CTHDB;
    }



    public void setMA_CTHDB(String mA_CTHDB) {
        MA_CTHDB = mA_CTHDB;
    }



    public String getMA_HDB() {
        return MA_HDB;
    }



    public void setMA_HDB(String mA_HDB) {
        MA_HDB = mA_HDB;
    }



    public String getMA_XE() {
        return MA_XE;
    }



    public void setMA_XE(String mA_XE) {
        MA_XE = mA_XE;
    }



    public long getGIA() {
        return GIA;
    }



    public void setGIA(long gIA) {
        GIA = gIA;
    }



    public int getSO_LUONG() {
        return SO_LUONG;
    }



    public void setSO_LUONG(int sO_LUONG) {
        SO_LUONG = sO_LUONG;
    }



    public String getTEN_XE() {
        return TEN_XE;
    }



    public void setTEN_XE(String tEN_XE) {
        TEN_XE = tEN_XE;
    }



    public long getGIA_NHAP() {
        return GIA_NHAP;
    }



    public void setGIA_NHAP(long gIA_NHAP) {
        GIA_NHAP = gIA_NHAP;
    }



    public String getNGAY_LAP() {
        return NGAY_LAP;
    }



    public void setNGAY_LAP(String nGAY_LAP) {
        NGAY_LAP = nGAY_LAP;
    }



    public String getTHANG_NAM() {
        return THANG_NAM;
    }



    public void setTHANG_NAM(String tHANG_NAM) {
        THANG_NAM = tHANG_NAM;
    }

    

    

    
    
}

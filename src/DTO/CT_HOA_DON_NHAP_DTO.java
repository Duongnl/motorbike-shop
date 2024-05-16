package DTO;

public class CT_HOA_DON_NHAP_DTO 
{ 
    private String MA_CTHDN ;
    private String MA_XE ;
    private String MA_HDN ;
    private long GIA ;
    private int SO_LUONG ;
    
    private String TEN_XE ;
    private long GIA_NHAP ;
    private String HANG_XE ;
    
    

    public CT_HOA_DON_NHAP_DTO() {
        MA_CTHDN = null;
        MA_XE = null;
        MA_HDN = null;
        GIA = 0;
        SO_LUONG = 0;
        
        TEN_XE = null;
        GIA_NHAP = 0;
        HANG_XE = null;
    }

    public CT_HOA_DON_NHAP_DTO(String mA_CTHDN, String mA_XE, String mA_HDN, long gIA, int sO_LUONG, String tEN_XE,
            long gIA_NHAP, String hANG_XE) {
        MA_CTHDN = mA_CTHDN;
        MA_XE = mA_XE;
        MA_HDN = mA_HDN;
        GIA = gIA;
        SO_LUONG = sO_LUONG;
        TEN_XE = tEN_XE;
        GIA_NHAP = gIA_NHAP;
        HANG_XE = hANG_XE;
    }



    public String getMA_CTHDN() {
        return MA_CTHDN;
    }
    public void setMA_CTHDN(String mA_CTHDN) {
        MA_CTHDN = mA_CTHDN;
    }
    public String getMA_XE() {
        return MA_XE;
    }
    public void setMA_XE(String mA_XE) {
        MA_XE = mA_XE;
    }
    public String getMA_HDN() {
        return MA_HDN;
    }
    public void setMA_HDN(String mA_HDN) {
        MA_HDN = mA_HDN;
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

    public String getHANG_XE() {
        return HANG_XE;
    }

    public void setHANG_XE(String hANG_XE) {
        HANG_XE = hANG_XE;
    }

    



      



}

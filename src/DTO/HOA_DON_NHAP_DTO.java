package DTO;



public class HOA_DON_NHAP_DTO 
{
    private String MA_HDN;
    private String MA_NV;
    private String TEN_NV;
    private String NGAY_LAP;
    private long TONG_TIEN;

    private int SDT;

    public HOA_DON_NHAP_DTO() {
        MA_HDN = null;
        MA_NV = null;
        NGAY_LAP = null;
        TEN_NV = null;
        TONG_TIEN = 0;
        SDT = 0;
    }

    
    public HOA_DON_NHAP_DTO(String mA_HDN, String mA_NV, String nGAY_LAP, String tEN_NV, long tONG_TIEN, int sDT) {
        MA_HDN = mA_HDN;
        MA_NV = mA_NV;
        NGAY_LAP = nGAY_LAP;
        TEN_NV = tEN_NV;
        TONG_TIEN = tONG_TIEN;
        SDT = sDT;
        
    }


    public String getMA_HDN() {
        return MA_HDN;
    }
    public void setMA_HDN(String mA_HDN) {
        MA_HDN = mA_HDN;
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
    public String getTEN_NV() {
        return TEN_NV;
    }
    public void setTEN_NV(String tEN_NV) {
        TEN_NV = tEN_NV;
    }
    public long getTONG_TIEN() {
        return TONG_TIEN;
    }
    public void setTONG_TIEN(long tONG_TIEN) {
        TONG_TIEN = tONG_TIEN;
    }


    public int getSDT() {
        return SDT;
    }


    public void setSDT(int sDT) {
        SDT = sDT;
    }

    

    
    
    


}

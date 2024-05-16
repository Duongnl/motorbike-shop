package DTO;

public class HANG_XE_DTO {
  
    private String MA_HANG;
    private String TEN_HANG;
    private String MO_TA;
    
    public HANG_XE_DTO() {
        MA_HANG = null;
        TEN_HANG = null;
        MO_TA = null;
    }

    public HANG_XE_DTO(String mA_HANG, String tEN_HANG, String mO_TA) {
        MA_HANG = mA_HANG;
        TEN_HANG = tEN_HANG;
        MO_TA = mO_TA;
    }

    public String getMA_HANG() {
        return MA_HANG;
    }

    public void setMA_HANG(String mA_HANG) {
        MA_HANG = mA_HANG;
    }

    public String getTEN_HANG() {
        return TEN_HANG;
    }

    public void setTEN_HANG(String tEN_HANG) {
        TEN_HANG = tEN_HANG;
    }

    public String getMO_TA() {
        return MO_TA;
    }

    public void setMO_TA(String mO_TA) {
        MO_TA = mO_TA;
    }

    
    @Override
    public String toString() {
        return TEN_HANG;
    }
    
 



    
}

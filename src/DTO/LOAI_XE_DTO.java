package DTO;

public class LOAI_XE_DTO {
    private String MA_LOAI;
    private String TEN_LOAI_XE;
    private String MO_TA;
    
    public LOAI_XE_DTO() {
        MA_LOAI = null;
        TEN_LOAI_XE = null;
        MO_TA = null;
    }
    
    public LOAI_XE_DTO(String mA_LOAI, String tEN_LOAI_XE, String mO_TA) {
        MA_LOAI = mA_LOAI;
        TEN_LOAI_XE = tEN_LOAI_XE;
        MO_TA = mO_TA;
    }

    public String getMA_LOAI() {
        return MA_LOAI;
    }

    public void setMA_LOAI(String mA_LOAI) {
        MA_LOAI = mA_LOAI;
    }

    public String getTEN_LOAI_XE() {
        return TEN_LOAI_XE;
    }

    public void setTEN_LOAI_XE(String tEN_LOAI_XE) {
        TEN_LOAI_XE = tEN_LOAI_XE;
    }

    public String getMO_TA() {
        return MO_TA;
    }

    public void setMO_TA(String mO_TA) {
        MO_TA = mO_TA;
    }
    

    @Override
    public String toString() {
        return TEN_LOAI_XE;
    }

}

package DTO;

public class MAU_XE_DTO {
    private String MA_MAU;
    private String TEN_MAU;
    
    public MAU_XE_DTO() {
        MA_MAU = null;
        TEN_MAU = null;
    }
    
    public MAU_XE_DTO(String mA_MAU, String tEN_MAU) {
        MA_MAU = mA_MAU;
        TEN_MAU = tEN_MAU;
    }

    public String getMA_MAU() {
        return MA_MAU;
    }

    public void setMA_MAU(String mA_MAU) {
        MA_MAU = mA_MAU;
    }

    public String getTEN_MAU() {
        return TEN_MAU;
    }

    public void setTEN_MAU(String tEN_MAU) {
        TEN_MAU = tEN_MAU;
    }
    
    
    @Override
    public String toString() {
        return TEN_MAU;
    }



}

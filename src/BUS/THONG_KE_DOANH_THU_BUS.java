package BUS;

import java.util.ArrayList;

import DAO.THONG_KE_DOANH_THU_DAO;
import DTO.CT_HOA_DON_BAN_DTO;

public class THONG_KE_DOANH_THU_BUS 
{ 
    
    private THONG_KE_DOANH_THU_DAO xe_MAY_DAO = new THONG_KE_DOANH_THU_DAO();

    public ArrayList<CT_HOA_DON_BAN_DTO> getAllCTHDN_ThongKe(String ngayLap) {
        return xe_MAY_DAO.getAllCTHDN_ThongKeDoanhThu(ngayLap);
    } 


    
}

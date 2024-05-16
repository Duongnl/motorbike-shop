package BUS;

import java.util.ArrayList;

import DAO.THONG_KE_NHAP_DAO;
import DTO.CT_HOA_DON_NHAP_DTO;

public class THONG_KE_NHAP_BUS 
{
    private THONG_KE_NHAP_DAO xe_MAY_DAO = new THONG_KE_NHAP_DAO();

    public ArrayList<CT_HOA_DON_NHAP_DTO> getAllCTHDN_ThongKe(String ngayLap) {
        return xe_MAY_DAO.getAllCTHDN_ThongKe(ngayLap);
    } 
 

    
}

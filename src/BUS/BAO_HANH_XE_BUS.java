package BUS;
import java.util.ArrayList;
import DAO.*;
import DTO.*;
public class BAO_HANH_XE_BUS 
{
    BAO_HANH_XE_DAO bao_Hanh_Xe_DAO = new BAO_HANH_XE_DAO();

    public ArrayList<BAO_HANH_XE_DTO> getAllHangXe ()
    {
        return bao_Hanh_Xe_DAO.getAllBaoHanhXe();
    }
    
    
    
    public boolean editBaoHanhXe(BAO_HANH_XE_DTO bao_Hanh_Xe_DTO){
        return bao_Hanh_Xe_DAO.editBaoHanhXe(bao_Hanh_Xe_DTO);
    }
    
    public boolean addBaoHanhXe(BAO_HANH_XE_DTO hang_XE_DTO){
        return bao_Hanh_Xe_DAO.addBaoHanhXe(hang_XE_DTO);
   }
     public boolean deleteBaoHanhXe (String maBaoHanh)
    {
        
        return bao_Hanh_Xe_DAO.deleteHangXe(maBaoHanh);
    }
//    public boolean checkMaHang (String maHang)
//    {
//        if (bao_Hanh_Xe_DAO.checkMaHang(maHang))
//        {
//            return true;
//        }
//        return false;
//    }
//    public boolean checkTenHang (String tenHang)
//    {
//        if (hang_XE_DAO.checkTenHang(tenHang))
//        {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean addHangXe(HANG_XE_DTO hang_XE_DTO){
//        return hang_XE_DAO.addHangXe(hang_XE_DTO);
//   }
//
//   public boolean editHangXe (HANG_XE_DTO hang_XE_DTO)
//    {
//        return hang_XE_DAO.editHangXe(hang_XE_DTO);
//    }
//    
//    public boolean checkMaHangInXeMay (String maHang)
//    {
//        if (hang_XE_DAO.checkMaHangInXeMay(maHang))
//        {
//            return true;
//        }
//        return false;
//    }
//
//
//    public boolean updateHangXeMay (String maHang)
//    {
//        return hang_XE_DAO.updateHangXeMay(maHang);
//    }
//
//    public boolean deleteMauXe (String maHang)
//    {
//        
//        return hang_XE_DAO.deleteHangXe(maHang);
//    }
//    


}

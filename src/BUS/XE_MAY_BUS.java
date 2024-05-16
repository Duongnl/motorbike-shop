package BUS;
import java.util.ArrayList;

import DAO.*;
import DTO.XE_MAY_DTO; 
public class XE_MAY_BUS 
{
    private XE_MAY_DAO xe_MAY_DAO = new XE_MAY_DAO();

    public ArrayList<XE_MAY_DTO> getAllXeMay() {
        return xe_MAY_DAO.getAllXeMay();
    } 
 
    public boolean checkMaXe (String maXe)
    {
        if (xe_MAY_DAO.checkMaXe(maXe))
        {
            return true;
        }
        return false;
    }
    public boolean checkTenXe (String tenXe)
    {
        if (xe_MAY_DAO.checkTenXe(tenXe))
        {
            return true;
        }
        return false;
    } 
   
    public boolean themSoLuongXeMay (String maXe, int soLuong)
    {
       return xe_MAY_DAO.themSoLuongXeMay(maXe, soLuong);
    }

    public boolean capNhatSoLuongXeMay (String maXe, int tonKho)
    {
       return xe_MAY_DAO.capNhatSoLuongXeMay(maXe, tonKho);
    }

     
    public boolean addXeMay(XE_MAY_DTO xe_MAY_DTO){
        return xe_MAY_DAO.addXeMay(xe_MAY_DTO);
   }

   public boolean deleteXeMay (String maXe)
   {
     return xe_MAY_DAO.deleteXeMay(maXe);
   }

   public boolean editXeMay(XE_MAY_DTO xe_MAY_DTO){
    return xe_MAY_DAO.editXeMay(xe_MAY_DTO);
}


    public ArrayList<XE_MAY_DTO>  findXeMay(String find, String timTheo) {
        return xe_MAY_DAO.findXeMay(find, timTheo);
    } 
}

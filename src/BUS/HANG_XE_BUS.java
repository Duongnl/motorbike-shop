package BUS;
import java.util.ArrayList;
import DAO.*;
import DTO.*;
public class HANG_XE_BUS 
{
    HANG_XE_DAO hang_XE_DAO = new HANG_XE_DAO();

    public ArrayList<HANG_XE_DTO> getAllHangXe ()
    {
        return hang_XE_DAO.getAllHangXe();
    }
    
    public boolean checkMaHang (String maHang)
    {
        if (hang_XE_DAO.checkMaHang(maHang))
        {
            return true;
        }
        return false;
    }
    public boolean checkTenHang (String tenHang)
    {
        if (hang_XE_DAO.checkTenHang(tenHang))
        {
            return true;
        }
        return false;
    }

    public boolean addHangXe(HANG_XE_DTO hang_XE_DTO){
        return hang_XE_DAO.addHangXe(hang_XE_DTO);
   }

   public boolean editHangXe (HANG_XE_DTO hang_XE_DTO)
    {
        return hang_XE_DAO.editHangXe(hang_XE_DTO);
    }
    
    public boolean checkMaHangInXeMay (String maHang)
    {
        if (hang_XE_DAO.checkMaHangInXeMay(maHang))
        {
            return true;
        }
        return false;
    }


    public boolean updateHangXeMay (String maHang)
    {
        return hang_XE_DAO.updateHangXeMay(maHang);
    }

    public boolean deleteMauXe (String maHang)
    {
        
        return hang_XE_DAO.deleteHangXe(maHang);
    }
    


}

package BUS;
import java.util.ArrayList;
import DAO.*;
import DTO.*;
public class LOAI_XE_BUS 
{
    LOAI_XE_DAO loai_XE_DAO = new LOAI_XE_DAO();

    public ArrayList<LOAI_XE_DTO> getAllLoaiXe ()
    {
        return loai_XE_DAO.getAllLoaiXe();
    }
    
    public boolean checkMaLoai (String maLoai)
    {
        if (loai_XE_DAO.checkMaLoai(maLoai))
        {
            return true;
        }
        return false;
    }
    public boolean checkTenLoai (String tenLoai)
    {
        if (loai_XE_DAO.checkTenLoai(tenLoai))
        {
            return true;
        }
        return false;
    }

    public boolean addLoaiXe(LOAI_XE_DTO loai_XE_DTO){
        return loai_XE_DAO.addLoaiXe(loai_XE_DTO);
   }

   public boolean editLoaiXe (LOAI_XE_DTO loai_XE_DTO)
    {
        return loai_XE_DAO.editLoaiXe(loai_XE_DTO);
    }
    
    public boolean checkMaLoaiInXeMay (String maLoai)
    {
        if (loai_XE_DAO.checkMaLoaiInXeMay(maLoai))
        {
            return true;
        }
        return false;
    }


    public boolean updateLoaiXeMay (String maLoai)
    {
        return loai_XE_DAO.updateLoaiXeMay(maLoai);
    }

    public boolean deleteMauXe (String maLoai)
    {
        
        return loai_XE_DAO.deleteLoaiXe(maLoai);
    }


}

package BUS;
import java.util.ArrayList;

import DAO.*;
import DTO.*;
public class MAU_XE_BUS {
    MAU_XE_DAO mau_XE_DAO = new MAU_XE_DAO();

    public ArrayList<MAU_XE_DTO> getAllMauXe ()
    {
        return mau_XE_DAO.getAllMauXe();
    }

    public boolean checkMaMau (String maMau)
    {
        if (mau_XE_DAO.checkMaMau(maMau))
        {
            return true;
        }
        return false;
    }
    public boolean checkTenMau (String tenMau)
    {
        if (mau_XE_DAO.checkTenMau(tenMau))
        {
            return true;
        }
        return false;
    }

    public boolean checkMaMauInXeMay (String maMau)
    {
        if (mau_XE_DAO.checkMaMauInXeMay(maMau))
        {
            return true;
        }
        return false;
    }
   
    public boolean updateMauXeMay (String maMau)
    {
        return mau_XE_DAO.updateMauXeMay(maMau);
    }

    public boolean deleteMauXe (String maMau)
    {
        
        return mau_XE_DAO.deleteMauXe(maMau);
    }


    public boolean addMauXe(MAU_XE_DTO mau_XE_DTO){
         return mau_XE_DAO.addMauXe(mau_XE_DTO);
    }

    
    public boolean editMauXe (MAU_XE_DTO mau_XE_DTO)
    {
        return mau_XE_DAO.editMauXe(mau_XE_DTO);
    }




}
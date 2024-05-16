package BUS;

import java.util.ArrayList;

import DAO.HOA_DON_BAN_DAO;
import DTO.HOA_DON_BAN_DTO;
import DTO.KHACH_HANG_DTO;

public class HOA_DON_BAN_BUS {
    HOA_DON_BAN_DAO hoa_DON_BAN_DAO = new HOA_DON_BAN_DAO();

    public ArrayList<HOA_DON_BAN_DTO> getAllHDB ()
    {
        return hoa_DON_BAN_DAO.getAllHDB();
    }




    public ArrayList<KHACH_HANG_DTO> findKhachHang (String maKH)
    {
        return hoa_DON_BAN_DAO.findKhachHang(maKH);
    }
    
    public boolean checkMaHDB (String maHDB)
    {
        if (hoa_DON_BAN_DAO.checkMaHDB(maHDB))
        {
            return true;
        } 
        return false;
    }

    public boolean addHDB(HOA_DON_BAN_DTO hoa_DON_BAN_DTO){
        return hoa_DON_BAN_DAO.addHDB(hoa_DON_BAN_DTO);
   }

   public boolean deleteHDB( String maHDB){
    return hoa_DON_BAN_DAO.deleteHDB(maHDB);
  }


 
  public ArrayList<HOA_DON_BAN_DTO> findHDB (String find, String timTheo)
  {
    return hoa_DON_BAN_DAO.findHDB(find, timTheo);
  }

}

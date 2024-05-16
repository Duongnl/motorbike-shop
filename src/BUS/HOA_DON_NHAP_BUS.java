package BUS;
import java.util.ArrayList;
import DAO.*;
import DTO.*;
public class HOA_DON_NHAP_BUS {
    
    HOA_DON_NHAP_DAO hoa_DON_NHAP_DAO = new HOA_DON_NHAP_DAO();

    public ArrayList<HOA_DON_NHAP_DTO> getAllHDN ()
    {
        return hoa_DON_NHAP_DAO.getAllHDN();
    }

    public boolean checkMaHDN (String maHDN)
    {
        if (hoa_DON_NHAP_DAO.checkMaHDN(maHDN))
        {
          return true;
        } 
        return false;
    }

    public boolean addHDN(HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO){
        return hoa_DON_NHAP_DAO.addHDN(hoa_DON_NHAP_DTO);
   }

   public boolean deleteHDN( String maHDN){
    return hoa_DON_NHAP_DAO.deleteHDN(maHDN);
  }


  public ArrayList<HOA_DON_NHAP_DTO> findHDN (String find, String timTheo)
  {
    return hoa_DON_NHAP_DAO.findHDN(find, timTheo);
  }



}

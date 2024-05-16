package BUS;
import java.util.ArrayList;
import DAO.*;
import DTO.*;
public class CT_HOA_DON_NHAP_BUS {
    
    CT_HOA_DON_NHAP_DAO ct_HOA_DON_NHAP_DAO = new CT_HOA_DON_NHAP_DAO();
    public ArrayList<CT_HOA_DON_NHAP_DTO> getAllCTHDN (String maHDN)
    {
        return ct_HOA_DON_NHAP_DAO.getAllCTHDN(maHDN);
    }

    public ArrayList<CT_HOA_DON_NHAP_DTO> getAllCTHDNTen_HANG (String maHDN)
    {
        return ct_HOA_DON_NHAP_DAO.getAllCTHDNTen_Hang(maHDN);
    }
    public boolean checkMaCTHDN (String maCTHDN)
    {
        if (ct_HOA_DON_NHAP_DAO.checkMaCTHDN(maCTHDN))
        {
            return true;
        }
        return false;
    }

    public boolean addCTHDN(CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO){
        return ct_HOA_DON_NHAP_DAO.addCTHDN(ct_HOA_DON_NHAP_DTO);
   }

   public boolean deleteCTHDN( String maHDN){
    return ct_HOA_DON_NHAP_DAO.deleteCTHDN(maHDN);
  }





}

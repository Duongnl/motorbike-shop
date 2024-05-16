package BUS;

import DAO.DoiMatKhau_DAO;

public class DoiMatKhau_BUS {
     DoiMatKhau_DAO doiMatKhau_DAO = new DoiMatKhau_DAO();


    public boolean checkMK (String pass, String maNV)
    {
        if (doiMatKhau_DAO.checkMK(pass, maNV))
        {
            return true;
        }
        return false;
    }

    public boolean doiMK (String maNV, String mKMoi)
    {
        if (doiMatKhau_DAO.doiMK(maNV, mKMoi))
        {
            return true;
        }
        return false;
    }
    
}

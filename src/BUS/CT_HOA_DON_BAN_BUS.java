package BUS;
import java.util.ArrayList;
import DAO.*;
import DTO.*;
public class CT_HOA_DON_BAN_BUS {
    CT_HOA_DON_BAN_DAO ct_HOA_DON_BAN_DAO = new CT_HOA_DON_BAN_DAO();

     
    public ArrayList<CT_HOA_DON_BAN_DTO> getAllCTHDB(String maHDB){
        return ct_HOA_DON_BAN_DAO.getAllCTHDB(maHDB);
}



        public boolean checkMaCTHDB (String maCTHDB)
            {
                if (ct_HOA_DON_BAN_DAO.checkMaCTHDB(maCTHDB))
                {
                    return true;
                }
                return false;
            }

            public boolean addCTHDB(CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO){
                return ct_HOA_DON_BAN_DAO.addCTHDB(ct_HOA_DON_BAN_DTO);
        }

        public boolean deleteCTHDB( String maHDB){
            return ct_HOA_DON_BAN_DAO.deleteCTHDB(maHDB);
        }



}


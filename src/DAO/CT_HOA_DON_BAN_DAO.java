package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class CT_HOA_DON_BAN_DAO {
    Connection conn = null;
        private ResultSet Rs = null;
        private PreparedStatement Ps = null;


        public ArrayList<CT_HOA_DON_BAN_DTO> getAllCTHDB(String maHDB)
        {
            ArrayList<CT_HOA_DON_BAN_DTO> arr = new ArrayList<CT_HOA_DON_BAN_DTO>();
            conn = ConnectToSQL.openConnection(); 
                try {
                     Ps = conn.prepareStatement("SELECT CT_HOA_DON_BAN.MA_CTHDB, CT_HOA_DON_BAN.MA_HDB, CT_HOA_DON_BAN.MA_XE, XE_MAY.TEN_XE, CT_HOA_DON_BAN.GIA_BAN, CT_HOA_DON_BAN.SO_LUONG, CT_HOA_DON_BAN.GIA FROM CT_HOA_DON_BAN, XE_MAY WHERE CT_HOA_DON_BAN.MA_XE = XE_MAY.MA_XE AND CT_HOA_DON_BAN.MA_HDB = ?");
                     Ps.setString(1, maHDB);
                     Rs = Ps.executeQuery();
    
                    while (Rs.next()) {
                        CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO = new CT_HOA_DON_BAN_DTO();
                        ct_HOA_DON_BAN_DTO.setMA_CTHDB(Rs.getString("MA_CTHDB").trim());
                        ct_HOA_DON_BAN_DTO.setMA_HDB(Rs.getString("MA_HDB").trim());
                        ct_HOA_DON_BAN_DTO.setMA_XE(Rs.getString ("MA_XE"));
                        ct_HOA_DON_BAN_DTO.setTEN_XE(Rs.getString("TEN_XE").trim());
                        ct_HOA_DON_BAN_DTO.setGIA_NHAP(Rs.getLong("GIA_BAN"));
                        ct_HOA_DON_BAN_DTO.setSO_LUONG(Rs.getInt("SO_LUONG"));
                        ct_HOA_DON_BAN_DTO.setGIA(Rs.getLong("GIA"));
                        arr.add(ct_HOA_DON_BAN_DTO);
                    }
                    return arr;
                }
                catch (Exception err) {
                  err.printStackTrace();
                  return null;
                }
                finally{
                    ConnectToSQL.closeConnection(conn);
                }
        }
    


        public Boolean checkMaCTHDB (String maCTHDB)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               Ps = conn.prepareStatement("SELECT *  FROM CT_HOA_DON_BAN WHERE MA_CTHDB =?");
               Ps.setString(1, maCTHDB);
               Rs = Ps.executeQuery();
               flag = Rs.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean addCTHDB (CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("INSERT INTO CT_HOA_DON_BAN (MA_CTHDB,MA_HDB,MA_XE,SO_LUONG,GIA,GIA_BAN ) VALUES (?,?,?,?,?,?)");
               Ps.setString(1, ct_HOA_DON_BAN_DTO.getMA_CTHDB());
               Ps.setString(2, ct_HOA_DON_BAN_DTO.getMA_HDB());
               Ps.setString(3, ct_HOA_DON_BAN_DTO.getMA_XE());
               Ps.setInt(4, ct_HOA_DON_BAN_DTO.getSO_LUONG());
               Ps.setLong(5, ct_HOA_DON_BAN_DTO.getGIA());   
               Ps.setLong(6, ct_HOA_DON_BAN_DTO.getGIA_NHAP());   
               
               Ps.executeUpdate();
               return true;
            } catch (Exception e) {
               e.printStackTrace();
               return false;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean deleteCTHDB (String maHDB)
    {
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("DELETE FROM CT_HOA_DON_BAN WHERE MA_HDB = ?");
            Ps.setString(1,maHDB);
            if (Ps.executeUpdate() ==1 )
            {
                return true;
            }
            else 
            {
                return false;
            }
         
        } catch (Exception e) {
            e.printStackTrace();
            return false;
         }
         finally{
             ConnectToSQL.closeConnection(conn);
         }
    }

    
}

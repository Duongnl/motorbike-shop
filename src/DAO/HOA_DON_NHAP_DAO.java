package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class HOA_DON_NHAP_DAO {
    
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public HOA_DON_NHAP_DAO () 
    {
        
    }

    public ArrayList<HOA_DON_NHAP_DTO> getAllHDN()
    {
        ArrayList<HOA_DON_NHAP_DTO> arr = new ArrayList<HOA_DON_NHAP_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT HOA_DON_NHAP.MA_HDN, HOA_DON_NHAP.MA_NV, NHAN_VIEN.HO_TEN, HOA_DON_NHAP.NGAY_LAP, HOA_DON_NHAP.TONG_TIEN FROM HOA_DON_NHAP, NHAN_VIEN WHERE  HOA_DON_NHAP.MA_NV = NHAN_VIEN.MA_NV ");
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO = new HOA_DON_NHAP_DTO();
                    
                    hoa_DON_NHAP_DTO.setMA_HDN(Rs.getString("MA_HDN").trim());
                    hoa_DON_NHAP_DTO.setMA_NV(Rs.getString("MA_NV").trim());
                    hoa_DON_NHAP_DTO.setTEN_NV(Rs.getString ("HO_TEN"));
                    hoa_DON_NHAP_DTO.setNGAY_LAP(Rs.getString("NGAY_LAP").trim());
                    hoa_DON_NHAP_DTO.setTONG_TIEN(Rs.getLong("TONG_TIEN"));
                    arr.add(hoa_DON_NHAP_DTO);
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

    public Boolean checkMaHDN (String maHDN)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               Ps = conn.prepareStatement("SELECT *  FROM HOA_DON_NHAP WHERE MA_HDN =?");
               Ps.setString(1, maHDN);
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


    public Boolean addHDN (HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("INSERT INTO HOA_DON_NHAP (MA_HDN,MA_NV,NGAY_LAP,TONG_TIEN ) VALUES (?,?,?,?)");
               Ps.setString(1, hoa_DON_NHAP_DTO.getMA_HDN());
               Ps.setString(2, hoa_DON_NHAP_DTO.getMA_NV());
               Ps.setString(3, hoa_DON_NHAP_DTO.getNGAY_LAP());
               Ps.setLong(4, hoa_DON_NHAP_DTO.getTONG_TIEN());
               
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

    

    public Boolean deleteHDN (String maHDN)
    {
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("DELETE FROM HOA_DON_NHAP WHERE MA_HDN = ?");
            Ps.setString(1,maHDN);
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


  

    public ArrayList<HOA_DON_NHAP_DTO> findHDN (String find, String timTheo)
    {
        ArrayList<HOA_DON_NHAP_DTO> arrXe = new ArrayList<HOA_DON_NHAP_DTO>();
         conn = ConnectToSQL.openConnection();
         try {
             Ps = conn.prepareStatement("SELECT HOA_DON_NHAP.MA_HDN, HOA_DON_NHAP.MA_NV, NHAN_VIEN.HO_TEN, NHAN_VIEN.SDT, HOA_DON_NHAP.NGAY_LAP, HOA_DON_NHAP.TONG_TIEN FROM HOA_DON_NHAP, NHAN_VIEN WHERE  HOA_DON_NHAP.MA_NV = NHAN_VIEN.MA_NV AND "+ timTheo + "=?");
             Ps.setString(1, find);
             Rs = Ps.executeQuery();
            
            
             while (Rs.next()) {
                HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO = new HOA_DON_NHAP_DTO();
                hoa_DON_NHAP_DTO.setMA_HDN(Rs.getString("MA_HDN").trim());
                hoa_DON_NHAP_DTO.setMA_NV(Rs.getString("MA_NV").trim());
                hoa_DON_NHAP_DTO.setTEN_NV(Rs.getString ("HO_TEN"));
                hoa_DON_NHAP_DTO.setNGAY_LAP(Rs.getString("NGAY_LAP").trim());
                hoa_DON_NHAP_DTO.setTONG_TIEN(Rs.getLong("TONG_TIEN"));
                hoa_DON_NHAP_DTO.setSDT(Rs.getInt("SDT"));
                arrXe.add(hoa_DON_NHAP_DTO);
            }
          
         }
        catch (Exception err) { 
          err.printStackTrace();
          return null;
        }
        finally{
            ConnectToSQL.closeConnection(conn);
        }
      
        return arrXe;
   }


}

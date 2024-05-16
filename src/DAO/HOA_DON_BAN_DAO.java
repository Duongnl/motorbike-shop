package DAO;

import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class HOA_DON_BAN_DAO {
    
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public HOA_DON_BAN_DAO ()
    {

    }

    public ArrayList<HOA_DON_BAN_DTO> getAllHDB()
    {
        ArrayList<HOA_DON_BAN_DTO> arr = new ArrayList<HOA_DON_BAN_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT HOA_DON_BAN.MA_HDB, HOA_DON_BAN.MA_NV, NHAN_VIEN.HO_TEN,HOA_DON_BAN.MA_KH, KHACH_HANG.TEN_KH  , HOA_DON_BAN.NGAY_LAP, HOA_DON_BAN.THANH_TOAN  FROM HOA_DON_BAN, NHAN_VIEN , KHACH_HANG WHERE  HOA_DON_BAN.MA_NV = NHAN_VIEN.MA_NV AND HOA_DON_BAN.MA_KH = KHACH_HANG.MA_KH ");
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    HOA_DON_BAN_DTO hoa_DON_BAN_DTO = new HOA_DON_BAN_DTO();
                    
                    hoa_DON_BAN_DTO.setMA_HDB(Rs.getString("MA_HDB").trim());
                    hoa_DON_BAN_DTO.setMA_NV(Rs.getString("MA_NV").trim());
                    hoa_DON_BAN_DTO.setMA_KH(Rs.getString("MA_KH").trim());
                    hoa_DON_BAN_DTO.setTEN_NV(Rs.getString ("HO_TEN").trim());
                    hoa_DON_BAN_DTO.setTEN_KH(Rs.getString ("TEN_KH").trim());
                    hoa_DON_BAN_DTO.setNGAY_LAP(Rs.getString("NGAY_LAP").trim());
                    hoa_DON_BAN_DTO.setTHANH_TOAN(Rs.getLong("THANH_TOAN"));
                    arr.add(hoa_DON_BAN_DTO);
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



    public Boolean checkMaHDB (String maHDB)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               Ps = conn.prepareStatement("SELECT *  FROM HOA_DON_BAN WHERE MA_HDB =?");
               Ps.setString(1, maHDB);
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

    public Boolean addHDB (HOA_DON_BAN_DTO hoa_DON_BAN_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("INSERT INTO HOA_DON_BAN (MA_HDB,MA_KH,MA_NV,NGAY_LAP,THANH_TOAN) VALUES (?,?,?,?,?)");
               Ps.setString(1, hoa_DON_BAN_DTO.getMA_HDB());
               Ps.setString(2, hoa_DON_BAN_DTO.getMA_KH());
               Ps.setString(3, hoa_DON_BAN_DTO.getMA_NV());
               Ps.setString(4, hoa_DON_BAN_DTO.getNGAY_LAP());
               Ps.setLong(5, hoa_DON_BAN_DTO.getTHANH_TOAN());
               
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

    public Boolean deleteHDB (String maHDB)
    {
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("DELETE FROM HOA_DON_BAN WHERE MA_HDB = ?");
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



    public ArrayList<KHACH_HANG_DTO> findKhachHang (String maKH)
    {
        ArrayList<KHACH_HANG_DTO> arrKH = new ArrayList<KHACH_HANG_DTO>();
         conn = ConnectToSQL.openConnection();
         
         try {
             Ps = conn.prepareStatement("SELECT * FROM KHACH_HANG WHERE MA_KH = ?");
             Ps.setString(1, maKH);
             Rs = Ps.executeQuery();
            
            
             while (Rs.next()) {
                KHACH_HANG_DTO khach_HANG_DTO = new KHACH_HANG_DTO();
                khach_HANG_DTO.setMA_KH(Rs.getString("MA_KH").trim()); 
                khach_HANG_DTO.setTEN_KH(Rs.getString("TEN_KH").trim()); 
                khach_HANG_DTO.setGioitinh(Rs.getString("GIOI_TINH"));
                khach_HANG_DTO.setDIA_CHI(Rs.getString("DIA_CHI")); 
                khach_HANG_DTO.setSDT( Rs.getInt("SDT")); 
                khach_HANG_DTO.setNGAY_CAP_NHAP(Rs.getString("NGAY_CAP_NHAT")); 
                
                arrKH.add(khach_HANG_DTO);
            }
          
         }
        catch (Exception err) { 
          err.printStackTrace();
          return null;
        }
        finally{
            ConnectToSQL.closeConnection(conn);
        }
      
        return arrKH;
   }
    

   public ArrayList<HOA_DON_BAN_DTO> findHDB (String find, String timTheo)
   {
       ArrayList<HOA_DON_BAN_DTO> arrXe = new ArrayList<HOA_DON_BAN_DTO>();
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("SELECT HOA_DON_BAN.MA_HDB, HOA_DON_BAN.MA_NV, NHAN_VIEN.HO_TEN,HOA_DON_BAN.MA_KH, KHACH_HANG.TEN_KH , KHACH_HANG.DIA_CHI , HOA_DON_BAN.NGAY_LAP, HOA_DON_BAN.THANH_TOAN  FROM HOA_DON_BAN, NHAN_VIEN , KHACH_HANG WHERE  HOA_DON_BAN.MA_NV = NHAN_VIEN.MA_NV AND HOA_DON_BAN.MA_KH = KHACH_HANG.MA_KH AND "+ timTheo + "=?");
            Ps.setString(1, find);
            Rs = Ps.executeQuery();
            while (Rs.next()) {
               HOA_DON_BAN_DTO hoa_DON_BAN_DTO = new HOA_DON_BAN_DTO();
               hoa_DON_BAN_DTO.setMA_HDB(Rs.getString("MA_HDB").trim());
               hoa_DON_BAN_DTO.setMA_NV(Rs.getString("MA_NV").trim());
               hoa_DON_BAN_DTO.setMA_KH(Rs.getString("MA_KH").trim());
               hoa_DON_BAN_DTO.setTEN_NV(Rs.getString ("HO_TEN").trim());
               hoa_DON_BAN_DTO.setTEN_KH(Rs.getString ("TEN_KH").trim());
               hoa_DON_BAN_DTO.setNGAY_LAP(Rs.getString("NGAY_LAP").trim());
               hoa_DON_BAN_DTO.setTHANH_TOAN(Rs.getLong("THANH_TOAN"));
               hoa_DON_BAN_DTO.setDIA_CHI(Rs.getString("DIA_CHI").trim());
               arrXe.add(hoa_DON_BAN_DTO);
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
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class HANG_XE_DAO 
{
    Connection conn = null;
    private ResultSet RsHangXe = null;
    private PreparedStatement PsHangXe = null;
    public HANG_XE_DAO ()
    {

    }
    
    public ArrayList<HANG_XE_DTO> getAllHangXe()
    {
        ArrayList<HANG_XE_DTO> arrHangXe = new ArrayList<HANG_XE_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
               
                 PsHangXe = conn.prepareStatement("SELECT *  FROM  HANG_XE ");
                 RsHangXe = PsHangXe.executeQuery();

                while (RsHangXe.next()) {
                    HANG_XE_DTO hang_XE_DTO = new HANG_XE_DTO();
                    hang_XE_DTO.setMA_HANG(RsHangXe.getString("MA_HANG").trim());
                    hang_XE_DTO.setTEN_HANG(RsHangXe.getString("TEN_HANG").trim());
                    hang_XE_DTO.setMO_TA(RsHangXe.getString("MO_TA").trim());
                    arrHangXe.add(hang_XE_DTO);
                }
              
                return arrHangXe;
            }
            catch (Exception err) {
              err.printStackTrace();
              return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean checkMaHang (String maHang)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsHangXe = conn.prepareStatement("SELECT *  FROM  HANG_XE WHERE MA_HANG =?");
               PsHangXe.setString(1, maHang);
               RsHangXe = PsHangXe.executeQuery();
               flag = RsHangXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean checkTenHang (String tenHang)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsHangXe = conn.prepareStatement("SELECT *  FROM  HANG_XE WHERE TEN_HANG = ? ");
               PsHangXe.setString(1, tenHang);
               RsHangXe = PsHangXe.executeQuery();
               flag = RsHangXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean addHangXe (HANG_XE_DTO hang_XE_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               PsHangXe = conn.prepareStatement("INSERT INTO HANG_XE (MA_HANG, TEN_HANG, MO_TA) VALUES (?, ?,?)");
               PsHangXe.setString(1, hang_XE_DTO.getMA_HANG());
               PsHangXe.setString(2, hang_XE_DTO.getTEN_HANG());
               PsHangXe.setString(3, hang_XE_DTO.getMO_TA());
               PsHangXe.executeUpdate();
               return true;
            } catch (Exception e) {
               e.printStackTrace();
               return false;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean editHangXe (HANG_XE_DTO hang_XE_DTO)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsHangXe = conn.prepareStatement("UPDATE HANG_XE SET  TEN_HANG =?, MO_TA = ?  WHERE MA_HANG = ? ");
            PsHangXe.setString(1, hang_XE_DTO.getTEN_HANG());
            PsHangXe.setString(2, hang_XE_DTO.getMO_TA());
            PsHangXe.setString(3, hang_XE_DTO.getMA_HANG());
            if (PsHangXe.executeUpdate() ==1 )
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

    public Boolean checkMaHangInXeMay (String maHang)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsHangXe = conn.prepareStatement("SELECT *  FROM  XE_MAY WHERE MA_HANG =?");
               PsHangXe.setString(1, maHang);
               RsHangXe = PsHangXe.executeQuery();
               flag = RsHangXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean updateHangXeMay (String maHang)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsHangXe = conn.prepareStatement("UPDATE XE_MAY SET  MA_HANG = NULL  WHERE MA_HANG = ? ");
            PsHangXe.setString(1,maHang);
            if (PsHangXe.executeUpdate() ==1 )
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

    public Boolean deleteHangXe (String maHang)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsHangXe = conn.prepareStatement("DELETE FROM HANG_XE WHERE MA_HANG = ?");
            PsHangXe.setString(1,maHang);
            if (PsHangXe.executeUpdate() ==1 )
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

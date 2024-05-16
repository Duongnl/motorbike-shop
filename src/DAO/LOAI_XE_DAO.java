package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class LOAI_XE_DAO 
{
    Connection conn = null;
    private ResultSet RsLoaiXe = null;
    private PreparedStatement PsLoaiXe = null;
    public LOAI_XE_DAO ()
    {

    }

    public ArrayList<LOAI_XE_DTO> getAllLoaiXe()
    {
        ArrayList<LOAI_XE_DTO> arrLoaiXe = new ArrayList<LOAI_XE_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
               
                 PsLoaiXe = conn.prepareStatement("SELECT *  FROM  LOAI_XE ");
                 RsLoaiXe = PsLoaiXe.executeQuery();

                while (RsLoaiXe.next()) {
                    LOAI_XE_DTO loai_XE_DTO = new LOAI_XE_DTO();
                    loai_XE_DTO.setMA_LOAI(RsLoaiXe.getString("MA_LOAI").trim());
                    loai_XE_DTO.setTEN_LOAI_XE(RsLoaiXe.getString("TEN_LOAI_XE").trim());
                    loai_XE_DTO.setMO_TA(RsLoaiXe.getString("MO_TA").trim());
                    arrLoaiXe.add(loai_XE_DTO);
                }
              
                
                return arrLoaiXe;
            }
            catch (Exception err) {
              err.printStackTrace();
              return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }

        
    }

    public Boolean checkMaLoai (String maLoai)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsLoaiXe = conn.prepareStatement("SELECT *  FROM  LOAI_XE WHERE MA_LOAI =?");
               PsLoaiXe.setString(1, maLoai);
               RsLoaiXe = PsLoaiXe.executeQuery();
               flag = RsLoaiXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean checkTenLoai (String tenLoai)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsLoaiXe = conn.prepareStatement("SELECT *  FROM  LOAI_XE WHERE TEN_LOAI_XE = ? ");
               PsLoaiXe.setString(1, tenLoai);
               RsLoaiXe = PsLoaiXe.executeQuery();
               flag = RsLoaiXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean addLoaiXe (LOAI_XE_DTO loai_XE_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               PsLoaiXe = conn.prepareStatement("INSERT INTO LOAI_XE (MA_LOAI, TEN_LOAI_XE, MO_TA) VALUES (?, ?,?)");
               PsLoaiXe.setString(1, loai_XE_DTO.getMA_LOAI());
               PsLoaiXe.setString(2, loai_XE_DTO.getTEN_LOAI_XE());
               PsLoaiXe.setString(3, loai_XE_DTO.getMO_TA());
               PsLoaiXe.executeUpdate();
               return true;
            } catch (Exception e) {
               e.printStackTrace();
               return false;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean editLoaiXe (LOAI_XE_DTO loai_XE_DTO)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsLoaiXe = conn.prepareStatement("UPDATE LOAI_XE SET  TEN_LOAI_XE =?, MO_TA = ?  WHERE MA_LOAI = ? ");
            PsLoaiXe.setString(1, loai_XE_DTO.getTEN_LOAI_XE());
            PsLoaiXe.setString(2, loai_XE_DTO.getMO_TA());
            PsLoaiXe.setString(3, loai_XE_DTO.getMA_LOAI());
            if (PsLoaiXe.executeUpdate() ==1 )
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

    public Boolean checkMaLoaiInXeMay (String maLoai)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsLoaiXe = conn.prepareStatement("SELECT *  FROM  XE_MAY WHERE MA_LOAI =?");
               PsLoaiXe.setString(1, maLoai);
               RsLoaiXe = PsLoaiXe.executeQuery();
               flag = RsLoaiXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean updateLoaiXeMay (String maLoai)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsLoaiXe = conn.prepareStatement("UPDATE XE_MAY SET  MA_LOAI = NULL  WHERE MA_LOAI = ? ");
            PsLoaiXe.setString(1,maLoai);
            if (PsLoaiXe.executeUpdate() ==1 )
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


    public Boolean deleteLoaiXe (String maLoai)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsLoaiXe = conn.prepareStatement("DELETE FROM LOAI_XE WHERE MA_LOAI = ?");
            PsLoaiXe.setString(1,maLoai);
            if (PsLoaiXe.executeUpdate() ==1 )
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

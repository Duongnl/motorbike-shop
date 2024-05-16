package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;

public class MAU_XE_DAO {
    Connection conn = null;
    private ResultSet RsMauXe = null;
    private PreparedStatement PsMauXe = null;
    public MAU_XE_DAO ()
    {

    }

    public ArrayList<MAU_XE_DTO> getAllMauXe()
    {
        ArrayList<MAU_XE_DTO> arrMauXe = new ArrayList<MAU_XE_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
               
                 PsMauXe = conn.prepareStatement("SELECT *  FROM  MAU_XE ");
                 RsMauXe = PsMauXe.executeQuery();

                while (RsMauXe.next()) {
                    MAU_XE_DTO mau_XE_DTO = new MAU_XE_DTO();
                    mau_XE_DTO.setMA_MAU(RsMauXe.getString("MA_MAU").trim());
                    mau_XE_DTO.setTEN_MAU(RsMauXe.getString("TEN_MAU").trim());
                    arrMauXe.add(mau_XE_DTO);
                }
              
                
                return arrMauXe;
            }
            catch (Exception err) {
              err.printStackTrace();
              return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }

        
    }
    
    public Boolean checkMaMau (String maMau)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsMauXe = conn.prepareStatement("SELECT *  FROM  MAU_XE WHERE MA_MAU =?");
               PsMauXe.setString(1, maMau);
               RsMauXe = PsMauXe.executeQuery();
               flag = RsMauXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean checkTenMau (String tenMau)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsMauXe = conn.prepareStatement("SELECT *  FROM  MAU_XE WHERE TEN_MAU = ? ");
               PsMauXe.setString(1, tenMau);
               RsMauXe = PsMauXe.executeQuery();
               flag = RsMauXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean addMauXe (MAU_XE_DTO mau_XE_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               PsMauXe = conn.prepareStatement("INSERT INTO MAU_XE (MA_MAU, TEN_MAU) VALUES (?, ?)");
               PsMauXe.setString(1, mau_XE_DTO.getMA_MAU());
               PsMauXe.setString(2, mau_XE_DTO.getTEN_MAU());
               PsMauXe.executeUpdate();
               return true;
            } catch (Exception e) {
               e.printStackTrace();
               return false;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean editMauXe (MAU_XE_DTO mau_XE_DTO)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsMauXe = conn.prepareStatement("UPDATE MAU_XE SET  TEN_MAU =?  WHERE MA_MAU = ? ");
            PsMauXe.setString(1, mau_XE_DTO.getTEN_MAU());
            PsMauXe.setString(2, mau_XE_DTO.getMA_MAU());
            if (PsMauXe.executeUpdate() ==1 )
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

    
    public Boolean checkMaMauInXeMay (String maMau)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsMauXe = conn.prepareStatement("SELECT *  FROM  XE_MAY WHERE MA_MAU =?");
               PsMauXe.setString(1, maMau);
               RsMauXe = PsMauXe.executeQuery();
               flag = RsMauXe.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean updateMauXeMay (String maMau)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsMauXe = conn.prepareStatement("UPDATE XE_MAY SET  MA_MAU = NULL  WHERE MA_MAU = ? ");
            PsMauXe.setString(1,maMau);
            if (PsMauXe.executeUpdate() ==1 )
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


    public Boolean deleteMauXe (String maMau)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsMauXe = conn.prepareStatement("DELETE FROM MAU_XE WHERE MA_MAU = ?");
            PsMauXe.setString(1,maMau);
            if (PsMauXe.executeUpdate() ==1 )
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

package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class XE_MAY_DAO {
     
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public XE_MAY_DAO ()
    {

    }

    // public String[][] getAllXeMay ()
    // {
    //     String[][] result = null;
    //     conn = ConnectToSQL.openConnection();
    //     try {
                
    //         Ps = conn.prepareStatement("SELECT MA_XE, TEN_XE, GIA, TEN_LOAI_XE, TEN_MAU, TEN_HANG, SO_KHUNG, DUNG_TICH, TON_KHO, THOI_GIAN_BH, XE_MAY.MA_MAU, XE_MAY.MA_HANG, XE_MAY.MA_LOAI FROM  XE_MAY left join HANG_XE ON XE_MAY.MA_HANG = HANG_XE.MA_HANG left join LOAI_XE on XE_MAY.MA_LOAI = LOAI_XE.MA_LOAI left join MAU_XE on XE_MAY.MA_MAU = MAU_XE.MA_MAU WHERE TRANG_THAI = 1");
    //         Rs = Ps.executeQuery();
    //         ArrayList<String[]> dataList = new ArrayList<>();
           
    //         while (Rs.next()) {
    //         String[] data = new String[13];
    //         data[0] = Rs.getString("MA_XE").trim();
    //         data[1] = Rs.getString("TEN_XE").trim();
    //         data[2] =  Integer.toString(Rs.getInt("GIA")).trim(); 
    //         data[3] = Rs.getString("TEN_LOAI_XE");
    //         data[4] = Rs.getString("TEN_MAU");
    //         data[5] = Rs.getString("TEN_HANG");
    //         data[6] = Rs.getString("SO_KHUNG").trim();
    //         data[7] = Rs.getString("DUNG_TICH").trim();
    //         data[8] = Integer.toString( Rs.getInt("TON_KHO")).trim() ;
    //         data[9] =Rs.getString("THOI_GIAN_BH").trim();
    //         data[10] = Rs.getString("MA_HANG");
    //         data[11] = Rs.getString("MA_LOAI");
    //         data[12] = Rs.getString("MA_MAU");
    //         dataList.add(data);    
    //        }
    //        result = dataList.toArray(new String[dataList.size()][13]);
    //     }
    //    catch (Exception err) { 
    //      err.printStackTrace();
    //      return null;
    //    }
    //    finally{
    //        ConnectToSQL.closeConnection(conn);
    //    }
     
    //    return result;
    // } 
    public ArrayList<XE_MAY_DTO> getAllXeMay ()
    {
        ArrayList<XE_MAY_DTO> arrXe = new ArrayList<XE_MAY_DTO>();
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("SELECT MA_XE, TEN_XE, GIA, GIA_NHAP, TEN_LOAI_XE, TEN_MAU, TEN_HANG, SO_KHUNG, DUNG_TICH, TON_KHO, THOI_GIAN_BH, XE_MAY.MA_MAU, XE_MAY.MA_HANG, XE_MAY.MA_LOAI FROM  XE_MAY left join HANG_XE ON XE_MAY.MA_HANG = HANG_XE.MA_HANG left join LOAI_XE on XE_MAY.MA_LOAI = LOAI_XE.MA_LOAI left join MAU_XE on XE_MAY.MA_MAU = MAU_XE.MA_MAU WHERE TRANG_THAI = 1");
            Rs = Ps.executeQuery();
            while (Rs.next()) {
            XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();
            xe_MAY_DTO.setMA_XE(Rs.getString("MA_XE").trim()); 
            xe_MAY_DTO.setTEN_XE(Rs.getString("TEN_XE").trim()); 
            xe_MAY_DTO.setGIA(Rs.getLong("GIA"));
            xe_MAY_DTO.setTEN_LOAI_XE(Rs.getString("TEN_LOAI_XE")); 
            xe_MAY_DTO.setTEN_MAU( Rs.getString("TEN_MAU")); 
            xe_MAY_DTO.setTEN_HANG(Rs.getString("TEN_HANG")); 
            xe_MAY_DTO.setSO_KHUNG( Rs.getString("SO_KHUNG").trim()); 
            xe_MAY_DTO.setDUNG_TICH( Rs.getString("DUNG_TICH").trim());
            xe_MAY_DTO.setTON_KHO(Rs.getInt("TON_KHO")); 
            xe_MAY_DTO.setTHOI_GIAN_BH( Rs.getString("THOI_GIAN_BH").trim()); 
            xe_MAY_DTO.setMA_HANG( Rs.getString("MA_HANG"));
            xe_MAY_DTO.setMA_LOAI(Rs.getString("MA_LOAI"));  
            xe_MAY_DTO.setMA_MAU(Rs.getString("MA_MAU")); 
            xe_MAY_DTO.setGIA_NHAP(Rs.getLong("GIA_NHAP")); 
            
            System.out.println(Rs.getString("MA_XE").trim());

            arrXe.add(xe_MAY_DTO);
           }
           return arrXe;
        }
        catch (Exception err) { 
            err.printStackTrace();
         return null;
       }
       finally{
           ConnectToSQL.closeConnection(conn);
       }
     
       
    }
    
    public ArrayList<XE_MAY_DTO> findXeMay (String find, String timTheo)
    {
        ArrayList<XE_MAY_DTO> arrXe = new ArrayList<XE_MAY_DTO>();
         conn = ConnectToSQL.openConnection();
         try {
             Ps = conn.prepareStatement("SELECT MA_XE, TEN_XE, GIA, GIA_NHAP, TEN_LOAI_XE, TEN_MAU, TEN_HANG, SO_KHUNG, DUNG_TICH, TON_KHO, THOI_GIAN_BH, XE_MAY.MA_MAU, XE_MAY.MA_HANG, XE_MAY.MA_LOAI FROM  XE_MAY left join HANG_XE ON XE_MAY.MA_HANG = HANG_XE.MA_HANG left join LOAI_XE on XE_MAY.MA_LOAI = LOAI_XE.MA_LOAI left join MAU_XE on XE_MAY.MA_MAU = MAU_XE.MA_MAU WHERE " + timTheo + " = ? AND TRANG_THAI = 1");
             Ps.setString(1, find);
             Rs = Ps.executeQuery();
            
            
             while (Rs.next()) {
                XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();
                xe_MAY_DTO.setMA_XE(Rs.getString("MA_XE").trim()); 
                xe_MAY_DTO.setTEN_XE(Rs.getString("TEN_XE").trim()); 
                xe_MAY_DTO.setGIA(Rs.getLong("GIA"));
                xe_MAY_DTO.setGIA_NHAP(Rs.getLong("GIA_NHAP"));
                xe_MAY_DTO.setTEN_LOAI_XE(Rs.getString("TEN_LOAI_XE")); 
                xe_MAY_DTO.setTEN_MAU( Rs.getString("TEN_MAU")); 
                xe_MAY_DTO.setTEN_HANG(Rs.getString("TEN_HANG")); 
                xe_MAY_DTO.setSO_KHUNG( Rs.getString("SO_KHUNG").trim()); 
                xe_MAY_DTO.setDUNG_TICH( Rs.getString("DUNG_TICH").trim());
                xe_MAY_DTO.setTON_KHO(Rs.getInt("TON_KHO")); 
                xe_MAY_DTO.setTHOI_GIAN_BH( Rs.getString("THOI_GIAN_BH").trim()); 
                xe_MAY_DTO.setMA_HANG( Rs.getString("MA_HANG"));
                xe_MAY_DTO.setMA_LOAI(Rs.getString("MA_LOAI"));  
                xe_MAY_DTO.setMA_MAU(Rs.getString("MA_MAU")); 
                arrXe.add(xe_MAY_DTO);
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
    
    
    
    
    
    public Boolean checkMaXe (String maXe)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
            Ps = conn.prepareStatement("SELECT *  FROM  XE_MAY WHERE MA_XE =?");
               Ps.setString(1, maXe);
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

    public Boolean checkTenXe (String tenXe)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               Ps = conn.prepareStatement("SELECT *  FROM XE_MAY WHERE TEN_XE = ? AND TRANG_THAI = 1");
               Ps.setString(1, tenXe);
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


    public Boolean addXeMay (XE_MAY_DTO xe_MAY_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("INSERT INTO XE_MAY (MA_XE, TEN_XE, GIA, MA_LOAI, MA_MAU, MA_HANG, SO_KHUNG, DUNG_TICH, TON_KHO, TRANG_THAI, THOI_GIAN_BH, GIA_NHAP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
               Ps.setString(1, xe_MAY_DTO.getMA_XE());
               Ps.setString(2, xe_MAY_DTO.getTEN_XE());
               Ps.setLong(3, xe_MAY_DTO.getGIA());
               Ps.setString(4, xe_MAY_DTO.getMA_LOAI());
               Ps.setString(5, xe_MAY_DTO.getMA_MAU()); 
               Ps.setString(6, xe_MAY_DTO.getMA_HANG());
               Ps.setString(7, xe_MAY_DTO.getSO_KHUNG().toUpperCase());
               Ps.setString(8, xe_MAY_DTO.getDUNG_TICH().toUpperCase());
               Ps.setInt(9, xe_MAY_DTO.getTON_KHO());
               Ps.setInt(10, 1);
               Ps.setString(11, xe_MAY_DTO.getTHOI_GIAN_BH());
               Ps.setLong(12, xe_MAY_DTO.getGIA_NHAP());
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

    public Boolean themSoLuongXeMay (String maXe, int soLuong)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("UPDATE XE_MAY SET TON_KHO = TON_KHO + ? WHERE MA_XE = ?");
               Ps.setInt(1, soLuong);
               Ps.setString(2, maXe);
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

    public Boolean capNhatSoLuongXeMay (String maXe, int tonKho)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("UPDATE XE_MAY SET TON_KHO = ? WHERE MA_XE = ?");
               Ps.setInt(1, tonKho);
               Ps.setString(2, maXe);
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


    public Boolean deleteXeMay (String  maXe)
    {
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("UPDATE XE_MAY SET  TRANG_THAI = ?  WHERE MA_XE = ? ");
            Ps.setInt(1, 0);
            Ps.setString(2, maXe);
           
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

    public Boolean editXeMay (XE_MAY_DTO xe_MAY_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("UPDATE XE_MAY SET TEN_XE = ?, GIA = ?, MA_LOAI = ?, MA_MAU = ?, MA_HANG =?, SO_KHUNG = ?, DUNG_TICH = ?, TON_KHO = ?, TRANG_THAI =?, THOI_GIAN_BH  = ? , GIA_NHAP = ? WHERE MA_XE = ?");
               Ps.setString(1, xe_MAY_DTO.getTEN_XE());
               Ps.setLong(2, xe_MAY_DTO.getGIA());
               Ps.setString(3, xe_MAY_DTO.getMA_LOAI());
               Ps.setString(4, xe_MAY_DTO.getMA_MAU()); 
               Ps.setString(5, xe_MAY_DTO.getMA_HANG());
               Ps.setString(6, xe_MAY_DTO.getSO_KHUNG().toUpperCase());
               Ps.setString(7, xe_MAY_DTO.getDUNG_TICH().toUpperCase());
               Ps.setInt(8, xe_MAY_DTO.getTON_KHO());
               Ps.setInt(9, 1);
               Ps.setString(10, xe_MAY_DTO.getTHOI_GIAN_BH());
               Ps.setLong(11, xe_MAY_DTO.getGIA_NHAP());
               Ps.setString(12, xe_MAY_DTO.getMA_XE());
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




   

}

package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class XeDaXoa_DAO 
{
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public XeDaXoa_DAO ()
    {

    }

    public String[][] getAllXeMayDaXoa ()
    {
        String[][] result = null;
        conn = ConnectToSQL.openConnection();
        try {
               
            Ps = conn.prepareStatement("SELECT MA_XE, TEN_XE, GIA, TEN_LOAI_XE, TEN_MAU, TEN_HANG, SO_KHUNG, DUNG_TICH, TON_KHO, THOI_GIAN_BH, XE_MAY.MA_MAU, XE_MAY.MA_HANG, XE_MAY.MA_LOAI FROM  XE_MAY left join HANG_XE ON XE_MAY.MA_HANG = HANG_XE.MA_HANG left join LOAI_XE on XE_MAY.MA_LOAI = LOAI_XE.MA_LOAI left join MAU_XE on XE_MAY.MA_MAU = MAU_XE.MA_MAU WHERE TRANG_THAI = 0");
            Rs = Ps.executeQuery();
            ArrayList<String[]> dataList = new ArrayList<>();
           
            while (Rs.next()) {
            String[] data = new String[13];
            data[0] = Rs.getString("MA_XE").trim();
            data[1] = Rs.getString("TEN_XE").trim();
            data[2] =  Float.toString(Rs.getFloat("GIA")).trim(); 
            data[3] = Rs.getString("TEN_LOAI_XE").trim();
            data[4] = Rs.getString("TEN_MAU");
            data[5] = Rs.getString("TEN_HANG");
            data[6] = Rs.getString("SO_KHUNG");
            data[7] = Rs.getString("DUNG_TICH").trim();
            data[8] = Integer.toString( Rs.getInt("TON_KHO")).trim() ;
            data[9] =Rs.getString("THOI_GIAN_BH").trim();
            data[10] = Rs.getString("MA_HANG");
            data[11] = Rs.getString("MA_LOAI");
            data[12] = Rs.getString("MA_MAU");
            dataList.add(data);    
           }
           result = dataList.toArray(new String[dataList.size()][13]);
        }
       catch (Exception err) {
         err.printStackTrace();
         return null;
       }
       finally{
           ConnectToSQL.closeConnection(conn);
       }
     
       return result;
    }
 



}

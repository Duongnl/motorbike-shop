package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;

public class DoiMatKhau_DAO 
{
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public DoiMatKhau_DAO ()
    {

    }


    public Boolean checkMK (String pass, String maNV)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               Ps = conn.prepareStatement("SELECT * FROM NHAN_VIEN WHERE PASS COLLATE Latin1_General_CS_AS = ?  AND MA_NV = ?");
               Ps.setString(1, pass);
               Ps.setString(2, maNV);
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
    
    public Boolean doiMK (String maNV, String mKMoi)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("UPDATE NHAN_VIEN SET PASS=? WHERE MA_NV = ?");
               Ps.setString(1,mKMoi);
               Ps.setString(2, maNV);
               
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

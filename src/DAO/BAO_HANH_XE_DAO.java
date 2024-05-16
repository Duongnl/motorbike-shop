package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;
public class BAO_HANH_XE_DAO 
{
    Connection conn = null;
    private ResultSet RsBaoHanhXe = null;
    private PreparedStatement PsBaoHanhXe = null;
    public BAO_HANH_XE_DAO ()
    {

    }
    
    public ArrayList<BAO_HANH_XE_DTO> getAllBaoHanhXe()
    {
        ArrayList<BAO_HANH_XE_DTO> arrBaoHanhXe = new ArrayList<BAO_HANH_XE_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
               
                 PsBaoHanhXe = conn.prepareStatement("SELECT *  FROM  BAO_HANH ");
                 RsBaoHanhXe = PsBaoHanhXe.executeQuery();

                while (RsBaoHanhXe.next()) {
                    BAO_HANH_XE_DTO bao_hanh_xe_DTO = new BAO_HANH_XE_DTO();
                    bao_hanh_xe_DTO.setMaBaoHanh(RsBaoHanhXe.getString("MA_BH").trim());
                    bao_hanh_xe_DTO.setMaXe(RsBaoHanhXe.getString("MA_XE").trim());
                    bao_hanh_xe_DTO.setMaNhanVien(RsBaoHanhXe.getString("MA_NV"));
                    bao_hanh_xe_DTO.setMaKhachHang(RsBaoHanhXe.getString("MA_KH").trim());
                    bao_hanh_xe_DTO.setNgayNhanXe(RsBaoHanhXe.getString("NGAY_LAP").trim());
                    bao_hanh_xe_DTO.setNgayTraXe(RsBaoHanhXe.getString("NGAY_TRA_XE").trim());
                    bao_hanh_xe_DTO.setMoTa(RsBaoHanhXe.getString("MO_TA").trim());
                    arrBaoHanhXe.add(bao_hanh_xe_DTO);
                }
                return arrBaoHanhXe;
            }
            catch (Exception err) {
              err.printStackTrace();
              return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }
    

    public boolean editBaoHanhXe(BAO_HANH_XE_DTO bao_Hanh_Xe_DTO) {
            conn = ConnectToSQL.openConnection();
        try {
            PsBaoHanhXe = conn.prepareStatement("UPDATE BAO_HANH SET  MA_XE =?, MA_NV = ? , MA_KH = ?, NGAY_LAP = ?, NGAY_TRA_XE = ?, MO_TA = ?  WHERE MA_BH = ? ");
            PsBaoHanhXe.setString(7, bao_Hanh_Xe_DTO.getMaBaoHanh());
            PsBaoHanhXe.setString(1, bao_Hanh_Xe_DTO.getMaXe());
            PsBaoHanhXe.setString(2, bao_Hanh_Xe_DTO.getMaNhanVien());
            PsBaoHanhXe.setString(3, bao_Hanh_Xe_DTO.getMaKhachHang());
            PsBaoHanhXe.setString(4, bao_Hanh_Xe_DTO.getNgayNhanXe());
            PsBaoHanhXe.setString(5, bao_Hanh_Xe_DTO.getNgayTraXe());
            PsBaoHanhXe.setString(6, bao_Hanh_Xe_DTO.getMoTa());
            
            if (PsBaoHanhXe.executeUpdate() ==1 )
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

    public boolean addBaoHanhXe(BAO_HANH_XE_DTO bao_Hanh_Xe_DTO) {
            conn = ConnectToSQL.openConnection();
        try {
            PsBaoHanhXe = conn.prepareStatement("INSERT INTO BAO_HANH  (MA_BH, MA_XE, MA_NV, MA_KH, NGAY_LAP, NGAY_TRA_XE, MO_TA) VALUES(?,?,?,?,?,?,?)");
            PsBaoHanhXe.setString(1, bao_Hanh_Xe_DTO.getMaBaoHanh());
            PsBaoHanhXe.setString(2, bao_Hanh_Xe_DTO.getMaXe());
            PsBaoHanhXe.setString(3, bao_Hanh_Xe_DTO.getMaNhanVien());
            PsBaoHanhXe.setString(4, bao_Hanh_Xe_DTO.getMaKhachHang());
            PsBaoHanhXe.setString(5, bao_Hanh_Xe_DTO.getNgayNhanXe());
            PsBaoHanhXe.setString(6, bao_Hanh_Xe_DTO.getNgayTraXe());
            PsBaoHanhXe.setString(7, bao_Hanh_Xe_DTO.getMoTa());
            PsBaoHanhXe.executeUpdate();

            return true;        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
         }
         finally{
             ConnectToSQL.closeConnection(conn);
         }   
    }

    public boolean deleteHangXe(String maBaoHanh) {
        conn = ConnectToSQL.openConnection();
        try {
            PsBaoHanhXe = conn.prepareStatement("DELETE FROM BAO_HANH WHERE MA_BH = ?");
            PsBaoHanhXe.setString(1, maBaoHanh);
            if (PsBaoHanhXe.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectToSQL.closeConnection(conn);
        }
    }

    
}

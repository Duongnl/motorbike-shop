package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Connection.*;
import java.awt.Color;
import java.sql.SQLException;
import DTO.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class THONG_KE_DOANH_THU_DAO {
    
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public THONG_KE_DOANH_THU_DAO ()
    {
        
    }
    
    public ArrayList<CT_HOA_DON_BAN_DTO> getAllCTHDN_ThongKeDoanhThu(String ngayLap)
    {
        ArrayList<CT_HOA_DON_BAN_DTO> arr = new ArrayList<CT_HOA_DON_BAN_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT CT_HOA_DON_BAN.MA_XE, XE_MAY.TEN_XE, CT_HOA_DON_BAN.GIA_BAN, CT_HOA_DON_BAN.SO_LUONG, CT_HOA_DON_BAN.GIA, HOA_DON_BAN.NGAY_LAP from HOA_DON_BAN, CT_HOA_DON_BAN, XE_MAY WHERE HOA_DON_BAN.MA_HDB = CT_HOA_DON_BAN.MA_HDB AND CT_HOA_DON_BAN.MA_XE = XE_MAY.MA_XE AND NGAY_LAP like ?");
                 Ps.setString(1, ngayLap);
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO = new CT_HOA_DON_BAN_DTO();
                    ct_HOA_DON_BAN_DTO.setMA_XE(Rs.getString ("MA_XE"));
                    ct_HOA_DON_BAN_DTO.setTEN_XE(Rs.getString("TEN_XE").trim());
                    ct_HOA_DON_BAN_DTO.setGIA_NHAP(Rs.getLong("GIA_BAN"));
                    ct_HOA_DON_BAN_DTO.setSO_LUONG(Rs.getInt("SO_LUONG"));
                    ct_HOA_DON_BAN_DTO.setGIA(Rs.getLong("GIA"));
                    ct_HOA_DON_BAN_DTO.setNGAY_LAP(Rs.getString ("NGAY_LAP"));
                    
                    String dateString = Rs.getString ("NGAY_LAP").trim();
    
                    SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM");
                    
                    // Chuyển đổi chuỗi thành đối tượng Date
                    Date date = inputDateFormat.parse(dateString);
                    
                    // Chuyển đổi đối tượng Date thành chuỗi theo định dạng mong muốn
                    String outputDateString = outputDateFormat.format(date);
                    ct_HOA_DON_BAN_DTO.setTHANG_NAM(outputDateString);
                    
                    
                    
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




}

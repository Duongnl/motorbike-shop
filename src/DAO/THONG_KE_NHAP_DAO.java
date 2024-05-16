package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.*;



public class THONG_KE_NHAP_DAO 
{
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public THONG_KE_NHAP_DAO ()
    {
        
    }
    
    public ArrayList<CT_HOA_DON_NHAP_DTO> getAllCTHDN_ThongKe(String ngayLap)
    {
        ArrayList<CT_HOA_DON_NHAP_DTO> arr = new ArrayList<CT_HOA_DON_NHAP_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT CT_HOA_DON_NHAP.MA_XE, XE_MAY.TEN_XE, CT_HOA_DON_NHAP.GIA_NHAP, CT_HOA_DON_NHAP.SO_LUONG, CT_HOA_DON_NHAP.GIA from HOA_DON_NHAP, CT_HOA_DON_NHAP, XE_MAY WHERE HOA_DON_NHAP.MA_HDN = CT_HOA_DON_NHAP.MA_HDN AND CT_HOA_DON_NHAP.MA_XE = XE_MAY.MA_XE AND HOA_DON_NHAP.NGAY_LAP like ? ");
                 Ps.setString(1, ngayLap);
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = new CT_HOA_DON_NHAP_DTO();
                    ct_HOA_DON_NHAP_DTO.setMA_XE(Rs.getString ("MA_XE"));
                    ct_HOA_DON_NHAP_DTO.setTEN_XE(Rs.getString("TEN_XE").trim());
                    ct_HOA_DON_NHAP_DTO.setGIA_NHAP(Rs.getLong("GIA_NHAP"));
                    ct_HOA_DON_NHAP_DTO.setSO_LUONG(Rs.getInt("SO_LUONG"));
                    ct_HOA_DON_NHAP_DTO.setGIA(Rs.getLong("GIA"));
                    
                    arr.add(ct_HOA_DON_NHAP_DTO);
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

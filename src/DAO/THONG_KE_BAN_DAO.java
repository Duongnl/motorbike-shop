/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Admin
 */
public class THONG_KE_BAN_DAO {
    Connection conn = null;
    private ResultSet Rs = null;
    private PreparedStatement Ps = null;
    public THONG_KE_BAN_DAO ()
    {
        
    }
    
    public ArrayList<CT_HOA_DON_BAN_DTO> getAllCTHDN_ThongKe(String ngayLap)
    {
        ArrayList<CT_HOA_DON_BAN_DTO> arr = new ArrayList<CT_HOA_DON_BAN_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT CT_HOA_DON_BAN.MA_XE, XE_MAY.TEN_XE, CT_HOA_DON_BAN.GIA_BAN, CT_HOA_DON_BAN.SO_LUONG, CT_HOA_DON_BAN.GIA from HOA_DON_BAN, CT_HOA_DON_BAN, XE_MAY WHERE HOA_DON_BAN.MA_HDB = CT_HOA_DON_BAN.MA_HDB AND CT_HOA_DON_BAN.MA_XE = XE_MAY.MA_XE AND HOA_DON_BAN.NGAY_LAP like ? ");
                 Ps.setString(1, ngayLap);
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO = new CT_HOA_DON_BAN_DTO();
                    ct_HOA_DON_BAN_DTO.setMA_XE(Rs.getString ("MA_XE"));
                    ct_HOA_DON_BAN_DTO.setTEN_XE(Rs.getString("TEN_XE").trim());
                    ct_HOA_DON_BAN_DTO.setGIA_NHAP(Rs.getLong("GIA_BAN"));
                    ct_HOA_DON_BAN_DTO.setSO_LUONG(Rs.getInt("SO_LUONG"));
                    ct_HOA_DON_BAN_DTO.setGIA(Rs.getLong("GIA"));
                    
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

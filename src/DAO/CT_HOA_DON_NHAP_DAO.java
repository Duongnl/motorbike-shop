package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connection.*;
import DTO.*;
public class CT_HOA_DON_NHAP_DAO {
        Connection conn = null;
        private ResultSet Rs = null;
        private PreparedStatement Ps = null;
        public CT_HOA_DON_NHAP_DAO ()
        {
            
        }
    
    public ArrayList<CT_HOA_DON_NHAP_DTO> getAllCTHDN(String maHDN)
    {
        ArrayList<CT_HOA_DON_NHAP_DTO> arr = new ArrayList<CT_HOA_DON_NHAP_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT CT_HOA_DON_NHAP.MA_CTHDN, CT_HOA_DON_NHAP.MA_HDN, CT_HOA_DON_NHAP.MA_XE, XE_MAY.TEN_XE,  CT_HOA_DON_NHAP.GIA_NHAP , CT_HOA_DON_NHAP.SO_LUONG, CT_HOA_DON_NHAP.GIA FROM CT_HOA_DON_NHAP, XE_MAY WHERE CT_HOA_DON_NHAP.MA_XE = XE_MAY.MA_XE AND CT_HOA_DON_NHAP.MA_HDN = ?");
                 Ps.setString(1, maHDN);
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = new CT_HOA_DON_NHAP_DTO();
                    ct_HOA_DON_NHAP_DTO.setMA_CTHDN(Rs.getString("MA_CTHDN").trim());
                    ct_HOA_DON_NHAP_DTO.setMA_HDN(Rs.getString("MA_HDN").trim());
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
 
   


    public ArrayList<CT_HOA_DON_NHAP_DTO> getAllCTHDNTen_Hang(String maHDN)
    {
        ArrayList<CT_HOA_DON_NHAP_DTO> arr = new ArrayList<CT_HOA_DON_NHAP_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 Ps = conn.prepareStatement("SELECT CT_HOA_DON_NHAP.MA_CTHDN, CT_HOA_DON_NHAP.MA_HDN, CT_HOA_DON_NHAP.MA_XE, XE_MAY.TEN_XE, HANG_XE.TEN_HANG , CT_HOA_DON_NHAP.GIA_NHAP, CT_HOA_DON_NHAP.SO_LUONG, CT_HOA_DON_NHAP.GIA FROM CT_HOA_DON_NHAP, XE_MAY, HANG_XE WHERE CT_HOA_DON_NHAP.MA_XE = XE_MAY.MA_XE AND XE_MAY.MA_HANG = HANG_XE.MA_HANG  AND CT_HOA_DON_NHAP.MA_HDN = ?");
                 Ps.setString(1, maHDN);
                 Rs = Ps.executeQuery();

                while (Rs.next()) {
                    CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = new CT_HOA_DON_NHAP_DTO();
                    ct_HOA_DON_NHAP_DTO.setMA_CTHDN(Rs.getString("MA_CTHDN").trim());
                    ct_HOA_DON_NHAP_DTO.setMA_HDN(Rs.getString("MA_HDN").trim());
                    ct_HOA_DON_NHAP_DTO.setMA_XE(Rs.getString ("MA_XE"));
                    ct_HOA_DON_NHAP_DTO.setTEN_XE(Rs.getString("TEN_XE").trim());
                    ct_HOA_DON_NHAP_DTO.setGIA_NHAP(Rs.getLong("GIA_NHAP"));
                    ct_HOA_DON_NHAP_DTO.setSO_LUONG(Rs.getInt("SO_LUONG"));
                    ct_HOA_DON_NHAP_DTO.setGIA(Rs.getLong("GIA"));
                    ct_HOA_DON_NHAP_DTO.setHANG_XE(Rs.getString("TEN_HANG"));
                    
                   
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


    public Boolean checkMaCTHDN (String maCTHDN)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               Ps = conn.prepareStatement("SELECT *  FROM CT_HOA_DON_NHAP WHERE MA_CTHDN =?");
               Ps.setString(1, maCTHDN);
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

    public Boolean addCTHDN (CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               Ps = conn.prepareStatement("INSERT INTO CT_HOA_DON_NHAP (MA_CTHDN,MA_HDN,MA_XE,SO_LUONG,GIA, GIA_NHAP ) VALUES (?,?,?,?,?,?)");
               Ps.setString(1, ct_HOA_DON_NHAP_DTO.getMA_CTHDN());
               Ps.setString(2, ct_HOA_DON_NHAP_DTO.getMA_HDN());
               Ps.setString(3, ct_HOA_DON_NHAP_DTO.getMA_XE());
               Ps.setInt(4, ct_HOA_DON_NHAP_DTO.getSO_LUONG());
               Ps.setLong(5, ct_HOA_DON_NHAP_DTO.getGIA());   
               Ps.setLong(6, ct_HOA_DON_NHAP_DTO.getGIA_NHAP());   
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

 
    public Boolean deleteCTHDN (String maHDN)
    {
        conn = ConnectToSQL.openConnection();
        try {
            Ps = conn.prepareStatement("DELETE FROM CT_HOA_DON_NHAP WHERE MA_HDN = ?");
            Ps.setString(1,maHDN);
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



   















}

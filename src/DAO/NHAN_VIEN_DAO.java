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
import static Connection.ConnectToSQL.openConnection;
import DTO.*;
import GUI.Login_GUI;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NHAN_VIEN_DAO {
    Connection conn = null;
    private ResultSet RsNhanVien = null;
    private PreparedStatement PsNhanVien = null;
    public NHAN_VIEN_DAO ()
    {

    }
    
    public ArrayList<NHAN_VIEN_DTO> getAllNhanVien()
    {
        ArrayList<NHAN_VIEN_DTO> arrNhanVien = new ArrayList<NHAN_VIEN_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
               
                 PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE TRANG_THAI = 1 ");
                 RsNhanVien = PsNhanVien.executeQuery();

                while (RsNhanVien.next()) {
                    NHAN_VIEN_DTO nhan_VIEN_DTO = new NHAN_VIEN_DTO();
                    nhan_VIEN_DTO.setMA_NV(RsNhanVien.getString("MA_NV").trim());
                    nhan_VIEN_DTO.setUSERNAME(RsNhanVien.getString("USERNAME").trim());
                    nhan_VIEN_DTO.setHO_TEN(RsNhanVien.getString("HO_TEN").trim());
                    nhan_VIEN_DTO.setDIA_CHI(RsNhanVien.getString("DIA_CHI").trim());
                    nhan_VIEN_DTO.setCHUC_VU(RsNhanVien.getString("MA_CHUC_VU").trim());
                    nhan_VIEN_DTO.setSDT(RsNhanVien.getInt("SDT"));
                    nhan_VIEN_DTO.setGMAIL(RsNhanVien.getString("GMAIL").trim());
                    nhan_VIEN_DTO.setGHI_CHU(RsNhanVien.getString("GHI_CHU").trim());
                    nhan_VIEN_DTO.setGIOI_TINH(RsNhanVien.getString("GIOI_TINH").trim());
                    arrNhanVien.add(nhan_VIEN_DTO);
                }
              
                return arrNhanVien;
            }
            catch (Exception err) {
              err.printStackTrace();
              return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean checkMaNV (String maNV)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE MA_NV =?");
               PsNhanVien.setString(1, maNV);
               RsNhanVien = PsNhanVien.executeQuery();
               flag = RsNhanVien.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean checkTenTK (String tenTK)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE USERNAME = ? ");
               PsNhanVien.setString(1, tenTK);
               RsNhanVien = PsNhanVien.executeQuery();
               flag = RsNhanVien.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean checkUser (String tenTK)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE USERNAME = ? AND TRANG_THAI =0");
               PsNhanVien.setString(1, tenTK);
               RsNhanVien = PsNhanVien.executeQuery();
               flag = RsNhanVien.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }

    public Boolean addNhanVien (NHAN_VIEN_DTO nhan_VIEN_DTO)
    {
        conn = ConnectToSQL.openConnection();
            try {
               PsNhanVien = conn.prepareStatement("INSERT INTO NHAN_VIEN (MA_NV,USERNAME,PASS,HO_TEN,DIA_CHI,MA_CHUC_VU,SDT,GMAIL,GHI_CHU,TRANG_THAI,GIOI_TINH) VALUES (?,?,'12345678',?,?,?,?,?,?,'1',?)");
               PsNhanVien.setString(1, nhan_VIEN_DTO.getMA_NV());
               PsNhanVien.setString(2, nhan_VIEN_DTO.getUSERNAME());
               PsNhanVien.setString(3, nhan_VIEN_DTO.getHO_TEN());
               PsNhanVien.setString(4, nhan_VIEN_DTO.getDIA_CHI());
               PsNhanVien.setString(5, nhan_VIEN_DTO.getCHUC_VU());
               PsNhanVien.setInt(6, nhan_VIEN_DTO.getSDT());
               PsNhanVien.setString(7, nhan_VIEN_DTO.getGMAIL());
               PsNhanVien.setString(8, nhan_VIEN_DTO.getGHI_CHU());
               PsNhanVien.setString(9, nhan_VIEN_DTO.getGIOI_TINH());
               PsNhanVien.executeUpdate();
               return true;
            } catch (Exception e) {
               e.printStackTrace();
               return false;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }

    public Boolean editNhanVien (NHAN_VIEN_DTO nhan_VIEN_DTO)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsNhanVien = conn.prepareStatement("UPDATE NHAN_VIEN SET USERNAME = ?,HO_TEN = ?,DIA_CHI = ?,MA_CHUC_VU = ?,SDT = ?,GMAIL = ?,GHI_CHU = ?, GIOI_TINH = ?  WHERE MA_NV = ? ");
            PsNhanVien.setString(1, nhan_VIEN_DTO.getUSERNAME());
            PsNhanVien.setString(2, nhan_VIEN_DTO.getHO_TEN());
            PsNhanVien.setString(3, nhan_VIEN_DTO.getDIA_CHI());
            PsNhanVien.setString(4, nhan_VIEN_DTO.getCHUC_VU());
            PsNhanVien.setInt(5, nhan_VIEN_DTO.getSDT());
            PsNhanVien.setString(6, nhan_VIEN_DTO.getGMAIL());
            PsNhanVien.setString(7, nhan_VIEN_DTO.getGHI_CHU());
            PsNhanVien.setString(8, nhan_VIEN_DTO.getGIOI_TINH());
            PsNhanVien.setString(9, nhan_VIEN_DTO.getMA_NV());
            if (PsNhanVien.executeUpdate() ==1 )
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

    public Boolean deleteNhanVien (String maNV, String ngayNghi)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsNhanVien = conn.prepareStatement("UPDATE NHAN_VIEN SET TRANG_THAI = ? , NGAY_NGHI = ?  WHERE MA_NV = ?  ");
            PsNhanVien.setInt(1,0);
            PsNhanVien.setString(2,ngayNghi.trim());
            PsNhanVien.setString(3,maNV.trim());
            if (PsNhanVien.executeUpdate() == 1 )
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
    
    public Boolean checkTK (String tk, String mk)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE USERNAME = ? AND  PASS COLLATE Latin1_General_CS_AS = ? AND TRANG_THAI = 1");
               PsNhanVien.setString(1, tk);
               PsNhanVien.setString(2, mk);
               RsNhanVien = PsNhanVien.executeQuery();
               flag = RsNhanVien.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }
    
    public Boolean checkMail (String tenMail)
    {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;    
        try {
               PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE GMAIL = ? ");
               PsNhanVien.setString(1, tenMail);
               RsNhanVien = PsNhanVien.executeQuery();
               flag = RsNhanVien.next();
               return flag;
            } catch (Exception e) {
               e.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return flag;
    }
    
    public Boolean editPass (NHAN_VIEN_DTO nhan_VIEN_DTO)
    {
        conn = ConnectToSQL.openConnection();
        try {
            PsNhanVien = conn.prepareStatement("UPDATE NHAN_VIEN SET PASS=? WHERE GMAIL=? ");
            PsNhanVien.setString(1, nhan_VIEN_DTO.getPASS());
            PsNhanVien.setString(2, nhan_VIEN_DTO.getGMAIL());
            if (PsNhanVien.executeUpdate() ==1 )
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
    
    public ArrayList<NHAN_VIEN_DTO> getAllTaiKhoan(String tk)
    {
        ArrayList<NHAN_VIEN_DTO> arrTK = new ArrayList<NHAN_VIEN_DTO>();
        conn = ConnectToSQL.openConnection();
            try {
                 PsNhanVien = conn.prepareStatement("SELECT *  FROM  NHAN_VIEN WHERE USERNAME = ? AND TRANG_THAI = 1 ");
                 PsNhanVien.setString(1, tk);
                 RsNhanVien = PsNhanVien.executeQuery();

                while (RsNhanVien.next()) {
                    NHAN_VIEN_DTO nhan_vien_DTO = new NHAN_VIEN_DTO();
                    nhan_vien_DTO.setMA_NV(RsNhanVien.getString("MA_NV").trim());
                    nhan_vien_DTO.setUSERNAME(RsNhanVien.getString("USERNAME").trim());
                    nhan_vien_DTO.setPASS(RsNhanVien.getString("PASS").trim());
                    nhan_vien_DTO.setHO_TEN(RsNhanVien.getString("HO_TEN").trim());
                    nhan_vien_DTO.setDIA_CHI(RsNhanVien.getString("DIA_CHI").trim());
                    nhan_vien_DTO.setCHUC_VU(RsNhanVien.getString("MA_CHUC_VU").trim());
                    nhan_vien_DTO.setSDT(RsNhanVien.getInt("SDT"));
                    nhan_vien_DTO.setGMAIL(RsNhanVien.getString("GMAIL").trim());
                    nhan_vien_DTO.setGHI_CHU(RsNhanVien.getString("GHI_CHU").trim());
                    nhan_vien_DTO.setGIOI_TINH(RsNhanVien.getString("GIOI_TINH").trim());
                    Login_GUI.id_user = nhan_vien_DTO.getMA_NV();
                    Login_GUI.ten_ad = nhan_vien_DTO.getUSERNAME();
                    Login_GUI.pass_id = nhan_vien_DTO.getPASS();
                    Login_GUI.name = nhan_vien_DTO.getHO_TEN();
                    Login_GUI.address = nhan_vien_DTO.getDIA_CHI();
                    Login_GUI.id_role = nhan_vien_DTO.getCHUC_VU();
                    Login_GUI.numphone = Integer.toString(nhan_vien_DTO.getSDT());
                    Login_GUI.email = nhan_vien_DTO.getGMAIL();
                    Login_GUI.note = nhan_vien_DTO.getGHI_CHU();
                    Login_GUI.sex = nhan_vien_DTO.getGIOI_TINH();
                return arrTK;
                }
            }
            catch (Exception err) {
                err.printStackTrace();
                return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
        return null;
    }
    
    public ArrayList<NHAN_VIEN_DTO> getAllNVNghi(){
        ArrayList<NHAN_VIEN_DTO> arrNhanVien2 = new ArrayList<NHAN_VIEN_DTO>();
        conn = ConnectToSQL.openConnection();
        try {
            PsNhanVien = conn.prepareStatement("SELECT * FROM NHAN_VIEN WHERE TRANG_THAI = 0");
            RsNhanVien = PsNhanVien.executeQuery();
           while(RsNhanVien.next()){
                NHAN_VIEN_DTO nhan_VIEN_DTO = new NHAN_VIEN_DTO();
                nhan_VIEN_DTO.setMA_NV(RsNhanVien.getString("MA_NV").trim());
                nhan_VIEN_DTO.setUSERNAME(RsNhanVien.getString("USERNAME").trim());
                nhan_VIEN_DTO.setHO_TEN(RsNhanVien.getString("HO_TEN").trim());
                nhan_VIEN_DTO.setDIA_CHI(RsNhanVien.getString("DIA_CHI").trim());
                nhan_VIEN_DTO.setCHUC_VU(RsNhanVien.getString("MA_CHUC_VU").trim());
                nhan_VIEN_DTO.setSDT(RsNhanVien.getInt("SDT"));
                nhan_VIEN_DTO.setGMAIL(RsNhanVien.getString("GMAIL").trim());
                nhan_VIEN_DTO.setGHI_CHU(RsNhanVien.getString("GHI_CHU").trim());
                nhan_VIEN_DTO.setGIOI_TINH(RsNhanVien.getString("GIOI_TINH").trim());
                nhan_VIEN_DTO.setNGAY_NGHI(RsNhanVien.getString("NGAY_NGHI"));
                arrNhanVien2.add(nhan_VIEN_DTO);
           }
        return arrNhanVien2;
            }
            catch (Exception err) {
              err.printStackTrace();
              return null;
            }
            finally{
                ConnectToSQL.closeConnection(conn);
            }
    }
    
    public boolean Update_ngay(NHAN_VIEN_DTO nhan_VIEN_DTO){
        boolean check = false;
        conn = ConnectToSQL.openConnection();
        try {
            PsNhanVien = conn.prepareCall("UPDATE NHAN_VIEN SET NGAY_NGHI = ? WHERE MA_NV = ?");
            PsNhanVien.setString(1,nhan_VIEN_DTO.getNGAY_NGHI());
            PsNhanVien.setString(2,nhan_VIEN_DTO.getMA_NV());
            int t = PsNhanVien.executeUpdate();
            if(t>0){
                check=true;
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        finally{
            ConnectToSQL.closeConnection(conn);
        }
        return check;
    }
    
    public ArrayList<NHAN_VIEN_DTO> thongtin_tk(String maNV){
        ArrayList<NHAN_VIEN_DTO> arrNhanVien3 = new ArrayList<NHAN_VIEN_DTO>();
        conn = ConnectToSQL.openConnection();
        try {
            PsNhanVien = conn.prepareCall("SELECT * FROM NHAN_VIEN WHERE TRANG_THAI = 1 and MA_NV = ?");
            PsNhanVien.setString(1, maNV);
            RsNhanVien = PsNhanVien.executeQuery();
            while(RsNhanVien.next()){
                NHAN_VIEN_DTO nhan_VIEN_DTO = new NHAN_VIEN_DTO();
                nhan_VIEN_DTO.setMA_NV(RsNhanVien.getString("MA_NV").trim());
                nhan_VIEN_DTO.setUSERNAME(RsNhanVien.getString("USERNAME").trim());
                nhan_VIEN_DTO.setHO_TEN(RsNhanVien.getString("HO_TEN").trim());
                nhan_VIEN_DTO.setDIA_CHI(RsNhanVien.getString("DIA_CHI").trim());
                nhan_VIEN_DTO.setCHUC_VU(RsNhanVien.getString("MA_CHUC_VU").trim());
                nhan_VIEN_DTO.setSDT(RsNhanVien.getInt("SDT"));
                nhan_VIEN_DTO.setGMAIL(RsNhanVien.getString("GMAIL").trim());
                nhan_VIEN_DTO.setGHI_CHU(RsNhanVien.getString("GHI_CHU").trim());
                nhan_VIEN_DTO.setGIOI_TINH(RsNhanVien.getString("GIOI_TINH").trim());
                arrNhanVien3.add(nhan_VIEN_DTO);
        }
            return arrNhanVien3;
            }
            catch (Exception err) {
              err.printStackTrace();
            }
            finally{
                ConnectToSQL.closeConnection(conn);
    }
        return null;
    }
}

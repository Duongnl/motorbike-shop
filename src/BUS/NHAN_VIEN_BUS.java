/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NHAN_VIEN_DAO;
import DTO.NHAN_VIEN_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class NHAN_VIEN_BUS {
    NHAN_VIEN_DAO nhan_VIEN_DAO = new NHAN_VIEN_DAO();

    public ArrayList<NHAN_VIEN_DTO> getAllNhanVien ()
    {
        return nhan_VIEN_DAO.getAllNhanVien();
    }

    public boolean checkMaNV (String maNV)
    {
        if (nhan_VIEN_DAO.checkMaNV(maNV))
        {
            return true;
        }
        return false;
    }
    public boolean checkTenTK (String tenTK)
    {
        if (nhan_VIEN_DAO.checkTenTK(tenTK))
        {
            return true;
        }
        return false;
    }

    public boolean checkUser (String tenTK)
    {
        if (nhan_VIEN_DAO.checkUser(tenTK))
        {
            return true;
        }
        return false;
    }
    
    public boolean checkMail (String tenMail)
    {
        if (nhan_VIEN_DAO.checkMail(tenMail))
        {
            return true;
        }
        return false;
    }
    
    public boolean editPass (NHAN_VIEN_DTO nhan_VIEN_DTO)
    {
        return nhan_VIEN_DAO.editPass(nhan_VIEN_DTO);
    }

    public boolean deleteNhanVien (String maNV, String ngayNghi)
    {
        
        return nhan_VIEN_DAO.deleteNhanVien(maNV,ngayNghi);
    }


    public boolean addNhanVien(NHAN_VIEN_DTO nhan_VIEN_DTO){
         return nhan_VIEN_DAO.addNhanVien(nhan_VIEN_DTO);
    }

    
    public boolean editNhanVien (NHAN_VIEN_DTO nhan_VIEN_DTO)
    {
        return nhan_VIEN_DAO.editNhanVien(nhan_VIEN_DTO);
    }
    
    public boolean checkTK (String tk, String mk)
    {
        if (nhan_VIEN_DAO.checkTK (tk, mk))
        {
            return true;
        }
        return false;
    }
    

    
    public ArrayList<NHAN_VIEN_DTO> getAllTaiKhoan(String tk) {
        return nhan_VIEN_DAO.getAllTaiKhoan(tk);
    }
    
    public ArrayList<NHAN_VIEN_DTO> getAllNVNghi() {
        return nhan_VIEN_DAO.getAllNVNghi();
    }
    
    public boolean Update_ngay (NHAN_VIEN_DTO nhan_VIEN_DTO)
    {
        return nhan_VIEN_DAO.Update_ngay(nhan_VIEN_DTO);
    }
    
    public ArrayList<NHAN_VIEN_DTO> thongtin_tk(String maNV) {
        return nhan_VIEN_DAO.thongtin_tk(maNV);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.THONG_KE_BAN_DAO;
import DTO.CT_HOA_DON_BAN_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class THONG_KE_BAN_BUS {
    private THONG_KE_BAN_DAO xe_MAY_DAO = new THONG_KE_BAN_DAO();

    public ArrayList<CT_HOA_DON_BAN_DTO> getAllCTHDB_ThongKe(String ngayLap) {
        return xe_MAY_DAO.getAllCTHDN_ThongKe(ngayLap);
    } 
}

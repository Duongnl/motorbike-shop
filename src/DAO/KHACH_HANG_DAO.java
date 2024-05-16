package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Connection.*;
import DTO.*;

public class KHACH_HANG_DAO {
    Connection conn = null;
    private ResultSet RsKhachHang = null;
    private PreparedStatement PsKhachHang = null;

    public KHACH_HANG_DAO() {
    }

    public ArrayList<KHACH_HANG_DTO> getAllKhachHang() {
        ArrayList<KHACH_HANG_DTO> arrKhachHang = new ArrayList<KHACH_HANG_DTO>();
        conn = ConnectToSQL.openConnection();
        try {

            PsKhachHang = conn.prepareStatement("SELECT *  FROM  KHACH_HANG WHERE TRANG_THAI =1 ");
            RsKhachHang = PsKhachHang.executeQuery();

            while (RsKhachHang.next()) {
                KHACH_HANG_DTO kHACH_HANG_DTO = new KHACH_HANG_DTO();
                kHACH_HANG_DTO.setMA_KH(RsKhachHang.getString("MA_KH").trim());
                kHACH_HANG_DTO.setTEN_KH(RsKhachHang.getString("TEN_KH").trim());
                kHACH_HANG_DTO.setDIA_CHI(RsKhachHang.getString("DIA_CHI").trim());
                kHACH_HANG_DTO.setSDT(RsKhachHang.getInt("SDT"));
                kHACH_HANG_DTO.setGioitinh(RsKhachHang.getString("GIOI_TINH"));

                kHACH_HANG_DTO.setNGAY_CAP_NHAP(RsKhachHang.getString("NGAY_CAP_NHAT"));
                // System.out.println(RsKhachHang.getString("NGAY_CAP_NHAT").trim());

                kHACH_HANG_DTO.setTRANG_THAI(RsKhachHang.getInt("TRANG_THAI"));

                arrKhachHang.add(kHACH_HANG_DTO);
            }

            return arrKhachHang;
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        } finally {
            ConnectToSQL.closeConnection(conn);
        }
    }

    public Boolean check_MAKH(String maKH) {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;
        try {
            // RsKhachHang = conn.prepareStatement("SELECT * FROM KHACH_HANG WHERE MA_KH
            // =?");
            PsKhachHang = conn.prepareStatement("SELECT *  FROM  KHACH_HANG WHERE MA_KH =?");
            PsKhachHang.setString(1, maKH);
            RsKhachHang = PsKhachHang.executeQuery();
            flag = RsKhachHang.next();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectToSQL.closeConnection(conn);
        }
        return flag;
    }

    public Boolean checkTenKH(String tenKH) {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;
        try {
            PsKhachHang = conn.prepareStatement("SELECT *  FROM  HANG_XE WHERE TEN_HANG = ? ");
            PsKhachHang.setString(1, tenKH);
            RsKhachHang = PsKhachHang.executeQuery();
            flag = RsKhachHang.next();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectToSQL.closeConnection(conn);
        }
        return flag;
    }

    public Boolean addKhachHang(KHACH_HANG_DTO khanh_hang_DTO) {
        conn = ConnectToSQL.openConnection();
        try {
            PsKhachHang = conn.prepareStatement(
                    "INSERT INTO KHACH_HANG (MA_KH, TEN_KH, DIA_CHI,SDT,GIOI_TINH,NGAY_CAP_NHAT,TRANG_THAI) VALUES (?,?,?,?,?,?,?)");
            PsKhachHang.setString(1, khanh_hang_DTO.getMA_KH());
            PsKhachHang.setString(2, khanh_hang_DTO.getTEN_KH());
            PsKhachHang.setString(3, khanh_hang_DTO.getDIA_CHI());
            PsKhachHang.setInt(4, khanh_hang_DTO.getSDT());
            PsKhachHang.setString(5, khanh_hang_DTO.getGioitinh());
            PsKhachHang.setString(6, khanh_hang_DTO.getNGAY_CAP_NHAP());
            PsKhachHang.setInt(7, 1);

            PsKhachHang.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectToSQL.closeConnection(conn);
        }
    }

    public Boolean editKhachHang(KHACH_HANG_DTO khanh_hang_DTO) {
        conn = ConnectToSQL.openConnection();
        try {
            PsKhachHang = conn.prepareStatement(
                    "UPDATE KHACH_HANG SET  TEN_KH =?, DIA_CHI = ?, SDT= ? , GIOI_TINH = ?  WHERE MA_KH = ? ");
            PsKhachHang.setString(1, khanh_hang_DTO.getTEN_KH());
            PsKhachHang.setString(2, khanh_hang_DTO.getDIA_CHI());
            PsKhachHang.setInt(3, khanh_hang_DTO.getSDT());
            PsKhachHang.setString(4, khanh_hang_DTO.getGioitinh());
            PsKhachHang.setString(5, khanh_hang_DTO.getMA_KH());
            if (PsKhachHang.executeUpdate() == 1) {
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

    public Boolean checkMAKhachHang(String maKH) {
        conn = ConnectToSQL.openConnection();
        Boolean flag = false;
        try {
            PsKhachHang = conn.prepareStatement("SELECT *  FROM  KHACH_HANG WHERE MA_KH =?");
            PsKhachHang.setString(1, maKH);
            RsKhachHang = PsKhachHang.executeQuery();
            flag = RsKhachHang.next();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectToSQL.closeConnection(conn);
        }
        return flag;
    }

    public Boolean updateKhachHang(String maKH) {
        conn = ConnectToSQL.openConnection();
        try {
            PsKhachHang = conn.prepareStatement("UPDATE KHACH_HANG SET  MA_KH = NULL  WHERE MA_KH = ? ");
            PsKhachHang.setString(1, maKH);
            if (PsKhachHang.executeUpdate() == 1) {
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

    public Boolean deleteKhachHang(String maKH) {
        conn = ConnectToSQL.openConnection();
        try {
            PsKhachHang = conn.prepareStatement("UPDATE KHACH_HANG SET  TRANG_THAI = ?  WHERE MA_KH = ? ");
            PsKhachHang.setInt(1, 0);
            PsKhachHang.setString(2, maKH);

            if (PsKhachHang.executeUpdate() == 1) {
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

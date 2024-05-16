package DTO;

public class KHACH_HANG_DTO {
    private String MA_KH;
    private String TEN_KH;
    private String DIA_CHI;
    private int SDT  ;
    private String NGAY_CAP_NHAP ;
    private int TRANG_THAI;
    private String GIOI_TINH;
    


public KHACH_HANG_DTO(){
    MA_KH = null;
    TEN_KH = null;
    DIA_CHI = null;
    SDT = 0;
    NGAY_CAP_NHAP  = null;
    TRANG_THAI = 0;
    GIOI_TINH = null;

}
public KHACH_HANG_DTO(String maKH, String tenKH, String diaChi, int sdt, String ngayCapNhat, int trangThai, String gioitinh) {
    this.MA_KH = maKH;
    this.TEN_KH = tenKH;
    this.DIA_CHI = diaChi;
    this.SDT = sdt;
    this.NGAY_CAP_NHAP = ngayCapNhat;
    this.TRANG_THAI = trangThai;
    this.GIOI_TINH = gioitinh;
}


public String getMA_KH() {
    return MA_KH;
}

public void setMA_KH(String maKH) {
    this.MA_KH = maKH;
}

public String getTEN_KH() {
    return TEN_KH;
}

public void setTEN_KH(String tenKH) {
    this.TEN_KH = tenKH;
}

public String getDIA_CHI() {
    return DIA_CHI;
}

public void setDIA_CHI(String diaChi) {
    this.DIA_CHI = diaChi;
}

public int getSDT() {
    return SDT;
}

public void setSDT(int sdt) {
    this.SDT = sdt;
}

public String getNGAY_CAP_NHAP() {
    return NGAY_CAP_NHAP;
}

public void setNGAY_CAP_NHAP(String ngayCapNhat) {
    this.NGAY_CAP_NHAP = ngayCapNhat;
}

public int getTRANG_THAI() {
    return TRANG_THAI;
}

public void setTRANG_THAI(int trangThai) {
    this.TRANG_THAI = trangThai;
}
public String getGioitinh() {
    return GIOI_TINH;
}
public void setGioitinh(String gIOI_TINH) {
    GIOI_TINH = gIOI_TINH;
}
}

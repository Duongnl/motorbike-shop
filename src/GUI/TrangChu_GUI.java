package GUI;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class TrangChu_GUI  extends JFrame
{
private JMenuBar jMenuBar_trangChu;


private JMenuItem jMenuItem_thongTinCaNhan;

private JMenu jMenu_doiTKMK;
// private JMenuItem jMenuItem_doiTK;
private JMenuItem jMenuItem_doiMK;
// private JButton jButton_logOut;
private JButton jButton_qLXM;
private JButton jButton_banHang;
private JButton jButton_baoHanh;
private JButton jButton_nhanVien;
private JButton jButton_khachHang;
private JButton jButton_timKiemNC;
private JMenu jMenu_taiKhoan;
private JMenuItem jMenuItem_dangXuat;


private JMenu jMenu_thongKe;


private JMenuItem jMenuItem_thongKe;





public TrangChu_GUI ()
   {
    this.init_TrangChu();
    this.setVisible(true);
   }
    
   public void init_TrangChu ()
   {
    this.setTitle("Trang chủ");
    this.setSize(1415,740);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   //  actionlistener trangchu controller

     jMenuBar_trangChu = new JMenuBar();

   //   TẠO JMENU THÔNG TIN
     jMenu_taiKhoan = new JMenu("TÀI KHOẢN");
     
     ImageIcon Icon_caNhan= new javax.swing.ImageIcon(getClass().getResource("/IMG/CN.png"));
     jMenuItem_thongTinCaNhan = new JMenuItem("THÔNG TIN CÁ NHÂN");
     jMenuItem_thongTinCaNhan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
     jMenuItem_thongTinCaNhan.setIcon(Icon_caNhan);
     jMenuItem_thongTinCaNhan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          init_ThongTinCaNhan(evt);
      }
  });
     
     ImageIcon Icon_dangXuat= new javax.swing.ImageIcon(getClass().getResource("/IMG/logout.png"));
     jMenuItem_dangXuat = new JMenuItem("ĐĂNG XUẤT");
     jMenuItem_dangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
     jMenuItem_dangXuat.setIcon(Icon_dangXuat);
     jMenuItem_dangXuat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          init_Login(evt);
        
      }
  });
     
     jMenu_taiKhoan.add(jMenuItem_thongTinCaNhan);
     jMenu_taiKhoan.addSeparator(); // duong gach ngang
     jMenu_taiKhoan.add(jMenuItem_dangXuat);
      
   // Tạo  jmenu đổi mk tài khoản
   jMenu_doiTKMK = new JMenu("ĐỔI TK/MK");
//    ImageIcon Icon_doiTK= new javax.swing.ImageIcon(getClass().getResource("/IMG/AC.png"));
   
//    jMenuItem_doiTK = new JMenuItem("ĐỔI TÀI KHOẢN");
//    jMenuItem_doiTK.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
//    jMenuItem_doiTK.setIcon(Icon_doiTK);
//    jMenuItem_doiTK.addActionListener(new java.awt.event.ActionListener() {
//     public void actionPerformed(java.awt.event.ActionEvent evt) {
//         init_DoiTaiKhoan(evt);
//     }
// });

   
   ImageIcon Icon_doiMK= new javax.swing.ImageIcon(getClass().getResource("/IMG/PW.png"));
   jMenuItem_doiMK = new JMenuItem("ĐỔI MẬT KHẨU");
   jMenuItem_doiMK.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
   jMenuItem_doiMK.setIcon(Icon_doiMK);
   jMenuItem_doiMK.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        init_DoiMatKhau(evt);
    }
});

//  jMenu_doiTKMK.add(jMenuItem_doiTK);
jMenu_doiTKMK.addSeparator(); // duong gach ngang
jMenu_doiTKMK.add(jMenuItem_doiMK);


jMenu_thongKe = new JMenu("THỐNG KÊ");
ImageIcon Icon_thongKe= new javax.swing.ImageIcon(getClass().getResource("/IMG/export.png"));
   jMenuItem_thongKe = new JMenuItem("THỐNG KÊ");
   jMenuItem_thongKe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
   jMenuItem_thongKe.setIcon(Icon_thongKe);
   jMenuItem_thongKe.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        thongKe(evt);
    }
});
  jMenu_thongKe.add(jMenuItem_thongKe);


      // add jmenu vao taskbar
   jMenuBar_trangChu.add(jMenu_taiKhoan);
   jMenuBar_trangChu.add(jMenu_doiTKMK);
   jMenuBar_trangChu.add(jMenu_thongKe);
   jMenuBar_trangChu.setBounds(0, 0, 1415, 34);
   
      //  font của tiêu đề cửa hàng quản lý bán xe máy
   Font font_tieuDe = new Font("Arial", Font.BOLD, 40);   
   

   // text tiêu đề cửa hàng quản lý bán xe máy
   JLabel jLabel_textQLCHBXM = new JLabel("QUẢN LÝ CỬA HÀNG BÁN XE MÁY", JLabel.CENTER);
   jLabel_textQLCHBXM.setFont(font_tieuDe);
   jLabel_textQLCHBXM.setBounds(357, 53, 700, 48);

   // jbutton logout 
   // ImageIcon Icon_logOut = new javax.swing.ImageIcon(getClass().getResource("/IMG/logout48.png");
   //  jButton_logOut = new JButton("LOG OUT");
   //  jButton_logOut.setIcon(Icon_logOut);
   //  jButton_logOut.setVerticalTextPosition(SwingConstants.BOTTOM);
   //  jButton_logOut.setHorizontalTextPosition(SwingConstants.CENTER);
   //  jButton_logOut.setBounds(0, 48, 90, 90);

   //  FONT trang chủ
   Font font_trangChu = new Font("Arial", Font.BOLD, 21);
 
   // font xin chào 
   Font font_xinChao = new Font("Arial", Font.BOLD, 16);

   // jlabel xin chào 
   ImageIcon Icon_xinChao= new javax.swing.ImageIcon(getClass().getResource("/IMG/xinchao.png"));
   JLabel jLabel_xinChao = new JLabel("XIN CHÀO " + Login_GUI.name);
   jLabel_xinChao.setFont(font_xinChao);
   jLabel_xinChao.setIcon(Icon_xinChao);
   jLabel_xinChao.setBounds(0, 116, 300, 40);


   //  jbutton quản lý xe máy
  
   ImageIcon Icon_qLXM= new javax.swing.ImageIcon(getClass().getResource("/IMG/motorbike.png"));
   jButton_qLXM = new JButton("QUẢN LÝ XE MÁY");
   jButton_qLXM.setIcon(Icon_qLXM);
   jButton_qLXM.setFont(font_trangChu);
   jButton_qLXM.setVerticalTextPosition(SwingConstants.BOTTOM);
   jButton_qLXM.setHorizontalTextPosition(SwingConstants.CENTER);
   jButton_qLXM.setBounds(218, 193, 220, 220);
   jButton_qLXM.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            init_TaskBarView(evt);
        }
    });
   

   // jbutton quản lý hóa đơn bán
   ImageIcon Icon_banHang= new javax.swing.ImageIcon(getClass().getResource("/IMG/sell.png"));
   jButton_banHang = new JButton("BÁN HÀNG");
   jButton_banHang.setIcon(Icon_banHang);
   jButton_banHang.setFont(font_trangChu);
   jButton_banHang.setVerticalTextPosition(SwingConstants.BOTTOM);
   jButton_banHang.setHorizontalTextPosition(SwingConstants.CENTER);
   jButton_banHang.setBounds(598, 193, 220, 220);
   jButton_banHang.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      init_HoaDonBan (evt);
    }
});


   // jbutton bảo hành
   ImageIcon Icon_baoHanh= new javax.swing.ImageIcon(getClass().getResource("/IMG/repair.png"));
   jButton_baoHanh = new JButton("BẢO HÀNH");
   jButton_baoHanh.setIcon(Icon_baoHanh);
   jButton_baoHanh.setFont(font_trangChu);
   jButton_baoHanh.setVerticalTextPosition(SwingConstants.BOTTOM);
   jButton_baoHanh.setHorizontalTextPosition(SwingConstants.CENTER);
   jButton_baoHanh.setBounds(978, 193, 220, 220);
   jButton_baoHanh.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        init_BaoHanh(evt);
    }
});

   // jbutton nhân viên
   ImageIcon Icon_nhanVien= new javax.swing.ImageIcon(getClass().getResource("/IMG/NV.png"));
   jButton_nhanVien = new JButton("NHÂN VIÊN");
   jButton_nhanVien.setIcon(Icon_nhanVien);
   jButton_nhanVien.setFont(font_trangChu);
   jButton_nhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
   jButton_nhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
   jButton_nhanVien.setBounds(218, 453, 220, 220);
   jButton_nhanVien.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       init_NhanVien(evt);
    }
});

   // jbutton khách hàng
   ImageIcon Icon_khachHang= new javax.swing.ImageIcon(getClass().getResource("/IMG/KH.png"));
   jButton_khachHang = new JButton("KHÁCH HÀNG");
   jButton_khachHang.setIcon(Icon_khachHang);
   jButton_khachHang.setFont(font_trangChu);
   jButton_khachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
   jButton_khachHang.setHorizontalTextPosition(SwingConstants.CENTER);
   jButton_khachHang.setBounds(598, 452, 220, 220);
   jButton_khachHang.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        init_KhachHang(evt);
    }
});

   // jbutton tìm kiếm
   ImageIcon Icon_timKiem= new javax.swing.ImageIcon(getClass().getResource("/IMG/find128.png"));
   jButton_timKiemNC = new JButton("TÌM KIẾM");
   jButton_timKiemNC.setIcon(Icon_timKiem);
   jButton_timKiemNC.setFont(font_trangChu);
   jButton_timKiemNC.setVerticalTextPosition(SwingConstants.BOTTOM);
   jButton_timKiemNC.setHorizontalTextPosition(SwingConstants.CENTER);
   jButton_timKiemNC.setBounds(978, 453, 220, 220);
   jButton_timKiemNC.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       init_TimKiem(evt);
    }
});
   
   this.setLayout(null);
   this.add(jMenuBar_trangChu);
   this.add(jLabel_textQLCHBXM);
   // this.add(jButton_logOut);
   this.add(jLabel_xinChao);
   this.add(jButton_qLXM);
   this.add(jButton_banHang);
   this.add(jButton_baoHanh);
   this.add(jButton_nhanVien);
   this.add(jButton_khachHang);
   this.add(jButton_timKiemNC);
    }

    public void init_TaskBarView (java.awt.event.ActionEvent evt)
    {
        if(Login_GUI.id_role.equals("Nhân viên kho hàng") || Login_GUI.id_role.equals("Admin")){
            TaskBar_QLXe_GUI taskBar_GUI = new TaskBar_QLXe_GUI();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền vào kho hàng", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void init_ThongTinCaNhan(java.awt.event.ActionEvent evt)
    {
      ThongTinCaNhan_GUI thongTinCaNhan_GUI = new ThongTinCaNhan_GUI();
    }

    public void init_DoiTaiKhoan(java.awt.event.ActionEvent evt)
    {
      DoiTaiKhoan_GUI doiTaiKhoan_GUI = new DoiTaiKhoan_GUI();
    }

    public void init_KhachHang (java.awt.event.ActionEvent evt)
    {
        if(Login_GUI.id_role.equals("Nhân viên kho hàng")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền vào khách hàng", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            KHACH_HANG_GUI khach_HANG_GUI = new KHACH_HANG_GUI();
        }
    }
    
    public void init_NhanVien(java.awt.event.ActionEvent evt)
    {
      if(Login_GUI.id_role.equals("Admin")){
        NHAN_VIEN_GUI nhan_VIEN_GUI = new NHAN_VIEN_GUI();
      } else {
          JOptionPane.showMessageDialog(this, "Bạn không có quyền vào nhân viên", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }
    
    public void thongKe (java.awt.event.ActionEvent evt)
    {
      TaskBar_ThongKe_GUI taskBar_ThongKe_GUI = new TaskBar_ThongKe_GUI();
    }



    public void init_DoiMatKhau(java.awt.event.ActionEvent evt)
    {
      DoiMatKhau_GUI doiMatKhau_GUI = new DoiMatKhau_GUI();
    }

    public void init_BaoHanh(java.awt.event.ActionEvent evt)
    {
      if(Login_GUI.id_role.equals("Nhân viên bảo trì") || Login_GUI.id_role.equals("Admin")){
        BAO_HANH_GUI bao_HANH_GUI = new BAO_HANH_GUI();
      }else {
          JOptionPane.showMessageDialog(this, "Bạn không có quyền vào bảo hành", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }

    public void init_Login(java.awt.event.ActionEvent evt)
    {
      this.dispose();
      Login_GUI login_GUI = new Login_GUI();
    }

    public void init_HoaDonBan(java.awt.event.ActionEvent evt)
    {
      System.out.println(Login_GUI.id_role.trim());  
      
      if(Login_GUI.id_role.trim().equals("Nhân viên bán hàng") || Login_GUI.id_role.equals("Admin")){
            TaskBar_HoaDonBan_GUI taskBar_HoaDonBan_GUI = new TaskBar_HoaDonBan_GUI();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền vào bán hàng", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
    public void init_TimKiem(java.awt.event.ActionEvent evt)
    {
      TimKiem_GUI timKiem_GUI = new TimKiem_GUI();
    }
    
  //  public static void main(String[] args) {
  //   new TrangChu_GUI();
  //  }


}

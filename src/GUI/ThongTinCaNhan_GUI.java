package GUI;

import BUS.NHAN_VIEN_BUS;
import DTO.NHAN_VIEN_DTO;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ThongTinCaNhan_GUI extends JFrame
{
    private JLabel jLabel_maNV;
    private JLabel jLabel_hoTen;
    private JLabel jLabel_userName;
    private JLabel jLabel_passWord;
    private JLabel jLabel_chucVu;
    private JLabel jLabel_SDT;
    private JLabel jLabel_Gmail;
    private JLabel jLabel_diaChi;
    private JLabel jLabel_ghiChu;
    private JButton jButton_exitTTCN;
    NHAN_VIEN_BUS nhan_VIEN_BUS = new NHAN_VIEN_BUS();


public ThongTinCaNhan_GUI ()
   {
      this.init_ThongTinCaNhan();
      getTT();
    this.setVisible(true);
   }
    
   public void init_ThongTinCaNhan ()
   { 
    this.setTitle("Thông tin cá nhân");
    this.setSize(500,620);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    // font tiêu đề thông tin cá nhân
    Font font_tieuDe = new Font("Arial", Font.BOLD, 25);
    
  

    // jbutton exit
    ImageIcon Icon_exitTTCN= new ImageIcon("D:\\HocKy4\\Java\\JAVAPROJECT\\src\\IMG\\exit24.png");
     jButton_exitTTCN = new JButton("EXIT");
    jButton_exitTTCN.setIcon(Icon_exitTTCN);
    jButton_exitTTCN.setBounds(9, 9, 90, 30);
    jButton_exitTTCN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          Dispose(evt);
      }
  });
   




    // jlable thông tin cá nhân
    JLabel jLabel_TTCN = new JLabel("THÔNG TIN CÁ NHÂN", JLabel.CENTER);
    jLabel_TTCN.setFont(font_tieuDe);
    jLabel_TTCN.setBounds(81, 44, 262, 30);

    // font thông tin cá nhân
    Font font_TTCN = new Font("Arial", Font.BOLD, 14); 

    // jlabel text mã nhân viên
    JLabel jLabel_textMaNV = new JLabel("MÃ NHÂN VIÊN:");
    jLabel_textMaNV.setFont(font_TTCN);
    jLabel_textMaNV.setBounds(81, 99, 115, 16);

    // jlabel mã nhân viên 
     jLabel_maNV = new JLabel("NV001");
    jLabel_maNV.setFont(font_TTCN);
    jLabel_maNV.setBounds(205, 99, 200, 16);


    // jlabel text họ tên
    JLabel jLabel_textHoTen = new JLabel("HỌ TÊN:");
    jLabel_textHoTen.setFont(font_TTCN);
    jLabel_textHoTen.setBounds(81, 140, 115, 16);

    // jlabel họ tên 
    jLabel_hoTen = new JLabel("Nguyễn Văn A");
    jLabel_hoTen.setFont(font_TTCN);
    jLabel_hoTen.setBounds(191, 140, 200, 16);

    // jlabel text username 
    JLabel jLabel_textUserName = new JLabel("USERNAME:");
    jLabel_textUserName.setFont(font_TTCN);
    jLabel_textUserName.setBounds(81, 181, 115, 16);

    // jlabel username 
    jLabel_userName = new JLabel("nguyenvana123");
    jLabel_userName.setFont(font_TTCN);
    jLabel_userName.setBounds(191, 181, 200, 16);

    // jlabel text password 
    JLabel jLabel_textPassWord = new JLabel("GIỚI TÍNH:");
    jLabel_textPassWord.setFont(font_TTCN);
    jLabel_textPassWord.setBounds(81, 222, 115, 16);

    // JLABEL password
    jLabel_passWord = new JLabel("123123123");
    jLabel_passWord.setFont(font_TTCN);
    jLabel_passWord.setBounds(191, 222, 200, 16);

    // jlable text chức vụ
    JLabel jLabel_textChucVu = new JLabel("CHỨC VỤ:");
    jLabel_textChucVu.setFont(font_TTCN);
    jLabel_textChucVu.setBounds(81, 263, 115, 16);

    // jlable chức vụ
    jLabel_chucVu = new JLabel("Nhân viên");
    jLabel_chucVu.setFont(font_TTCN);
    jLabel_chucVu.setBounds(191, 263, 200, 16);

    // jlable text số điện thoại
    JLabel jLabel_textSDT = new JLabel("SDT:");
    jLabel_textSDT.setFont(font_TTCN);
    jLabel_textSDT.setBounds(81, 304, 115, 16);

    // JLABLE số điện thoại
    jLabel_SDT = new JLabel("0963717300");
    jLabel_SDT.setFont(font_TTCN);
    jLabel_SDT.setBounds(191, 304, 200, 16);

    // jlable text gmail
    JLabel jLabel_textGmail = new JLabel("GMAIL:");
    jLabel_textGmail.setFont(font_TTCN);
    jLabel_textGmail.setBounds(81, 345, 115, 16);

    // jlable gmail
    jLabel_Gmail = new JLabel("nguyenvana123@gmail.com");
    jLabel_Gmail.setFont(font_TTCN);
    jLabel_Gmail.setBounds(191, 345, 200, 16);

    // jlable text địa chỉ 
    JLabel jLabel_textDiaChi = new JLabel("ĐỊA CHỈ:");
    jLabel_textDiaChi.setFont(font_TTCN);
    jLabel_textDiaChi.setBounds(81, 386, 115, 16);

    // jlable địa chỉ 
    jLabel_diaChi = new JLabel("Tân Phú, Hồ Chí Minh");
    jLabel_diaChi.setFont(font_TTCN);
    jLabel_diaChi.setBounds(191, 386, 200, 16);

    // jlable text ghi chú 
    JLabel jLabel_textGhiChu = new JLabel("GHI CHÚ:");
    jLabel_textGhiChu.setFont(font_TTCN);
    jLabel_textGhiChu.setBounds(81, 427, 115, 16);

    // jlable ghi chú 
    jLabel_ghiChu = new JLabel("Không có");
    jLabel_ghiChu.setFont(font_TTCN);
    jLabel_ghiChu.setBounds(191, 427, 200, 16);

    // jpanel thông tin cá nhân
    JPanel jPanel_TTCN = new JPanel();
    jPanel_TTCN.setLayout(null);
    jPanel_TTCN.add(jLabel_TTCN);
    jPanel_TTCN.add(jLabel_textMaNV);
    jPanel_TTCN.add(jLabel_maNV);
    jPanel_TTCN.add(jLabel_textHoTen);
    jPanel_TTCN.add(jLabel_hoTen);
    jPanel_TTCN.add(jLabel_textUserName);
    jPanel_TTCN.add(jLabel_userName);
    jPanel_TTCN.add(jLabel_textPassWord);
    jPanel_TTCN.add(jLabel_passWord);
    jPanel_TTCN.add(jLabel_textChucVu);
    jPanel_TTCN.add(jLabel_chucVu);
    jPanel_TTCN.add(jLabel_textSDT);
    jPanel_TTCN.add(jLabel_SDT);
    jPanel_TTCN.add(jLabel_textGmail);
    jPanel_TTCN.add(jLabel_Gmail);
    jPanel_TTCN.add(jLabel_textDiaChi);
    jPanel_TTCN.add(jLabel_diaChi);
    jPanel_TTCN.add(jLabel_textGhiChu);
    jPanel_TTCN.add(jLabel_ghiChu);

    jPanel_TTCN.setBackground(Color.LIGHT_GRAY);
    jPanel_TTCN.setBounds(38, 59, 423, 499);
    

    this.setLayout(null);
    this.add(jButton_exitTTCN);
    this.add(jPanel_TTCN);


   }

   public void Dispose (java.awt.event.ActionEvent evt)
   {
    this.dispose();
   }

  //  public void getTT(){
  //       nhan_VIEN_BUS.thongtin_tk(Login_GUI.id_user);
  //       NHAN_VIEN_DTO nhan_VIEN_DTO = new NHAN_VIEN_DTO();
  //       nhan_VIEN_DTO.setMA_NV(jLabel_maNV.getText().trim());
  //       nhan_VIEN_DTO.setUSERNAME(jLabel_userName.getText().trim());
  //       nhan_VIEN_DTO.setHO_TEN(jLabel_hoTen.getText().trim());
  //       nhan_VIEN_DTO.setDIA_CHI(jLabel_diaChi.getText().trim());
  //       nhan_VIEN_DTO.setCHUC_VU(jLabel_chucVu.getText().trim());
  //       nhan_VIEN_DTO.setSDT(Integer.parseInt(jLabel_SDT.getText().trim()));
  //       nhan_VIEN_DTO.setGMAIL(jLabel_Gmail.getText().trim());
  //       nhan_VIEN_DTO.setGHI_CHU(jLabel_ghiChu.getText().trim());
  //   }

    public void getTT(){
      nhan_VIEN_BUS.thongtin_tk(Login_GUI.id_user);
      
      jLabel_maNV.setText(Login_GUI.id_user);
      jLabel_userName.setText(Login_GUI.ten_ad);
      jLabel_hoTen.setText(Login_GUI.name);
      jLabel_diaChi.setText(Login_GUI.address);
      jLabel_passWord.setText(Login_GUI.sex);
      jLabel_chucVu.setText(Login_GUI.id_role);
      jLabel_SDT.setText(Login_GUI.numphone);
      jLabel_Gmail.setText(Login_GUI.email);
      jLabel_ghiChu.setText(Login_GUI.note);
  }


    


   public static void main(String[] args) {
     new ThongTinCaNhan_GUI();
   }

}

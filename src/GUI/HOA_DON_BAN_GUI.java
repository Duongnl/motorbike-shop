package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.CT_HOA_DON_BAN_BUS;
import BUS.HOA_DON_BAN_BUS;
import BUS.XE_MAY_BUS;
import CHECK.Check1;
import DTO.CT_HOA_DON_BAN_DTO;
import DTO.HOA_DON_BAN_DTO;
import DTO.KHACH_HANG_DTO;
import DTO.XE_MAY_DTO;

public class HOA_DON_BAN_GUI extends JPanel {
   
   
    private JTextField jTextField_timKiemXeMay;
    
    private JTextField jTextField_timKiemKhachHang;

    private String[] String_timKiemTheoXeHDB = {"Mã xe", "Tên xe", "Giá", "Loại xe", "Hãng xe"  };

    JComboBox<String> comboBox_timKiemTheoXeHDB;




    private JTable jTable_XeMayHDB;

    private NonEditableTableModel tableModel_XeMayHDB;

    private JScrollPane jScrollPane_XeMayHDB;

    private JTable jTable_XeMayCTHDB;

    private NonEditableTableModel tableModel_XeMayCTHDB;

    private JScrollPane jScrollPane_XeMayCTHDB;

    private JButton jButton_timKiemXeMayHDB;

  private XE_MAY_BUS xe_MAY_BUS = new XE_MAY_BUS();

   

    private JButton jButton_resetXeMayHDB;

    private JButton jButton_timKiemKhachHangHDB;

    private JButton jButton_themKhachHangHDB;

    private JButton jButton_resetKhachHangHDB;

    private JButton jButton_themVaoCTHDB;

    private JButton jButton_resetCTHDB;

    private JButton jButton_xoaCTHDB;

    private JButton jButton_banHang;

    private JTextField jTextField_soLuong;

    

    private ArrayList<XE_MAY_DTO> arrXeHDB = new ArrayList<XE_MAY_DTO>();
    private ArrayList<XE_MAY_DTO> arrXeCTHDB = new ArrayList<XE_MAY_DTO>();

    private JTable tableSelectHDB;
    private int selectedRowHDB;

    private JTable tableSelectCTHDB;
    private int selectedRowCTHDB;

    private JTextField jTextField_tongTien;

    private JLabel jLabel_maKH;

    private JLabel jLabel_tenKH;

    private JLabel jLabel_gioiTinh;

    private JLabel jLabel_sDT;

    private JLabel jLabel_diaChi;

    private Check1 check1 = new Check1();

    HOA_DON_BAN_BUS hoa_DON_BAN_BUS = new HOA_DON_BAN_BUS();
    CT_HOA_DON_BAN_BUS ct_HOA_DON_BAN_BUS = new CT_HOA_DON_BAN_BUS();

    private JTextField jTextField_giaBan;


    public HOA_DON_BAN_GUI ()
   {
    init_HoaDonBan();
    arrXeHDB = xe_MAY_BUS.getAllXeMay();
    loadAllXeMayHDB();

   }

    public void init_HoaDonBan ()
    {
        Font font_tieuDe = new Font("Arial", Font.BOLD, 25);
        Font font_tieuDe2 = new Font("Arial", Font.BOLD, 16); 
        Font font_tieuDe3 = new Font("Arial", Font.BOLD, 18); 
        
        Font font_HDB = new Font("Arial", Font.BOLD, 14); 

        
        JLabel jLabel_timKiemXeMay = new JLabel("TÌM KIẾM XE MÁY");
        jLabel_timKiemXeMay.setFont(font_tieuDe);
        jLabel_timKiemXeMay.setBounds(131, 17, 300, 30);

        JLabel jLabel_timKiem = new JLabel("TÌM KIẾM:");
        jLabel_timKiem.setFont(font_HDB);
        jLabel_timKiem.setBounds(30, 66, 73, 16);

        JLabel jLabel_timKiemTheo = new JLabel("TÌM KIẾM THEO:");
        jLabel_timKiemTheo.setFont(font_HDB);
        jLabel_timKiemTheo.setBounds(30, 118 , 150, 16);

        JLabel jLabel_khachHang = new JLabel("KHÁCH HÀNG");
        jLabel_khachHang.setFont(font_tieuDe);
        jLabel_khachHang.setBounds(1080, 17, 300, 30);

        JLabel jLabel_nhapMaKhachHang = new JLabel("NHẬP MÃ KH:");
        jLabel_nhapMaKhachHang.setFont(font_HDB);
        jLabel_nhapMaKhachHang.setBounds(950, 66 , 180, 16);




        JLabel jLabel_thongTinKhachHang = new JLabel("THÔNG TIN KHÁCH HÀNG");
        jLabel_thongTinKhachHang.setFont(font_tieuDe2);
        jLabel_thongTinKhachHang.setBounds(1100, 160, 350, 30);

        JLabel jLabel_textMaKhachHang = new JLabel("MÃ KHÁCH HÀNG:");
        jLabel_textMaKhachHang.setFont(font_HDB);
        jLabel_textMaKhachHang.setBounds(950, 199, 150, 16);

        JLabel jLabel_textTenKhachHang = new JLabel("TÊN KHÁCH HÀNG:");
        jLabel_textTenKhachHang.setFont(font_HDB);
        jLabel_textTenKhachHang.setBounds(950, 231, 150, 16);

        JLabel jLabel_textgioiTinh = new JLabel("GIỚI TÍNH");
        jLabel_textgioiTinh.setFont(font_HDB);
        jLabel_textgioiTinh.setBounds(950, 261 , 150, 16);

        JLabel jLabel_textSoDienThoai = new JLabel("SỐ ĐIỆN THOẠI:");
        jLabel_textSoDienThoai.setFont(font_HDB);
        jLabel_textSoDienThoai.setBounds(950, 292, 150, 16);

        JLabel jLabel_textDiaChi = new JLabel("ĐỊA CHỈ:");
        jLabel_textDiaChi.setFont(font_HDB);
        jLabel_textDiaChi.setBounds(950, 322, 150, 16);







        JLabel jLabel_soLuong = new JLabel("SỐ LƯỢNG");
        jLabel_soLuong.setFont(font_HDB);
        jLabel_soLuong.setBounds(830, 169, 109, 16);

        JLabel jLabel_giaBan = new JLabel("GIÁ BÁN");
        jLabel_giaBan.setFont(font_HDB);
        jLabel_giaBan.setBounds(835, 100, 109, 16);


        JLabel jLabel_chiTietXeMay = new JLabel("CHI TIẾT HÓA ĐƠN");
        jLabel_chiTietXeMay.setFont(font_tieuDe);
        jLabel_chiTietXeMay.setBounds(522, 363, 300, 30);




//------------------------------------------------------------------------------------------------------------
         jTextField_timKiemXeMay = new JTextField();
        jTextField_timKiemXeMay.setFont(font_HDB);
        jTextField_timKiemXeMay.setBounds(164, 62, 297, 24);

        jTextField_timKiemKhachHang = new JTextField();
        jTextField_timKiemKhachHang.setFont(font_HDB);
        jTextField_timKiemKhachHang.setBounds(1050, 62, 200, 24);

        jTextField_soLuong = new JTextField();
        jTextField_soLuong.setFont(font_HDB);
        jTextField_soLuong.setBounds(800, 195, 136, 24);

        jTextField_giaBan = new JTextField();
        jTextField_giaBan.setFont(font_HDB);
        jTextField_giaBan.setBounds(800, 125, 136, 24);

//------------------------------------------------------------------------------------------------------------        

    comboBox_timKiemTheoXeHDB = new JComboBox<>(String_timKiemTheoXeHDB);
    comboBox_timKiemTheoXeHDB.setFont(font_HDB);
    comboBox_timKiemTheoXeHDB.setBounds(164, 115, 136, 24);
//----------------------------------------------------------------------------------------------------
//     table 
    jTable_XeMayHDB = new JTable();
    tableModel_XeMayHDB = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ BÁN", "LOẠI XE", "MÀU XE", "HÃNG XE", "SỐ KHUNG", "DUNG TÍCH", "TỒN KHO", "THỜI GIAN BẢO HÀNH", "MÃ HÃNG", "MÃ LOẠI", "MÃ MÀU"} );
    jTable_XeMayHDB = new JTable(tableModel_XeMayHDB);
    jScrollPane_XeMayHDB = new JScrollPane(jTable_XeMayHDB);
    jScrollPane_XeMayHDB.setBounds(0, 169, 780, 169);
    jTable_XeMayHDB.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
         tableSelectHDB = jTable_XeMayHDB;
         selectedRowHDB = tableSelectHDB.getSelectedRow();
         
         String giaNhap = jTable_XeMayHDB.getValueAt(selectedRowHDB, 3)+"";
          giaNhap = giaNhap.replaceAll(",", "");
         jTextField_giaBan.setText(giaNhap);
    }
  });

  jTable_XeMayHDB.getColumnModel().getColumn(11).setResizable(false);
  jTable_XeMayHDB.getColumnModel().getColumn(11).setPreferredWidth(0);
  jTable_XeMayHDB.getColumnModel().getColumn(11).setMinWidth(0);
  jTable_XeMayHDB.getColumnModel().getColumn(11).setMaxWidth(0);

  jTable_XeMayHDB.getColumnModel().getColumn(12).setResizable(false);
  jTable_XeMayHDB.getColumnModel().getColumn(12).setPreferredWidth(0);
  jTable_XeMayHDB.getColumnModel().getColumn(12).setMinWidth(0);
  jTable_XeMayHDB.getColumnModel().getColumn(12).setMaxWidth(0);

  jTable_XeMayHDB.getColumnModel().getColumn(13).setResizable(false);
  jTable_XeMayHDB.getColumnModel().getColumn(13).setPreferredWidth(0);
  jTable_XeMayHDB.getColumnModel().getColumn(13).setMinWidth(0);
  jTable_XeMayHDB.getColumnModel().getColumn(13).setMaxWidth(0);



    jTable_XeMayCTHDB = new JTable();
    tableModel_XeMayCTHDB = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ BÁN", "LOẠI XE", "MÀU XE", "HÃNG XE", "SỐ KHUNG", "DUNG TÍCH", "THỜI GIAN BH", "MÃ HÃNG", "MÃ LOẠI", "MÃ MÀU", "SỐ LƯỢNG", "TỔNG"} );
    jTable_XeMayCTHDB = new JTable(tableModel_XeMayCTHDB);
    jScrollPane_XeMayCTHDB = new JScrollPane(jTable_XeMayCTHDB);
    jScrollPane_XeMayCTHDB.setBounds(0, 402, 1234, 150);
    jTable_XeMayCTHDB.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
         tableSelectCTHDB = jTable_XeMayCTHDB;
         selectedRowCTHDB = tableSelectCTHDB.getSelectedRow();
    }
  });




    jTable_XeMayCTHDB.getColumnModel().getColumn(10).setResizable(false);
    jTable_XeMayCTHDB.getColumnModel().getColumn(10).setPreferredWidth(0);
    jTable_XeMayCTHDB.getColumnModel().getColumn(10).setMinWidth(0);
    jTable_XeMayCTHDB.getColumnModel().getColumn(10).setMaxWidth(0);

    jTable_XeMayCTHDB.getColumnModel().getColumn(11).setResizable(false);
    jTable_XeMayCTHDB.getColumnModel().getColumn(11).setPreferredWidth(0);
    jTable_XeMayCTHDB.getColumnModel().getColumn(11).setMinWidth(0);
    jTable_XeMayCTHDB.getColumnModel().getColumn(11).setMaxWidth(0);

    jTable_XeMayCTHDB.getColumnModel().getColumn(12).setResizable(false);
    jTable_XeMayCTHDB.getColumnModel().getColumn(12).setPreferredWidth(0);
    jTable_XeMayCTHDB.getColumnModel().getColumn(12).setMinWidth(0);
    jTable_XeMayCTHDB.getColumnModel().getColumn(12).setMaxWidth(0);


//------------------------------------------------------------------------------------------------------------
    ImageIcon Icon_timKiem = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));
    jButton_timKiemXeMayHDB = new JButton("TÌM KIẾM");
    jButton_timKiemXeMayHDB.setFont(font_HDB);
    jButton_timKiemXeMayHDB.setIcon(Icon_timKiem);
    jButton_timKiemXeMayHDB.setBounds(325, 106, 136, 41);    
    jButton_timKiemXeMayHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       findXeMay(evt);
      }
  });     
    

    ImageIcon Icon_them = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
    jButton_themVaoCTHDB = new JButton("THÊM");
    jButton_themVaoCTHDB.setFont(font_HDB);
    jButton_themVaoCTHDB.setIcon(Icon_them);
    jButton_themVaoCTHDB.setBounds(800, 238, 136, 41);
    jButton_themVaoCTHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addCTHDB(evt);
      }
  });     
    
    ImageIcon Icon_reset = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
    jButton_resetXeMayHDB = new JButton("RESET");
    jButton_resetXeMayHDB.setFont(font_HDB);
    jButton_resetXeMayHDB.setIcon(Icon_reset);
    jButton_resetXeMayHDB.setBounds(800, 297, 136, 41); 
    jButton_resetXeMayHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetHDB();
      }
  });     
       

    
    jButton_timKiemKhachHangHDB = new JButton("TÌM KIẾM");
    jButton_timKiemKhachHangHDB.setFont(font_HDB);
    jButton_timKiemKhachHangHDB.setIcon(Icon_timKiem);
    jButton_timKiemKhachHangHDB.setBounds(1253, 53, 136, 41); 
    jButton_timKiemKhachHangHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       findKhachHang(evt);
      }
  });     

    
    jButton_themKhachHangHDB = new JButton("KH");
    jButton_themKhachHangHDB.setFont(font_HDB);
    jButton_themKhachHangHDB.setIcon(Icon_them);
    jButton_themKhachHangHDB.setBounds(1080, 106, 136, 41);
    jButton_themKhachHangHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         init_KhachHang(evt);
      }
  }); 
    
    jButton_resetKhachHangHDB = new JButton("RESET");
    jButton_resetKhachHangHDB.setFont(font_HDB);
    jButton_resetKhachHangHDB.setIcon(Icon_reset);
    jButton_resetKhachHangHDB.setBounds(1253, 106, 136, 41); 
    jButton_resetKhachHangHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetKH();
      }
  }); 
    
    jButton_resetCTHDB = new JButton("RESET");
    jButton_resetCTHDB.setFont(font_HDB);
    jButton_resetCTHDB.setIcon(Icon_reset);
    jButton_resetCTHDB.setBounds(1253, 402, 136, 41); 
    jButton_resetCTHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         resetCTHDB();
      }
  }); 
    
    ImageIcon Icon_delete = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
    jButton_xoaCTHDB = new JButton("XÓA");
    jButton_xoaCTHDB.setFont(font_HDB);
    jButton_xoaCTHDB.setIcon(Icon_delete);
    jButton_xoaCTHDB.setBounds(1253, 480, 136, 41); 
    jButton_xoaCTHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteCTHD(evt);
      }
  }); 
    
    ImageIcon Icon_ban = new javax.swing.ImageIcon(getClass().getResource("/IMG/ban.png"));
    jButton_banHang = new JButton("BÁN");
    jButton_banHang.setFont(font_HDB);
    jButton_banHang.setIcon(Icon_ban);
    jButton_banHang.setBounds(1253, 558, 136, 41); 
    jButton_banHang.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       banHang(evt);
      }
  }); 
    

    JLabel jLabel_tongTien = new JLabel("TỔNG TIỀN:");
    jLabel_tongTien.setFont(font_tieuDe3);
    jLabel_tongTien.setBounds(810, 558, 136, 41); 
    
    jTextField_tongTien = new JTextField("0");
    jTextField_tongTien.setFont(font_tieuDe3);
    jTextField_tongTien.setEditable(false);
    jTextField_tongTien.setBackground(Color.LIGHT_GRAY);
    jTextField_tongTien.setBounds(930, 558, 300, 41); 
    
     jLabel_maKH = new JLabel("");
    jLabel_maKH.setFont(font_HDB);
    jLabel_maKH.setBounds(1090, 198, 293, 16);

    jLabel_tenKH = new JLabel("");
    jLabel_tenKH.setFont(font_HDB);
    jLabel_tenKH.setBounds(1090, 230, 293, 16);

    jLabel_gioiTinh = new JLabel("");
    jLabel_gioiTinh.setFont(font_HDB);
    jLabel_gioiTinh.setBounds(1090, 261, 293, 16);

    jLabel_sDT = new JLabel("");
    jLabel_sDT.setFont(font_HDB);
    jLabel_sDT.setBounds(1090, 292, 293, 16);

    jLabel_diaChi = new JLabel("");
    jLabel_diaChi.setFont(font_HDB);
    jLabel_diaChi.setBounds(1090, 323, 293, 16);

    
    
    this.setBackground(new java.awt.Color(204, 255, 255));
        this.setLayout(null);
        this.add(jLabel_timKiemXeMay);
        this.add(jLabel_timKiem);
        this.add(jLabel_timKiemTheo);
        this.add(jLabel_khachHang);
        this.add(jLabel_nhapMaKhachHang);
        this.add(jLabel_thongTinKhachHang);
        this.add(jLabel_textMaKhachHang);
        this.add(jLabel_textTenKhachHang);
        this.add(jLabel_textSoDienThoai);
        this.add(jLabel_textDiaChi);
        this.add(jLabel_chiTietXeMay);
        this.add(jTextField_timKiemXeMay);
        this.add(jTextField_timKiemKhachHang);
        this.add(comboBox_timKiemTheoXeHDB);
        this.add(jScrollPane_XeMayHDB);
        this.add(jScrollPane_XeMayCTHDB);
        this.add(jButton_timKiemXeMayHDB);
        this.add(jButton_themVaoCTHDB);
        this.add(jButton_resetXeMayHDB);
        this.add(jButton_timKiemKhachHangHDB);

        this.add(jButton_themKhachHangHDB);
        this.add(jButton_resetKhachHangHDB);
        // this.add(jButton_resetCTHDB);
        this.add(jButton_xoaCTHDB);
        this.add(jButton_banHang);

        this.add(jLabel_soLuong);
        this.add(jTextField_soLuong);
        this.add(jTextField_tongTien);
        this.add(jLabel_tongTien);
        this.add(jLabel_textgioiTinh);

        this.add(jLabel_maKH);
        this.add(jLabel_tenKH);
        this.add(jLabel_gioiTinh);
        this.add(jLabel_sDT);
        this.add(jLabel_diaChi);
        this.add(jLabel_giaBan);
        this.add(jTextField_giaBan);
        
    }
    
    public void loadAllXeMayHDB ()
   {
    tableModel_XeMayHDB.setRowCount(0);
    loadXeMayLenTableHDB(arrXeHDB);

   }








   public void loadXeMayLenTableHDB (ArrayList<XE_MAY_DTO> arrXe)
   {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    for (int i = 0; i<arrXe.size(); i++)
      {
        
        XE_MAY_DTO xe_MAY_DTO = arrXe.get(i);
        Object[] newrow = {i+1,xe_MAY_DTO.getMA_XE(), xe_MAY_DTO.getTEN_XE(),decimalFormat.format( xe_MAY_DTO.getGIA()), xe_MAY_DTO.getTEN_LOAI_XE(), xe_MAY_DTO.getTEN_MAU(), xe_MAY_DTO.getTEN_HANG(), xe_MAY_DTO.getSO_KHUNG(), xe_MAY_DTO.getDUNG_TICH(), xe_MAY_DTO.getTON_KHO(), xe_MAY_DTO.getTHOI_GIAN_BH(), xe_MAY_DTO.getMA_HANG(), xe_MAY_DTO.getMA_LOAI(),xe_MAY_DTO.getMA_MAU()};
        tableModel_XeMayHDB.addRow(newrow);
      }
   }


   public void findKhachHang (java.awt.event.ActionEvent evt)
   {
     if (jTextField_timKiemKhachHang.getText().equals(""))
     {
      JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng!");
     }
     else if (check1.checkMaKH(jTextField_timKiemKhachHang.getText().toUpperCase().trim(), "MKH") == false)
     {
      JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng (VD:MKH54123)!");
     }
    else 
    {
      ArrayList<KHACH_HANG_DTO> arrKH = new ArrayList<KHACH_HANG_DTO>();
       arrKH = hoa_DON_BAN_BUS.findKhachHang(jTextField_timKiemKhachHang.getText().toUpperCase().trim());
       if (arrKH.size() == 0)
       {
        JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại, vui lòng thêm khách hàng mới!");
        jLabel_maKH.setText("");
        jLabel_tenKH.setText("");
        jLabel_gioiTinh.setText("");
        jLabel_sDT.setText( "");
        jLabel_diaChi.setText("");
       }
       else 
       {
          jLabel_maKH.setText(arrKH.get(0).getMA_KH());
          jLabel_tenKH.setText(arrKH.get(0).getTEN_KH());
          jLabel_gioiTinh.setText(arrKH.get(0).getGioitinh());
          jLabel_sDT.setText("0" + Integer.toString(+arrKH.get(0).getSDT()) );
          jLabel_diaChi.setText(arrKH.get(0).getDIA_CHI());
       }

    }
     
   }

   public void banHang (java.awt.event.ActionEvent evt)
   {
    if (arrXeCTHDB.size() == 0)
    {
      JOptionPane.showMessageDialog(this, "Chi tiết hóa đơn trống!");
    }
    else if (jLabel_maKH.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Thông tin khách hàng trống!");
    }else 
    {
      for (int i = 0; i<arrXeHDB.size(); i++)
        {
          if (xe_MAY_BUS.checkMaXe(arrXeHDB.get(i).getMA_XE().trim()))
          {
            xe_MAY_BUS.capNhatSoLuongXeMay(arrXeHDB.get(i).getMA_XE().trim(), arrXeHDB.get(i).getTON_KHO());
          }
          
        }
        nhapVaoHDB();
        resetHDB();
        arrXeCTHDB.removeAll(arrXeCTHDB);
        resetCTHDB();
        tongTien();






    }
   }


   public void nhapVaoHDB ()
   {
    String maHDB = "";
    while (true) {
      maHDB = check1.Ma_generateRandomCode("HDB");
      if (hoa_DON_BAN_BUS.checkMaHDB(maHDB) == false ){
        break;
        }
    }

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String strDate = formatter.format(date);

    HOA_DON_BAN_DTO hoa_DON_BAN_DTO = new HOA_DON_BAN_DTO();
    hoa_DON_BAN_DTO.setMA_HDB(maHDB.trim());
    hoa_DON_BAN_DTO.setMA_NV(Login_GUI.id_user);
    hoa_DON_BAN_DTO.setMA_KH(jLabel_maKH.getText().trim());
    hoa_DON_BAN_DTO.setNGAY_LAP(strDate);
    long tongTien = Long.parseLong(jTextField_tongTien.getText().trim().replaceAll(",", ""));
    hoa_DON_BAN_DTO.setTHANH_TOAN(tongTien);
    hoa_DON_BAN_BUS.addHDB(hoa_DON_BAN_DTO);
     nhapVaoCTHDB(maHDB);

     JOptionPane.showMessageDialog(this, "Bán hàng thành công (Mã HDN:" + maHDB  +")!");
     resetKH();




   }

   public void nhapVaoCTHDB (String maHDB)
   {
    for (int i= 0; i<arrXeCTHDB.size(); i++)
    {
      String maCTHDB = "";
       while (true) {
        maCTHDB = check1.Ma_generateRandomCode("CTHDB");
      if (ct_HOA_DON_BAN_BUS.checkMaCTHDB(maCTHDB) == false ){
        break;
        }
      }
      CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO = new CT_HOA_DON_BAN_DTO();
      ct_HOA_DON_BAN_DTO.setMA_CTHDB(maCTHDB.trim());
      ct_HOA_DON_BAN_DTO.setMA_HDB(maHDB.trim());
      ct_HOA_DON_BAN_DTO.setMA_XE(arrXeCTHDB.get(i).getMA_XE().trim());
      ct_HOA_DON_BAN_DTO.setSO_LUONG(arrXeCTHDB.get(i).getTON_KHO());
      ct_HOA_DON_BAN_DTO.setGIA_NHAP(arrXeCTHDB.get(i).getGIA());
      ct_HOA_DON_BAN_DTO.setGIA(arrXeCTHDB.get(i).getTONG_TIEN());
      ct_HOA_DON_BAN_BUS.addCTHDB(ct_HOA_DON_BAN_DTO);
    }
   }



   public void loadXeMayCTHDB()
   {
    tableModel_XeMayCTHDB.setRowCount(0);
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    for (int i = 0; i<arrXeCTHDB.size(); i++)
      {
        
        XE_MAY_DTO xe_MAY_DTO = arrXeCTHDB.get(i);
        Object [] newrow = {i+1, xe_MAY_DTO.getMA_XE(), xe_MAY_DTO.getTEN_XE(), decimalFormat.format( xe_MAY_DTO.getGIA()), xe_MAY_DTO.getTEN_LOAI_XE(), xe_MAY_DTO.getTEN_MAU(), xe_MAY_DTO.getTEN_HANG(), xe_MAY_DTO.getSO_KHUNG(), xe_MAY_DTO.getDUNG_TICH(), xe_MAY_DTO.getTHOI_GIAN_BH(), xe_MAY_DTO.getMA_HANG(), xe_MAY_DTO.getMA_LOAI(), xe_MAY_DTO.getMA_MAU(), xe_MAY_DTO.getTON_KHO(), decimalFormat.format( xe_MAY_DTO.getTONG_TIEN())};

        tableModel_XeMayCTHDB.addRow(newrow);
      }
   }


   public void resetKH ()
   {
          jLabel_maKH.setText("");
          jLabel_tenKH.setText("");
          jLabel_gioiTinh.setText("");
          jLabel_sDT.setText( "");
          jLabel_diaChi.setText("");
          jTextField_timKiemKhachHang.setText("");
   }

   public void deleteCTHD(java.awt.event.ActionEvent evt)
   {
      if (jTable_XeMayCTHDB.getSelectedRow() == -1)
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn xe để xóa !");
      }
      else 
      {
        String maXe = jTable_XeMayCTHDB.getValueAt(selectedRowCTHDB, 1)+"";
        for (int i = 0; i< arrXeCTHDB.size(); i++)
        {
          if (arrXeCTHDB.get(i).getMA_XE().trim().equals(maXe.trim()))
          {
            for (int j = 0; j<arrXeHDB.size(); j++)
            {
              if (arrXeHDB.get(j).getMA_XE().trim().equals(maXe.trim()))
              {
                arrXeHDB.get(j).setTON_KHO(arrXeHDB.get(j).getTON_KHO() +arrXeCTHDB.get(i).getTON_KHO());
              }
            }
            arrXeCTHDB.remove(arrXeCTHDB.get(i));
            resetHDB();
            loadXeMayCTHDB();
            tongTien();
          }
        }



      }
   
    }



   public void tongTien ()
   {
    long tongTienHDN = 0; 
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    for (int i = 0; i < arrXeCTHDB.size(); i++)
     {
       tongTienHDN += arrXeCTHDB.get(i).getTONG_TIEN();
     }
     jTextField_tongTien.setText(decimalFormat.format(tongTienHDN));
   }

   
   public void resetHDB()
   {
      loadAllXeMayHDB();
      jTextField_soLuong.setText("");
      jTextField_timKiemXeMay.setText("");
      jTextField_giaBan.setText("");
      comboBox_timKiemTheoXeHDB.setSelectedIndex(0);
   }

   public void resetCTHDB()
   {
      loadXeMayCTHDB();
      
   }


   
   public void addCTHDB (java.awt.event.ActionEvent evt)   // add vào arraylistCTHD
   {
    if(jTable_XeMayHDB.getSelectedRow()  == -1)
    {
      JOptionPane.showMessageDialog(this, "Vui lòng chọn xe !");
     
    }
    else if (jTextField_soLuong.getText().equals("") ||jTextField_giaBan.getText().equals("") )
    {
      JOptionPane.showMessageDialog(this, "Không được để trống !");
    }
    else if (check1.checkSoLuong(jTextField_soLuong.getText().trim()) == false)
    {
      JOptionPane.showMessageDialog(this, "Số lượng phải là số !");
    }
    else if (check1.checkGiaNhap(jTextField_giaBan.getText().trim()) == false)
    {
      JOptionPane.showMessageDialog(this, "Giá phải là số và >=4");
    }

  else 
    {  
     int  tonKho = Integer.parseInt(jTable_XeMayHDB.getValueAt(selectedRowHDB, 9)+"");
     int  soLuong =  Integer.parseInt(jTextField_soLuong.getText().trim());
          if ( soLuong > tonKho)
          {
            JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ");
          } 
          else 
          {
            String maXe =  jTable_XeMayHDB.getValueAt(selectedRowHDB, 1)+"";
            Boolean flag = true;
            for (int i = 0; i<arrXeCTHDB.size(); i++)
            {
              if (arrXeCTHDB.get(i).getMA_XE().trim().equals(maXe) && arrXeCTHDB.get(i).getGIA() == Integer.parseInt(jTextField_giaBan.getText().trim()) )
              {
                arrXeCTHDB.get(i).setTON_KHO( arrXeCTHDB.get(i).getTON_KHO() + soLuong);
                arrXeCTHDB.get(i).setTONG_TIEN( arrXeCTHDB.get(i).getGIA() *arrXeCTHDB.get(i).getTON_KHO() );
               
                flag = false;
                
              }
            }  
            
            if (flag == true)
            {
              XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();

              xe_MAY_DTO.setMA_XE(maXe.trim());
              xe_MAY_DTO.setTEN_XE((jTable_XeMayHDB.getValueAt(selectedRowHDB, 2)+"").trim());
              
              // String gia = jTable_XeMayHDB.getValueAt(selectedRowHDB, 3)+"";
              // gia = gia.replaceAll(",", "");
              xe_MAY_DTO.setGIA(Long.parseLong( jTextField_giaBan.getText().trim()) );
              
              xe_MAY_DTO.setSO_KHUNG((jTable_XeMayHDB.getValueAt(selectedRowHDB, 7)+"").toUpperCase().trim());
              xe_MAY_DTO.setDUNG_TICH((jTable_XeMayHDB.getValueAt(selectedRowHDB, 8)+"").toUpperCase().trim());
              xe_MAY_DTO.setMA_MAU((jTable_XeMayHDB.getValueAt(selectedRowHDB, 13)+"").trim());
              xe_MAY_DTO.setTEN_MAU((jTable_XeMayHDB.getValueAt(selectedRowHDB, 5)+"").trim());
              xe_MAY_DTO.setMA_LOAI((jTable_XeMayHDB.getValueAt(selectedRowHDB, 12)+"").trim());
              xe_MAY_DTO.setTEN_LOAI_XE((jTable_XeMayHDB.getValueAt(selectedRowHDB, 4)+"").trim());
              xe_MAY_DTO.setMA_HANG((jTable_XeMayHDB.getValueAt(selectedRowHDB, 11)+"").trim());
              xe_MAY_DTO.setTEN_HANG((jTable_XeMayHDB.getValueAt(selectedRowHDB, 6)+"").trim());
              xe_MAY_DTO.setTON_KHO(soLuong);
              xe_MAY_DTO.setTHOI_GIAN_BH((jTable_XeMayHDB.getValueAt(selectedRowHDB, 10)+"").trim());
              xe_MAY_DTO.setTONG_TIEN(xe_MAY_DTO.getTON_KHO()*xe_MAY_DTO.getGIA());
              arrXeCTHDB.add(xe_MAY_DTO);

              
            }
           
            for (int i = 0; i< arrXeHDB.size(); i++)
              {
                if (arrXeHDB.get(i).getMA_XE().trim().equals(maXe.trim()))
                {
                  arrXeHDB.get(i).setTON_KHO(arrXeHDB.get(i).getTON_KHO() - soLuong);
                }
              }
              
              resetHDB();
              tongTien();
              loadXeMayCTHDB();

          
          }
    
  
  
  
  }





}

    
    public void init_KhachHang(java.awt.event.ActionEvent evt)
    {
      KHACH_HANG_GUI khach_HANG_GUI = new KHACH_HANG_GUI();

    }
    
    public void findXeMay (java.awt.event.ActionEvent evt)
  {
    String selectedItem = (String)comboBox_timKiemTheoXeHDB.getSelectedItem();
   
    if (selectedItem.equals("Mã xe"))
    {
      if (jTextField_timKiemXeMay.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else if (check1.checkMa(jTextField_timKiemXeMay.getText().trim(), "MX")  )
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiemXeMay.getText().trim(), "MA_XE");
        if (data.size() == 0)
        {
          JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
        }
        else 
        {
          tableModel_XeMayHDB.setRowCount(0);
           loadXeMayLenTableHDB(data);
        }
      } 
      else
       {
        JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng địng dạng mã xe (VD : MX58421) !");
       }
    }

    else if (selectedItem.equals("Tên xe"))
    {
      if (jTextField_timKiemXeMay.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiemXeMay.getText().trim(), "TEN_XE");
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
      }
      else 
      {
        tableModel_XeMayHDB.setRowCount(0);
         loadXeMayLenTableHDB(data);
      }
      }
    }

    else if (selectedItem.equals("Giá"))
    {
      if (jTextField_timKiemXeMay.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else if (check1.checkGiaNhap(jTextField_timKiemXeMay.getText().trim()) == false)
      {
        JOptionPane.showMessageDialog(this,"Giá phải là số !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiemXeMay.getText().trim(), "GIA");
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
      }
      else 
      {
        tableModel_XeMayHDB.setRowCount(0);
         loadXeMayLenTableHDB(data);
      }
      }
    }

    else if (selectedItem.equals("Loại xe"))
    {
      if (jTextField_timKiemXeMay.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  arrXeMay = xe_MAY_BUS.getAllXeMay();
        ArrayList<XE_MAY_DTO>  data = new ArrayList<XE_MAY_DTO>();
        for (int i = 0; i<arrXeMay.size(); i++)
        {
          if (arrXeMay.get(i).getTEN_LOAI_XE().toUpperCase().trim().equals(jTextField_timKiemXeMay.getText().toUpperCase().trim()))
          {
            data.add(arrXeMay.get(i));
          }
        }
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy loại xe này !");
      }
      else 
      {
        tableModel_XeMayHDB.setRowCount(0);
         loadXeMayLenTableHDB(data);
      }
      }
    }

    else if (selectedItem.equals("Hãng xe"))
    {
      if (jTextField_timKiemXeMay.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  arrXeMay = xe_MAY_BUS.getAllXeMay();
        ArrayList<XE_MAY_DTO>  data = new ArrayList<XE_MAY_DTO>();
        for (int i = 0; i<arrXeMay.size(); i++)
        {
          if (arrXeMay.get(i).getTEN_HANG().toUpperCase().trim().equals(jTextField_timKiemXeMay.getText().toUpperCase().trim()))
          {
            data.add(arrXeMay.get(i));
          }
        }
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy hãng xe này !");
      }
      else 
      {
        tableModel_XeMayHDB.setRowCount(0);
         loadXeMayLenTableHDB(data);
      }
      }
    }
  } 


    public class NonEditableTableModel extends DefaultTableModel {
  
        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
          super(data, columnNames);
        }
        @Override
        public boolean isCellEditable(int row, int column) {
          return false; // không cho phép sửa đổi các ô trong bảng
        }
      }



}

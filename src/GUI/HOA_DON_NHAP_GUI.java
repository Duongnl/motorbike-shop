package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import BUS.CT_HOA_DON_NHAP_BUS;
import BUS.HANG_XE_BUS;
import BUS.HOA_DON_NHAP_BUS;
import BUS.LOAI_XE_BUS;
import BUS.MAU_XE_BUS;
import BUS.XE_MAY_BUS;
import BUS.XeDaXoa_BUS;
import CHECK.Check1;
import DTO.CT_HOA_DON_NHAP_DTO;
import DTO.HANG_XE_DTO;
import DTO.HOA_DON_NHAP_DTO;
import DTO.LOAI_XE_DTO;
import DTO.MAU_XE_DTO;
import DTO.XE_MAY_DTO;
import Import.ImportCTHDN_Excel;

public class HOA_DON_NHAP_GUI extends JPanel {
    
    private JTable jTable_HDN;
    private NonEditableTableModel tableModel_HDN;
    private JScrollPane jScrollPane_HDN;
    private JTextField jTextField_tenXeHDN;
    private JTextField jTextField_giaBanHDN;
    private JTextField jTextField_soKhungHDN;
    private JTextField jTextField_dungTichHDN;
    private JComboBox<MAU_XE_DTO> comboBox_mauXeHDN;
    private JComboBox<LOAI_XE_DTO> comboBox_LoaiXeHDN;
    private JComboBox <HANG_XE_DTO>comboBox_hangSXHDN;
    private JTextField jTextField_soLuong;
    private JTextField jTextField_TGBHHDN;
    private JTextField jTextField_nhapMaXe;
    private JTextField jTextField_tongTien;
    private JComboBox <XE_MAY_DTO> comboBox_ChonXe;
    private JButton jButton_resetXeHDN;
    private JButton jButton_timKiemHDN;
    private JButton jButton_themXeHDN;
    private JButton jButton_suaXeHDN;
    private JButton jButton_xoaXeHDN;
    // private JButton jButton_nhapXeTuExcelHDN;
    private JButton jButton_nhapXeHDN;
    private Check1 check1 = new Check1();
    private XE_MAY_BUS xe_MAY_BUS = new XE_MAY_BUS();
    private HANG_XE_BUS hang_XE_BUS = new HANG_XE_BUS();
    private LOAI_XE_BUS loai_XE_BUS = new LOAI_XE_BUS();
    private MAU_XE_BUS mau_XE_BUS = new MAU_XE_BUS();
    private ImportCTHDN_Excel importCTHDN_Excel = new ImportCTHDN_Excel();
    private HOA_DON_NHAP_BUS hoa_DON_NHAP_BUS = new HOA_DON_NHAP_BUS();
    private CT_HOA_DON_NHAP_BUS ct_HOA_DON_NHAP_BUS = new CT_HOA_DON_NHAP_BUS();
    private ArrayList<XE_MAY_DTO> arrXeMay = new ArrayList<XE_MAY_DTO>();
    private String maXe;
    private HANG_XE_DTO selectedHangXe;
    private MAU_XE_DTO selectedMauXe;
    private LOAI_XE_DTO selectedLoaiXe;
    private XE_MAY_DTO selectedXeMay;
    
    private JTextField jTextField_maXeHDN;
    private JTextField jTextField_giaNhapXe;
    // private JTextField jTextField_fileExcel;

    public HOA_DON_NHAP_GUI ()
    {
        init_HoaDonNhap();
        loadKhoaNgoaiHDN();
    }

    public void init_HoaDonNhap ()
    {
       // Table xe máy
    jTable_HDN = new JTable();
    tableModel_HDN = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ NHẬP" ,"GIÁ BÁN", "LOẠI XE", "MÀU XE", "HÃNG XE", "SỐ KHUNG", "DUNG TÍCH", "THỜI GIAN BH", "MÃ HÃNG", "MÃ LOẠI", "MÃ MÀU", "SỐ LƯỢNG", "TỔNG"} );
    jTable_HDN = new JTable(tableModel_HDN);
    jScrollPane_HDN = new JScrollPane(jTable_HDN);
    jScrollPane_HDN.setBounds(0, 47, 1400, 201);
    jTable_HDN.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
        JTable tableSelect = jTable_HDN;
        int selectedRow = tableSelect.getSelectedRow();
        
        moKhoaAll();
        for (int i = 0; i < comboBox_ChonXe.getItemCount(); i++) {     
          if (((XE_MAY_DTO) comboBox_ChonXe.getItemAt(i)).getMA_XE().equals(jTable_HDN.getValueAt(selectedRow, 1))) {
           KhoaAll();
          }
        }
        
         
        jTextField_maXeHDN.setText(jTable_HDN.getValueAt(selectedRow, 1)+"");
        
        jTextField_tenXeHDN.setText(jTable_HDN.getValueAt(selectedRow, 2)+"");

        String giaNhap = jTable_HDN.getValueAt(selectedRow, 3)+"";
        giaNhap = giaNhap.replaceAll(",", "");
        jTextField_giaNhapXe.setText(giaNhap);



        
        String gia = jTable_HDN.getValueAt(selectedRow, 4)+"";
        gia = gia.replaceAll(",", "");
        jTextField_giaBanHDN.setText(gia);
        
        jTextField_soKhungHDN.setText(tableModel_HDN.getValueAt(selectedRow, 8)+"");
        jTextField_dungTichHDN.setText(tableModel_HDN.getValueAt(selectedRow, 9)+"");
        jTextField_TGBHHDN.setText(tableModel_HDN.getValueAt(selectedRow, 10)+"");
        for (int i = 0; i < comboBox_hangSXHDN.getItemCount(); i++) {
         
            if (((HANG_XE_DTO) comboBox_hangSXHDN.getItemAt(i)).getMA_HANG().equals(jTable_HDN.getValueAt(selectedRow, 11))) {
              comboBox_hangSXHDN.setSelectedIndex(i);
              System.out.println("có vào");
                break;
            }else {
              comboBox_hangSXHDN.setSelectedIndex(-1);
            }
        }

        for (int i = 0; i < comboBox_LoaiXeHDN.getItemCount(); i++) {
          if (((LOAI_XE_DTO) comboBox_LoaiXeHDN.getItemAt(i)).getMA_LOAI().equals(jTable_HDN.getValueAt(selectedRow, 12))) {
            comboBox_LoaiXeHDN.setSelectedIndex(i);
            System.out.println("có vào");
              break;
          }else {
            comboBox_LoaiXeHDN.setSelectedIndex(-1);
          }
      }

      for (int i = 0; i < comboBox_mauXeHDN.getItemCount(); i++) {
        System.out.println(jTable_HDN.getValueAt(selectedRow, 12));
       
          if (((MAU_XE_DTO) comboBox_mauXeHDN.getItemAt(i)).getMA_MAU().equals(jTable_HDN.getValueAt(selectedRow, 13))) {
            comboBox_mauXeHDN.setSelectedIndex(i);
            System.out.println("có vào");
              break;
          }else {
            comboBox_mauXeHDN.setSelectedIndex(-1);
          }
      }
        jTextField_soLuong.setText(tableModel_HDN.getValueAt(selectedRow, 14)+"");
        

       

        

       


        
       
        
        // for (int i = 0; i < comboBox_LoaiXeHDN.getItemCount(); i++) {
        //   System.out.println(jTable_HDN.getValueAt(selectedRow, 12));
        //     if (((LOAI_XE_DTO) comboBox_LoaiXeHDN.getItemAt(i)).getMA_LOAI().equals(jTable_HDN.getValueAt(selectedRow, 12))) {
        //       comboBox_LoaiXeHDN.setSelectedIndex(i);
        //       System.out.println("có vào");
        //         break;
        //     }
        // }
        
       
    
    
    }
  });



    jTable_HDN.getColumnModel().getColumn(11).setResizable(false);
    jTable_HDN.getColumnModel().getColumn(11).setPreferredWidth(0);
    jTable_HDN.getColumnModel().getColumn(11).setMinWidth(0);
    jTable_HDN.getColumnModel().getColumn(11).setMaxWidth(0);

    jTable_HDN.getColumnModel().getColumn(12).setResizable(false);
    jTable_HDN.getColumnModel().getColumn(12).setPreferredWidth(0);
    jTable_HDN.getColumnModel().getColumn(12).setMinWidth(0);
    jTable_HDN.getColumnModel().getColumn(12).setMaxWidth(0);

    jTable_HDN.getColumnModel().getColumn(13).setResizable(false);
    jTable_HDN.getColumnModel().getColumn(13).setPreferredWidth(0);
    jTable_HDN.getColumnModel().getColumn(13).setMinWidth(0);
    jTable_HDN.getColumnModel().getColumn(13).setMaxWidth(0);

    Font font_tieuDe = new Font("Arial", Font.BOLD, 18);
    Font font_xeMay = new Font("Arial", Font.BOLD, 14);

    JLabel jLabel_textCTHD = new JLabel("CHI TIẾT HÓA ĐƠN");
    jLabel_textCTHD.setFont(font_tieuDe);
    jLabel_textCTHD.setBounds(6, 7, 228, 30);

     //Text MÃ XE
     JLabel jLabel_textMaXe = new JLabel("MÃ XE:");
     jLabel_textMaXe.setFont(font_xeMay);
     jLabel_textMaXe.setBounds(10, 268, 89, 16);

      // JTextFile MÃ XE 
     jTextField_maXeHDN = new JTextField();
    jTextField_maXeHDN.setFont(font_xeMay);
    jTextField_maXeHDN.setBounds(99, 264, 270, 24);
    jTextField_maXeHDN.setText("Xe mới");
    jTextField_maXeHDN.setEditable(false);
    jTextField_maXeHDN.setBackground(Color.LIGHT_GRAY);

    // text tên xe
    JLabel jLabel_textTenXe = new JLabel("TÊN XE:");
    jLabel_textTenXe.setFont(font_xeMay);
    jLabel_textTenXe.setBounds(10, 330, 86, 16);

    
    

    // jtextfile tên xe
    jTextField_tenXeHDN = new JTextField();
    jTextField_tenXeHDN.setFont(font_xeMay);
    jTextField_tenXeHDN.setBounds(99, 324, 270, 24);

    // text giá nhập
    JLabel jLabel_textGiaBan = new JLabel("GIÁ BÁN:");
    jLabel_textGiaBan.setFont(font_xeMay);
    jLabel_textGiaBan.setBounds(10, 466, 86, 16);

    // jtextfile giá nhập 
    jTextField_giaBanHDN = new JTextField();
    jTextField_giaBanHDN.setFont(font_xeMay);
    jTextField_giaBanHDN.setBounds(99, 462, 270, 24);

    // TEXT SỐ KHUNG 
    JLabel jLabel_textSoKhung = new JLabel("SỐ KHUNG:");
    jLabel_textSoKhung.setFont(font_xeMay);
    jLabel_textSoKhung.setBounds(10, 579, 86, 16);

    // JTEXTFILE SỐ KHUNG
    jTextField_soKhungHDN = new JTextField();
    jTextField_soKhungHDN.setFont(font_xeMay);
    jTextField_soKhungHDN.setBounds(99, 575, 270, 24);

     //---------------------------------------------------------------------------------
      // jTextField_fileExcel = new JTextField();
      // jTextField_fileExcel.setFont(font_xeMay);
      // jTextField_fileExcel.setBounds(590, 575, 180, 24);
      

    // text Dung tích 
    JLabel jLabel_textDungTich = new JLabel("DUNG TÍCH:");
    jLabel_textDungTich.setFont(font_xeMay);
    jLabel_textDungTich.setBounds(10, 529, 86, 16);

    // jtextFile dung tích
    jTextField_dungTichHDN = new JTextField();
    jTextField_dungTichHDN.setFont(font_xeMay);
    jTextField_dungTichHDN.setBounds(99, 525, 270, 24);

     // text màu xe
     JLabel jLabel_textMauXe = new JLabel("MÀU XE:");
     jLabel_textMauXe.setFont(font_xeMay);
     jLabel_textMauXe.setBounds(512, 268, 86, 16);
     
     // jcombobox màu xe
     comboBox_mauXeHDN = new JComboBox<>();
     comboBox_mauXeHDN.setFont(font_xeMay);
     comboBox_mauXeHDN.setBounds(590, 264, 109, 24);

      // text loại xe 
    JLabel jLabel_textLoaiXe = new JLabel("LOẠI XE:");
    jLabel_textLoaiXe.setFont(font_xeMay);
    jLabel_textLoaiXe.setBounds( 512, 335, 86, 16);

    // jcombobox loại xe
    comboBox_LoaiXeHDN = new JComboBox<>();
    comboBox_LoaiXeHDN.setFont(font_xeMay);
    comboBox_LoaiXeHDN.setBounds(590, 331, 109, 24);

    // text hãng sản xuất
    JLabel jLabel_textHangSX = new JLabel("HÃNG SX:");
    jLabel_textHangSX.setFont(font_xeMay);
    jLabel_textHangSX.setBounds( 512, 402, 86, 16);

    // jcombobox hãng sản xuất
    comboBox_hangSXHDN = new JComboBox<>();
    comboBox_hangSXHDN.setFont(font_xeMay);
    comboBox_hangSXHDN.setBounds(590, 397, 109, 24);

    comboBox_ChonXe = new JComboBox<>();
    comboBox_ChonXe.setFont(font_xeMay);
    comboBox_ChonXe.setBounds(1054, 357, 159, 24);
    comboBox_ChonXe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chonXeMay(evt);
      }
  });
  

    // text tồn kho
    JLabel jLabel_textSoLuong = new JLabel("SỐ LƯỢNG:");
    jLabel_textSoLuong.setFont(font_xeMay);
    jLabel_textSoLuong.setBounds( 500, 466, 120, 16);

    // jtextfile tồn kho
    jTextField_soLuong = new JTextField();
    jTextField_soLuong.setFont(font_xeMay);
    jTextField_soLuong.setBounds(590, 461, 270, 24);

     // text thời gian bảo hành 
     JLabel jLabel_textTGBH = new JLabel("TG BH:");
     jLabel_textTGBH.setFont(font_xeMay);
     jLabel_textTGBH.setBounds( 512, 531, 83, 16);

    //  JLabel jLabel_textFileExcel = new JLabel("FILE EXCEL:");
    // jLabel_textFileExcel.setFont(font_xeMay);
    // jLabel_textFileExcel.setBounds( 490, 579, 200, 16);
 
     // jtextfile thời gian bảo hành 
     jTextField_TGBHHDN = new JTextField();
     jTextField_TGBHHDN.setFont(font_xeMay);
     jTextField_TGBHHDN.setBounds(590, 525, 270, 24);
 
     JLabel jLabel_textChonXeTrongKho = new JLabel("CHỌN XE ĐÃ CÓ");
     jLabel_textChonXeTrongKho.setFont(font_xeMay);
     jLabel_textChonXeTrongKho.setBounds( 1061, 260, 145, 16);

   
   
     JLabel jLabel_textGiaNhapXe = new JLabel("GIÁ NHẬP:");
     jLabel_textGiaNhapXe.setFont(font_xeMay);
     jLabel_textGiaNhapXe.setBounds(10, 397, 86, 16);
 
    
     jTextField_giaNhapXe = new JTextField();
     jTextField_giaNhapXe.setFont(font_xeMay);
     jTextField_giaNhapXe.setBounds(99, 391, 270, 24);


     JLabel jLabel_textNhapMaXe = new JLabel("NHẬP MÃ XE:");
     jLabel_textNhapMaXe.setFont(font_xeMay);
     jLabel_textNhapMaXe.setBounds( 959, 295, 100, 16);

     JLabel jLabel_textChonXe = new JLabel("CHỌN XE:");
     jLabel_textChonXe.setFont(font_xeMay);
     jLabel_textChonXe.setBounds( 977, 361, 100, 16);

     JLabel jLabel_textTongTien = new JLabel("TỔNG TIỀN:");
     jLabel_textTongTien.setFont(font_tieuDe);
     jLabel_textTongTien.setBounds( 782, 559, 128, 24);


     jTextField_nhapMaXe = new JTextField();
     jTextField_nhapMaXe.setFont(font_xeMay);
     jTextField_nhapMaXe.setBounds(1054, 291, 159, 24);

     jTextField_tongTien = new JTextField("0");
     jTextField_tongTien.setFont(font_tieuDe);
     jTextField_tongTien.setBounds(910, 548, 300, 46);
     jTextField_tongTien.setBackground(Color.LIGHT_GRAY);
     jTextField_tongTien.setEditable(false);


     
        // jbutton tim kiem
        ImageIcon Icon_timKiemXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));
        jButton_timKiemHDN = new JButton("TÌM KIẾM XE");
        jButton_timKiemHDN.setFont(font_xeMay);
        jButton_timKiemHDN.setIcon(Icon_timKiemXe);
        jButton_timKiemHDN.setBounds(1231, 282, 155, 41);
        jButton_timKiemHDN.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
       timKiemXe(evt);
      
        }
        });



     ImageIcon Icon_resetXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
     jButton_resetXeHDN = new JButton("RESET");
     jButton_resetXeHDN.setFont(font_xeMay);
     jButton_resetXeHDN.setIcon(Icon_resetXe);
     jButton_resetXeHDN.setBounds(1231, 348, 155, 42);
     jButton_resetXeHDN.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetXeMayHDN();
       }
   });


     // jbutton them
    ImageIcon Icon_themXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
    jButton_themXeHDN = new JButton("THÊM");
    jButton_themXeHDN.setFont(font_xeMay);
    jButton_themXeHDN.setIcon(Icon_themXe);
    jButton_themXeHDN.setBounds(1053, 414, 155, 42);
    jButton_themXeHDN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addXeMay(evt);
      }
  });

  // jbutton sua
  ImageIcon Icon_suaXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/edit.png"));
  jButton_suaXeHDN = new JButton("SỬA");
  jButton_suaXeHDN.setFont(font_xeMay);
  jButton_suaXeHDN.setIcon(Icon_suaXe);
  jButton_suaXeHDN.setBounds(1231, 414, 155, 42);
  jButton_suaXeHDN.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      editXeMay(evt);
    }
});

    // JBUTTON XÓA
    ImageIcon Icon_xoaXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
    jButton_xoaXeHDN = new JButton("XÓA");
    jButton_xoaXeHDN.setFont(font_xeMay);
    jButton_xoaXeHDN.setIcon(Icon_xoaXe);
    jButton_xoaXeHDN.setBounds(1053, 484, 155, 42);
    jButton_xoaXeHDN.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      deleteXeMay(evt);
    }
    });

    // //   JBUTTON NHẬP XE TỪ EXCEL
    // ImageIcon Icon_nhapXeTuExcel = new javax.swing.ImageIcon(getClass().getResource("/IMG/import.png"));
    // jButton_nhapXeTuExcelHDN = new JButton("NHẬP EXCEL");
    // jButton_nhapXeTuExcelHDN.setFont(font_xeMay);
    // jButton_nhapXeTuExcelHDN.setIcon(Icon_nhapXeTuExcel);
    // jButton_nhapXeTuExcelHDN.setBounds(1231, 484, 155, 42);
    // jButton_nhapXeTuExcelHDN.addActionListener(new java.awt.event.ActionListener() {
    //   public void actionPerformed(java.awt.event.ActionEvent evt) {
    //     ImportExcel(evt);
    //   }
    //   });

    ImageIcon Icon_nhapXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/nhap.png"));
    jButton_nhapXeHDN = new JButton("NHẬP XE");
    jButton_nhapXeHDN.setFont(font_xeMay);
    jButton_nhapXeHDN.setIcon(Icon_nhapXe);
    jButton_nhapXeHDN.setBounds(1231, 550, 155, 42);
    jButton_nhapXeHDN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       nhapHang(evt);
      }
      });
      this.setBackground(new java.awt.Color(204, 255, 255));
    
    this.setLayout(null);
    this.add(jScrollPane_HDN);
    this.add(jLabel_textCTHD);
    this.add(jLabel_textMaXe);
    this.add(jTextField_maXeHDN);
    
    this.add(jLabel_textTenXe);
    this.add(jTextField_tenXeHDN);

    this.add(jLabel_textGiaBan);
    this.add(jTextField_giaBanHDN);
    
    this.add(jLabel_textSoKhung);
    this.add(jTextField_soKhungHDN);

    this.add(jLabel_textDungTich);
    this.add(jTextField_dungTichHDN);

    this.add(jLabel_textMauXe);
    this.add(comboBox_mauXeHDN);
    
    this.add(jLabel_textLoaiXe);
    this.add(comboBox_LoaiXeHDN);

    this.add(jLabel_textHangSX);
    this.add(comboBox_hangSXHDN);

    this.add(jLabel_textSoLuong);
    this.add(jTextField_soLuong);

    this.add(jLabel_textTGBH);
    this.add(jTextField_TGBHHDN);

    this.add(jLabel_textChonXeTrongKho);
    this.add(jLabel_textNhapMaXe);
    this.add(jTextField_nhapMaXe);
    this.add(jButton_timKiemHDN);
    this.add(jLabel_textChonXe);
    this.add(comboBox_ChonXe);
    this.add(jButton_resetXeHDN);
    this.add(jLabel_textTongTien);
    this.add(jTextField_tongTien);
    this.add(jButton_themXeHDN);
    this.add(jButton_suaXeHDN);
    this.add(jButton_xoaXeHDN);
    // this.add(jButton_nhapXeTuExcelHDN);
    this.add(jButton_nhapXeHDN);
     this.add(jLabel_textGiaNhapXe);
     this.add(jTextField_giaNhapXe);
    //  this.add(jLabel_textFileExcel);
    //  this.add(jTextField_fileExcel);


    }

  


    // public void ImportExcel (java.awt.event.ActionEvent evt)
    // {
    //   if (jTextField_fileExcel.getText().equals(""))
    //   {
    //     JOptionPane.showMessageDialog(this, "Nhập tên file excel!");
    //   }else 
    //  {
    //   arrXeMay.removeAll(arrXeMay);
    //   resetXeMayHDN();
    //   arrXeMay = importCTHDN_Excel.ImportCTHDN(jTextField_fileExcel.getText().trim());
    //   if (arrXeMay == null)
    //   {
    //     JOptionPane.showMessageDialog(this, "Lỗi!");
    //   }
    //   else 
    //   {
        
    //     loadAllXeMayHDN();
    //     tongTien();
    //   }
    //  }
    // }

    public void loadKhoaNgoaiHDN()
   {
      comboBox_hangSXHDN.removeAllItems();
      ArrayList<HANG_XE_DTO> arrHangXe = new ArrayList<HANG_XE_DTO>();
      arrHangXe = hang_XE_BUS.getAllHangXe();
      for (HANG_XE_DTO hang_XE_DTO : arrHangXe){
        comboBox_hangSXHDN.addItem(hang_XE_DTO);
      }
     comboBox_mauXeHDN.removeAllItems();
     ArrayList<MAU_XE_DTO> arrMauXe = new ArrayList<MAU_XE_DTO>();
     arrMauXe = mau_XE_BUS.getAllMauXe();
     for (MAU_XE_DTO mau_XE_DTO : arrMauXe) {
       comboBox_mauXeHDN.addItem(mau_XE_DTO);
      }
     comboBox_LoaiXeHDN.removeAllItems();
      ArrayList<LOAI_XE_DTO> arrLoaiXe = new ArrayList<LOAI_XE_DTO>();
      arrLoaiXe = loai_XE_BUS.getAllLoaiXe();
      for (LOAI_XE_DTO loai_XE_DTO : arrLoaiXe) {
        comboBox_LoaiXeHDN.addItem(loai_XE_DTO);
     }
     
     comboBox_ChonXe.removeAllItems();
     ArrayList<XE_MAY_DTO> arrXe = new ArrayList<XE_MAY_DTO>();
     arrXe = xe_MAY_BUS.getAllXeMay();
     for (XE_MAY_DTO xe_MAY_DTO : arrXe) {
       comboBox_ChonXe.addItem(xe_MAY_DTO);
    }
   }

   
   public void chonXeMay (java.awt.event.ActionEvent evt)
   {
    if (comboBox_ChonXe.getSelectedIndex() != -1)
    {
        selectedXeMay = (XE_MAY_DTO) comboBox_ChonXe.getSelectedItem();
        ArrayList<XE_MAY_DTO> xeMay = new ArrayList<XE_MAY_DTO>();
        xeMay = xe_MAY_BUS.findXeMay(selectedXeMay.getMA_XE().trim(), "MA_XE");
        jTextField_maXeHDN.setText(xeMay.get(0).getMA_XE());
        jTextField_tenXeHDN.setText(xeMay.get(0).getTEN_XE());
        // jTextField_tenXeHDN.setEditable(false);
        // jTextField_tenXeHDN.setBackground(Color.LIGHT_GRAY);
        jTextField_giaBanHDN.setText(xeMay.get(0).getGIA()+"");
        // jTextField_giaBanHDN.setEditable(false);
        // jTextField_giaBanHDN.setBackground(Color.LIGHT_GRAY);
        jTextField_soKhungHDN.setText(xeMay.get(0).getSO_KHUNG());
        // jTextField_soKhungHDN.setEditable(false);
        // jTextField_soKhungHDN.setBackground(Color.LIGHT_GRAY);
        jTextField_dungTichHDN.setText(xeMay.get(0).getDUNG_TICH());
        // jTextField_dungTichHDN.setEditable(false);
        // jTextField_dungTichHDN.setBackground(Color.LIGHT_GRAY);
        jTextField_giaNhapXe.setText(xeMay.get(0).getGIA_NHAP()+"");
        
        for (int i = 0; i < comboBox_LoaiXeHDN.getItemCount(); i++) {     
            if (((LOAI_XE_DTO) comboBox_LoaiXeHDN.getItemAt(i)).getMA_LOAI().equals(xeMay.get(0).getMA_LOAI())) {
              comboBox_LoaiXeHDN.setSelectedIndex(i);
                break;
            }
            else{
              comboBox_LoaiXeHDN.setSelectedIndex(-1);
            }
        }
        comboBox_LoaiXeHDN.setEnabled(false);
        for (int i = 0; i < comboBox_hangSXHDN.getItemCount(); i++) {
            if (((HANG_XE_DTO) comboBox_hangSXHDN.getItemAt(i)).getMA_HANG().equals(xeMay.get(0).getMA_HANG())) {
              comboBox_hangSXHDN.setSelectedIndex(i);
                break;
            }
            else {
              comboBox_hangSXHDN.setSelectedIndex(-1);
            }
        }
        comboBox_hangSXHDN.setEnabled(false);
        
        for (int i = 0; i < comboBox_mauXeHDN.getItemCount(); i++) {
            if (((MAU_XE_DTO) comboBox_mauXeHDN.getItemAt(i)).getMA_MAU().equals(xeMay.get(0).getMA_MAU())) {
              comboBox_mauXeHDN.setSelectedIndex(i);
                break;
            }
            else{
              comboBox_mauXeHDN.setSelectedIndex(-1);
            }
        }
        // comboBox_mauXeHDN.setEnabled(false);
        
        jTextField_soLuong.setText("");
        jTextField_TGBHHDN.setText(xeMay.get(0).getTHOI_GIAN_BH());
        // jTextField_TGBHHDN.setEditable(false);
        // jTextField_TGBHHDN.setBackground(Color.LIGHT_GRAY);
        KhoaAll();
      }
   }



   public void loadAllXeMayHDN ()
   {
      tableModel_HDN.setRowCount(0);
      DecimalFormat decimalFormat = new DecimalFormat("###,###");
      for (int i = 0; i< arrXeMay.size(); i++)
      {
        XE_MAY_DTO xe_MAY_DTO = arrXeMay.get(i);
        Object [] newrow = {i+1, xe_MAY_DTO.getMA_XE(), xe_MAY_DTO.getTEN_XE(), decimalFormat.format( xe_MAY_DTO.getGIA_NHAP()) ,decimalFormat.format( xe_MAY_DTO.getGIA()), xe_MAY_DTO.getTEN_LOAI_XE(), xe_MAY_DTO.getTEN_MAU(), xe_MAY_DTO.getTEN_HANG(), xe_MAY_DTO.getSO_KHUNG(), xe_MAY_DTO.getDUNG_TICH(), xe_MAY_DTO.getTHOI_GIAN_BH(), xe_MAY_DTO.getMA_HANG(), xe_MAY_DTO.getMA_LOAI(), xe_MAY_DTO.getMA_MAU(), xe_MAY_DTO.getTON_KHO(), decimalFormat.format( xe_MAY_DTO.getTONG_TIEN())};
         tableModel_HDN.addRow(newrow);
      }
   }

   public void moKhoaAll ()
   {
    jTextField_tenXeHDN.setEditable(true);
    jTextField_giaBanHDN.setEditable(true);
    jTextField_soKhungHDN.setEditable(true);
    jTextField_dungTichHDN.setEditable(true);
    jTextField_TGBHHDN.setEditable(true);
    jTextField_giaNhapXe.setEditable(true);
    comboBox_LoaiXeHDN.setEnabled(true);
    comboBox_hangSXHDN.setEnabled(true);
    comboBox_mauXeHDN.setEnabled(true);
    
    jTextField_tenXeHDN.setBackground(Color.WHITE); 
     jTextField_giaBanHDN.setBackground(Color.WHITE);
     jTextField_giaNhapXe.setBackground(Color.WHITE);
     jTextField_soKhungHDN.setBackground(Color.WHITE);
     jTextField_dungTichHDN.setBackground(Color.WHITE);
     jTextField_TGBHHDN.setBackground(Color.WHITE);
   }

   public void KhoaAll ()
   {
    jTextField_tenXeHDN.setEditable(false);
    jTextField_giaBanHDN.setEditable(false);
    jTextField_giaNhapXe.setEditable(false);
    jTextField_soKhungHDN.setEditable(false);
    jTextField_dungTichHDN.setEditable(false);
    jTextField_TGBHHDN.setEditable(false);
    comboBox_LoaiXeHDN.setEnabled(false);
    comboBox_hangSXHDN.setEnabled(false);
    comboBox_mauXeHDN.setEnabled(false);
    
     jTextField_tenXeHDN.setBackground(Color.LIGHT_GRAY); 
     jTextField_giaBanHDN.setBackground(Color.LIGHT_GRAY);
     jTextField_giaNhapXe.setBackground(Color.LIGHT_GRAY);
     jTextField_soKhungHDN.setBackground(Color.LIGHT_GRAY);
     jTextField_dungTichHDN.setBackground(Color.LIGHT_GRAY);
     jTextField_TGBHHDN.setBackground(Color.LIGHT_GRAY);
   }

   public void resetXeMayHDN()
   {
    System.out.println("CÓ vào");
    moKhoaAll();
    // jTextField_tenXeHDN.setEditable(true);
    // jTextField_giaBanHDN.setEditable(true);
    // jTextField_soKhungHDN.setEditable(true);
    // jTextField_dungTichHDN.setEditable(true);
    // jTextField_TGBHHDN.setEditable(true);
    // comboBox_LoaiXeHDN.setEnabled(true);
    // comboBox_hangSXHDN.setEnabled(true);
    // comboBox_mauXeHDN.setEnabled(true);
    
    // jTextField_tenXeHDN.setBackground(Color.WHITE); 
    //  jTextField_giaBanHDN.setBackground(Color.WHITE);
    //  jTextField_soKhungHDN.setBackground(Color.WHITE);
    //  jTextField_dungTichHDN.setBackground(Color.WHITE);
    //  jTextField_TGBHHDN.setBackground(Color.WHITE);
     
     comboBox_LoaiXeHDN.setSelectedIndex(0);
     comboBox_hangSXHDN.setSelectedIndex(0);
     comboBox_mauXeHDN.setSelectedIndex(0);
     comboBox_ChonXe.setSelectedIndex(-1);
     
     jTextField_maXeHDN.setText("Xe mới");
     jTextField_tenXeHDN.setText("");
     jTextField_giaBanHDN.setText("");
     jTextField_giaNhapXe.setText("");
     jTextField_soKhungHDN.setText("");
     jTextField_dungTichHDN.setText("");
     jTextField_soLuong.setText("");
     jTextField_TGBHHDN.setText("");
     jTextField_nhapMaXe.setText("");
    loadAllXeMayHDN();
   }


   public void nhapHang (java.awt.event.ActionEvent evt)
   {
    if (arrXeMay.size() == 0)
    {
      JOptionPane.showMessageDialog(this, "Chi tiết hóa đơn trống!");
    } else {
      for (int i = 0; i<arrXeMay.size(); i++)
        {
          if (xe_MAY_BUS.checkMaXe(arrXeMay.get(i).getMA_XE().trim()))
          {
            xe_MAY_BUS.themSoLuongXeMay(arrXeMay.get(i).getMA_XE().trim(), arrXeMay.get(i).getTON_KHO());
          }
          else 
          {
            xe_MAY_BUS.addXeMay(arrXeMay.get(i));
          }
        }
        nhapVaoHoaDon();
        deleteAllXeMay();
        loadKhoaNgoaiHDN(); 
    }
  }

  public void nhapVaoHoaDon ()
  {
    String maHDN = "";
    while (true) {
      maHDN = check1.Ma_generateRandomCode("HDN");
      if (hoa_DON_NHAP_BUS.checkMaHDN(maHDN) == false ){
        break;
        }
    }
      Date date = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
     String strDate = formatter.format(date);

    HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO = new HOA_DON_NHAP_DTO();
    hoa_DON_NHAP_DTO.setMA_HDN(maHDN.trim());
    hoa_DON_NHAP_DTO.setMA_NV(Login_GUI.id_user);
    hoa_DON_NHAP_DTO.setNGAY_LAP(strDate);
    long tongTien = Long.parseLong(jTextField_tongTien.getText().trim().replaceAll(",", ""));
    hoa_DON_NHAP_DTO.setTONG_TIEN(tongTien);
    hoa_DON_NHAP_BUS.addHDN(hoa_DON_NHAP_DTO);
    nhapVaoCTHD(maHDN);
    JOptionPane.showMessageDialog(this, "Nhập hàng thành công (Mã HDN:" + maHDN  +")!");
  }

  public void nhapVaoCTHD (String maHDN)
  {
    for (int i= 0; i<arrXeMay.size(); i++)
    {
      String maCTHDN = "";
       while (true) {
        maCTHDN = check1.Ma_generateRandomCode("CTHDN");
      if (ct_HOA_DON_NHAP_BUS.checkMaCTHDN(maCTHDN) == false ){
        break;
        }
      }
      CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = new CT_HOA_DON_NHAP_DTO();
      ct_HOA_DON_NHAP_DTO.setMA_CTHDN(maCTHDN.trim());
      ct_HOA_DON_NHAP_DTO.setMA_HDN(maHDN.trim());
      ct_HOA_DON_NHAP_DTO.setMA_XE(arrXeMay.get(i).getMA_XE().trim());
      ct_HOA_DON_NHAP_DTO.setSO_LUONG(arrXeMay.get(i).getTON_KHO());
      ct_HOA_DON_NHAP_DTO.setGIA(arrXeMay.get(i).getTONG_TIEN());
      ct_HOA_DON_NHAP_DTO.setGIA_NHAP(arrXeMay.get(i).getGIA_NHAP());
      ct_HOA_DON_NHAP_BUS.addCTHDN(ct_HOA_DON_NHAP_DTO);
    }
  }

   public Boolean checkTenXeTrongBang (String tenXe){
    for (int i = 0; i < arrXeMay.size(); i++){
      if (tenXe.trim().equals(arrXeMay.get(i).getTEN_XE().trim())){
        return true;
      }
    }
    return false;

   }

   public void tongTien ()
   {
    long tongTienHDN = 0; 
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    for (int i = 0; i < arrXeMay.size(); i++)
     {
       tongTienHDN += arrXeMay.get(i).getTONG_TIEN();
     }
     jTextField_tongTien.setText(decimalFormat.format(tongTienHDN));
   }
 

   public void timKiemXe (java.awt.event.ActionEvent evt)
   {
    if (jTextField_nhapMaXe.getText().equals(""))
    {
      JOptionPane.showMessageDialog(this, "Vui lòng điền mã xe !");
    }else if (check1.checkMa(jTextField_nhapMaXe.getText().trim(), "MX") == false)
    {
      JOptionPane.showMessageDialog(this, "Sai định dạng mã xe (VD:MX45125) !");
    }else {
    selectedXeMay = (XE_MAY_DTO) comboBox_ChonXe.getSelectedItem();
    ArrayList<XE_MAY_DTO> xeMay = new ArrayList<XE_MAY_DTO>();
    xeMay = xe_MAY_BUS.findXeMay(jTextField_nhapMaXe.getText().trim(), "MA_XE");
    if (xeMay.size() == 0)
    {
      JOptionPane.showMessageDialog(this, "Không tìm thấy xe!");
    }
    else 
    {
        jTextField_maXeHDN.setText(xeMay.get(0).getMA_XE());
        jTextField_tenXeHDN.setText(xeMay.get(0).getTEN_XE());
        jTextField_giaBanHDN.setText(xeMay.get(0).getGIA()+"");
        jTextField_soKhungHDN.setText(xeMay.get(0).getSO_KHUNG());
        jTextField_dungTichHDN.setText(xeMay.get(0).getDUNG_TICH());
        for (int i = 0; i < comboBox_LoaiXeHDN.getItemCount(); i++) {     
            if (((LOAI_XE_DTO) comboBox_LoaiXeHDN.getItemAt(i)).getMA_LOAI().equals(xeMay.get(0).getMA_LOAI())) {
              comboBox_LoaiXeHDN.setSelectedIndex(i);
                break;
            }
            else{
              comboBox_LoaiXeHDN.setSelectedIndex(-1);
            }
        }
        for (int i = 0; i < comboBox_hangSXHDN.getItemCount(); i++) {
            if (((HANG_XE_DTO) comboBox_hangSXHDN.getItemAt(i)).getMA_HANG().equals(xeMay.get(0).getMA_HANG())) {
              comboBox_hangSXHDN.setSelectedIndex(i);
                break;
            }
            else {
              comboBox_hangSXHDN.setSelectedIndex(-1);
            }
        }
        for (int i = 0; i < comboBox_mauXeHDN.getItemCount(); i++) {
            if (((MAU_XE_DTO) comboBox_mauXeHDN.getItemAt(i)).getMA_MAU().equals(xeMay.get(0).getMA_MAU())) {
              comboBox_mauXeHDN.setSelectedIndex(i);
                break;
            }
            else{
              comboBox_mauXeHDN.setSelectedIndex(-1);
            }
        }
        jTextField_soLuong.setText("");
        jTextField_TGBHHDN.setText(xeMay.get(0).getTHOI_GIAN_BH());
        KhoaAll();
    }
  }  

}

    public void addXeMay(java.awt.event.ActionEvent evt)
    {
      try {
        if (jTextField_tenXeHDN.getText().equals("") || jTextField_giaBanHDN.getText().equals("") || jTextField_soKhungHDN.getText().equals("") || jTextField_dungTichHDN.getText().equals("") || jTextField_soLuong.getText().equals("") || jTextField_TGBHHDN.getText().equals("") ){
         JOptionPane.showMessageDialog(this, "Các trường không được để trống!");
       }
       else{
            if (check1.CheckTen(jTextField_tenXeHDN.getText(), 30) == false){
              JOptionPane.showMessageDialog(this, "Tên phải lớn hơn 1 chữ và bé hơn 30 chữ");
            } 
            else if (check1.checkGiaNhap(jTextField_giaBanHDN.getText()) == false){
              JOptionPane.showMessageDialog(this, "Giá bán phải là số, không chứa ký tự đặc biệt khác, >=4 số!");
            }
            else if (check1.checkGiaNhap(jTextField_giaNhapXe.getText()) == false){
              JOptionPane.showMessageDialog(this, "Giá nhập phải là số, không chứa ký tự đặc biệt khác, >=4 số!");
            }

           else if (check1.checksoKhung(jTextField_soKhungHDN.getText()) == false){
              JOptionPane.showMessageDialog(this, "Số khung chỉ chứa chữ và số và >=5 chữ số và <=30 chữ số !");
            }
           else if (check1.checkDungTich(jTextField_dungTichHDN.getText()) == false){
              JOptionPane.showMessageDialog(this, "Sai định dạng dung tích, (VD:50CC) >=4 và <=30 chữ số!");
            }
           else if (check1.checkSoLuong(jTextField_soLuong.getText()) == false){
              JOptionPane.showMessageDialog(this, "Số lượng chỉ được chứa số !");
            } 
            else {
              Boolean flag1 = true;  
              if (xe_MAY_BUS.checkTenXe(jTextField_tenXeHDN.getText().trim())  && jTextField_maXeHDN.getText().trim().equals("Xe mới")|| checkTenXeTrongBang(jTextField_tenXeHDN.getText().trim())  && jTextField_maXeHDN.getText().trim().equals("Xe mới") ){
                  int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại tên xe này, bạn có muốn thêm tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
                  if (dialogResult == JOptionPane.YES_OPTION) {
                    flag1 = true; 
                  } 
                  else{
                      flag1 = false;
                    }
                }  
            if (flag1 == true){
                if (jTextField_maXeHDN.getText().equals("Xe mới") == true){
                maXe = "";
                while (true) {
                  maXe = check1.Ma_generateRandomCode("MX");
                  if (xe_MAY_BUS.checkMaXe(maXe) == false ){
                    break;
                    }
                }
              }
                else {
                  maXe = jTextField_maXeHDN.getText().trim();
                }
                
                Boolean flag = true;
                for (int i = 0; i <arrXeMay.size(); i++){
                  if (maXe.trim().equals(arrXeMay.get(i).getMA_XE().trim())) {
                    arrXeMay.get(i).setTON_KHO( arrXeMay.get(i).getTON_KHO() + Integer.parseInt(jTextField_soLuong.getText().trim()));
                    arrXeMay.get(i).setTONG_TIEN(arrXeMay.get(i).getTON_KHO() * arrXeMay.get(i).getGIA_NHAP() );
                    flag = false;
                    resetXeMayHDN();
                    tongTien();
                  }
                }
                
                if (flag == true){ 
                selectedHangXe = (HANG_XE_DTO) comboBox_hangSXHDN.getSelectedItem();
                selectedMauXe = (MAU_XE_DTO) comboBox_mauXeHDN.getSelectedItem();
                selectedLoaiXe = (LOAI_XE_DTO) comboBox_LoaiXeHDN.getSelectedItem();
                XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();
                xe_MAY_DTO.setMA_XE(maXe.trim());
                xe_MAY_DTO.setTEN_XE(jTextField_tenXeHDN.getText().trim());
                xe_MAY_DTO.setGIA(Long.parseLong(jTextField_giaBanHDN.getText().trim()));
                xe_MAY_DTO.setGIA_NHAP(Long.parseLong(jTextField_giaNhapXe.getText().trim()));
                
                xe_MAY_DTO.setSO_KHUNG(jTextField_soKhungHDN.getText().toUpperCase().trim());
                xe_MAY_DTO.setDUNG_TICH(jTextField_dungTichHDN.getText().toUpperCase().trim());
                if (selectedMauXe != null)
                {xe_MAY_DTO.setMA_MAU(selectedMauXe.getMA_MAU().trim());
                xe_MAY_DTO.setTEN_MAU(selectedMauXe.getTEN_MAU().trim());}
                if (selectedLoaiXe != null)
                {xe_MAY_DTO.setMA_LOAI(selectedLoaiXe.getMA_LOAI().trim());
                xe_MAY_DTO.setTEN_LOAI_XE(selectedLoaiXe.getTEN_LOAI_XE());}
                if (selectedHangXe != null)
                {xe_MAY_DTO.setMA_HANG(selectedHangXe.getMA_HANG().trim());
                xe_MAY_DTO.setTEN_HANG(selectedHangXe.getTEN_HANG().trim());}
                xe_MAY_DTO.setTON_KHO(Integer.parseInt(jTextField_soLuong.getText().trim()));
                xe_MAY_DTO.setTHOI_GIAN_BH(jTextField_TGBHHDN.getText().trim());
                xe_MAY_DTO.setTONG_TIEN(xe_MAY_DTO.getTON_KHO()*xe_MAY_DTO.getGIA_NHAP());
                arrXeMay.add(xe_MAY_DTO);
                resetXeMayHDN();
                tongTien(); 
               }
            }
          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public void deleteAllXeMay ()
    {
      arrXeMay.removeAll(arrXeMay);
      loadAllXeMayHDN();
      jTextField_tongTien.setText("0");
    }

    public void deleteXeMay (java.awt.event.ActionEvent evt)
    {
      if (jTextField_maXeHDN.getText().trim().equals("Xe mới") || jTable_HDN.getSelectedRow() == -1){
        JOptionPane.showMessageDialog(this, "Vui lòng chọn xe để xóa !");
      }
      else{ 
      for (int i = 0; i<arrXeMay.size(); i++){
        if (jTextField_maXeHDN.getText().trim().equals(arrXeMay.get(i).getMA_XE().trim())){
          arrXeMay.remove(i);
        }
      }
       resetXeMayHDN();
       tongTien();
      }
    }

    public void editXeMay (java.awt.event.ActionEvent evt)
    {
      if (jTextField_maXeHDN.getText().trim().equals("Xe mới") || jTable_HDN.getSelectedRow() == -1)
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn xe để sửa !");
      }
      else 
    {
      selectedHangXe = (HANG_XE_DTO) comboBox_hangSXHDN.getSelectedItem();
      selectedMauXe = (MAU_XE_DTO) comboBox_mauXeHDN.getSelectedItem();
      selectedLoaiXe = (LOAI_XE_DTO) comboBox_LoaiXeHDN.getSelectedItem();
      for (int i =0; i < arrXeMay.size(); i++)
      {
        if (jTextField_maXeHDN.getText().trim().equals(arrXeMay.get(i).getMA_XE().trim()))
        {
          arrXeMay.get(i).setTEN_XE(jTextField_tenXeHDN.getText().trim());
          arrXeMay.get(i).setGIA(Long.parseLong(jTextField_giaBanHDN.getText().trim()));
          arrXeMay.get(i).setGIA_NHAP(Long.parseLong(jTextField_giaNhapXe.getText().trim()));
          
          arrXeMay.get(i).setSO_KHUNG(jTextField_soKhungHDN.getText().toUpperCase().trim());
          arrXeMay.get(i).setDUNG_TICH(jTextField_dungTichHDN.getText().toUpperCase().trim());
          if (selectedMauXe!= null)
          {arrXeMay.get(i).setMA_MAU(selectedMauXe.getMA_MAU().trim());
          arrXeMay.get(i).setTEN_MAU(selectedMauXe.getTEN_MAU().trim());}
          if (selectedLoaiXe != null)
          {arrXeMay.get(i).setMA_LOAI(selectedLoaiXe.getMA_LOAI().trim());
          arrXeMay.get(i).setTEN_LOAI_XE(selectedLoaiXe.getTEN_LOAI_XE());}
          if (selectedHangXe != null)
          {arrXeMay.get(i).setMA_HANG(selectedHangXe.getMA_HANG().trim());
          arrXeMay.get(i).setTEN_HANG(selectedHangXe.getTEN_HANG().trim());}
          
          arrXeMay.get(i).setTON_KHO(Integer.parseInt(jTextField_soLuong.getText().trim()));
          arrXeMay.get(i).setTHOI_GIAN_BH(jTextField_TGBHHDN.getText().trim());
          arrXeMay.get(i).setTONG_TIEN( arrXeMay.get(i).getTON_KHO()* arrXeMay.get(i).getGIA_NHAP());
        }
      }
    resetXeMayHDN();
    tongTien();  
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

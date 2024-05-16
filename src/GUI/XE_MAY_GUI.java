package GUI;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import BUS.HANG_XE_BUS;
// import BUS.HOA_DON_NHAP_BUS;
import BUS.LOAI_XE_BUS;
import BUS.MAU_XE_BUS;
import BUS.XE_MAY_BUS;
import DTO.HANG_XE_DTO;
// import DTO.HOA_DON_NHAP_DTO;
import DTO.LOAI_XE_DTO;
import DTO.MAU_XE_DTO;
import DTO.XE_MAY_DTO;
import Export.ExportXeMay_Excel;
import CHECK.*;

import javax.swing.*;

public class XE_MAY_GUI extends JPanel
{

    private NonEditableTableModel tableModel_XeMay;
    
    private JScrollPane jScrollPane_XeMay;

    private JTable jTable_XeMay;

    private JTextField jTextField_maXe;

    private JTextField jTextField_tenXe;

    // private String[] String_MauXe = {};

    JComboBox<MAU_XE_DTO> comboBox_mauXe;

    // private String[] String_LoaiXe = {};

    JComboBox<LOAI_XE_DTO> comboBox_LoaiXe;

    // private String[] String_hangSX = { };

    JComboBox<HANG_XE_DTO> comboBox_hangSX;

    private String[] String_timKiemTheoXe = {"Mã xe", "Tên xe","Giá nhập" ,"Giá bán", "Loại xe", "Hãng xe" };

    JComboBox<String> comboBox_timKiemTheoXe;


    private JTextField jTextField_giaBan;

    private JTextField jTextField_soKhung;

    private JTextField jTextField_dungTich;

    private JTextField jTextField_tonKho;

    private JTextField jTextField_TGBH;

    // private JButton jButton_themXe;

    private JButton jButton_suaXe;

    private JButton jButton_xoaXe;

    private JButton jButton_resetXe;

    // private JButton jButton_nhapXe;

    private JButton jButton_xuatXe;

    private JTextField jTextField_timKiem;
    
    // private int SO_LUONG;

    private String gia;
    
    private Check1 check1;

    private XE_MAY_BUS xe_MAY_BUS = new XE_MAY_BUS();
    private HANG_XE_BUS hang_XE_BUS = new HANG_XE_BUS();
    private LOAI_XE_BUS loai_XE_BUS = new LOAI_XE_BUS();
    private MAU_XE_BUS mau_XE_BUS = new MAU_XE_BUS();
    private ExportXeMay_Excel exportXeMay_Excel = new ExportXeMay_Excel();
    // private HOA_DON_NHAP_BUS hoa_DON_NHAP_BUS = new HOA_DON_NHAP_BUS();

    private MAU_XE_DTO selectedMauXe;

    private HANG_XE_DTO selectedHangXe;

    private LOAI_XE_DTO selectedLoaiXe;

    private String tenXe;

    private JTextField jTextField_giaNhapXe;

    // private String maNV;

    // private String maXe;

      
    public XE_MAY_GUI ()
    {
      // SO_LUONG =  -1;
      check1 = new Check1();
      this.init_XE_MAY();
      loadAllXeMay();
      loadKhoaNgoai();
    }


     public void init_XE_MAY ()
     {
      // Table xe máy
    jTable_XeMay = new JTable();
    tableModel_XeMay = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ NHẬP", "GIÁ BÁN", "LOẠI XE", "MÀU XE", "HÃNG XE", "SỐ KHUNG", "DUNG TÍCH", "TỒN KHO", "THỜI GIAN BẢO HÀNH", "MÃ HÃNG", "MÃ LOẠI", "MÃ MÀU"} );
    jTable_XeMay = new JTable(tableModel_XeMay);
    jScrollPane_XeMay = new JScrollPane(jTable_XeMay);
    jScrollPane_XeMay.setBounds(0, 0, 1400, 248);
    
    
    
    jTable_XeMay.addMouseListener(new MouseAdapter() {
      private String giaNhap;

      @Override
      public void mouseClicked(MouseEvent e) {
        JTable tableSelect = jTable_XeMay;
        int selectedRow = tableSelect.getSelectedRow();
        jTextField_maXe.setText(jTable_XeMay.getValueAt(selectedRow, 1)+"");
        
        tenXe = jTable_XeMay.getValueAt(selectedRow, 2)+"";
        jTextField_tenXe.setText(tenXe);


        giaNhap =  jTable_XeMay.getValueAt(selectedRow, 3)+"";
        giaNhap = giaNhap.replaceAll(",", "");
        jTextField_giaNhapXe.setText(giaNhap);

        
        gia =  jTable_XeMay.getValueAt(selectedRow, 4)+"";
        gia = gia.replaceAll(",", "");
        jTextField_giaBan.setText(gia);
        
          
          for (int i = 0; i < comboBox_LoaiXe.getItemCount(); i++) {
            System.out.println(jTable_XeMay.getValueAt(selectedRow, 12));
              if (((LOAI_XE_DTO) comboBox_LoaiXe.getItemAt(i)).getMA_LOAI().equals(jTable_XeMay.getValueAt(selectedRow, 13))) {
                comboBox_LoaiXe.setSelectedIndex(i);
                System.out.println("có vào");
                  break;
              }else {
                comboBox_LoaiXe.setSelectedIndex(-1);
              }
          }
          
          for (int i = 0; i < comboBox_hangSX.getItemCount(); i++) {
            System.out.println(jTable_XeMay.getValueAt(selectedRow, 12));
           
              if (((HANG_XE_DTO) comboBox_hangSX.getItemAt(i)).getMA_HANG().equals(jTable_XeMay.getValueAt(selectedRow, 12))) {
                comboBox_hangSX.setSelectedIndex(i);
                System.out.println("có vào");
                  break;
              }else {
                comboBox_hangSX.setSelectedIndex(-1);
              }
          }

          for (int i = 0; i < comboBox_mauXe.getItemCount(); i++) {
            System.out.println(jTable_XeMay.getValueAt(selectedRow, 12));
           
              if (((MAU_XE_DTO) comboBox_mauXe.getItemAt(i)).getMA_MAU().equals(jTable_XeMay.getValueAt(selectedRow, 14))) {
                comboBox_mauXe.setSelectedIndex(i);
                System.out.println("có vào");
                  break;
              }else {
                comboBox_mauXe.setSelectedIndex(-1);
              }
          }
          jTextField_soKhung.setText(jTable_XeMay.getValueAt(selectedRow, 8)+"");
          jTextField_dungTich.setText(jTable_XeMay.getValueAt(selectedRow, 9)+"");
          jTextField_tonKho.setText(jTable_XeMay.getValueAt(selectedRow, 10)+"");
          jTextField_TGBH.setText(jTable_XeMay.getValueAt(selectedRow, 11)+"");
        }
  });



    // Font của xe máy
    Font font_xeMay = new Font("Arial", Font.BOLD, 14);
    
    
    //Text MÃ XE
    JLabel jLabel_textMaXe = new JLabel("MÃ XE:");
    jLabel_textMaXe.setFont(font_xeMay);
    jLabel_textMaXe.setBounds(10, 268, 89, 16);

    // JTextFile MÃ XE 
    jTextField_maXe = new JTextField();
    jTextField_maXe.setFont(font_xeMay);
    jTextField_maXe.setBounds(99, 264, 270, 24);
    jTextField_maXe.setText("CHỌN XE");
    jTextField_maXe.setEditable(false);
    jTextField_maXe.setBackground(Color.LIGHT_GRAY);


    // text tên xe
    JLabel jLabel_textTenXe = new JLabel("TÊN XE:");
    jLabel_textTenXe.setFont(font_xeMay);
    jLabel_textTenXe.setBounds(10, 330, 86, 16);

    // jtextfile tên xe
    jTextField_tenXe = new JTextField();
    jTextField_tenXe.setFont(font_xeMay);
    jTextField_tenXe.setBounds(99, 324, 270, 24);


    // JLabel jLabel_textGiaNhapXe = new JLabel("GIÁ NHẬP:");
    // jLabel_textGiaNhapXe.setFont(font_xeMay);
    // jLabel_textGiaNhapXe.setBounds(10, 466, 86, 16);

    // jTextField_giaNhapXe = new JTextField();
    // jTextField_giaNhapXe.setFont(font_xeMay);
    // jTextField_giaNhapXe.setBounds(99, 462, 270, 24);


    JLabel jLabel_textGiaNhapXe = new JLabel("GIÁ NHẬP:");
    jLabel_textGiaNhapXe.setFont(font_xeMay);
    jLabel_textGiaNhapXe.setBounds(10, 397, 86, 16);

    jTextField_giaNhapXe = new JTextField();
    jTextField_giaNhapXe.setFont(font_xeMay);
    jTextField_giaNhapXe.setBounds(99, 391, 270, 24);


    // text giá nhập
    JLabel jLabel_textGiaBan = new JLabel("GIÁ BÁN:");
    jLabel_textGiaBan.setFont(font_xeMay);
    jLabel_textGiaBan.setBounds(10, 466, 86, 16);

    // jtextfile giá nhập 
    jTextField_giaBan = new JTextField();
    jTextField_giaBan.setFont(font_xeMay);
    jTextField_giaBan.setBounds(99, 462, 270, 24);

    // TEXT SỐ KHUNG 
    JLabel jLabel_textSoKhung = new JLabel("SỐ KHUNG:");
    jLabel_textSoKhung.setFont(font_xeMay);
    jLabel_textSoKhung.setBounds(10, 579, 86, 16);

    // JTEXTFILE SỐ KHUNG
    jTextField_soKhung = new JTextField();
    jTextField_soKhung.setFont(font_xeMay);
    jTextField_soKhung.setBounds(99, 575, 270, 24);

 

 

    // text Dung tích 
    JLabel jLabel_textDungTich = new JLabel("DUNG TÍCH:");
    jLabel_textDungTich.setFont(font_xeMay);
    jLabel_textDungTich.setBounds(10, 529, 86, 16);

    // jtextFile dung tích
    jTextField_dungTich = new JTextField();
    jTextField_dungTich.setFont(font_xeMay);
    jTextField_dungTich.setBounds(99, 525, 270, 24);

    
    



    // text màu xe
    JLabel jLabel_textMauXe = new JLabel("MÀU XE:");
    jLabel_textMauXe.setFont(font_xeMay);
    jLabel_textMauXe.setBounds(512, 268, 86, 16);
    
    // jcombobox màu xe
    comboBox_mauXe = new JComboBox<>();
    comboBox_mauXe.setFont(font_xeMay);
    comboBox_mauXe.setBounds(590, 264, 109, 24);


    // text loại xe 
    JLabel jLabel_textLoaiXe = new JLabel("LOẠI XE:");
    jLabel_textLoaiXe.setFont(font_xeMay);
    jLabel_textLoaiXe.setBounds( 512, 335, 86, 16);

    // jcombobox loại xe
    comboBox_LoaiXe = new JComboBox<>();
    comboBox_LoaiXe.setFont(font_xeMay);
    comboBox_LoaiXe.setBounds(590, 331, 109, 24);

    // text hãng sản xuất
    JLabel jLabel_textHangSX = new JLabel("HÃNG SX:");
    jLabel_textHangSX.setFont(font_xeMay);
    jLabel_textHangSX.setBounds( 512, 402, 86, 16);




    // jcombobox hãng sản xuất
    comboBox_hangSX = new JComboBox<>();
    comboBox_hangSX.setFont(font_xeMay);
    comboBox_hangSX.setBounds(590, 397, 109, 24);

    // text tồn kho
    JLabel jLabel_textTonKho = new JLabel("TỒN KHO:");
    jLabel_textTonKho.setFont(font_xeMay);
    jLabel_textTonKho.setBounds( 512, 466, 83, 16);

    // jtextfile tồn kho
    jTextField_tonKho = new JTextField();
    jTextField_tonKho.setFont(font_xeMay);
    jTextField_tonKho.setBounds(590, 461, 270, 24);
    jTextField_tonKho.setEditable(false);
    jTextField_tonKho.setBackground(Color.LIGHT_GRAY);

    // text thời gian bảo hành 
    JLabel jLabel_textTGBH = new JLabel("TG BH:");
    jLabel_textTGBH.setFont(font_xeMay);
    jLabel_textTGBH.setBounds( 512, 531, 83, 16);

    // jtextfile thời gian bảo hành 
    jTextField_TGBH = new JTextField();
    jTextField_TGBH.setFont(font_xeMay);
    jTextField_TGBH.setBounds(590, 525, 270, 24);

    
  //   // jbutton them
  //   ImageIcon Icon_themXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
  //   jButton_themXe = new JButton("THÊM XE");
  //   jButton_themXe.setFont(font_xeMay);
  //   jButton_themXe.setIcon(Icon_themXe);
  //   jButton_themXe.setBounds(1061, 397, 155, 42);
  //   jButton_themXe.addActionListener(new java.awt.event.ActionListener() {
  //     public void actionPerformed(java.awt.event.ActionEvent evt) {
  //      kiemTraAdd(evt);
  //     }
  // });

    // jbutton sua
    ImageIcon Icon_suaXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/edit.png"));
    jButton_suaXe = new JButton("SỬA");
    jButton_suaXe.setFont(font_xeMay);
    jButton_suaXe.setIcon(Icon_suaXe);
    jButton_suaXe.setBounds(1061, 433, 155, 42);
    jButton_suaXe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       editXeMay(evt);
      }
  });

    // JBUTTON XÓA
    ImageIcon Icon_xoaXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
    jButton_xoaXe = new JButton("XÓA");
    jButton_xoaXe.setFont(font_xeMay);
    jButton_xoaXe.setIcon(Icon_xoaXe);
    jButton_xoaXe.setBounds(1061, 513, 155, 42);
    jButton_xoaXe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       deleteXeMay(evt);
      }
  });

    // JBUTTON RESET 
    ImageIcon Icon_resetXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
    jButton_resetXe = new JButton("RESET");
    jButton_resetXe.setFont(font_xeMay);
    jButton_resetXe.setIcon(Icon_resetXe);
    jButton_resetXe.setBounds(1231, 433, 155, 42);
    jButton_resetXe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       resetXeMay();
      }
  });

    // JBUTTON NHẬP XE TỪ EXCEL
    // ImageIcon Icon_nhapXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/import.png"));
    // jButton_nhapXe = new JButton("NHẬP EXCEL");
    // jButton_nhapXe.setFont(font_xeMay);
    // jButton_nhapXe.setIcon(Icon_nhapXe);
    // jButton_nhapXe.setBounds(1231, 472, 155, 42);


    
    // jbutton xuất ra excel
    ImageIcon Icon_xuatXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/export.png"));
    jButton_xuatXe = new JButton("XUẤT EXCEL");
    jButton_xuatXe.setFont(font_xeMay);
    jButton_xuatXe.setIcon(Icon_xuatXe);
    jButton_xuatXe.setBounds(1231, 513, 155, 42);
    jButton_xuatXe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ExportXeMay(evt);
      }
  });

  //  TEXT TÌM KIẾM 
  JLabel jLabel_textTimKiem = new JLabel("TÌM KIẾM:");
  jLabel_textTimKiem.setFont(font_xeMay);
  jLabel_textTimKiem.setBounds( 944, 265, 82, 16);
  

  // jtextfile tìm kiếm 
  jTextField_timKiem = new JTextField();
  jTextField_timKiem.setFont(font_xeMay);
  jTextField_timKiem.setBounds(1061, 261, 325, 24);

  // text tìm kiếm theo 
  JLabel jLabel_textTimKiemTheo = new JLabel("TÌM KIẾM THEO:");
  jLabel_textTimKiemTheo.setFont(font_xeMay);
  jLabel_textTimKiemTheo.setBounds( 944, 335, 117, 16);

  // jcombobox tìm kiếm theo 
  comboBox_timKiemTheoXe = new JComboBox<>(String_timKiemTheoXe);
  comboBox_timKiemTheoXe.setFont(font_xeMay);
  comboBox_timKiemTheoXe.setBounds(1061, 331, 155, 24);

  // jbutton tim kiem
  ImageIcon Icon_timKiemXe = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));
  JButton jButton_timKiem = new JButton("TÌM KIẾM XE");
  jButton_timKiem.setFont(font_xeMay);
  jButton_timKiem.setIcon(Icon_timKiemXe);
  jButton_timKiem.setBounds(1231, 322, 155, 41);
  jButton_timKiem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
     findXeMay(evt);
     System.out.println("có vào");
    }
});



 this.setBackground(new java.awt.Color(204, 255, 255));

    this.setLayout(null);
    
    this.add(jScrollPane_XeMay);
    
    this.add(jLabel_textMaXe);
    this.add(jTextField_maXe);
    
    this.add(jLabel_textTenXe);
    this.add(jTextField_tenXe);

    this.add(jLabel_textGiaBan);
    this.add(jTextField_giaBan);
    
    this.add(jLabel_textSoKhung);
    this.add(jTextField_soKhung);

    this.add(jLabel_textDungTich);
    this.add(jTextField_dungTich);

    this.add(jLabel_textMauXe);
    this.add(comboBox_mauXe);
    
    this.add(jLabel_textLoaiXe);
    this.add(comboBox_LoaiXe);

    this.add(jLabel_textHangSX);
    this.add(comboBox_hangSX);

    this.add(jLabel_textTonKho);
    this.add(jTextField_tonKho);

    this.add(jLabel_textTGBH);
    this.add(jTextField_TGBH);
    
    // this.add(jButton_themXe);
    this.add(jButton_suaXe);
    this.add(jButton_xoaXe);
    this.add(jButton_resetXe);
    // this.add(jButton_nhapXe);
    this.add(jButton_xuatXe);

    this.add(jLabel_textTimKiem);
    this.add(jTextField_timKiem);
    this.add(jLabel_textTimKiemTheo);
    this.add(comboBox_timKiemTheoXe);
    this.add(jButton_timKiem);
     this.add(jLabel_textGiaNhapXe);
     this.add(jTextField_giaNhapXe);
     
  
     }

    public void loadAllXeMay ()
    {
      tableModel_XeMay.setRowCount(0);
      
      ArrayList<XE_MAY_DTO> arrXe = xe_MAY_BUS.getAllXeMay();
      loadXeMayLenTable(arrXe);
   }

   public void loadXeMayLenTable (ArrayList<XE_MAY_DTO> arrXe)
   {
      
      DecimalFormat decimalFormat = new DecimalFormat("###,###");
      // for (String[] rowdata : data) {
      //   // Duyệt qua các phần tử của mảng con
      //   Object[] newrow = {i,rowdata[0],rowdata[1],decimalFormat.format(Double.parseDouble(rowdata[2])),rowdata[3],rowdata[4],rowdata[5],rowdata[6],rowdata[7],rowdata[8],rowdata[9],rowdata[10],rowdata[11],rowdata[12]};
      //   i+=1;
      //   tableModel_XeMay.addRow(newrow);
      // }

      for (int i = 0; i<arrXe.size(); i++)
      {
        
        XE_MAY_DTO xe_MAY_DTO = arrXe.get(i);
        Object[] newrow = {i+1,xe_MAY_DTO.getMA_XE(), xe_MAY_DTO.getTEN_XE(),  decimalFormat.format( xe_MAY_DTO.getGIA_NHAP()) ,decimalFormat.format( xe_MAY_DTO.getGIA()), xe_MAY_DTO.getTEN_LOAI_XE(), xe_MAY_DTO.getTEN_MAU(), xe_MAY_DTO.getTEN_HANG(), xe_MAY_DTO.getSO_KHUNG(), xe_MAY_DTO.getDUNG_TICH(), xe_MAY_DTO.getTON_KHO(), xe_MAY_DTO.getTHOI_GIAN_BH(), xe_MAY_DTO.getMA_HANG(), xe_MAY_DTO.getMA_LOAI(),xe_MAY_DTO.getMA_MAU()};
        tableModel_XeMay.addRow(newrow);
      }
     
      jTable_XeMay.getColumnModel().getColumn(12).setResizable(false);
      jTable_XeMay.getColumnModel().getColumn(12).setPreferredWidth(0);
      jTable_XeMay.getColumnModel().getColumn(12).setMinWidth(0);
      jTable_XeMay.getColumnModel().getColumn(12).setMaxWidth(0);

      jTable_XeMay.getColumnModel().getColumn(13).setResizable(false);
      jTable_XeMay.getColumnModel().getColumn(13).setPreferredWidth(0);
      jTable_XeMay.getColumnModel().getColumn(13).setMinWidth(0);
      jTable_XeMay.getColumnModel().getColumn(13).setMaxWidth(0);

      jTable_XeMay.getColumnModel().getColumn(14).setResizable(false);
      jTable_XeMay.getColumnModel().getColumn(14).setPreferredWidth(0);
      jTable_XeMay.getColumnModel().getColumn(14).setMinWidth(0);
      jTable_XeMay.getColumnModel().getColumn(14).setMaxWidth(0);
   }



   public void loadKhoaNgoai()
   {
      comboBox_hangSX.removeAllItems();
      
      ArrayList<HANG_XE_DTO> arrHangXe = new ArrayList<HANG_XE_DTO>();
      arrHangXe = hang_XE_BUS.getAllHangXe();

      for (HANG_XE_DTO hang_XE_DTO : arrHangXe) 
      {
        comboBox_hangSX.addItem(hang_XE_DTO);
     }
     
     comboBox_mauXe.removeAllItems();
     ArrayList<MAU_XE_DTO> arrMauXe = new ArrayList<MAU_XE_DTO>();
     arrMauXe = mau_XE_BUS.getAllMauXe();
     for (MAU_XE_DTO mau_XE_DTO : arrMauXe) {
       comboBox_mauXe.addItem(mau_XE_DTO);
      }
      
    

    comboBox_LoaiXe.removeAllItems();
      ArrayList<LOAI_XE_DTO> arrLoaiXe = new ArrayList<LOAI_XE_DTO>();
      arrLoaiXe = loai_XE_BUS.getAllLoaiXe();
      for (LOAI_XE_DTO loai_XE_DTO : arrLoaiXe) {
        comboBox_LoaiXe.addItem(loai_XE_DTO);
    }
    
   }

  //  public void kiemTraAdd (java.awt.event.ActionEvent evt)
  //  {
  //    if (jTextField_maXe.getText().equals("XE MỚI") == true)
  //    {
  //      addXeMay();
  //     //  addHDN();
      
  //    } 
  //    else 
  //    {
  //     String strSoLuong =  JOptionPane.showInputDialog(this, "Nhập số lượng xe :");
  //     System.out.println(strSoLuong);
  //     if (strSoLuong.equals(""))
  //     {
  //       JOptionPane.showMessageDialog(this, "Không được để trống!");
  //     }
  //     else if (check1.checkSoLuong(strSoLuong) == false)
  //     {
  //       JOptionPane.showMessageDialog(this, "Số lượng phải là số và lớn hơn 0!");
  //     }
  //     SO_LUONG =  Integer.parseInt(strSoLuong);
  //     xe_MAY_BUS.themSoLuongXeMay(jTextField_maXe.getText().trim(), SO_LUONG);
  //     JOptionPane.showMessageDialog(this, "Thêm xe thành công !");
  //     // addHDN();
  //     resetXeMay();
  //    }
  //  }

   
  // public void addHDN ()
  // {
  //    maNV = "NV5";
    
  //   String maHDN = "";
  //   while (true) {
  //     maHDN = check1.MaXe_generateRandomCode("HDN");
  //     if (hoa_DON_NHAP_BUS.checkMaHDN(maHDN) == false )
  //     {
  //       break;
  //     }
  //   }
  //    Date date = new Date();
  //    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
  //    String strDate = formatter.format(date);
  //    HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO = new HOA_DON_NHAP_DTO();
     
  //    hoa_DON_NHAP_DTO.setMA_HDN(maHDN.trim());
  //    hoa_DON_NHAP_DTO.setMA_NV(maNV.trim());
  //    hoa_DON_NHAP_DTO.setNGAY_LAP(strDate);
  //    hoa_DON_NHAP_DTO.setSO_LUONG(SO_LUONG);
  //    if (jTextField_maXe.getText().equals("CHỌN XE") == true)
  //    {
  //      System.out.println(jTextField_giaBan.getText().trim());
  //     hoa_DON_NHAP_DTO.setTONG_TIEN(SO_LUONG* Integer.parseInt(jTextField_giaBan.getText().trim()));
  //     jTextField_maXe.setText(maXe.trim());
  //    }
  //    else 
  //    {
  //      hoa_DON_NHAP_DTO.setTONG_TIEN(SO_LUONG* Integer.parseInt(gia));
  //     }
  //     hoa_DON_NHAP_DTO.setMA_XE(jTextField_maXe.getText().trim());
  //    hoa_DON_NHAP_BUS.addHDN(hoa_DON_NHAP_DTO);
  // } 


//    public void addXeMay ()
//    {
     
//     try {
//     if (jTextField_tenXe.getText().equals("") || jTextField_giaBan.getText().equals("") || jTextField_soKhung.getText().equals("") || jTextField_dungTich.getText().equals("") || jTextField_TGBH.getText().equals("") )
//     {
//       JOptionPane.showMessageDialog(this, "Các trường không được để trống!");
//     }
//     else 
//     {
//       if (check1.CheckTen(jTextField_tenXe.getText(), 30) == false)
//       {
//         JOptionPane.showMessageDialog(this, "Tên phải lớn hơn 1 chữ và bé hơn 30 chữ");
//       }
//       else if (check1.checkGiaNhap(jTextField_giaBan.getText()) == false)
//       {
//         JOptionPane.showMessageDialog(this, "Giá nhập phải là số, không chứa ký tự đặc biệt khác, >=4 số!");
//       }
//       else if (check1.checksoKhung(jTextField_soKhung.getText()) == false)
//        {
//         JOptionPane.showMessageDialog(this, "Số khung chỉ chứa chữ và số và >=5 chữ số và <=30 chữ số !");
//        }
//       else if (check1.checkDungTich(jTextField_dungTich.getText()) == false)
//        {
//         JOptionPane.showMessageDialog(this, "Sai định dạng dung tích, (VD:50CC) >=4 và <=30 chữ số!");
//        }
//       else 
//       {
//         Boolean flag = true;  
//         if (xe_MAY_BUS.checkTenXe(jTextField_tenXe.getText().trim()))
//           {
//             int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại tên xe này, bạn có muốn thêm tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
//             if (dialogResult == JOptionPane.YES_OPTION) 
//             {
//                flag = true; 
//             } 
//             else 
//               {
//                 flag = false;
//               }
//           }
       
//         if (flag == true)    
//         {
//              maXe = "";
//             while (true) {
//               maXe = check1.MaXe_generateRandomCode("MX");
//               if (xe_MAY_BUS.checkMaXe(maXe) == false )
//               {
//                 break;
//               }
//             }

//               String strSoLuong =  JOptionPane.showInputDialog(this, "Nhập số lượng xe :");
//               System.out.println(strSoLuong);
//               if (strSoLuong.equals(""))
//               {
//                 JOptionPane.showMessageDialog(this, "Không được để trống!");
//               }
//               else if (check1.checkSoLuong(strSoLuong) == false)
//               {
//                 JOptionPane.showMessageDialog(this, "Số lượng phải là số và lớn hơn 0!");
//               }
//               else 
//               {
//                 selectedHangXe = (HANG_XE_DTO) comboBox_hangSX.getSelectedItem();
//                 selectedMauXe = (MAU_XE_DTO) comboBox_mauXe.getSelectedItem();
//                 selectedLoaiXe = (LOAI_XE_DTO) comboBox_LoaiXe.getSelectedItem();
//                 SO_LUONG =  Integer.parseInt(strSoLuong);
                
                
//                 XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();
//                 xe_MAY_DTO.setMA_XE(maXe.trim());
//                 xe_MAY_DTO.setTEN_XE(jTextField_tenXe.getText().trim());
//                 xe_MAY_DTO.setGIA(Integer.parseInt(jTextField_giaBan.getText().trim()));
//                 xe_MAY_DTO.setSO_KHUNG(jTextField_soKhung.getText().trim());
//                 xe_MAY_DTO.setDUNG_TICH(jTextField_dungTich.getText().trim());
//                 xe_MAY_DTO.setMA_MAU(selectedMauXe.getMA_MAU());
//                 xe_MAY_DTO.setMA_LOAI(selectedLoaiXe.getMA_LOAI());
//                 xe_MAY_DTO.setMA_HANG(selectedHangXe.getMA_HANG());
//                 xe_MAY_DTO.setTON_KHO(SO_LUONG);
//                 xe_MAY_DTO.setTHOI_GIAN_BH(jTextField_TGBH.getText().trim());
//                 xe_MAY_BUS.addXeMay(xe_MAY_DTO);
//                 JOptionPane.showMessageDialog(this, "Nhập xe thành công ( Mã xe :" + maXe + ") !" );
//                 resetXeMay();
                
//               } 
//         }
//       }  
//    }
//   }
//     catch (Exception err) {
//     }
//  }


    public void ExportXeMay (java.awt.event.ActionEvent evt)
    {
      
      
      exportXeMay_Excel.ExportXeMay();
      JOptionPane.showMessageDialog(this, "Xuất file excel thành công");

    }

   public void editXeMay(java.awt.event.ActionEvent evt)
   {
    if (jTextField_maXe.getText().equals("CHỌN XE") == true)
    {
      JOptionPane.showMessageDialog(this, "Vui lòng chọn xe để sửa !");
    }
    else if (jTextField_tenXe.getText().equals("") || jTextField_giaBan.getText().equals("") || jTextField_soKhung.getText().equals("") || jTextField_dungTich.getText().equals("") || jTextField_TGBH.getText().equals("") || jTextField_giaNhapXe.getText().equals("") )
    {
      JOptionPane.showMessageDialog(this, "Các trường không được để trống!");
    }
    else 
    {
      if (check1.CheckTen(jTextField_tenXe.getText(), 30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên phải lớn hơn 1 chữ và bé hơn 30 chữ");
      }
      else if (check1.checkGiaNhap(jTextField_giaBan.getText()) == false)
      {
        JOptionPane.showMessageDialog(this, "Giá bán phải là số, không chứa ký tự đặc biệt khác, >=4 số!");
      }
      else if (check1.checkGiaNhap(jTextField_giaNhapXe.getText()) == false)
      {
        JOptionPane.showMessageDialog(this, "Giá nhập phải là số, không chứa ký tự đặc biệt khác, >=4 số!");
      }
      else if (check1.checksoKhung(jTextField_soKhung.getText()) == false)
       {
        JOptionPane.showMessageDialog(this, "Số khung chỉ chứa chữ và số và >=5 chữ số và <=30 chữ số !");
       }
      else if (check1.checkDungTich(jTextField_dungTich.getText()) == false)
       {
        JOptionPane.showMessageDialog(this, "Sai định dạng dung tích, (VD:50CC) >=4 và <=30 chữ số!");
       }
      else 
      {
          boolean flag = true;
          System.out.println(tenXe);
          System.out.println(jTextField_tenXe.getText().trim());
          if (xe_MAY_BUS.checkTenXe(jTextField_tenXe.getText().trim()) && tenXe.trim().equals(jTextField_tenXe.getText().trim()) == false )
          {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tên xe đã có trong bảng, bạn có muốn sửa tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) 
            {
               flag = true; 
            } 
            else 
              {
                flag = false;
              }
          }
        if (flag == true) 
       {  
        selectedHangXe = (HANG_XE_DTO) comboBox_hangSX.getSelectedItem();
        selectedMauXe = (MAU_XE_DTO) comboBox_mauXe.getSelectedItem();
        selectedLoaiXe = (LOAI_XE_DTO) comboBox_LoaiXe.getSelectedItem();
        
        XE_MAY_DTO xe_MAY_DTO = new XE_MAY_DTO();
        xe_MAY_DTO.setMA_XE(jTextField_maXe.getText().trim());
        xe_MAY_DTO.setTEN_XE(jTextField_tenXe.getText().trim());
        xe_MAY_DTO.setGIA(Long.parseLong(jTextField_giaBan.getText().trim()));
        xe_MAY_DTO.setGIA_NHAP(Long.parseLong(jTextField_giaNhapXe.getText().trim()));
        xe_MAY_DTO.setSO_KHUNG(jTextField_soKhung.getText().trim());
        xe_MAY_DTO.setDUNG_TICH(jTextField_dungTich.getText().trim());
        if(selectedMauXe!=null)
        {xe_MAY_DTO.setMA_MAU(selectedMauXe.getMA_MAU());}
        if (selectedLoaiXe!=null)
        {xe_MAY_DTO.setMA_LOAI(selectedLoaiXe.getMA_LOAI());}
        if(selectedHangXe!=null)
        {xe_MAY_DTO.setMA_HANG(selectedHangXe.getMA_HANG());}
        xe_MAY_DTO.setTON_KHO( Integer.parseInt(jTextField_tonKho.getText()) );
        xe_MAY_DTO.setTHOI_GIAN_BH(jTextField_TGBH.getText().trim());
        xe_MAY_BUS.editXeMay(xe_MAY_DTO);
        JOptionPane.showMessageDialog(this, "Sửa thông tin xe thành công !");
        resetXeMay();
         }
      }
    }
  }


  public void resetXeMay ()
  {
    tableModel_XeMay.setRowCount(0);
    loadAllXeMay();
    loadKhoaNgoai();
    jTextField_maXe.setText("CHỌN XE");
    jTextField_tenXe.setText("");
    jTextField_giaBan.setText("");
    jTextField_giaNhapXe.setText("");
    jTextField_soKhung.setText("");
    jTextField_dungTich.setText("");
    comboBox_LoaiXe.setSelectedIndex(0);
    comboBox_hangSX.setSelectedIndex(0);
    comboBox_mauXe.setSelectedIndex(0);
    jTextField_tonKho.setText("");
    jTextField_TGBH.setText("");
    jTextField_timKiem.setText("");

  }


   public void deleteXeMay (java.awt.event.ActionEvent evt)
   {
      if (jTextField_maXe.getText().equals("CHỌN XE"))
      {
        JOptionPane.showMessageDialog(this,"Vui lòng chọn xe để xóa !");
      }
      else 
      {
        xe_MAY_BUS.deleteXeMay(jTextField_maXe.getText().trim());
        JOptionPane.showMessageDialog(this,"Xóa xe thành công !");
        resetXeMay();
      }
   }


  public void findXeMay (java.awt.event.ActionEvent evt)
  {
    String selectedItem = (String)comboBox_timKiemTheoXe.getSelectedItem();
   
    if (selectedItem.equals("Mã xe"))
    {
      if (jTextField_timKiem.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else if (check1.checkMa(jTextField_timKiem.getText().trim(), "MX")  )
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiem.getText().trim(), "MA_XE");
        if (data.size() == 0)
        {
          JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
        }
        else 
        {
          tableModel_XeMay.setRowCount(0);
          loadXeMayLenTable(data);
        }
      } 
      else
       {
        JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng địng dạng mã xe (VD : MX58421) !");
       }
    }

    else if (selectedItem.equals("Tên xe"))
    {
      if (jTextField_timKiem.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiem.getText().trim(), "TEN_XE");
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
      }
      else 
      {
        tableModel_XeMay.setRowCount(0);
        loadXeMayLenTable(data);
      }
      }
    }

    else if (selectedItem.equals("Giá nhập"))
    {
      if (jTextField_timKiem.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else if (check1.checkGiaNhap(jTextField_timKiem.getText().trim()) == false)
      {
        JOptionPane.showMessageDialog(this,"Giá phải là số !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiem.getText().trim(), "GIA_NHAP");
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
      }
      else 
      {
        tableModel_XeMay.setRowCount(0);
        loadXeMayLenTable(data);
      }
      }
    }


    else if (selectedItem.equals("Giá bán"))
    {
      if (jTextField_timKiem.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else if (check1.checkGiaNhap(jTextField_timKiem.getText().trim()) == false)
      {
        JOptionPane.showMessageDialog(this,"Giá phải là số !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  data = xe_MAY_BUS.findXeMay(jTextField_timKiem.getText().trim(), "GIA");
      if (data.size() == 0)
      {
        JOptionPane.showMessageDialog(this,"Không tìm thấy xe nào !");
      }
      else 
      {
        tableModel_XeMay.setRowCount(0);
        loadXeMayLenTable(data);
      }
      }
    }

    else if (selectedItem.equals("Loại xe"))
    {
      if (jTextField_timKiem.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  arrXeMay = xe_MAY_BUS.getAllXeMay();
        ArrayList<XE_MAY_DTO>  data = new ArrayList<XE_MAY_DTO>();
        for (int i = 0; i<arrXeMay.size(); i++)
        {
          if (arrXeMay.get(i).getTEN_LOAI_XE().toUpperCase().trim().equals(jTextField_timKiem.getText().toUpperCase().trim()))
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
        tableModel_XeMay.setRowCount(0);
        loadXeMayLenTable(data);
      }
      }
    }

    else if (selectedItem.equals("Hãng xe"))
    {
      if (jTextField_timKiem.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this,"Không được để trống !");
      }
      else 
      {
        ArrayList<XE_MAY_DTO>  arrXeMay = xe_MAY_BUS.getAllXeMay();
        ArrayList<XE_MAY_DTO>  data = new ArrayList<XE_MAY_DTO>();
        for (int i = 0; i<arrXeMay.size(); i++)
        {
          if (arrXeMay.get(i).getTEN_HANG().toUpperCase().trim().equals(jTextField_timKiem.getText().toUpperCase().trim()))
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
        tableModel_XeMay.setRowCount(0);
        loadXeMayLenTable(data);
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

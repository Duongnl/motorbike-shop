package GUI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

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
import CHECK.Check1;
import DTO.CT_HOA_DON_BAN_DTO;
import DTO.HOA_DON_BAN_DTO;
import Export.ExportHDB_PDF;

  



public class CT_HOA_DON_BAN_GUI extends JPanel {
     
    private String[] String_timKiemTheoHDB = { "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Tên khách hàng", "Ngày lập", "Thanh toán"};

    JComboBox<String> comboBox_timKiemTheoHDB;

    private JTextField jTextField_timKiemHD;

    private JButton jButton_timKiemHDB;

    private JButton jButton_resetHDB;

    private JButton jButton_xoaHDB;

    private JTable jTable_HDB;

    private NonEditableTableModel tableModel_HDB;

    private JScrollPane jScrollPane_HDB;

    private JTable jTable_CTHDB;

    private NonEditableTableModel tableModel_CTHDB;

    private JScrollPane jScrollPane_CTHDB;

    private HOA_DON_BAN_BUS hoa_DON_BAN_BUS = new HOA_DON_BAN_BUS();

    private String maHDB;

    private CT_HOA_DON_BAN_BUS ct_HOA_DON_BAN_BUS = new CT_HOA_DON_BAN_BUS();
    
    private ExportHDB_PDF exportHDB_PDF = new ExportHDB_PDF();

    private Check1 check1 = new Check1();

    private JButton jButton_xuatHD;

    public CT_HOA_DON_BAN_GUI ()
    {  
        init_CT_HoaDonBan();
       
        loadAllHDB();

    }

    public void init_CT_HoaDonBan()
    {
        Font font_tieuDe = new Font("Arial", Font.BOLD, 25);
        Font font_CTHDB = new Font("Arial", Font.BOLD, 14); 

        JLabel jLabel_hoaDon = new JLabel("HÓA ĐƠN");
        jLabel_hoaDon.setFont(font_tieuDe);
        jLabel_hoaDon.setBounds(372, 30, 122, 28);

        JLabel jLabel_timKiem = new JLabel("TÌM KIẾM HÓA ĐƠN");
        jLabel_timKiem.setFont(font_tieuDe);
        jLabel_timKiem.setBounds(1089, 57, 250, 28);


        JLabel jLabel_chiTietHoaDon = new JLabel("CHI TIẾT HÓA ĐƠN");
        jLabel_chiTietHoaDon.setFont(font_tieuDe);
        jLabel_chiTietHoaDon.setBounds(335, 350, 250, 28);

        JLabel jLabel_timKiemHoaDon= new JLabel("TÌM KIẾM HÓA ĐƠN:");
        jLabel_timKiemHoaDon.setFont(font_CTHDB);
        jLabel_timKiemHoaDon.setBounds(894, 119, 200, 16);

        JLabel jLabel_timKiemHoaDonTheo= new JLabel("TÌM KIẾM HÓA ĐƠN THEO:");
        jLabel_timKiemHoaDonTheo.setFont(font_CTHDB);
        jLabel_timKiemHoaDonTheo.setBounds(850, 186, 200, 16);
//---------------------------------------------------------------------------------------------
          jTextField_timKiemHD =  new JTextField();
         jTextField_timKiemHD.setFont(font_CTHDB);
         jTextField_timKiemHD.setBounds(1046, 115, 297, 24);

//----------------------------------------------------------------------------------------
    comboBox_timKiemTheoHDB = new JComboBox<>(String_timKiemTheoHDB);
    comboBox_timKiemTheoHDB.setFont(font_CTHDB);
    comboBox_timKiemTheoHDB.setBounds(1046, 182, 136, 24);

//-----------------------------------------------------------------------------------
    ImageIcon Icon_timKiem = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));    
    jButton_timKiemHDB = new JButton("TÌM KIẾM");
    jButton_timKiemHDB.setFont(font_CTHDB);
    jButton_timKiemHDB.setIcon(Icon_timKiem);
    jButton_timKiemHDB.setBounds(1207, 173, 136, 41);
    jButton_timKiemHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         findHDB(evt);
      }
  });

    ImageIcon Icon_reset = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
    jButton_resetHDB = new JButton("RESET");
    jButton_resetHDB.setFont(font_CTHDB);
    jButton_resetHDB.setIcon(Icon_reset);
    jButton_resetHDB.setBounds(1046, 274, 136, 41);
    jButton_resetHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      resetHDB();
      }
  });


    ImageIcon Icon_delete = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
    jButton_xoaHDB = new JButton("XÓA");
    jButton_xoaHDB.setFont(font_CTHDB);
    jButton_xoaHDB.setIcon(Icon_delete);
    jButton_xoaHDB.setBounds(1207, 274, 136, 41);
    jButton_xoaHDB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         deleteHDB(evt);
      }
  });

  ImageIcon Icon_export = new javax.swing.ImageIcon(getClass().getResource("/IMG/export.png"));
    jButton_xuatHD = new JButton("XUẤT HD");
    jButton_xuatHD.setFont(font_CTHDB);
    jButton_xuatHD.setIcon(Icon_export);
    jButton_xuatHD.setBounds(885, 274, 136, 41);
    jButton_xuatHD.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exportHDB(evt);
      }
  });





    //---------------------------------------------------------------------------


    jTable_HDB = new JTable();
    tableModel_HDB = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ HÓA ĐƠN", "MÃ KHÁCH HÀNG","TÊN KHÁCH HÀNG", "MÃ NHÂN VIÊN","TÊN NHÂN VIÊN", "NGÀY LẬP", "THANH TOÁN"} );
    jTable_HDB = new JTable(tableModel_HDB);
    jScrollPane_HDB = new JScrollPane(jTable_HDB);
    jScrollPane_HDB.setBounds(0, 57, 830, 258);
    jTable_HDB.addMouseListener(new MouseAdapter() {
    

      @Override
      public void mouseClicked(MouseEvent e) {
          JTable tableSelect = jTable_HDB;
          int selectedRow = tableSelect.getSelectedRow();
           resetCTHDB();
           maHDB = jTable_HDB.getValueAt(selectedRow, 1)+"";
          loadCTHDB(jTable_HDB.getValueAt(selectedRow, 1)+"");
       
        
        
          }
      });


    jTable_CTHDB = new JTable();
    tableModel_CTHDB = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ CHI TIẾT", "MÃ HÓA ĐƠN", "MÃ XE","TÊN XE", "GIÁ", "SỐ LƯỢNG", "TỔNG"});
    jTable_CTHDB = new JTable(tableModel_CTHDB);
    jScrollPane_CTHDB = new JScrollPane(jTable_CTHDB);
    jScrollPane_CTHDB.setBounds(0, 390, 830, 240);

    this.setBackground(new java.awt.Color(204, 255, 255));
        this.setLayout(null);
        this.add(jLabel_hoaDon);
        this.add(jLabel_timKiem);
        this.add(jLabel_chiTietHoaDon);
        this.add(jLabel_timKiemHoaDon);
        this.add(jLabel_timKiemHoaDonTheo);
        this.add(jTextField_timKiemHD);
        this.add(comboBox_timKiemTheoHDB);
        this.add(jButton_timKiemHDB);
        this.add(jButton_resetHDB);
        this.add(jButton_xoaHDB);
        this.add(jScrollPane_HDB);
        this.add(jScrollPane_CTHDB);
        this.add(jButton_xuatHD);
        
    }
    
   public void exportHDB (java.awt.event.ActionEvent evt)
   {
    if (jTable_HDB.getSelectedRow() == -1)
     {
      JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn để xuất!");
     }
     else 
     {
      exportHDB_PDF.exportHDB(maHDB.trim());
      JOptionPane.showMessageDialog(this,"Xuất hóa đơn thành công !");
     }

   }



    public void loadAllHDB()
    {
    ArrayList<HOA_DON_BAN_DTO> arr = new ArrayList<HOA_DON_BAN_DTO>();
    arr = hoa_DON_BAN_BUS.getAllHDB();
    DecimalFormat formatter = new DecimalFormat("#,###");
    for (int i = 0; i<arr.size(); i++)
    {
      HOA_DON_BAN_DTO hoa_DON_NHAP_DTO = arr.get(i);
      Object[] newrow = {i+1,hoa_DON_NHAP_DTO.getMA_HDB(),hoa_DON_NHAP_DTO.getMA_KH(), hoa_DON_NHAP_DTO.getTEN_KH() ,hoa_DON_NHAP_DTO.getMA_NV(),hoa_DON_NHAP_DTO.getTEN_NV() , hoa_DON_NHAP_DTO.getNGAY_LAP(), formatter.format((long)  hoa_DON_NHAP_DTO.getTHANH_TOAN() )};
      tableModel_HDB.addRow(newrow);
    }
  }

  public void loadHDBLenBang(ArrayList<HOA_DON_BAN_DTO> arr)
    {
     tableModel_HDB.setRowCount(0);  
    DecimalFormat formatter = new DecimalFormat("#,###");
    for (int i = 0; i<arr.size(); i++)
    {
      HOA_DON_BAN_DTO hoa_DON_NHAP_DTO = arr.get(i);
      Object[] newrow = {i+1,hoa_DON_NHAP_DTO.getMA_HDB(),hoa_DON_NHAP_DTO.getMA_KH(), hoa_DON_NHAP_DTO.getTEN_KH() ,hoa_DON_NHAP_DTO.getMA_NV(),hoa_DON_NHAP_DTO.getTEN_NV() , hoa_DON_NHAP_DTO.getNGAY_LAP(), formatter.format((long)  hoa_DON_NHAP_DTO.getTHANH_TOAN() )};
      tableModel_HDB.addRow(newrow);
    }
  }


  public void resetCTHDB ()
  {
     tableModel_CTHDB.setRowCount(0);
    
  }

  public void resetHDB ()
  {
    tableModel_HDB.setRowCount(0);
    jTextField_timKiemHD.setText("");
    loadAllHDB();
    resetCTHDB();
  }

  public void loadCTHDB(String maHDB)
  {
    ArrayList<CT_HOA_DON_BAN_DTO> arr = new ArrayList<CT_HOA_DON_BAN_DTO>();
    arr = ct_HOA_DON_BAN_BUS.getAllCTHDB(maHDB.trim());
    DecimalFormat formatter = new DecimalFormat("#,###");
    for (int i = 0; i<arr.size(); i++)
    {
      CT_HOA_DON_BAN_DTO ct_HOA_DON_NHAP_DTO = arr.get(i);
      Object[] newrow = {i+1,ct_HOA_DON_NHAP_DTO.getMA_CTHDB(), ct_HOA_DON_NHAP_DTO.getMA_HDB(),ct_HOA_DON_NHAP_DTO.getMA_XE() , ct_HOA_DON_NHAP_DTO.getTEN_XE(),formatter.format((long)  ct_HOA_DON_NHAP_DTO.getGIA_NHAP() ), ct_HOA_DON_NHAP_DTO.getSO_LUONG(), formatter.format((long) ct_HOA_DON_NHAP_DTO.getGIA())};
      tableModel_CTHDB.addRow(newrow);
    }
  }

  public void deleteHDB (java.awt.event.ActionEvent evt)
  {
     if (jTable_HDB.getSelectedRow() == -1)
     {
      JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn để xóa !");
     }
     else 
     {
        ct_HOA_DON_BAN_BUS.deleteCTHDB(maHDB.trim());
        hoa_DON_BAN_BUS.deleteHDB(maHDB.trim());
        JOptionPane.showMessageDialog(this,"Xóa hóa đơn thành công !");
        resetHDB();
        resetCTHDB(); 
     }
  }


  public void findHDB (java.awt.event.ActionEvent evt)
   {
     String selectedItem = (String) comboBox_timKiemTheoHDB.getSelectedItem();
    
     if (selectedItem.equals("Mã hóa đơn"))
     {
       if (jTextField_timKiemHD.getText().equals(""))
       {
         JOptionPane.showMessageDialog(this,"Không được để trống !");
       }
       else if (check1.checkMaKH(jTextField_timKiemHD.getText().trim(), "HDB") == false  )
       {
         JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng địng dạng mã hóa đơn (VD : HDB58421) !");
       } 
       else
        {
          ArrayList<HOA_DON_BAN_DTO>  data = hoa_DON_BAN_BUS.findHDB(jTextField_timKiemHD.getText().trim(), "MA_HDB");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
          }
          else 
          {
            tableModel_HDB.setRowCount(0);
            loadHDBLenBang(data);
          }
        }
      }


      if (selectedItem.equals("Mã nhân viên"))
     {
       if (jTextField_timKiemHD.getText().equals(""))
       {
         JOptionPane.showMessageDialog(this,"Không được để trống !");
       }
       else if (check1.checkMaKH(jTextField_timKiemHD.getText().trim(), "MNV") == false  )
       {
         JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng địng dạng mã nhân viên (VD : MNV58421) !");
       } 
       else
        {
          ArrayList<HOA_DON_BAN_DTO>  data = hoa_DON_BAN_BUS.findHDB(jTextField_timKiemHD.getText().trim(), "HOA_DON_BAN.MA_NV");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
          }
          else 
          {
            tableModel_HDB.setRowCount(0);
            loadHDBLenBang(data);
          }
        }
      }
 
      else if (selectedItem.equals("Ngày lập"))
      {
        if (jTextField_timKiemHD.getText().equals(""))
        {
          JOptionPane.showMessageDialog(this,"Không được để trống !");
        }
        else if (check1.checkThoiGian(jTextField_timKiemHD.getText().trim()) == false)
        {
          JOptionPane.showMessageDialog(this,"Ngày tháng năm không hợp lệ ! (VD:02/03/2023)");
        }
        else 
        {
          ArrayList<HOA_DON_BAN_DTO>  arrHDN = hoa_DON_BAN_BUS.getAllHDB();
          ArrayList<HOA_DON_BAN_DTO>  data = new ArrayList<HOA_DON_BAN_DTO>();
          for (int i = 0; i<arrHDN.size(); i++)
          {
            String dateTimeString = arrHDN.get(i).getNGAY_LAP().trim();
            String dateString = dateTimeString.substring(0, 10);
            if (dateString.equals(jTextField_timKiemHD.getText().toUpperCase().trim()))
            {
              data.add(arrHDN.get(i));
            }
          }
        if (data.size() == 0)
        {
          JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn này !");
        }
        else 
        {
          tableModel_HDB.setRowCount(0);
          loadHDBLenBang(data);
        }
        }
      }



      else if (selectedItem.equals("Tên khách hàng"))
      {
        if (jTextField_timKiemHD.getText().equals(""))
        {
          JOptionPane.showMessageDialog(this,"Không được để trống !");
        }
        
        else 
        {
          ArrayList<HOA_DON_BAN_DTO>  arrHDN = hoa_DON_BAN_BUS.getAllHDB();
          ArrayList<HOA_DON_BAN_DTO>  data = new ArrayList<HOA_DON_BAN_DTO>();
          for (int i = 0; i<arrHDN.size(); i++)
          {
          
            if (arrHDN.get(i).getTEN_KH().toUpperCase().trim().equals(jTextField_timKiemHD.getText().toUpperCase().trim()))
            {
              data.add(arrHDN.get(i));
            }
          }
        if (data.size() == 0)
        {
          JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn này !");
        }
        else 
        {
          tableModel_HDB.setRowCount(0);
          loadHDBLenBang(data);
        }
        }
      }


     else if (selectedItem.equals("Thanh toán"))
     {
       if (jTextField_timKiemHD.getText().equals(""))
       {
         JOptionPane.showMessageDialog(this,"Không được để trống !");
       }
       else if (check1.checkGiaNhap(jTextField_timKiemHD.getText().trim()) == false  )
       {
         JOptionPane.showMessageDialog(this,"Định dạng giá sai !");
       } 
       else
        {
          ArrayList<HOA_DON_BAN_DTO>  data = hoa_DON_BAN_BUS.findHDB(jTextField_timKiemHD.getText().trim(), "THANH_TOAN");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
            
          }
          else 
          {
            tableModel_HDB.setRowCount(0);
            loadHDBLenBang(data);
          }
        }
      }
   

    if (selectedItem.equals("Mã khách hàng"))
     {
       if (jTextField_timKiemHD.getText().equals(""))
       {
         JOptionPane.showMessageDialog(this,"Không được để trống !");
       }
       else if (check1.checkMaKH(jTextField_timKiemHD.getText().trim(), "MKH") == false  )
       {
         JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng địng dạng mã khách hàng (VD : MKH58421) !");
       } 
       else
        {
          ArrayList<HOA_DON_BAN_DTO>  data = hoa_DON_BAN_BUS.findHDB(jTextField_timKiemHD.getText().trim(), "HOA_DON_BAN.MA_KH");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
          }
          else 
          {
            tableModel_HDB.setRowCount(0);
            loadHDBLenBang(data);
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

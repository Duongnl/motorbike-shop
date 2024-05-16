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

import BUS.CT_HOA_DON_NHAP_BUS;
import BUS.HOA_DON_NHAP_BUS;
import CHECK.Check1;
import DTO.CT_HOA_DON_NHAP_DTO;
import DTO.HOA_DON_NHAP_DTO;
import Export.ExportHDN_PDF;

public class CT_HOA_DON_NHAP_GUI extends JPanel 
{
    private String[] String_timKiemTheoHDN = {"Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Thanh toán"};
    JComboBox<String> comboBox_timKiemTheoHDN;
    private JTextField jTextField_timKiemHD;
    private JButton jButton_timKiemHDN;
    private JButton jButton_resetHDN;
    private JButton jButton_xoaHDN;
    private JTable jTable_HDN;
    private NonEditableTableModel tableModel_HDN;
    private JScrollPane jScrollPane_HDN;
    private JTable jTable_CTHDN;
    private NonEditableTableModel tableModel_CTHDN;
    private JScrollPane jScrollPane_CTHDN;
    private HOA_DON_NHAP_BUS hoa_DON_NHAP_BUS = new HOA_DON_NHAP_BUS();
    private CT_HOA_DON_NHAP_BUS ct_HOA_DON_NHAP_BUS = new CT_HOA_DON_NHAP_BUS();
    private String maHDN;
    private Check1 check1 = new Check1();
    private JButton jButton_xuatHD;
    private ExportHDN_PDF exportHDN_PDF = new ExportHDN_PDF();

    public CT_HOA_DON_NHAP_GUI ()
    {
        init_CT_HoaDonNhap();
        loadAllHDN();
    }

    public void init_CT_HoaDonNhap ()
    {

        
        Font font_tieuDe = new Font("Arial", Font.BOLD, 25);
        Font font_CTHDB = new Font("Arial", Font.BOLD, 14); 

        JLabel jLabel_hoaDon = new JLabel("HÓA ĐƠN NHẬP XE");
        jLabel_hoaDon.setFont(font_tieuDe);
        jLabel_hoaDon.setBounds(320, 15, 300, 28);

        JLabel jLabel_timKiem = new JLabel("TÌM KIẾM HÓA ĐƠN");
        jLabel_timKiem.setFont(font_tieuDe);
        jLabel_timKiem.setBounds(1089, 57, 250, 28);


        JLabel jLabel_chiTietHoaDon = new JLabel("CHI TIẾT HÓA ĐƠN NHẬP XE");
        jLabel_chiTietHoaDon.setFont(font_tieuDe);
        jLabel_chiTietHoaDon.setBounds(260, 350, 500, 28);

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
    comboBox_timKiemTheoHDN = new JComboBox<>(String_timKiemTheoHDN);
    comboBox_timKiemTheoHDN.setFont(font_CTHDB);
    comboBox_timKiemTheoHDN.setBounds(1046, 182, 136, 24);

//-----------------------------------------------------------------------------------
    ImageIcon Icon_timKiem = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));    
    jButton_timKiemHDN = new JButton("TÌM KIẾM");
    jButton_timKiemHDN.setFont(font_CTHDB);
    jButton_timKiemHDN.setIcon(Icon_timKiem);
    jButton_timKiemHDN.setBounds(1207, 173, 136, 41);
    jButton_timKiemHDN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       findHDN(evt);
      }
  });

    ImageIcon Icon_reset = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
    jButton_resetHDN = new JButton("RESET");
    jButton_resetHDN.setFont(font_CTHDB);
    jButton_resetHDN.setIcon(Icon_reset);
    jButton_resetHDN.setBounds(1046, 274, 136, 41);
    jButton_resetHDN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       resetHDN();
       resetCTHDN();
      }
  });

  ImageIcon Icon_export = new javax.swing.ImageIcon(getClass().getResource("/IMG/export.png"));
    jButton_xuatHD = new JButton("XUẤT HD");
    jButton_xuatHD.setFont(font_CTHDB);
    jButton_xuatHD.setIcon(Icon_export);
    jButton_xuatHD.setBounds(885, 274, 136, 41);
    jButton_xuatHD.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exportHDN(evt);
      }
  });
 
    ImageIcon Icon_delete = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
    jButton_xoaHDN = new JButton("XÓA");
    jButton_xoaHDN.setFont(font_CTHDB);
    jButton_xoaHDN.setIcon(Icon_delete);
    jButton_xoaHDN.setBounds(1207, 274, 136, 41);
    jButton_xoaHDN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       deleteHDN(evt);
      }
  });

    //---------------------------------------------------------------------------


    jTable_HDN = new JTable();
    tableModel_HDN = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ HÓA ĐƠN", "MÃ NHÂN VIÊN", "TÊN NHÂN VIÊN" ,"NGÀY LẬP", "THANH TOÁN"} );
    jTable_HDN = new JTable(tableModel_HDN);
    jScrollPane_HDN = new JScrollPane(jTable_HDN);
    jScrollPane_HDN.setBounds(0, 57, 830, 258);
    jTable_HDN.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          JTable tableSelect = jTable_HDN;
          int selectedRow = tableSelect.getSelectedRow();
          resetCTHDN();
           maHDN = jTable_HDN.getValueAt(selectedRow, 1)+"";
          loadCTHDN(jTable_HDN.getValueAt(selectedRow, 1)+"");
       
        
        
          }
      });


    jTable_CTHDN = new JTable();
    tableModel_CTHDN = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ CHI TIẾT", "MÃ HÓA ĐƠN", "MÃ XE" ,"TÊN XE","GIÁ NHẬP","SỐ LƯỢNG","TỔNG"});
    jTable_CTHDN = new JTable(tableModel_CTHDN);
    jScrollPane_CTHDN = new JScrollPane(jTable_CTHDN);
    jScrollPane_CTHDN.setBounds(0, 390, 830, 240);
    
    this.setBackground(new java.awt.Color(204, 255, 255));
        this.setLayout(null);
        this.add(jLabel_hoaDon);
        this.add(jLabel_timKiem);
        this.add(jLabel_chiTietHoaDon);
        this.add(jLabel_timKiemHoaDon);
        this.add(jLabel_timKiemHoaDonTheo);
        this.add(jTextField_timKiemHD);
        this.add(comboBox_timKiemTheoHDN);
        this.add(jButton_timKiemHDN);
        this.add(jButton_resetHDN);
        this.add(jButton_xoaHDN);
        this.add(jScrollPane_HDN);
        this.add(jScrollPane_CTHDN);
        this.add(jButton_xuatHD);
    }

    public void deleteHDN (java.awt.event.ActionEvent evt)
    {
       if (jTable_HDN.getSelectedRow() == -1)
       {
        JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn để xóa !");
       }
       else 
       {
          ct_HOA_DON_NHAP_BUS.deleteCTHDN(maHDN.trim());
          hoa_DON_NHAP_BUS.deleteHDN(maHDN.trim());
          JOptionPane.showMessageDialog(this,"Xóa hóa đơn thành công !");
          resetHDN();
          resetCTHDN(); 
       }

    }
 

    public void exportHDN (java.awt.event.ActionEvent evt)
    {
     if (jTable_HDN.getSelectedRow() == -1)
      {
       JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn để xuất!");
      }
      else 
      {
       exportHDN_PDF.exportHDN(maHDN.trim());
       JOptionPane.showMessageDialog(this,"Xuất hóa đơn thành công !");
      }
 
    }
 

    public void loadAllHDN()
    {
    ArrayList<HOA_DON_NHAP_DTO> arr = new ArrayList<HOA_DON_NHAP_DTO>();
    arr = hoa_DON_NHAP_BUS.getAllHDN();
    DecimalFormat formatter = new DecimalFormat("#,###");
    for (int i = 0; i<arr.size(); i++)
    {
      HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO = arr.get(i);
      Object[] newrow = {i+1,hoa_DON_NHAP_DTO.getMA_HDN(), hoa_DON_NHAP_DTO.getMA_NV(),hoa_DON_NHAP_DTO.getTEN_NV() , hoa_DON_NHAP_DTO.getNGAY_LAP(), formatter.format((long)  hoa_DON_NHAP_DTO.getTONG_TIEN() )};
      tableModel_HDN.addRow(newrow);
    }
  } 

  public void loadHDNLenBang(ArrayList<HOA_DON_NHAP_DTO> arr)
    {
     tableModel_HDN.setRowCount(0);  
    DecimalFormat formatter = new DecimalFormat("#,###");
    for (int i = 0; i<arr.size(); i++)
    {
      HOA_DON_NHAP_DTO hoa_DON_NHAP_DTO = arr.get(i);
      Object[] newrow = {i+1,hoa_DON_NHAP_DTO.getMA_HDN(), hoa_DON_NHAP_DTO.getMA_NV(),hoa_DON_NHAP_DTO.getTEN_NV() , hoa_DON_NHAP_DTO.getNGAY_LAP(), formatter.format((long)  hoa_DON_NHAP_DTO.getTONG_TIEN() )};
      tableModel_HDN.addRow(newrow);
    }
  }

  public void loadCTHDN (String maHDN)
  {
    ArrayList<CT_HOA_DON_NHAP_DTO> arr = new ArrayList<CT_HOA_DON_NHAP_DTO>();
    arr = ct_HOA_DON_NHAP_BUS.getAllCTHDN(maHDN.trim());
    DecimalFormat formatter = new DecimalFormat("#,###");
    for (int i = 0; i<arr.size(); i++)
    {
      CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = arr.get(i);
      Object[] newrow = {i+1,ct_HOA_DON_NHAP_DTO.getMA_CTHDN(), ct_HOA_DON_NHAP_DTO.getMA_HDN(),ct_HOA_DON_NHAP_DTO.getMA_XE() , ct_HOA_DON_NHAP_DTO.getTEN_XE(),formatter.format((long)  ct_HOA_DON_NHAP_DTO.getGIA_NHAP() ), ct_HOA_DON_NHAP_DTO.getSO_LUONG(), formatter.format((long) ct_HOA_DON_NHAP_DTO.getGIA())};
      tableModel_CTHDN.addRow(newrow);
    }
  }

  public void resetCTHDN ()
  {
     tableModel_CTHDN.setRowCount(0);
    
  }

  public void resetHDN ()
   {
    tableModel_HDN.setRowCount(0);
    loadAllHDN();
    comboBox_timKiemTheoHDN.setSelectedIndex(0);
    jTextField_timKiemHD.setText("");
   }

   public void findHDN (java.awt.event.ActionEvent evt)
   {
     String selectedItem = (String) comboBox_timKiemTheoHDN.getSelectedItem();
    
     if (selectedItem.equals("Mã hóa đơn"))
     {
       if (jTextField_timKiemHD.getText().equals(""))
       {
         JOptionPane.showMessageDialog(this,"Không được để trống !");
       }
       else if (check1.checkMaKH(jTextField_timKiemHD.getText().trim(), "HDN") == false  )
       {
         JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng địng dạng mã hóa đơn (VD : HDN58421) !");
       } 
       else
        {
          ArrayList<HOA_DON_NHAP_DTO>  data = hoa_DON_NHAP_BUS.findHDN(jTextField_timKiemHD.getText().trim(), "MA_HDN");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
          }
          else 
          {
            tableModel_HDN.setRowCount(0);
            loadHDNLenBang(data);
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
          ArrayList<HOA_DON_NHAP_DTO>  data = hoa_DON_NHAP_BUS.findHDN(jTextField_timKiemHD.getText().trim(), "HOA_DON_NHAP.MA_NV");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
          }
          else 
          {
            tableModel_HDN.setRowCount(0);
            loadHDNLenBang(data);
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
          ArrayList<HOA_DON_NHAP_DTO>  arrHDN = hoa_DON_NHAP_BUS.getAllHDN();
          ArrayList<HOA_DON_NHAP_DTO>  data = new ArrayList<HOA_DON_NHAP_DTO>();
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
          tableModel_HDN.setRowCount(0);
          loadHDNLenBang(data);
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
          ArrayList<HOA_DON_NHAP_DTO>  data = hoa_DON_NHAP_BUS.findHDN(jTextField_timKiemHD.getText().trim(), "TONG_TIEN");
          if (data.size() == 0)
          {
            JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn nào !");
            
          }
          else 
          {
            tableModel_HDN.setRowCount(0);
            loadHDNLenBang(data);
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

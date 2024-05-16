package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import CHECK.*;
import BUS.HANG_XE_BUS;
import DTO.HANG_XE_DTO;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class HANG_XE_GUI extends JPanel {

    private JTable jTable_HangXe;
    private NonEditableTableModel tableModel_HangXe;
    private JScrollPane jScrollPane_HangXe;
    
    private JTextField jTextField_maHang;
    private JTextField jTextField_tenHang;
    private JTextArea jTextArea_moTaHang;
    private JScrollPane jScrollPane_motaHang;
    private JButton jButton_themHang;
    private JButton jButton_suaHang;
    private JButton jButton_xoaHang;
    private JButton jButton_resetHang;
    
    // private JTextField jTextField_timKiem;
    // private String[] String_timKiemTheoHang = { };
    // JComboBox<String> comboBox_timKiemTheoHang;
    // private JButton jButton_timKiemHang;
  private HANG_XE_BUS hang_XE_BUS = new HANG_XE_BUS();
  private Check1 check1;

    public HANG_XE_GUI ()
    {
       check1 = new Check1();
        this.init_HANG_XE();   
        loadAllHangXe();
    }
    

    public void init_HANG_XE ()
    {
        // table hãng xe
         jTable_HangXe = new JTable();
         tableModel_HangXe = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT" ,"MÃ HÃNG", "TÊN HÃNG", "MÔ TẢ"} );
        jTable_HangXe = new JTable(tableModel_HangXe);
        jScrollPane_HangXe = new JScrollPane(jTable_HangXe);
        jScrollPane_HangXe.setBounds(0, 0, 814, 312);

        jTable_HangXe.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              JTable tableSelect = jTable_HangXe;
              int selectedRow = tableSelect.getSelectedRow();
              jTextField_maHang.setText(jTable_HangXe.getValueAt(selectedRow, 1)+"");
              jTextField_tenHang.setText(jTable_HangXe.getValueAt(selectedRow, 2)+"");
              jTextArea_moTaHang.setText(jTable_HangXe.getValueAt(selectedRow, 3)+"");
            }
      });




        // font của hãng xe
        Font font_hangXe = new Font("Arial", Font.BOLD, 14);

        // text mã hãng 
        JLabel jLabel_textMaHang = new JLabel("MÃ HÃNG:");
        jLabel_textMaHang.setFont(font_hangXe);
        jLabel_textMaHang.setBounds(14, 345, 77, 16);


        // jtextfile mã hãng
        jTextField_maHang = new JTextField();
        jTextField_maHang.setFont(font_hangXe);
        jTextField_maHang.setBounds(99, 341, 270, 24);
        jTextField_maHang.setText("Hãng mới");
        jTextField_maHang.setEditable(false);
        jTextField_maHang.setBackground(Color.LIGHT_GRAY);
        // text tên hãng
        JLabel jLabel_textTenHang = new JLabel("TÊN HÃNG:");
        jLabel_textTenHang.setFont(font_hangXe);
        jLabel_textTenHang.setBounds(14, 401, 85, 16);

        // jtextfile tên hãng
        jTextField_tenHang = new JTextField();
        jTextField_tenHang.setFont(font_hangXe);
        jTextField_tenHang.setBounds(99, 397, 270, 24);

        // text mô tả
        JLabel jLabel_textMoTaHang = new JLabel("MÔ TẢ:");
        jLabel_textMoTaHang.setFont(font_hangXe);
        jLabel_textMoTaHang.setBounds(14, 451, 73, 16);

        // JTEXTFILE mô tả 
         jTextArea_moTaHang = new JTextArea();
         jTextArea_moTaHang.setFont(font_hangXe);
         jScrollPane_motaHang = new JScrollPane(jTextArea_moTaHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         jScrollPane_motaHang.setBounds(100, 451, 269, 136);

        //  jbutton them
        ImageIcon Icon_themHang = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
        jButton_themHang = new JButton("THÊM HÃNG");
        jButton_themHang.setFont(font_hangXe);
        jButton_themHang.setIcon(Icon_themHang);
        jButton_themHang.setBounds(544, 332, 160, 42);
        jButton_themHang.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           addHangXe(evt);
          }
      });

      jButton_themHang.addKeyListener(new KeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
             addHangXe(null);
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {}
        
        @Override
        public void keyReleased(KeyEvent e) {}
      });

        // jbutton sửa
        ImageIcon Icon_suaHang = new javax.swing.ImageIcon(getClass().getResource("/IMG/edit.png"));
        jButton_suaHang = new JButton("SỬA");
        jButton_suaHang.setFont(font_hangXe);
        jButton_suaHang.setIcon(Icon_suaHang);
        jButton_suaHang.setBounds(544, 397, 160, 42);
        jButton_suaHang.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            editHangXe(evt);
          }
      });

        // jbutton xóa
        ImageIcon Icon_xoaHang = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
        jButton_xoaHang = new JButton("XÓA");
        jButton_xoaHang.setFont(font_hangXe);
        jButton_xoaHang.setIcon(Icon_xoaHang);
        jButton_xoaHang.setBounds(544, 459, 160, 42);
        jButton_xoaHang.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           deleteHangXe(evt);
          }
      });

        // jbutton reset
        ImageIcon Icon_resetHang = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
        jButton_resetHang = new JButton("RESET");
        jButton_resetHang.setFont(font_hangXe);
        jButton_resetHang.setIcon(Icon_resetHang);
        jButton_resetHang.setBounds(544, 524, 160, 42);
        jButton_resetHang.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           resetHangXe();
          }
      });

        // // JLABLE TÌM KIẾM HÃNG
        // Font font_timKiemHang = new Font("Arial ", Font.BOLD, 20);
        // JLabel jLabel_textTimKiemHang = new JLabel("TÌM KIẾM HÃNG");
        // jLabel_textTimKiemHang.setFont(font_timKiemHang);
        // jLabel_textTimKiemHang.setBounds(1051, 26, 161, 24);

        // // jlabel tìm kiếm 
        // JLabel jLabel_textTimKiem = new JLabel("TÌM KIẾM:");
        // jLabel_textTimKiem.setFont(font_hangXe);
        // jLabel_textTimKiem.setBounds(895, 69 , 73, 16);

        // // jtextfile tìm kiếm 
        // jTextField_timKiem = new JTextField();
        // jTextField_timKiem.setFont(font_hangXe);
        // jTextField_timKiem.setBounds(1019, 65, 270, 24);

        // // jlabel tìm kiếm theo
        // JLabel jLabel_textTimKiemTheo = new JLabel("TÌM KIẾM THEO:");
        // jLabel_textTimKiemTheo.setFont(font_hangXe);
        // jLabel_textTimKiemTheo.setBounds(894, 132 , 103, 16);

        // // combobox tìm kiếm theo hãng
        // comboBox_timKiemTheoHang = new JComboBox<>(String_timKiemTheoHang);
        // comboBox_timKiemTheoHang.setFont(font_hangXe);
        // comboBox_timKiemTheoHang.setBounds(1019, 128, 109, 24);

        // // jbutton tìm kiếm 
        // ImageIcon Icon_timKiemHang = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png");
        // jButton_timKiemHang = new JButton("TÌM KIẾM");
        // jButton_timKiemHang.setFont(font_hangXe);
        // jButton_timKiemHang.setIcon(Icon_timKiemHang);
        // jButton_timKiemHang.setBounds(1074, 210, 136, 42);





 


        this.setBackground(new java.awt.Color(204, 255, 255));

        this.setLayout(null);
        this.add(jScrollPane_HangXe);
        this.add(jLabel_textMaHang);
        this.add(jTextField_maHang);
        this.add(jLabel_textTenHang);
        this.add(jTextField_tenHang);
        this.add(jLabel_textMoTaHang);
        this.add(jScrollPane_motaHang);
        this.add(jButton_themHang);
        this.add(jButton_suaHang);
        this.add(jButton_xoaHang);
        this.add(jButton_resetHang);
        
        // this.add(jLabel_textTimKiemHang);
        // this.add(jLabel_textTimKiem);
        // this.add(jTextField_timKiem);
        // this.add(jLabel_textTimKiemTheo);
        // this.add(comboBox_timKiemTheoHang);
        // this.add(jButton_timKiemHang);
        
        
    }

    public void loadAllHangXe ()
    {
      ArrayList<HANG_XE_DTO> arrHangXe = new ArrayList<HANG_XE_DTO>();
      arrHangXe = hang_XE_BUS.getAllHangXe();

      for (int i = 0; i<arrHangXe.size(); i++)
      {
        HANG_XE_DTO hang_XE_DTO = arrHangXe.get(i);
        Object[] newrow = {i+1,hang_XE_DTO.getMA_HANG(), hang_XE_DTO.getTEN_HANG(), hang_XE_DTO.getMO_TA()};
        tableModel_HangXe.addRow(newrow);
      }
    }

    public void resetHangXe ()
    {
      tableModel_HangXe.setRowCount(0);
      loadAllHangXe();
      jTextField_maHang.setText("Hãng mới");
      jTextField_tenHang.setText("");
      jTextArea_moTaHang.setText("");
    }

    public void addHangXe(java.awt.event.ActionEvent evt)
    {
      if ( jTextField_maHang.getText().equals("Hãng mới") == false)  
      { 
        JOptionPane.showMessageDialog(this, "Mã hãng xe tồn tại !, bấm reset để thêm hãng xe mới");
      }
      
      else if ( jTextField_tenHang.getText().equals("") || jTextArea_moTaHang.getText().equals("") )
      {
        JOptionPane.showMessageDialog(this, "Các trường không được để trống !");
      }
      else if (check1.CheckTen(jTextField_tenHang.getText().trim(),30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên hãng phải nhỏ hơn 30 chữ cái !");
      }
      else if (check1.CheckTen(jTextArea_moTaHang.getText().trim(),40) == false)
      {
        JOptionPane.showMessageDialog(this, "Mô tả phải nhỏ hơn 40 chữ cái !");
      }
     else 
     {
        Boolean flag = true;  
         
        if (hang_XE_BUS.checkTenHang(jTextField_tenHang.getText().trim()))
          {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại hãng này, bạn có muốn thêm tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
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
          String maHang = "";
          HANG_XE_DTO hang_XE_DTO = new HANG_XE_DTO();
        
            while (true) 
            {
              maHang = check1.generateRandomCode("MH");
              if ( hang_XE_BUS.checkMaHang(maHang) == false)
                {
                    break;
                }
            }
              jTextField_maHang.setText(maHang.trim());
              hang_XE_DTO.setMA_HANG(maHang.trim());
              hang_XE_DTO.setTEN_HANG(jTextField_tenHang.getText().trim());
              hang_XE_DTO.setMO_TA(jTextArea_moTaHang.getText().trim());
              hang_XE_BUS.addHangXe(hang_XE_DTO);
              JOptionPane.showMessageDialog(this, "Thêm hãng xe thành công (Mã hãng: " + hang_XE_DTO.getMA_HANG() +")");
              resetHangXe();
        }
      
        
      }
    
    }


    public void editHangXe(java.awt.event.ActionEvent evt)
    {
      if (jTextField_maHang.getText().equals("Hãng mới"))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn hãng!");
      }
      else if (jTextField_tenHang.getText().equals("") || jTextArea_moTaHang.getText().equals("") )
      {
        JOptionPane.showMessageDialog(this, "Các trường không được để trống !");
      }
      else if (check1.CheckTen(jTextField_tenHang.getText().trim(),30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên hãng phải nhỏ hơn 30 chữ cái !");
      }
      else if (check1.CheckTen(jTextArea_moTaHang.getText().trim(),40) == false)
      {
        JOptionPane.showMessageDialog(this, "Mô tả phải nhỏ hơn 40 chữ cái !");
      }
      
     else 
     {
       
      Boolean flag = true;
      if (hang_XE_BUS.checkTenHang(jTextField_tenHang.getText().trim()))
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại hãng xe này, bạn có muốn sửa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
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
        HANG_XE_DTO hang_XE_DTO = new HANG_XE_DTO();
        hang_XE_DTO.setMA_HANG(jTextField_maHang.getText().trim());
        hang_XE_DTO.setTEN_HANG(jTextField_tenHang.getText().trim());
        hang_XE_DTO.setMO_TA(jTextArea_moTaHang.getText().trim());
        hang_XE_BUS.editHangXe(hang_XE_DTO);
        JOptionPane.showMessageDialog(this, "Sửa hãng xe thành công");
        resetHangXe();
      }
      }
    
    }

    public void deleteHangXe(java.awt.event.ActionEvent evt)
    {
      if (jTextField_maHang.getText().equals("Hãng mới"))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn hãng xe !");
      }
     else 
     {
      Boolean flag = true;  
      if (hang_XE_BUS.checkMaHangInXeMay(jTextField_maHang.getText().trim()))
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đang có xe đang sử dụng hãng này, bạn vẫn muốn xóa chứ ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) 
            {
               flag = true;
               hang_XE_BUS.updateHangXeMay(jTextField_maHang.getText().trim());
            } 
            else 
              {
                flag = false;
              }
        }

      if (flag == true)
      {
         hang_XE_BUS.deleteMauXe(jTextField_maHang.getText().trim());
         JOptionPane.showMessageDialog(this, "Xóa hãng xe thành công");
         resetHangXe();
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

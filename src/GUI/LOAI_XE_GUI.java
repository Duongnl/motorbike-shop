package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import BUS.*;
import DTO.*;
import CHECK.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;



public class LOAI_XE_GUI extends JPanel {

    private JTable jTable_LoaiXe;
    private NonEditableTableModel tableModel_LoaiXe;
    private JScrollPane jScrollPane_LoaiXe;
    private JTextField jTextField_maLoai;
    private JTextField jTextField_tenLoai;
    private JTextArea jTextArea_moTaLoai;
    private JScrollPane jScrollPane_moTaLoai;
    private JButton jButton_themLoai;
    private JButton jButton_suaLoai;
    private JButton jButton_xoaLoai;
    private JButton jButton_resetLoai;
    private LOAI_XE_BUS loai_XE_BUS = new LOAI_XE_BUS();
    private Check1 check1;

    public LOAI_XE_GUI ()
    {
       check1 = new Check1();
        this.init_LOAI_XE();   
        loadAllLoaiXe();
    }
    

    public void init_LOAI_XE ()
    {
        // table hãng xe
         jTable_LoaiXe = new JTable();
         tableModel_LoaiXe = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT" ,"MÃ LOẠI", "TÊN LOẠI", "MÔ TẢ"} );
        jTable_LoaiXe = new JTable(tableModel_LoaiXe);
        jScrollPane_LoaiXe = new JScrollPane(jTable_LoaiXe);
        jScrollPane_LoaiXe.setBounds(0, 0, 1415, 312);

        jTable_LoaiXe.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              JTable tableSelect = jTable_LoaiXe;
              int selectedRow = tableSelect.getSelectedRow();
              jTextField_maLoai.setText(jTable_LoaiXe.getValueAt(selectedRow, 1)+"");
              jTextField_tenLoai.setText(jTable_LoaiXe.getValueAt(selectedRow, 2)+"");
              jTextArea_moTaLoai.setText(jTable_LoaiXe.getValueAt(selectedRow, 3)+"");
            }
      });



        // font của hãng xe
        Font font_loaiXe = new Font("Arial", Font.BOLD, 14);

        // text mã hãng 
        JLabel jLabel_textMaHang = new JLabel("MÃ LOẠI:");
        jLabel_textMaHang.setFont(font_loaiXe);
        jLabel_textMaHang.setBounds(14, 345, 73, 16);

        // jtextfile mã hãng
        jTextField_maLoai = new JTextField();
        jTextField_maLoai.setFont(font_loaiXe);
        jTextField_maLoai.setBounds(99, 341, 270, 24);
        jTextField_maLoai.setText("Loại mới");
        jTextField_maLoai.setEditable(false);
        jTextField_maLoai.setBackground(Color.LIGHT_GRAY);

        // text tên hãng
        JLabel jLabel_textTenHang = new JLabel("TÊN LOẠI:");
        jLabel_textTenHang.setFont(font_loaiXe);
        jLabel_textTenHang.setBounds(14, 401, 73, 16);

        // jtextfile tên hãng
        jTextField_tenLoai = new JTextField();
        jTextField_tenLoai.setFont(font_loaiXe);
        jTextField_tenLoai.setBounds(99, 397, 270, 24);

        // text mô tả
        JLabel jLabel_textMoTaHang = new JLabel("MÔ TẢ:");
        jLabel_textMoTaHang.setFont(font_loaiXe);
        jLabel_textMoTaHang.setBounds(14, 451, 73, 16);

        // JTEXTFILE mô tả 
         jTextArea_moTaLoai = new JTextArea();
         jTextArea_moTaLoai.setFont(font_loaiXe);
         jScrollPane_moTaLoai = new JScrollPane(jTextArea_moTaLoai, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         jScrollPane_moTaLoai.setBounds(100, 451, 269, 136);

        //  jbutton them
        ImageIcon Icon_themLoai = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
        jButton_themLoai = new JButton("THÊM LOẠI");
        jButton_themLoai.setFont(font_loaiXe);
        jButton_themLoai.setIcon(Icon_themLoai);
        jButton_themLoai.setBounds(544, 332, 150, 42);
        jButton_themLoai.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            addLoaiXe(evt);
          }
      });

      jButton_themLoai.addKeyListener(new KeyListener() {
          @Override
          public void keyPressed(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                addLoaiXe(null);
                
              }
          }
          @Override
          public void keyTyped(KeyEvent e) {}
          
          @Override
          public void keyReleased(KeyEvent e) {}
        });

        // jbutton sửa
        ImageIcon Icon_suaLoai = new javax.swing.ImageIcon(getClass().getResource("/IMG/edit.png"));
        jButton_suaLoai = new JButton("SỬA");
        jButton_suaLoai.setFont(font_loaiXe);
        jButton_suaLoai.setIcon(Icon_suaLoai);
        jButton_suaLoai.setBounds(544, 397, 150, 42);
        jButton_suaLoai.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           editLoaiXe(evt);
          }
      });

        // jbutton xóa
        ImageIcon Icon_xoaLoai = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
        jButton_xoaLoai = new JButton("XÓA");
        jButton_xoaLoai.setFont(font_loaiXe);
        jButton_xoaLoai.setIcon(Icon_xoaLoai);
        jButton_xoaLoai.setBounds(544, 459, 150, 42);
        jButton_xoaLoai.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           deleteLoaiXe(evt);
          }
      });

        // jbutton reset
        ImageIcon Icon_resetHang = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
        jButton_resetLoai = new JButton("RESET");
        jButton_resetLoai.setFont(font_loaiXe);
        jButton_resetLoai.setIcon(Icon_resetHang);
        jButton_resetLoai.setBounds(544, 524, 150, 42);
        jButton_resetLoai.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           resetLoaiXe();
          }
      });

      this.setBackground(new java.awt.Color(204, 255, 255));

        this.setLayout(null);
        this.add(jScrollPane_LoaiXe);
        this.add(jLabel_textMaHang);
        this.add(jTextField_maLoai);
        this.add(jLabel_textTenHang);
        this.add(jTextField_tenLoai);
        this.add(jLabel_textMoTaHang);
        this.add(jScrollPane_moTaLoai);
        this.add(jButton_themLoai);
        this.add(jButton_suaLoai);
        this.add(jButton_xoaLoai);
        this.add(jButton_resetLoai);
        
        
    }

    public void loadAllLoaiXe ()
    {
      ArrayList<LOAI_XE_DTO> arrLoaiXe = new ArrayList<LOAI_XE_DTO>();
      arrLoaiXe = loai_XE_BUS.getAllLoaiXe();

      for (int i = 0; i<arrLoaiXe.size(); i++)
      {
        LOAI_XE_DTO loai_XE_DTO = arrLoaiXe.get(i);
        Object[] newrow = {i+1,loai_XE_DTO.getMA_LOAI(), loai_XE_DTO.getTEN_LOAI_XE(), loai_XE_DTO.getMO_TA()};
        tableModel_LoaiXe.addRow(newrow);
      }
      
    }



    public void resetLoaiXe ()
    {
      tableModel_LoaiXe.setRowCount(0);
      loadAllLoaiXe();
      jTextField_maLoai.setText("Loại mới");
      jTextField_tenLoai.setText("");
      jTextArea_moTaLoai.setText("");
    }

    public void addLoaiXe(java.awt.event.ActionEvent evt)
    {
      if ( jTextField_maLoai.getText().equals("Loại mới") == false)  
      { 
        JOptionPane.showMessageDialog(this, "Mã loại xe tồn tại !, bấm reset để thêm loại xe mới");
      }
      
      else if ( jTextField_tenLoai.getText().equals("") || jTextArea_moTaLoai.getText().equals("") )
      {
        JOptionPane.showMessageDialog(this, "Các trường không được để trống !");
      }
      else if (check1.CheckTen(jTextField_tenLoai.getText().trim(),30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên loại phải nhỏ hơn 30 chữ cái !");
      }
      else if (check1.CheckTen(jTextArea_moTaLoai.getText().trim(),40) == false)
      {
        JOptionPane.showMessageDialog(this, "Mô tả phải nhỏ hơn 40 chữ cái !");
      }
     else 
     {
        Boolean flag = true;  
         
        if (loai_XE_BUS.checkTenLoai(jTextField_tenLoai.getText().trim()))
          {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại loại này, bạn có muốn thêm tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
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
          String maLoai = "";
          LOAI_XE_DTO loai_XE_DTO = new LOAI_XE_DTO();
        
            while (true) 
            {
              maLoai = check1.generateRandomCode("ML");
              if ( loai_XE_BUS.checkMaLoai(maLoai) == false)
                {
                    break;
                }
            }
              jTextField_maLoai.setText(maLoai.trim());
              loai_XE_DTO.setMA_LOAI(maLoai.trim());
              loai_XE_DTO.setTEN_LOAI_XE(jTextField_tenLoai.getText().trim());
              loai_XE_DTO.setMO_TA(jTextArea_moTaLoai.getText().trim());
              loai_XE_BUS.addLoaiXe(loai_XE_DTO);
              JOptionPane.showMessageDialog(this, "Thêm loại xe thành công (Mã loại: " + loai_XE_DTO.getMA_LOAI() +")");
              resetLoaiXe();
        }
      
        
      }
    
    }

  
    public void editLoaiXe(java.awt.event.ActionEvent evt)
    {
      if (jTextField_maLoai.getText().equals("Loại mới"))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn loại!");
      }
      else if (jTextField_tenLoai.getText().equals("") || jTextArea_moTaLoai.getText().equals("") )
      {
        JOptionPane.showMessageDialog(this, "Các trường không được để trống !");
      }
      else if (check1.CheckTen(jTextField_tenLoai.getText().trim(),30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên loại phải nhỏ hơn 30 chữ cái !");
      }
      else if (check1.CheckTen(jTextArea_moTaLoai.getText().trim(),40) == false)
      {
        JOptionPane.showMessageDialog(this, "Mô tả phải nhỏ hơn 40 chữ cái !");
      }
      
     else 
     {
       
      Boolean flag = true;
      if (loai_XE_BUS.checkTenLoai(jTextField_tenLoai.getText().trim()))
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại loại xe này, bạn có muốn sửa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
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
        LOAI_XE_DTO loai_XE_DTO = new LOAI_XE_DTO();
        loai_XE_DTO.setMA_LOAI(jTextField_maLoai.getText().trim());
        loai_XE_DTO.setTEN_LOAI_XE(jTextField_tenLoai.getText().trim());
        loai_XE_DTO.setMO_TA(jTextArea_moTaLoai.getText().trim());
        loai_XE_BUS.editLoaiXe(loai_XE_DTO);
        JOptionPane.showMessageDialog(this, "Sửa loại xe thành công");
        resetLoaiXe();
      }
      }
    
    }


    public void deleteLoaiXe(java.awt.event.ActionEvent evt)
    {
      if (jTextField_maLoai.getText().equals("Loại mới"))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn loại xe !");
      }
     else 
     {
      Boolean flag = true;  
      if (loai_XE_BUS.checkMaLoaiInXeMay(jTextField_maLoai.getText().trim()))
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đang có xe đang sử dụng loại này, bạn vẫn muốn xóa chứ ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) 
            {
               flag = true;
               loai_XE_BUS.updateLoaiXeMay(jTextField_maLoai.getText().trim());
            } 
            else 
              {
                flag = false;
              }
        }

      if (flag == true)
      {
         loai_XE_BUS.deleteMauXe(jTextField_maLoai.getText().trim());
         JOptionPane.showMessageDialog(this, "Xóa loại xe thành công");
         resetLoaiXe();
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

package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import BUS.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DTO.*;
import CHECK.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MAU_XE_GUI extends JPanel
{
    private JTable jTable_mauXe;
    private NonEditableTableModel tableModel_mauXe;
    private JScrollPane jScrollPane_mauXe;
    private JTextField jTextField_maMau;
    private JTextField jTextField_tenMau;
    private JButton jButton_themMau;
    private JButton jButton_suaMau;
    private JButton jButton_xoaMau;
    private JButton jButton_resetMau;

    private MAU_XE_BUS mau_XE_BUS = new MAU_XE_BUS();     
    private Check1 check1;
    
    public MAU_XE_GUI ()
    {
      check1 = new Check1();  
      this.init_MAU_XE(); 
      loadAllMauXe();
    }
    

    public void init_MAU_XE ()
    {
        // table hãng xe
         jTable_mauXe = new JTable();
         tableModel_mauXe = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT" ,"MÃ MÀU", "TÊN MÀU"} );
        jTable_mauXe = new JTable(tableModel_mauXe);
        jScrollPane_mauXe = new JScrollPane(jTable_mauXe);
        jScrollPane_mauXe.setBounds(0, 0, 1415, 312);

        jTable_mauXe.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              JTable tableSelect = jTable_mauXe;
              int selectedRow = tableSelect.getSelectedRow();
              jTextField_maMau.setText(jTable_mauXe.getValueAt(selectedRow, 1)+"");
              jTextField_tenMau.setText(jTable_mauXe.getValueAt(selectedRow, 2)+"");
          }
      });
      
        // font của hãng xe
        Font font_loaiXe = new Font("Arial", Font.BOLD, 14);

        // text mã hãng 
        JLabel jLabel_textMaHang = new JLabel("MÃ MÀU:");
        jLabel_textMaHang.setFont(font_loaiXe);
        jLabel_textMaHang.setBounds(14, 345, 73, 16);

        // jtextfile mã hãng
        jTextField_maMau = new JTextField("Màu mới");
        jTextField_maMau.setFont(font_loaiXe);
        jTextField_maMau.setBounds(99, 341, 270, 24);
        jTextField_maMau.setEditable(false);
        jTextField_maMau.setBackground(Color.LIGHT_GRAY);

        // text tên hãng
        JLabel jLabel_textTenHang = new JLabel("TÊN MÀU:");
        jLabel_textTenHang.setFont(font_loaiXe);
        jLabel_textTenHang.setBounds(14, 401, 73, 16);

        // jtextfile tên hãng
        jTextField_tenMau = new JTextField();
        jTextField_tenMau.setFont(font_loaiXe);
        jTextField_tenMau.setBounds(99, 397, 270, 24);

       
     

    
        //  jbutton them
        ImageIcon Icon_themMau = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
        jButton_themMau = new JButton("THÊM MÀU");
        jButton_themMau.setFont(font_loaiXe);
        jButton_themMau.setIcon(Icon_themMau);
        jButton_themMau.setBounds(544, 332, 150, 42);
        jButton_themMau.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
             addMauXe(evt);
          }
      });

        jButton_themMau.addKeyListener(new KeyListener() {
          @Override
          public void keyPressed(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               
                addMauXe(null);
              }
          }
          @Override
          public void keyTyped(KeyEvent e) {}
          
          @Override
          public void keyReleased(KeyEvent e) {}
        });




        // jbutton sửa
        ImageIcon Icon_suaMau = new javax.swing.ImageIcon(getClass().getResource("/IMG/edit.png"));
        jButton_suaMau = new JButton("SỬA");
        jButton_suaMau.setFont(font_loaiXe);
        jButton_suaMau.setIcon(Icon_suaMau);
        jButton_suaMau.setBounds(544, 397, 150, 42);
        jButton_suaMau.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
           editMauXe(evt);
          }
      });

        // jbutton xóa
        ImageIcon Icon_xoaMau = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
        jButton_xoaMau = new JButton("XÓA");
        jButton_xoaMau.setFont(font_loaiXe);
        jButton_xoaMau.setIcon(Icon_xoaMau);
        jButton_xoaMau.setBounds(544, 459, 150, 42);
        jButton_xoaMau.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteMauXe(evt);
          }
      });

        // jbutton reset
        ImageIcon Icon_resetMau = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
        jButton_resetMau = new JButton("RESET");
        jButton_resetMau.setFont(font_loaiXe);
        jButton_resetMau.setIcon(Icon_resetMau);
        jButton_resetMau.setBounds(544, 524, 150, 42);
        jButton_resetMau.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetMauXe();
          }
      });

      this.setBackground(new java.awt.Color(204, 255, 255));

        this.setLayout(null);
        this.add(jScrollPane_mauXe);
        this.add(jLabel_textMaHang);
        this.add(jTextField_maMau);
        this.add(jLabel_textTenHang);
        this.add(jTextField_tenMau);
       
        this.add(jButton_themMau);
        this.add(jButton_suaMau);
        this.add(jButton_xoaMau);
        this.add(jButton_resetMau);
        
        
    }

    public void loadAllMauXe ()
    {
      ArrayList<MAU_XE_DTO> arrMauXe = new ArrayList<MAU_XE_DTO>();
      arrMauXe = mau_XE_BUS.getAllMauXe();
      for (int i = 0; i<arrMauXe.size(); i++)
      {
        
        MAU_XE_DTO mau_XE_DTO = arrMauXe.get(i);
        Object[] newrow = {i+1,mau_XE_DTO.getMA_MAU(), mau_XE_DTO.getTEN_MAU()};
        tableModel_mauXe.addRow(newrow);
      }
      

    }

    public void addMauXe(java.awt.event.ActionEvent evt)
    {
      
      if ( jTextField_maMau.getText().equals("Màu mới") == false)  
      { 
        JOptionPane.showMessageDialog(this, "Mã loại xe tồn tại !, bấm reset để thêm loại xe mới");
      }
      else if ( jTextField_tenMau.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng điền tên màu bạn muốn thêm !");
      }
      else if (check1.CheckTen(jTextField_tenMau.getText().trim(), 30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên màu phải nhỏ hơn 30 chữ cái !");
      }

     else 
     {
        Boolean flag = true;  
        if (mau_XE_BUS.checkTenMau(jTextField_tenMau.getText().trim()))
          {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại màu này, bạn có muốn thêm tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
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
          String maMau = "";
          MAU_XE_DTO mau_XE_DTO = new MAU_XE_DTO();
        
            while (true) 
            {
              maMau = check1.generateRandomCode("MM");
              if ( mau_XE_BUS.checkMaMau(maMau) == false)
                {
                    break;
                }
            }
              jTextField_maMau.setText(maMau.trim());
              mau_XE_DTO.setMA_MAU(maMau.trim());
              mau_XE_DTO.setTEN_MAU(jTextField_tenMau.getText().trim());
              mau_XE_BUS.addMauXe(mau_XE_DTO);
              JOptionPane.showMessageDialog(this, "Thêm màu thành công (Mã màu: " + mau_XE_DTO.getMA_MAU() +")");
              resetMauXe();
        }
      
        
      }
    
    }


    public void deleteMauXe(java.awt.event.ActionEvent evt)
    {
      if (jTextField_maMau.getText().equals("Màu mới"))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn màu !");
      }
     else 
     {
      Boolean flag = true;  
      if (mau_XE_BUS.checkMaMauInXeMay(jTextField_maMau.getText().trim()))
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đang có xe đang sử dụng màu này, bạn vẫn muốn xóa chứ ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) 
            {
               flag = true;
               mau_XE_BUS.updateMauXeMay(jTextField_maMau.getText().trim());
            } 
            else 
              {
                flag = false;
              }
        }

      if (flag == true)
      {
         mau_XE_BUS.deleteMauXe(jTextField_maMau.getText().trim());
         JOptionPane.showMessageDialog(this, "Xóa màu thành công");
         resetMauXe();
      }
        
      }
    
}
    public void resetMauXe ()
    {  
      tableModel_mauXe.setRowCount(0);
      loadAllMauXe();
      jTextField_maMau.setText("Màu mới");
      jTextField_tenMau.setText("");
    }


    public void editMauXe(java.awt.event.ActionEvent evt)
    {
      if (jTextField_maMau.getText().equals("Màu mới"))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn màu!");
      }
      else if (jTextField_maMau.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this, "Vui lòng điền tên màu !");
      }
      else if (check1.CheckTen(jTextField_tenMau.getText().trim(),30) == false)
      {
        JOptionPane.showMessageDialog(this, "Tên màu phải nhỏ hơn 30 chữ cái !");
      }
     else 
     {
       
      Boolean flag = true;
      if (mau_XE_BUS.checkTenMau(jTextField_tenMau.getText().trim()))
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại màu này, bạn có muốn sửa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
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
        MAU_XE_DTO mau_XE_DTO = new MAU_XE_DTO();
        mau_XE_DTO.setMA_MAU(jTextField_maMau.getText().trim());
        mau_XE_DTO.setTEN_MAU(jTextField_tenMau.getText().trim());
        mau_XE_BUS.editMauXe(mau_XE_DTO);
        JOptionPane.showMessageDialog(this, "Sửa màu thành công");
        resetMauXe();
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


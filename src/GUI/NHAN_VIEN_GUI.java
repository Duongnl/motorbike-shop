/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import BUS.NHAN_VIEN_BUS;
import CHECK.Check1;
import Connection.ConnectToSQL;
import DTO.NHAN_VIEN_DTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import GUI.Login_GUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author DELL
 */
public class NHAN_VIEN_GUI extends JFrame {
    JLabel tieude, manv, tentk, tennv, diachi, phanquyen, sdt, gmail, thongtin, tab1, tab2, tim1, tim2, timtheo, gioitinh;
    JTextField Manv, Tentk, Tennv, Diachi, Sdt, Gmail, Tim;
    JPanel nv, nvnl, panel1;
    JTable NV, NVNL;
    JTabbedPane p1;
    JScrollPane scnv, scttin, scnghi;
    JComboBox Comboquyen, Combotim, Combosex;
    JTextArea Thongtin;
    JButton them, xoa, sua, rs, thoat, timnv;
    private Check1 check1;
    private NonEditableTableModel tableModel_NV, tableModel_NVN;
    NHAN_VIEN_BUS nhan_VIEN_BUS = new NHAN_VIEN_BUS();
    ArrayList<NHAN_VIEN_DTO> arrNhanVien = new ArrayList<NHAN_VIEN_DTO>();
    
    public NHAN_VIEN_GUI(){
        check1 = new Check1();
        init_NhanVien();
        loadAllNhanVien();
        loadAllNhanVienNghi();
    }
    
    public void init_NhanVien() {
        setSize(1415, 740);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        tieude = new JLabel("QUẢN LÍ NHÂN VIÊN");
        tieude.setBackground(new java.awt.Color(204, 255, 255));
        tieude.setFont(new java.awt.Font("Segoe UI Black", 0, 24));
        tieude.setForeground(new java.awt.Color(0, 204, 204));
        tieude.setBounds(530, 10, 250, 50);
        
        Font font = new Font("Segoe UI Plain", 0 ,14);
        tim1 = new JLabel("TÌM KIẾM NHÂN VIÊN");
        tim1.setFont(new java.awt.Font("Segoe UI Black", 0, 20));
        tim1.setBounds(1140,250,300,30);
        tim2 = new JLabel("Tìm kiếm:");
        tim2.setFont(font);
        tim2.setBounds(1070,290,100,30);
        timtheo = new JLabel("Tìm kiếm theo");
        timtheo.setFont(font);
        timtheo.setBounds(1070,340,100,30);
        Tim = new JTextField();
        Tim.setBounds(1180,295,200,25);
        String kiem[] ={"Mã NV", "Tên NV", "Sdt"};
        Combotim = new JComboBox(kiem);
        Combotim.setBounds(1180,343,100,25);
        timnv = new JButton("Tìm");
        timnv.setBounds(1200,400,120,50);
        timnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               find(evt);
            }
        });
        
        panel1 = new JPanel();
        panel1.setBackground(new java.awt.Color(204, 255, 255));
        panel1.setLayout(null);
        panel1.setBounds(0,0,1400,705);
        manv = new JLabel("Mã nhân viên:");
        manv.setBounds(50,250,100,30);
        manv.setFont(font);
        tentk = new JLabel("Tên tài khoản:");
        tentk.setFont(font);
        tentk.setBounds(50,300,100,30);
        tennv = new JLabel("Tên nhân viên:");
        tennv.setFont(font);
        tennv.setBounds(50,350,100,30);
        diachi = new JLabel("Địa chỉ:");
        diachi.setFont(font);
        diachi.setBounds(50,400,100,30);
        phanquyen = new JLabel("Phân quyền:");
        phanquyen.setFont(font);
        phanquyen.setBounds(50,450,100,30);
        sdt = new JLabel("Số điện thoại:");
        sdt.setFont(font);
        sdt.setBounds(600,250,100,30);
        gmail = new JLabel("Email:");
        gmail.setFont(font);
        gmail.setBounds(600,300,100,30);
        gioitinh = new JLabel("Giới tính");
        gioitinh.setFont(font);
        gioitinh.setBounds(600,350,100,30);
        thongtin = new JLabel("Thông tin khác:");
        thongtin.setFont(font);
        thongtin.setBounds(600,400,100,30);
        
        Manv = new JTextField();
        Manv.setBounds(170,255,300,25);
        Manv.setEditable(false);
        Tentk = new JTextField();
        Tentk.setBounds(170,305,300,25);
        Tennv = new JTextField();
        Tennv.setBounds(170,355,300,25);
        Diachi = new JTextField();
        Diachi.setBounds(170,405,300,25);
        String quyen[] = {"Admin", "Nhân viên bán hàng", "Nhân viên kho hàng", "Nhân viên bảo trì"};
        Comboquyen = new JComboBox(quyen);
        Comboquyen.setBounds(170,455,250,25);
        Sdt = new JTextField();
        Sdt.setBounds(718,255,300,25);
        Gmail = new JTextField();
        Gmail.setBounds(718,305,300,25);
        String sex[] = {"Nam", "Nữ"};
        Combosex = new JComboBox(sex);
        Combosex.setBounds(718,355,180,25);
        Thongtin = new JTextArea();
        Thongtin.setBounds(718,405,300,80);
//        Thongtin.setColumns(20);
//        Thongtin.setRows(5);
//        scttin.setViewportView(Thongtin);
        scttin = new JScrollPane();
        scttin.setViewportView(Thongtin);
        scttin.setBounds(718,405,300,80);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        them = new JButton("Thêm");
        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Add-16pix.png")));
        them.setBounds(150,520,120,50);
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               ThemNV(evt);
            }
        });
        xoa = new JButton("Xóa");
        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/delete1.png")));
        xoa.setBounds(650,520,120,50);
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               XoaNV(evt);
            }
        });
        sua = new JButton("Sửa");
        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Actions-document-edit-icon-16.png")));
        sua.setBounds(400,520,120,50);
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               SuaNV(evt);
            }
        });
        rs = new JButton("Reset");
        rs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/exchange.png")));
        rs.setBounds(900,520,120,50);
        rs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               resetNhanVien();
            }
        });
        thoat = new JButton("Exit");
        thoat.setBounds(1250,20,120,50);
        thoat.setBackground(new java.awt.Color(255, 255, 153));
        thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Actions-edit-delete-icon-16.png")));
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               Dispose(evt);
            }
        });
        
        nv = new JPanel();
        nv.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        nv.setLayout(null);
        nv.setBounds(0,70,1400,695);
        nv.setBackground(new java.awt.Color(204, 255, 255));
        tableModel_NV = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT", "Mã NV", "Tên TK", "Tên NV", "Giới tính", "Địa chỉ", "Cấp bậc", "Sđt", "Gmail", "Thông tin"} );
        NV = new JTable(tableModel_NV);
        NV.setBounds(0,0,1400,230);
        NV.setRowHeight(20);
        NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNVMouseClicked(evt);
            }
        });
//        NV.getColumn(0).setWidth(100);
        scnv = new JScrollPane();
        scnv.setViewportView(NV);
        scnv.setBounds(0, 0, 1400, 230);
//        NV.setShowGrid(true);
//        NV.setSurrendersFocusOnKeystroke(true);
        nv.add(manv);
        nv.add(tentk);
        nv.add(tennv);
        nv.add(diachi);
        nv.add(phanquyen);
        nv.add(sdt);
        nv.add(gmail);
        nv.add(thongtin);
        nv.add(Manv);
        nv.add(Tentk);
        nv.add(Tennv);
        nv.add(Diachi);
        nv.add(Comboquyen);
        nv.add(Sdt);
        nv.add(Gmail);
        nv.add(them);
        nv.add(xoa);
        nv.add(sua);
        nv.add(rs);
        panel1.add(thoat);
        nv.add(scttin);
        nv.add(scnv);
        nv.add(tim1);
        nv.add(tim2);
        nv.add(timtheo);
        nv.add(Tim);
        nv.add(Combotim);
        nv.add(timnv);
        nv.add(gioitinh);
        nv.add(Combosex);
        
        tab1 = new JLabel("Nhân viên", SwingConstants.CENTER);
        tab1.setPreferredSize(new Dimension(120,25));
        tab1.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        tab2 = new JLabel("Nhân viên đã nghỉ", SwingConstants.CENTER);
        tab2.setPreferredSize(new Dimension(120,25));
        tab2.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        
        nvnl = new JPanel();
        nvnl.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        nvnl.setLayout(null);
        nvnl.setBounds(0,60,1400,695);
        nvnl.setBackground(new java.awt.Color(204, 255, 255));
        tableModel_NVN = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT", "Mã NV", "Tên TK", "Tên NV", "Giới tính", "Địa chỉ", "Chức vụ", "Sđt", "Gmail", "Thông tin", "Ngày nghỉ làm"} );
        NVNL = new JTable(tableModel_NVN);
        NVNL.setBounds(0,0,1400,400);
        NVNL.setRowHeight(20);
        scnghi = new JScrollPane();
        scnghi.setViewportView(NVNL);
        scnghi.setBounds(0,0,1400,400);
        nvnl.add(scnghi);

        p1 = new JTabbedPane();
        p1.setBackground(new java.awt.Color(102, 204, 255));
        p1.addTab(" ", nv);
        p1.addTab(" ", nvnl);
        p1.setTabComponentAt(0,tab1);
        p1.setTabComponentAt(1,tab2);
        p1.setBounds(0,70,1400,695);
        p1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
              int tabIndex = p1.getSelectedIndex(); 
              if (tabIndex == 1)
              {
                loadAllNhanVienNghi();
              }
              
            
            }
        }); 

        
        add(panel1);
        panel1.add(tieude);
        panel1.add(p1);



        
//        NV.getColumnModel().getColumn(0).setWidth(30);
        if (NV.getColumnModel().getColumnCount() > 0) {
            NV.getColumnModel().getColumn(0).setMaxWidth(40);
            NV.getColumnModel().getColumn(1).setMaxWidth(100);
            NV.getColumnModel().getColumn(2).setMaxWidth(140);
            NV.getColumnModel().getColumn(3).setMinWidth(150);
            NV.getColumnModel().getColumn(4).setMaxWidth(80);
            NV.getColumnModel().getColumn(5).setMinWidth(300);
            NV.getColumnModel().getColumn(6).setMinWidth(130);
            NV.getColumnModel().getColumn(7).setMinWidth(100);
            NV.getColumnModel().getColumn(8).setMinWidth(100); 
            NV.getColumnModel().getColumn(9).setMinWidth(100);
        }
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(CENTER);

        NV.getColumnModel().getColumn(0).setCellRenderer(rendar); 
        NV.getColumnModel().getColumn(1).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(2).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(3).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(4).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(5).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(6).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(7).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(8).setCellRenderer(rendar);
        NV.getColumnModel().getColumn(9).setCellRenderer(rendar);
        setVisible(true);
    }
    
     public void Dispose(java.awt.event.ActionEvent evt)
     {
        this.dispose();
     }

    public void ThemNV(java.awt.event.ActionEvent evt) {
        String maNV = "";
        NHAN_VIEN_DTO nhan_VIEN_DTO = new NHAN_VIEN_DTO();
        while(true){
        maNV = check1.Ma_generateRandomCode("MNV");
        if (nhan_VIEN_BUS.checkMaNV(maNV) == false){
                break;
            }
        }
        Manv.setText(maNV.trim());
        nhan_VIEN_DTO.setMA_NV(maNV.trim());
        nhan_VIEN_DTO.setUSERNAME(Tentk.getText().trim());
        nhan_VIEN_DTO.setHO_TEN(Tennv.getText().trim());
        nhan_VIEN_DTO.setGIOI_TINH((String)Combosex.getSelectedItem());
       
        nhan_VIEN_DTO.setDIA_CHI(Diachi.getText().trim());
        nhan_VIEN_DTO.setCHUC_VU((String)Comboquyen.getSelectedItem());
        nhan_VIEN_DTO.setSDT(Integer.parseInt(Sdt.getText().trim()));
        nhan_VIEN_DTO.setGMAIL(Gmail.getText().trim());
        nhan_VIEN_DTO.setGHI_CHU(Thongtin.getText().trim());
        
        if (Manv.getText().equals("") || Tentk.getText().equals("") || Tennv.getText().equals("") || Diachi.getText().equals("") || Sdt.getText().equals("") || Gmail.getText().equals("") || Thongtin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Đầy Đủ Thông Tin", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(nhan_VIEN_BUS.checkTenTK(Tentk.getText().trim())){
            JOptionPane.showMessageDialog(this, "Tên Tài Khoản Nhân Viên Đã Tồn Tại", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if (nhan_VIEN_BUS.addNhanVien(nhan_VIEN_DTO)) {
            JOptionPane.showMessageDialog(this, "Thêm Nhân Viên Thành Công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            resetNhanVien();
        }else {
            JOptionPane.showMessageDialog(this, "Lỗi Thêm Nhân Viên", "ERROR", JOptionPane.ERROR_MESSAGE);
            }  
        }
    
    public void SuaNV(java.awt.event.ActionEvent evt) {
        String maNV = "";
        NHAN_VIEN_DTO nhan_VIEN_DTO = new NHAN_VIEN_DTO();
        while(true){
        maNV = check1.Ma_generateRandomCode("MNV");
        if (nhan_VIEN_BUS.checkMaNV(maNV) == false){
                break;
            }
        }
        nhan_VIEN_DTO.setMA_NV(Manv.getText().trim());
        nhan_VIEN_DTO.setUSERNAME(Tentk.getText().trim());
        nhan_VIEN_DTO.setHO_TEN(Tennv.getText().trim());
        nhan_VIEN_DTO.setGIOI_TINH((String)Combosex.getSelectedItem());
        
         System.out.println((String)Combosex.getSelectedItem());
        
        nhan_VIEN_DTO.setDIA_CHI(Diachi.getText().trim());
        nhan_VIEN_DTO.setCHUC_VU((String)Comboquyen.getSelectedItem());
        nhan_VIEN_DTO.setSDT(Integer.parseInt(Sdt.getText().trim()));
        nhan_VIEN_DTO.setGMAIL(Gmail.getText().trim());
        nhan_VIEN_DTO.setGHI_CHU(Thongtin.getText().trim());
        if (Manv.getText().equals("") || Tentk.getText().equals("") || Tennv.getText().equals("") || Diachi.getText().equals("") || Sdt.getText().equals("") || Gmail.getText().equals("") || Thongtin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Đầy Đủ Thông Tin", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(nhan_VIEN_BUS.checkTenTK(Tentk.getText().trim())){
            JOptionPane.showMessageDialog(this, "Username tồn tại!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if (nhan_VIEN_BUS.editNhanVien(nhan_VIEN_DTO)) {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            resetNhanVien();
        }else {
            JOptionPane.showMessageDialog(this, "Lỗi sửa nhân viên", "ERROR", JOptionPane.ERROR_MESSAGE);
            }  
        }
    
    public void XoaNV(java.awt.event.ActionEvent evt) {
        boolean check = true;
        int row = NV.getSelectedRow();
        if (row == -1){
        JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản !");
        check = false;
      }else if(Login_GUI.ten_ad.equals(Tentk.getText().trim())){
        JOptionPane.showMessageDialog(this, "Không được xóa tài khoản bản thân", "ERROR", JOptionPane.ERROR_MESSAGE);
      }else if(check == true){
            NHAN_VIEN_DTO nv = new NHAN_VIEN_DTO();
            int click=JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa","Thông Báo",JOptionPane.YES_NO_OPTION);
            if( click == JOptionPane.YES_OPTION){
                    
                System.out.println(Manv.getText().trim());
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                nv.setNGAY_NGHI(dateFormat.format(date));
                    
                    if (nhan_VIEN_BUS.deleteNhanVien(Manv.getText().trim(), dateFormat.format(date).trim() )) {
                        
                       
                        
                        JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        resetNhanVien();
                        // System.out.println(arrNhanVien.get(row).getMA_NV());
                        // nv.setMA_NV(arrNhanVien.get(row).getMA_NV());
                        //     if(nhan_VIEN_BUS.Update_ngay(nv)){
                            // JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        //         resetNhanVien();
                        // }
                    
                    
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi xóa nhân viên", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                
            
            }
        }
    }
    
    public void loadAllNhanVien (){
        arrNhanVien = nhan_VIEN_BUS.getAllNhanVien();

        for (int i = 0; i < arrNhanVien.size(); i++){
          NHAN_VIEN_DTO nhan_VIEN_DTO = arrNhanVien.get(i);
          Object[] newrow = {i+1,nhan_VIEN_DTO.getMA_NV(), nhan_VIEN_DTO.getUSERNAME(), nhan_VIEN_DTO.getHO_TEN(), nhan_VIEN_DTO.getGIOI_TINH(), nhan_VIEN_DTO.getDIA_CHI(), nhan_VIEN_DTO.getCHUC_VU(), "0"+ nhan_VIEN_DTO.getSDT(), nhan_VIEN_DTO.getGMAIL(), nhan_VIEN_DTO.getGHI_CHU()};
          tableModel_NV.addRow(newrow);
        }
    }
    
    public void resetNhanVien (){
      tableModel_NV.setRowCount(0);
      loadAllNhanVien();
      Manv.setText("");
      Tentk.setText("");
      Tennv.setText("");
      Diachi.setText("");
      Sdt.setText("");
      Gmail.setText("");
      Thongtin.setText("");
    }
    
    public void loadAllNhanVienNghi (){
      tableModel_NVN.setRowCount(0);  
      arrNhanVien = nhan_VIEN_BUS.getAllNVNghi();
      for (int i = 0; i < arrNhanVien.size(); i++)
      {
        NHAN_VIEN_DTO nhan_VIEN_DTO = arrNhanVien.get(i);
        Object[] newrow = {i+1,nhan_VIEN_DTO.getMA_NV(), nhan_VIEN_DTO.getUSERNAME(), nhan_VIEN_DTO.getHO_TEN(), nhan_VIEN_DTO.getGIOI_TINH(), nhan_VIEN_DTO.getDIA_CHI(), nhan_VIEN_DTO.getCHUC_VU(),"0"+ nhan_VIEN_DTO.getSDT(), nhan_VIEN_DTO.getGMAIL(), nhan_VIEN_DTO.getGHI_CHU(), nhan_VIEN_DTO.getNGAY_NGHI()};
        tableModel_NVN.addRow(newrow);
      }
      
    }
    
    private void TableNVMouseClicked(java.awt.event.MouseEvent evt) {   
        JTable tableSelect = NV;
        int selectedRow = tableSelect.getSelectedRow();
        Manv.setForeground(Color.red);
        Manv.setBackground(new java.awt.Color(153, 153, 153));

        Manv.setText(NV.getValueAt(selectedRow, 1)+"");
        Tentk.setText(NV.getValueAt(selectedRow, 2)+"");
        Tennv.setText(NV.getValueAt(selectedRow, 3)+"");
        Combosex.setSelectedItem(NV.getValueAt(selectedRow, 4)+"");
        Diachi.setText(NV.getValueAt(selectedRow, 5)+"");
        Comboquyen.setSelectedItem(NV.getValueAt(selectedRow, 6)+"");
        Sdt.setText(NV.getValueAt(selectedRow, 7)+"");
        Gmail.setText(NV.getValueAt(selectedRow, 8)+"");
        Thongtin.setText(NV.getValueAt(selectedRow, 9)+"");       
    } 
    
    public void find(java.awt.event.ActionEvent evt){
        if(Tim.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập thông tin muốn tìm kiếm");
        }else {
            int selectCbbNhanVien = Combotim.getSelectedIndex();
                ArrayList<NHAN_VIEN_DTO> arrNhanVien = new ArrayList<NHAN_VIEN_DTO>();
                arrNhanVien = nhan_VIEN_BUS.getAllNhanVien();
                if(selectCbbNhanVien==0){
                    int start=0;
                    for(NHAN_VIEN_DTO nhan_VIEN_DTO: arrNhanVien){
                        if(nhan_VIEN_DTO.getMA_NV().equalsIgnoreCase(Tim.getText().trim())){
                            Object[] newrow = {start + 1,nhan_VIEN_DTO.getMA_NV(), nhan_VIEN_DTO.getUSERNAME(), nhan_VIEN_DTO.getHO_TEN(), nhan_VIEN_DTO.getGIOI_TINH(), nhan_VIEN_DTO.getDIA_CHI(), nhan_VIEN_DTO.getCHUC_VU(), nhan_VIEN_DTO.getSDT(), nhan_VIEN_DTO.getGMAIL(), nhan_VIEN_DTO.getGHI_CHU()};
                            tableModel_NV.addRow(newrow);
                            start++;
                        }
                    }if (start == 0){
                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
                       }
                    }else if(selectCbbNhanVien==1){
                        int start=0;
                        for(NHAN_VIEN_DTO nhan_VIEN_DTO: arrNhanVien){
                            if(nhan_VIEN_DTO.getHO_TEN().equalsIgnoreCase(Tim.getText().trim())){
                                Object[] newrow = {start + 1,nhan_VIEN_DTO.getMA_NV(), nhan_VIEN_DTO.getUSERNAME(), nhan_VIEN_DTO.getHO_TEN(), nhan_VIEN_DTO.getGIOI_TINH(), nhan_VIEN_DTO.getDIA_CHI(), nhan_VIEN_DTO.getCHUC_VU(), nhan_VIEN_DTO.getSDT(), nhan_VIEN_DTO.getGMAIL(), nhan_VIEN_DTO.getGHI_CHU()};
                                tableModel_NV.addRow(newrow);
                                start++;
                            }
                        }if (start == 0){
                            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
                        }
                    }else if(selectCbbNhanVien==2){
                        int start=0;
                        for(NHAN_VIEN_DTO nhan_VIEN_DTO: arrNhanVien){
                            if(String.valueOf("0" + nhan_VIEN_DTO.getSDT()).equalsIgnoreCase(Tim.getText().trim())){
                                Object[] newrow = {start + 1,nhan_VIEN_DTO.getMA_NV(), nhan_VIEN_DTO.getUSERNAME(), nhan_VIEN_DTO.getHO_TEN(), nhan_VIEN_DTO.getGIOI_TINH(), nhan_VIEN_DTO.getDIA_CHI(), nhan_VIEN_DTO.getCHUC_VU(), nhan_VIEN_DTO.getSDT(), nhan_VIEN_DTO.getGMAIL(), nhan_VIEN_DTO.getGHI_CHU()};
                                tableModel_NV.addRow(newrow);
                                start++;
                            }
                       }if (start == 0){
                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
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
    
    public static void main(String[] args) {
        new NHAN_VIEN_GUI();
    }
}


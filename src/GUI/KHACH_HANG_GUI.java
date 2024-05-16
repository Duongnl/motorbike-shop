package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import CHECK.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import BUS.KHACH_HANG_BUS;
import DAO.KHACH_HANG_DAO;
import DTO.KHACH_HANG_DTO;

public class KHACH_HANG_GUI extends JFrame {
  private JButton exit;
  private JTable jTable_kh;
  private NonEditableTableModel tableModel_kh;
  private JScrollPane jScrollPane_kh;
  // private TableModel tableModel_kh;
  private JLabel title;
  private JLabel txt_makh;
  private JLabel txt_tenkh;
  private JLabel txt_diachi;
  private JLabel txt_sdt;
  private JLabel txt_search, txt_gioitinh;
  private JLabel txt_typesearch;
  private KHACH_HANG_BUS khach_hang_BUS = new KHACH_HANG_BUS();
  private Check1 check1 = new Check1();

  private JButton add;
  private JButton edit;
  private JButton del;
  private JButton reset;
  private JButton bt_search;

  private JTextField makh;
  private JTextField tenkh;
  private JTextField diachi;
  private JTextField sdt;
  private JTextField search;
  // private JTextField trangthai;

  JComboBox<String> comboBox_Loaikh;
  JComboBox<String> comboBox_Gioitinh;

  private String[] String_Loaikh = { " ", " Tên khách hàng", " Mã khách hàng" };
  private String[] String_Gioitinh = { "Nam", "Nữ" };

  public KHACH_HANG_GUI() {
    this.init_KhachHang();
    loadAllKhachHang();
    this.setVisible(true);
  }

  public void init_KhachHang() {
    this.setTitle(" Khách Hàng ");
    this.setSize(1415, 740);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  


    Font font2 = new Font("Arial", Font.BOLD, 14);
    Font font1 = new Font("Arial", Font.BOLD, 36);

    ImageIcon exitIcon = new ImageIcon("D:\\HocKy4\\Java\\JAVAPROJECT\\src\\IMG\\exit.png");
    exit = new JButton("EXIT");
    exit.setBounds(30, 25, 100, 40);
    exit.setIcon(exitIcon);
    exit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Dispose(evt);
      }
    });

    jTable_kh = new JTable();
    tableModel_kh = new NonEditableTableModel(new Object[][] {
    }, new String[] { "STT", "MÃ KH", "TÊN KH", "ĐỊA CHỈ", "SỐ ĐIỆN THOẠI", "GIỚI TÍNH", "NGÀY CẬP NHẬP" });
    jTable_kh = new JTable(tableModel_kh);
    jScrollPane_kh = new JScrollPane(jTable_kh);
    jScrollPane_kh.setBounds(10, 114, 1380, 256);

    jTable_kh.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JTable tableSelect = jTable_kh;
        int selectedRow = tableSelect.getSelectedRow();
        makh.setText(jTable_kh.getValueAt(selectedRow, 1) + "");
        tenkh.setText(jTable_kh.getValueAt(selectedRow, 2) + "");
        diachi.setText(jTable_kh.getValueAt(selectedRow, 3) + "");
        sdt.setText(jTable_kh.getValueAt(selectedRow, 4) + "");
        comboBox_Gioitinh.setSelectedItem(jTable_kh.getValueAt(selectedRow, 5) + "");

      }
    });

    title = new JLabel("KHÁCH HÀNG");
    title.setBounds(604, 38, 300, 44);
    title.setFont(font1);

    txt_makh = new JLabel("MÃ KH");
    txt_makh.setBounds(21, 385, 58, 24);
    txt_makh.setFont(font2);

    txt_tenkh = new JLabel("TÊN KH");
    txt_tenkh.setBounds(21, 455, 66, 24);
    txt_tenkh.setFont(font2);

    txt_diachi = new JLabel("ĐỊA CHỈ");
    txt_diachi.setBounds(21, 525, 64, 24);
    txt_diachi.setFont(font2);

    txt_sdt = new JLabel("SỐ ĐIỆN THOẠI");
    txt_sdt.setBounds(710, 385, 122, 24);
    txt_sdt.setFont(font2);

    txt_search = new JLabel("TÌM KIẾM");
    txt_search.setBounds(710, 525, 139, 24);
    txt_search.setFont(font2);

    txt_gioitinh = new JLabel("GIỚI TÍNH");
    txt_gioitinh.setBounds(710, 455, 139, 24);
    txt_gioitinh.setFont(font2);

    txt_typesearch = new JLabel("TÌM KIẾM THEO");
    txt_typesearch.setBounds(710, 595, 110, 24);
    txt_typesearch.setFont(font2);

    comboBox_Loaikh = new JComboBox<>(String_Loaikh);
    comboBox_Loaikh.setFont(font2);
    // .setBounds(590, 331, 109, 24);
    comboBox_Loaikh.setBounds(870, 520, 380, 37);

    comboBox_Gioitinh = new JComboBox<>(String_Gioitinh);
    comboBox_Gioitinh.setFont(font2);
    // comboBox_Gioitinh.setBounds(710,455,139,24);
    comboBox_Gioitinh.setBounds(870, 450, 517, 37);

    makh = new JTextField();
    makh.setBounds(128, 380, 517, 37);
    makh.setEditable(false);
    makh.setText("KHÁCH HÀNG MỚI");
    makh.setFont(font2);

    tenkh = new JTextField();
    tenkh.setBounds(128, 450, 517, 37);
    tenkh.setFont(font2);

    diachi = new JTextField();
    diachi.setBounds(128, 520, 517, 37);
    diachi.setFont(font2);

    sdt = new JTextField();
    sdt.setBounds(870, 380, 517, 37);
    sdt.setFont(font2);

    search = new JTextField();
    search.setFont(font2);
    // search.setBounds(870, 450, 517, 37);
    search.setBounds(870, 590, 517, 37);

    // trangthai = new JTextField();
    // trangthai.setBounds(870, 600, 517, 37);

    ImageIcon addIcon = new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"));
    ImageIcon delIcon = new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"));
    ImageIcon resetIcon = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
    ImageIcon editIcon = new javax.swing.ImageIcon(getClass().getResource("/IMG/edit.png"));
    ImageIcon searchIcon = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));

    add = new JButton("ADD");
    add.setBounds(300, 660, 100, 40);
    add.setIcon(addIcon);
    add.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addKhachHang(evt);
      }
    });

    add.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          addKhachHang(null);
        }
      }

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    });

    edit = new JButton("EDIT");
    edit.setBounds(550, 660, 100, 40);
    edit.setIcon(editIcon);
    edit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editKhachHang(evt);
      }
    });

    del = new JButton("DEL");
    del.setBounds(800, 660, 100, 40);
    del.setIcon(delIcon);
    del.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteKhachHang(evt);
      }
    });

    reset = new JButton("RESET");
    reset.setBounds(1050, 660, 120, 40);
    reset.setIcon(resetIcon);
    reset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetKhachHang();
        deleteAllKhachHang();
        loadAllKhachHang();
      }
    });

    bt_search = new JButton("SEARCH");
    // bt_search.setBounds(1000, 660, 100, 40);
    bt_search.setBounds(1265, 520, 120, 37);

    bt_search.setIcon(searchIcon);
    bt_search.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<KHACH_HANG_DTO> arrKhachHang = new ArrayList<KHACH_HANG_DTO>();
        arrKhachHang = khach_hang_BUS.getALLKhachHang();

        if (comboBox_Loaikh.getSelectedIndex() == 0) {
          JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thuộc tính cần tìm kiếm ");
        } else if (comboBox_Loaikh.getSelectedIndex() == 1) {
          deleteAllKhachHang();
          int dem = 0;
          for (KHACH_HANG_DTO obj : arrKhachHang) {
            if (obj.getTEN_KH().equalsIgnoreCase(search.getText().trim())) {
              System.out.println(1);
              Object[] newrow = { dem + 1, obj.getMA_KH(), obj.getTEN_KH(), obj.getDIA_CHI(),
                  obj.getSDT(), obj.getGioitinh(), obj.getNGAY_CAP_NHAP(),
                  obj.getTRANG_THAI() };
              dem++;
              DefaultTableModel model = (DefaultTableModel) jTable_kh.getModel();
              model.addRow(newrow);
            }
          }
          if (dem == 0) {
            JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu cần tìm ");
          }
        } else if (comboBox_Loaikh.getSelectedIndex() == 2) {
          deleteAllKhachHang();
          int dem = 0;
          for (KHACH_HANG_DTO obj : arrKhachHang) {
            if (obj.getMA_KH().equalsIgnoreCase(search.getText())) {
              Object[] newrow = { dem + 1, obj.getMA_KH(), obj.getTEN_KH(), obj.getDIA_CHI(),
                  obj.getSDT(), obj.getGioitinh(), obj.getNGAY_CAP_NHAP(),
                  obj.getTRANG_THAI() };
              dem++;
              DefaultTableModel model = (DefaultTableModel) jTable_kh.getModel();
              model.addRow(newrow);
            }
          }
          if (dem == 0) {
            JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu cần tìm ");
          }
        }
      }
    });
    
    
    this.setBackground(new java.awt.Color(204, 255, 255));
    this.setLayout(null);
    this.add(title);
    this.add(txt_makh);
    this.add(txt_tenkh);
    this.add(txt_sdt);
    this.add(txt_diachi);
    this.add(txt_search);
    this.add(txt_typesearch);
    this.add(txt_gioitinh);

    this.add(comboBox_Loaikh);
    this.add(makh);
    this.add(tenkh);
    this.add(sdt);
    this.add(diachi);
    this.add(bt_search);
    // this.add(trangthai);
    this.add(comboBox_Gioitinh);

    this.add(add);
    this.add(edit);
    this.add(del);
    this.add(reset);
    this.add(search);
    
    this.add(jScrollPane_kh);
    this.add(exit);

  }

  // public void loadAllKhachHang()
  // {
  // ArrayList<KHACH_HANG_DTO> arrKhachHang = new ArrayList<KHACH_HANG_DTO>();
  // arrKhachHang = khach_hang_BUS.getALLKhachHang();

  // for (int i = 0; i<arrKhachHang.size(); i++)
  // {
  // KHACH_HANG_DTO khach_hang_DTO = arrKhachHang.get(i);
  // Object[] newrow = {i+1,khach_hang_DTO.getMA_KH(), khach_hang_DTO.getTEN_KH(),
  // khach_hang_DTO.getDIA_CHI(),
  // khach_hang_DTO.getSDT(),khach_hang_DTO.getGioitinh(),khach_hang_DTO.getNGAY_CAP_NHAP(),khach_hang_DTO.getTRANG_THAI()};
  // tableModel_kh.addRow(newrow);

  // }
  // }
  public void loadAllKhachHang() {
    ArrayList<KHACH_HANG_DTO> arrKhachHang = new ArrayList<KHACH_HANG_DTO>();
    arrKhachHang = khach_hang_BUS.getALLKhachHang();
    for (int i = 0; i < arrKhachHang.size(); i++) {
      KHACH_HANG_DTO khach_hang_DTO = arrKhachHang.get(i);
      Object[] newrow = { i + 1, khach_hang_DTO.getMA_KH(), khach_hang_DTO.getTEN_KH(), khach_hang_DTO.getDIA_CHI(),
          "0"+khach_hang_DTO.getSDT(), khach_hang_DTO.getGioitinh(), khach_hang_DTO.getNGAY_CAP_NHAP(),
          khach_hang_DTO.getTRANG_THAI() };
      DefaultTableModel model = (DefaultTableModel) jTable_kh.getModel();
      model.addRow(newrow);
    }

  }

  public void resetKhachHang() {
    tableModel_kh.setRowCount(0);
    loadAllKhachHang();
    makh.setText("KHÁCH HÀNG MỚI");
    tenkh.setText("");
    sdt.setText("");
    diachi.setText("");
    bt_search.setText("");
    search.setText("");
  }

  public void deleteAllKhachHang() {
    DefaultTableModel model = (DefaultTableModel) jTable_kh.getModel();
    model.setRowCount(0);
  }

  public void addKhachHang(java.awt.event.ActionEvent evt) {
    if (makh.getText().equals("KHÁCH HÀNG MỚI") == false) {
      JOptionPane.showMessageDialog(this, "Mã Khach' hang` tồn tại !, bấm reset để thêm Khach Hang` mới");
    }
    else if (tenkh.getText().equals("") || sdt.getText().equals("") || diachi.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Các ô không được để trống !");
    } else if (check1.CheckTen(tenkh.getText().trim(), 40) == false) {
      JOptionPane.showMessageDialog(this, "Tên Khách hàng phải nhỏ hơn 40 chữ cái !");
    } else if (check1.CheckTen(makh.getText().trim(), 40) == false) {
      JOptionPane.showMessageDialog(this, "Mã khách hàng phải nhỏ hơn 40 chữ cái !");
    } else if (check1.CheckTen(diachi.getText().trim(), 40) == false) {
      JOptionPane.showMessageDialog(this, "địa chỉ khách hàng phải nhỏ hơn 40 chữ cái !");
    } else if (check1.checkSDT(sdt.getText().trim()) == false) {
      JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại!");
    } else {
      Boolean flag = true;

      if (khach_hang_BUS.checkTenKH(tenkh.getText().trim())) {
        int dialogResult = JOptionPane.showConfirmDialog(null,
            "Đã tồn tại Khách hàng này, bạn có muốn thêm tiếp không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
          flag = true;
        } else {
          flag = false;
        }
      }

      if (flag == true) {
        String maKH = "";
        KHACH_HANG_DTO Khach_hang_DTO = new KHACH_HANG_DTO();

        while (true) {
          maKH = check1.Ma_generateRandomCode("MKH");
          if (khach_hang_BUS.check_MAKH(maKH) == false) {
            break;
          }
        }
        makh.setText(maKH.trim());
        Khach_hang_DTO.setMA_KH(makh.getText().trim());
        Khach_hang_DTO.setTEN_KH(tenkh.getText().trim());
        Khach_hang_DTO.setDIA_CHI(diachi.getText().trim());
        Khach_hang_DTO.setSDT(Integer.parseInt(( sdt.getText().trim())));
        Khach_hang_DTO.setGioitinh((String)comboBox_Gioitinh.getSelectedItem());
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strDate = formatter.format(date);
        Khach_hang_DTO.setNGAY_CAP_NHAP(strDate);

        
        
        khach_hang_BUS.addKhachHang(Khach_hang_DTO);

        JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công (Mã hãng: " + Khach_hang_DTO.getMA_KH() + ")");
        resetKhachHang();

      }

    }

  }

  public void editKhachHang(java.awt.event.ActionEvent evt) {
    // if (makh.getText().equals("KHÁCH HÀNG MỚI")== fal se) {
    //   JOptionPane.showMessageDialog(this, "Mã Khach' hang` tồn tại !, bấm reset để thêm Khach Hang` mới");
    // }

     if (tenkh.getText().equals("") || sdt.getText().equals("") || diachi.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "Các ô không được để trống !");
    } else if (check1.CheckTen(tenkh.getText().trim(), 40) == false) {
      JOptionPane.showMessageDialog(this, "Tên Khách hàng phải nhỏ hơn 40 chữ cái !");
    } else if (check1.CheckTen(makh.getText().trim(), 40) == false) {
      JOptionPane.showMessageDialog(this, "Mã khách hàng phải nhỏ hơn 40 chữ cái !");
    } else if (check1.CheckTen(diachi.getText().trim(), 40) == false) {
      JOptionPane.showMessageDialog(this, "địa chỉ khách hàng phải nhỏ hơn 40 chữ cái !");
    } else if (check1.CheckTen(sdt.getText().trim(), 12) == false) {
      JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng phải quá hơn 11 chữ cái !");
    } else {

      Boolean flag = true;
      if (khach_hang_BUS.checkTenKH(tenkh.getText().trim())) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Đã tồn tại Khách hàng này, bạn có muốn sửa không ?",
            "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
          flag = true;
        } else {
          flag = false;
        }
      }

      if (flag == true) {
        KHACH_HANG_DTO Khach_hang_DTO = new KHACH_HANG_DTO();

        Khach_hang_DTO.setMA_KH(makh.getText().trim());
        Khach_hang_DTO.setTEN_KH(tenkh.getText().trim());
        Khach_hang_DTO.setDIA_CHI(diachi.getText().trim());
        Khach_hang_DTO.setSDT(Integer.parseInt((sdt.getText().trim())));
        Khach_hang_DTO.setGioitinh((String)comboBox_Gioitinh.getSelectedItem());
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strDate = formatter.format(date);
        Khach_hang_DTO.setNGAY_CAP_NHAP(strDate);

        khach_hang_BUS.editKhachHang(Khach_hang_DTO);


        JOptionPane.showMessageDialog(this, "Sửa thành công");
        resetKhachHang();
      }
    }

  }

  public void deleteKhachHang(java.awt.event.ActionEvent evt) {
    if (makh.getText().equals("KHÁCH HÀNG MỚI")) {
      JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng !");
    } else {
      // Boolean flag = true;
      // if (khach_hang_BUS.checkMAKhachHang(makh.getText().trim())) {
      //   int dialogResult = JOptionPane.showConfirmDialog(null,
      //       "Đang có khách hàng đang sử dụng mã, bạn vẫn muốn xóa chứ ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
      //   if (dialogResult == JOptionPane.YES_OPTION) {
      //     flag = true;
      //     khach_hang_BUS.updateKhachHang(makh.getText().trim());
      //   } else {
      //     flag = false;
      //   }
      // }

      // if (flag == true) {
        khach_hang_BUS.deleteKhachHang(makh.getText().trim());
        JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công");
        resetKhachHang();
      // }

    }

  }

  public void Dispose(java.awt.event.ActionEvent evt) {
    this.dispose();
  }

  public class NonEditableTableModel extends DefaultTableModel {

    public NonEditableTableModel(Object[][] data, Object[] columnNames) {
      super(data, columnNames);
    }

    public DefaultTableModel getModel() {
      return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return false; // không cho phép sửa đổi các ô trong bảng
    }

  }

  public void removeAllKhachHang() {
    DefaultTableModel model = tableModel_kh.getModel();
    model.setRowCount(0);
  }

  public static void main(String[] args) {
    new KHACH_HANG_GUI();
  }

}

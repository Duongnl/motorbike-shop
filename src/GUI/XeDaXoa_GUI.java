package GUI;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.XeDaXoa_BUS;

public class XeDaXoa_GUI extends JPanel
{
    private JTable jTable_XeDaXoa;
    private NonEditableTableModel tableModel_XeDaXoa;
    private JScrollPane jScrollPane_XeDaXoa;
    private JTextField jTextField_timKiem;
    private String[] String_timKiemTheo = { };
    private JComboBox comboBox_timKiemTheo;
    private JButton jButton_timKiemXeDaXoa;
    private JButton jButton_resetXeDaXoa;
    private XeDaXoa_BUS xeDaXoa_BUS = new XeDaXoa_BUS();



    public XeDaXoa_GUI ()
    {
        init_XeDaXoa();
        loadAllXeDaXoa();
    }
    
    public void init_XeDaXoa ()
    {
    jTable_XeDaXoa = new JTable();
    tableModel_XeDaXoa = new NonEditableTableModel(new Object[][] {
    }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ NHẬP", "LOẠI XE", "MÀU XE", "HÃNG XE", "SỐ KHUNG", "DUNG TÍCH", "TỒN KHO", "THỜI GIAN BẢO HÀNH", "MÃ HÃNG", "MÃ LOẠI", "MÃ MÀU"} );
    jTable_XeDaXoa = new JTable(tableModel_XeDaXoa);
    jScrollPane_XeDaXoa = new JScrollPane(jTable_XeDaXoa);
    jScrollPane_XeDaXoa.setBounds(0, 0, 1400, 394);



    // font hóa đơn nhập
    Font font_XeDaXoa = new Font("Arial", Font.BOLD, 14);


    // jlabel tìm kiếm 
    JLabel jLabel_timKiem = new JLabel("TÌM KIẾM:");
    jLabel_timKiem.setFont(font_XeDaXoa);
    jLabel_timKiem.setBounds(27, 448, 73, 16);

    // jtextField tìm kiếm 
    jTextField_timKiem = new JTextField();
    jTextField_timKiem.setFont(font_XeDaXoa);
    jTextField_timKiem.setBounds(146, 444 , 270, 24);

    // jlabel tìm kiếm theo 
    JLabel jLabel_timKiemTheo = new JLabel("TÌM KIẾM THEO:");
    jLabel_timKiemTheo.setFont(font_XeDaXoa);
    jLabel_timKiemTheo.setBounds(27, 511, 115, 16);

    // jcombobox tìm kiếm theo
    comboBox_timKiemTheo = new JComboBox<>(String_timKiemTheo);
    comboBox_timKiemTheo.setFont(font_XeDaXoa);
    comboBox_timKiemTheo.setBounds(146, 507, 109, 24);
   
    // JBUTTON TÌM KIẾM 
    ImageIcon Icon_timKiemXeDaXoa = new javax.swing.ImageIcon(getClass().getResource("/IMG/find.png"));
    jButton_timKiemXeDaXoa = new JButton("TÌM KIẾM");
    jButton_timKiemXeDaXoa.setFont(font_XeDaXoa);
    jButton_timKiemXeDaXoa.setIcon(Icon_timKiemXeDaXoa);
    jButton_timKiemXeDaXoa.setBounds(480, 444, 155, 42);

    // Reset XeDaXoa
    ImageIcon Icon_resetXeDaXoa = new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));
    jButton_resetXeDaXoa = new JButton("RESET");
    jButton_resetXeDaXoa.setFont(font_XeDaXoa);
    jButton_resetXeDaXoa.setIcon(Icon_resetXeDaXoa);
    jButton_resetXeDaXoa.setBounds(480, 511, 155, 42);
    jButton_resetXeDaXoa.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       resetXeDaXoa();
      }
  });

  this.setBackground(new java.awt.Color(204, 255, 255));
    this.setLayout(null);
    this.add(jScrollPane_XeDaXoa);
    // this.add(jLabel_timKiem);
    // this.add(jLabel_timKiemTheo);
    // this.add(jTextField_timKiem);
    // this.add(jButton_resetXeDaXoa);
    // this.add(jButton_timKiemXeDaXoa);
    // this.add(comboBox_timKiemTheo);
            
        
        
        
    }

    public void loadAllXeDaXoa ()
    {
      tableModel_XeDaXoa.setRowCount(0);
      
      String [][]  data = xeDaXoa_BUS.getAllXeMayDaXoa();
      int i = 1;
     
      DecimalFormat decimalFormat = new DecimalFormat("###,###");
      for (String[] rowdata : data) {
        // Duyệt qua các phần tử của mảng con
        Object[] newrow = {i,rowdata[0],rowdata[1],decimalFormat.format(Double.parseDouble(rowdata[2])),rowdata[3],rowdata[4],rowdata[5],rowdata[6],rowdata[7],rowdata[8],rowdata[9],rowdata[10],rowdata[11],rowdata[12] };
        i+=1;
        tableModel_XeDaXoa.addRow(newrow);
      }
      jTable_XeDaXoa.getColumnModel().getColumn(11).setResizable(false);
      jTable_XeDaXoa.getColumnModel().getColumn(11).setPreferredWidth(0);
      jTable_XeDaXoa.getColumnModel().getColumn(11).setMinWidth(0);
      jTable_XeDaXoa.getColumnModel().getColumn(11).setMaxWidth(0);

      jTable_XeDaXoa.getColumnModel().getColumn(12).setResizable(false);
      jTable_XeDaXoa.getColumnModel().getColumn(12).setPreferredWidth(0);
      jTable_XeDaXoa.getColumnModel().getColumn(12).setMinWidth(0);
      jTable_XeDaXoa.getColumnModel().getColumn(12).setMaxWidth(0);

      jTable_XeDaXoa.getColumnModel().getColumn(13).setResizable(false);
      jTable_XeDaXoa.getColumnModel().getColumn(13).setPreferredWidth(0);
      jTable_XeDaXoa.getColumnModel().getColumn(13).setMinWidth(0);
      jTable_XeDaXoa.getColumnModel().getColumn(13).setMaxWidth(0);
   }

   public void resetXeDaXoa ()
   {
    tableModel_XeDaXoa.setRowCount(0);
    loadAllXeDaXoa();
    jTextField_timKiem.setText("");
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

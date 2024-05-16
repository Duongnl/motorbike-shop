package GUI;
import java.awt.Font;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.THONG_KE_DOANH_THU_BUS;
import BUS.THONG_KE_NHAP_BUS;
import CHECK.Check1;
import DTO.CT_HOA_DON_BAN_DTO;
import DTO.CT_HOA_DON_BAN_DTO;

import javax.swing.JPanel;

public class THONG_KE_DOANH_THU_GUI extends JPanel
{


    private String[] String_Thang = {"01","02","03","04","05","06","07","08","09","10","11","12" };
    JComboBox<String> comboBox_Thang;
   
    JTextField jTextField_Nam;
    
    Check1 check1 = new Check1();
    JButton jButton_ThongKe;
    THONG_KE_DOANH_THU_BUS thong_KE_DOANH_THU_BUS = new THONG_KE_DOANH_THU_BUS();
    

    private JTable jTable_SanPham;
    private NonEditableTableModel tableModel_SanPham;
    private JScrollPane jScrollPane_SanPham;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
      public  THONG_KE_DOANH_THU_GUI ()
    {
        this.init_ThongKeNhap();
        // BieuDoNhap();
        
    }

    public void init_ThongKeNhap ()
    {
        // setSize(1415,740);
        setLayout(null);
        Font font = new Font("Segoe UI Plain", 0 ,14);
        
        JLabel   tieude1 = new JLabel("Bảng sản phẩm");
        tieude1.setBackground(new java.awt.Color(204, 255, 255));
        tieude1.setFont(new java.awt.Font("Segoe UI Black", 0, 24));
        tieude1.setForeground(new java.awt.Color(0, 204, 204));
        tieude1.setBounds(30, 60, 250, 50);
        JLabel  tieude2 = new JLabel("Biểu đồ");
        tieude2.setBackground(new java.awt.Color(204, 255, 255));
        tieude2.setFont(new java.awt.Font("Segoe UI Black", 0, 24));
        tieude2.setForeground(new java.awt.Color(0, 204, 204));
        tieude2.setBounds(710, 60, 250, 50);
        JLabel   month = new JLabel("Tháng");
        month.setFont(font);
        month.setBounds(30,20,80,25);
        JLabel  year = new JLabel("Năm");
        year.setFont(font);
        year.setBounds(180,20,80,25);
       


        comboBox_Thang = new JComboBox<>(String_Thang);
        comboBox_Thang.setBounds(90,20,60,25);
        
        jTextField_Nam = new JTextField("2023");
        jTextField_Nam.setBounds(230,20,100,25);
        
        jButton_ThongKe = new JButton("Thống kê");
        jButton_ThongKe.setBounds(360,20,140,25);
        jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            thongKeDoanhThu(evt);
          }
      });
        
        
        jTable_SanPham = new JTable();
        tableModel_SanPham = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ BÁN", "SỐ LƯỢNG" , "TỔNG", "NGÀY LẬP"} );
        jTable_SanPham = new JTable(tableModel_SanPham);
        jScrollPane_SanPham = new JScrollPane(jTable_SanPham);
        jScrollPane_SanPham.setBounds(20,140,640,380);
        
         dataset = new DefaultCategoryDataset();
      
        
        // Tạo biểu đồ từ dataset
         chart = ChartFactory.createBarChart(
                "THỐNG KÊ DOANH THU", 
                "NGÀY THÁNG", "DOANH THU", dataset);

        // Thêm biểu đồ vào ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(710,140,680,380);
        // chartPanel.setBounds(850,140,500,380);
        
        // Thêm ChartPanel vào JFrame
        
        
        this.setLayout(null);
        this.setBackground(new java.awt.Color(204, 255, 255));
        
        
        this.add(month);
        this.add(comboBox_Thang);
        this.add(year);
        this.add(jTextField_Nam);
        this.add(tieude1);
        this.add(tieude2);
        this.add(jButton_ThongKe);
        this.add(jScrollPane_SanPham);
        this.add(chartPanel);
        
        
    }

    public void thongKeDoanhThu (java.awt.event.ActionEvent evt)
    {
     tableModel_SanPham.setRowCount(0);
     // CategoryPlot plot = chart.getCategoryPlot();
     // plot.setDataset(dataset);
     dataset.clear();
     
      if (jTextField_Nam.getText().equals(""))
       {
         JOptionPane.showMessageDialog(this, "Năm không được để trống", "ERROR", JOptionPane.ERROR_MESSAGE);
       }else if (check1.checkSoLuong(jTextField_Nam.getText().trim()) == false)
       {
         JOptionPane.showMessageDialog(this, "Không đúng định dạng năm", "ERROR", JOptionPane.ERROR_MESSAGE);
       }
       else 
         {
         String ngayLap = "";
         String thang= (String)comboBox_Thang.getSelectedItem();
         String nam = jTextField_Nam.getText().trim();
         ngayLap = "%" + thang+"/"+nam + "%";
         ArrayList<CT_HOA_DON_BAN_DTO> arrCTHDN = new ArrayList<CT_HOA_DON_BAN_DTO>();
         arrCTHDN = thong_KE_DOANH_THU_BUS.getAllCTHDN_ThongKe(ngayLap);
         if (arrCTHDN.size() == 0)
         {
           JOptionPane.showMessageDialog(this, "Không có doanh trong thời gian này", "ERROR", JOptionPane.ERROR_MESSAGE);
           tableModel_SanPham.setRowCount(0);
         }else
         {
           DecimalFormat decimalFormat = new DecimalFormat("###,###");
             for (int i = 0; i<arrCTHDN.size(); i++)
             {
               CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO = arrCTHDN.get(i);
               Object[] newrow = {i+1,ct_HOA_DON_BAN_DTO.getMA_XE(), ct_HOA_DON_BAN_DTO.getTEN_XE(),  decimalFormat.format(ct_HOA_DON_BAN_DTO.getGIA_NHAP()), ct_HOA_DON_BAN_DTO.getSO_LUONG(), decimalFormat.format(ct_HOA_DON_BAN_DTO.getGIA()), ct_HOA_DON_BAN_DTO.getNGAY_LAP()};
               tableModel_SanPham.addRow(newrow);
 
             }
             veBieuDo(arrCTHDN);
           }
 
 
 
       }
    }
    
    class Xe {
      private String maXe;
      private String tenXe;
      private long soLuong;
  
      public Xe(String maXe, String tenXe, long soLuong) {
          this.maXe = maXe;
          this.tenXe = tenXe;
          this.soLuong = soLuong;
      }
  
      public String getMaXe() {
          return maXe;
      }
  
      public String getTenXe() {
          return tenXe;
      }
  
      public long getSoLuong() {
          return soLuong;
      }
  
      public void setSoLuong(long soLuong) {
          this.soLuong = soLuong;
      }
  
      @Override
      public String toString() {
          return "Mã xe: " + maXe + ", Tên xe: " + tenXe + ", Số lượng: " + soLuong;
      }
  }



  public void veBieuDo ( ArrayList<CT_HOA_DON_BAN_DTO> arrCTHDN)
  {
 
    ArrayList <Xe> arrXe = new ArrayList<Xe>();

       for (int i = 0; i< arrCTHDN.size(); i++)
       {
         CT_HOA_DON_BAN_DTO ct_HOA_DON_BAN_DTO = arrCTHDN.get(i);
         String maXe = ct_HOA_DON_BAN_DTO.getTHANG_NAM();
         String tenXe = ct_HOA_DON_BAN_DTO.getTEN_XE();
         long soLuong = ct_HOA_DON_BAN_DTO.getGIA();

         Xe xe = new Xe(maXe, tenXe,soLuong);
         arrXe.add( xe);
       }


       // Tạo một Map để lưu trữ các đối tượng Xe theo mã xe
       Map<String, Xe> xeMap = new HashMap<>();

       // Duyệt qua mảng các đối tượng Xe và thêm/sửa thông tin trong Map
       for (Xe xe : arrXe) {
         if(xe == null) {
           continue;
       }
         
         String maXe = xe.getMaXe();

           if (xeMap.containsKey(maXe)) { // Nếu đã có trong Map
               long soLuongMoi = xeMap.get(maXe).getSoLuong() + xe.getSoLuong(); // Tổng hợp số lượng mới và số lượng cũ
               xeMap.get(maXe).setSoLuong(soLuongMoi); // Cập nhật lại giá trị trong Map
           } else { // Nếu chưa có trong Map
               xeMap.put(maXe, xe); // Thêm mới đối tượng Xe vào Map
           }
       }

       // Tạo một danh sách để chứa các đối tượng duy nhất từ Map
       List<Xe> listXe = new ArrayList<>(xeMap.values());
       DecimalFormat decimalFormat = new DecimalFormat("###,###");

       // In ra kết quả
       System.out.println("Danh sách các đối tượng Xe duy nhất:");
       for (Xe xe : listXe) {
         dataset.setValue( xe.getSoLuong()   , "DOANH THU", xe.getMaXe() );
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

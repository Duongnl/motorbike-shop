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
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import BUS.THONG_KE_NHAP_BUS;
import CHECK.Check1;
import DTO.CT_HOA_DON_NHAP_DTO;



public class THONG_KE_NHAP_GUI extends JPanel {
    
  private String[] String_Thang = {"01","02","03","04","05","06","07","08","09","10","11","12" };
    JComboBox<String> comboBox_Thang;
   
    JTextField jTextField_Nam;
    
    Check1 check1 = new Check1();
    JButton jButton_ThongKe;
    THONG_KE_NHAP_BUS thong_KE_NHAP_BUS = new THONG_KE_NHAP_BUS();
    

    private JTable jTable_SanPhamNhap;
    private NonEditableTableModel tableModel_SanPhamNhap;
    private JScrollPane jScrollPane_SanPhamNhap;
    
    
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;


    public  THONG_KE_NHAP_GUI ()
    {
        this.init_ThongKeNhap();
        // BieuDoNhap();
        
    }

    public void init_ThongKeNhap ()
    {
        // setSize(1415,740);
        setLayout(null);
        Font font = new Font("Segoe UI Plain", 0 ,14);
        
        JLabel   tieude1 = new JLabel("Bảng sản phẩm nhập");
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
            thongKeNhapXe(evt);
          }
      });
        
        
        jTable_SanPhamNhap = new JTable();
        tableModel_SanPhamNhap = new NonEditableTableModel(new Object[][] {
        }, new String[]{"STT" ,"MÃ XE", "TÊN XE", "GIÁ NHẬP", "SỐ LƯỢNG", "TỔNG"} );
        jTable_SanPhamNhap = new JTable(tableModel_SanPhamNhap);
        jScrollPane_SanPhamNhap = new JScrollPane(jTable_SanPhamNhap);
        jScrollPane_SanPhamNhap.setBounds(20,140,640,380);
        
         dataset = new DefaultCategoryDataset();
      
        
        // Tạo biểu đồ từ dataset
         chart = ChartFactory.createBarChart(
                "THỐNG KÊ SỐ LƯỢNG NHẬP XE", 
                "XE MÁY", "SỐ LƯỢNG NHẬP", dataset);

        // Thêm biểu đồ vào ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(710,140,680,380);
        
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
        this.add(jScrollPane_SanPhamNhap);
        this.add(chartPanel);
        
        
    }

  //  public void BieuDoNhap ()
  //  {
  //   DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  //   dataset.setValue(120, "Products", "Jan");
  //   dataset.setValue(240, "Products", "Feb");
  //   dataset.setValue(180, "Products", "Mar");
  //   dataset.setValue(90, "Products", "Apr");
    
  //   // Tạo biểu đồ từ dataset
  //   JFreeChart chart = ChartFactory.createBarChart(
  //           "THỐNG KÊ SỐ LƯỢNG NHẬP XE", 
  //           "XE MÁY", "SỐ LƯỢNG NHẬP", dataset);

  //   // Thêm biểu đồ vào ChartPanel
  //   ChartPanel chartPanel = new ChartPanel(chart);
  //   chartPanel.setBounds(710,140,680,380);
    
  //   // Thêm ChartPanel vào JFrame
  //   this.add(chartPanel);
  //  }
 

 

   public void thongKeNhapXe (java.awt.event.ActionEvent evt)
   {
    tableModel_SanPhamNhap.setRowCount(0);
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
        ArrayList<CT_HOA_DON_NHAP_DTO> arrCTHDN = new ArrayList<CT_HOA_DON_NHAP_DTO>();
        arrCTHDN = thong_KE_NHAP_BUS.getAllCTHDN_ThongKe(ngayLap);
        if (arrCTHDN.size() == 0)
        {
          JOptionPane.showMessageDialog(this, "Không có xe nào nhập trong thời gian này", "ERROR", JOptionPane.ERROR_MESSAGE);
          tableModel_SanPhamNhap.setRowCount(0);
        }else
        {
          DecimalFormat decimalFormat = new DecimalFormat("###,###");
            for (int i = 0; i<arrCTHDN.size(); i++)
            {
              CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = arrCTHDN.get(i);
              Object[] newrow = {i+1,ct_HOA_DON_NHAP_DTO.getMA_XE(), ct_HOA_DON_NHAP_DTO.getTEN_XE(),  decimalFormat.format(ct_HOA_DON_NHAP_DTO.getGIA_NHAP()), ct_HOA_DON_NHAP_DTO.getSO_LUONG(), decimalFormat.format(ct_HOA_DON_NHAP_DTO.getGIA())};
              tableModel_SanPhamNhap.addRow(newrow);

            }
            veBieuDo(arrCTHDN);
          }



      }
   }
   

   class Xe {
    private String maXe;
    private String tenXe;
    private int soLuong;

    public Xe(String maXe, String tenXe, int soLuong) {
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Mã xe: " + maXe + ", Tên xe: " + tenXe + ", Số lượng: " + soLuong;
    }
}




  //  public void veBieuDo ( ArrayList<CT_HOA_DON_NHAP_DTO> arrCTHDN)
  //  {
  
  //         Xe[] arrXe = new Xe[5]; 
  //         // ArrayList <Xe> arrXe = new ArrayList<Xe>();

  //       for (int i = 0; i< arrCTHDN.size(); i++)
  //       {
  //         CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = arrCTHDN.get(i);
  //         String maXe = ct_HOA_DON_NHAP_DTO.getMA_XE();
  //         String tenXe = ct_HOA_DON_NHAP_DTO.getTEN_XE();
  //         int soLuong = ct_HOA_DON_NHAP_DTO.getSO_LUONG();

  //         Xe xe = new Xe(maXe, tenXe,soLuong);
  //         arrXe[i] = xe;
  //       }


  //       // Tạo một Map để lưu trữ các đối tượng Xe theo mã xe
  //       Map<String, Xe> xeMap = new HashMap<>();

  //       // Duyệt qua mảng các đối tượng Xe và thêm/sửa thông tin trong Map
  //       for (Xe xe : arrXe) {
  //         if(xe == null) {
  //           continue;
  //       }
          
  //         String maXe = xe.getMaXe();

  //           if (xeMap.containsKey(maXe)) { // Nếu đã có trong Map
  //               int soLuongMoi = xeMap.get(maXe).getSoLuong() + xe.getSoLuong(); // Tổng hợp số lượng mới và số lượng cũ
  //               xeMap.get(maXe).setSoLuong(soLuongMoi); // Cập nhật lại giá trị trong Map
  //           } else { // Nếu chưa có trong Map
  //               xeMap.put(maXe, xe); // Thêm mới đối tượng Xe vào Map
  //           }
  //       }

  //       // Tạo một danh sách để chứa các đối tượng duy nhất từ Map
  //       List<Xe> listXe = new ArrayList<>(xeMap.values());

  //       // In ra kết quả
  //       System.out.println("Danh sách các đối tượng Xe duy nhất:");
  //       for (Xe xe : listXe) {
  //         dataset.setValue(xe.getSoLuong(), "Products", xe.getMaXe() + "-" + xe.getTenXe());
  //       }

   
  //  }


   public void veBieuDo ( ArrayList<CT_HOA_DON_NHAP_DTO> arrCTHDN)
   {
  
          // Xe[] arrXe = new Xe[5]; 
          ArrayList <Xe> arrXe = new ArrayList<Xe>();

        for (int i = 0; i< arrCTHDN.size(); i++)
        {
          CT_HOA_DON_NHAP_DTO ct_HOA_DON_NHAP_DTO = arrCTHDN.get(i);
          String maXe = ct_HOA_DON_NHAP_DTO.getMA_XE();
          String tenXe = ct_HOA_DON_NHAP_DTO.getTEN_XE();
          int soLuong = ct_HOA_DON_NHAP_DTO.getSO_LUONG();

          Xe xe = new Xe(maXe, tenXe,soLuong);
          arrXe.add(xe);
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
                int soLuongMoi = xeMap.get(maXe).getSoLuong() + xe.getSoLuong(); // Tổng hợp số lượng mới và số lượng cũ
                xeMap.get(maXe).setSoLuong(soLuongMoi); // Cập nhật lại giá trị trong Map
            } else { // Nếu chưa có trong Map
                xeMap.put(maXe, xe); // Thêm mới đối tượng Xe vào Map
            }
        }

        // Tạo một danh sách để chứa các đối tượng duy nhất từ Map
        List<Xe> listXe = new ArrayList<>(xeMap.values());

        // In ra kết quả
        System.out.println("Danh sách các đối tượng Xe duy nhất:");
        for (Xe xe : listXe) {
          dataset.setValue(xe.getSoLuong(), "Xe máy", xe.getMaXe() + "-" + xe.getTenXe());
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

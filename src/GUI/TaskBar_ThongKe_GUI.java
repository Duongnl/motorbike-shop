package GUI;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TaskBar_ThongKe_GUI  extends JFrame 
{
    THONG_KE_NHAP_GUI thong_KE_NHAP_GUI = new THONG_KE_NHAP_GUI();
    THONG_KE_BAN_GUI thong_KE_BAN_GUI = new THONG_KE_BAN_GUI();
    THONG_KE_DOANH_THU_GUI thong_KE_DOANH_THU_GUI = new THONG_KE_DOANH_THU_GUI();
    
    

    private JButton jButton_exit;
    private JTabbedPane tabbedPaneHDB;
    public TaskBar_ThongKe_GUI ()
    {
        this.init_ThongKe();
        this.setVisible(true);
    }
    public void init_ThongKe ()
    {
     this.setTitle("Thống kê");
    this.setSize(1415,740);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
     // Tiêu đề "hóa đơn bán"
     JLabel jLabel_textThongKe = new JLabel("THỐNG KÊ", JLabel.CENTER);
     Font font_textKhoXeMay  = new Font("Arial", Font.BOLD, 40);
     jLabel_textThongKe.setFont(font_textKhoXeMay);
     jLabel_textThongKe.setBounds(508, 12, 383, 50);

      // NÚT QUAY LẠI
      ImageIcon Icon_exit =new javax.swing.ImageIcon(getClass().getResource("/IMG/exit.png"));
      jButton_exit = new JButton("EXIT");
      jButton_exit.setIcon(Icon_exit);
      jButton_exit.setBounds(14, 12, 100, 50);
      jButton_exit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          Dispose(evt);
        }
    });

    // THANH TASKBAR
    tabbedPaneHDB = new JTabbedPane(); 
    tabbedPaneHDB.addTab("THỐNG KÊ NHẬP HÀNG",thong_KE_NHAP_GUI );
    tabbedPaneHDB.addTab("THỐNG KÊ BÁN HÀNG",thong_KE_BAN_GUI );
    tabbedPaneHDB.addTab("THỐNG KÊ DOANH THU",thong_KE_DOANH_THU_GUI );
    // tabbedPaneHDB.addTab("XEM HÓA ĐƠN",  );
    tabbedPaneHDB.setBounds(0, 70,1400,630);
    tabbedPaneHDB.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
          int tabIndex = tabbedPaneHDB.getSelectedIndex(); 
          
          if (tabIndex == 0)
          {
            
          }
          if (tabIndex == 1)
          {
            
          }
          if (tabIndex == 2)
          {
            
          }

          
        
        }
    }); 


    this.setLayout(null);
    this.add(jLabel_textThongKe);
    this.add(jButton_exit);
    this.add(tabbedPaneHDB);

    }



    public void Dispose (java.awt.event.ActionEvent evt)
    {
        this.dispose();
    }


    public static void main(String[] args) {
        new TaskBar_ThongKe_GUI();
    }








}

package GUI;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import DTO.XE_MAY_DTO;
public class TaskBar_HoaDonBan_GUI extends JFrame
{
    private JButton jButton_exitHDB;
    private JTabbedPane tabbedPaneHDB;
    private HOA_DON_BAN_GUI hoa_DON_BAN_GUI;
    private CT_HOA_DON_BAN_GUI ct_HOA_DON_BAN_GUI;

    public TaskBar_HoaDonBan_GUI ()
    {
        hoa_DON_BAN_GUI = new HOA_DON_BAN_GUI();
        ct_HOA_DON_BAN_GUI = new CT_HOA_DON_BAN_GUI();
        this.init_HoaDonBan();
        this.setVisible(true);
    }

    public void init_HoaDonBan ()
    {
    this.setTitle("Quản lý hóa đơn bán");
    this.setSize(1415,740);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Tiêu đề "hóa đơn bán"
    JLabel jLabel_textKhoXeMay = new JLabel("HÓA ĐƠN BÁN", JLabel.CENTER);
    Font font_textKhoXeMay  = new Font("Arial", Font.BOLD, 40);
    jLabel_textKhoXeMay.setFont(font_textKhoXeMay);
    jLabel_textKhoXeMay.setBounds(508, 12, 383, 50);


     // NÚT QUAY LẠI
     ImageIcon Icon_exit =new javax.swing.ImageIcon(getClass().getResource("/IMG/exit.png"));
     jButton_exitHDB = new JButton("EXIT");
     jButton_exitHDB.setIcon(Icon_exit);
     jButton_exitHDB.setBounds(14, 12, 100, 50);
     jButton_exitHDB.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
          Dispose(evt);
       }
   });


    // THANH TASKBAR
    tabbedPaneHDB = new JTabbedPane(); 
    tabbedPaneHDB.addTab("LẬP HÓA ĐƠN",hoa_DON_BAN_GUI );
    tabbedPaneHDB.addTab("XEM HÓA ĐƠN", ct_HOA_DON_BAN_GUI );
   
    tabbedPaneHDB.setBounds(0, 70,1400,630);
    tabbedPaneHDB.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
          int tabIndex = tabbedPaneHDB.getSelectedIndex(); 
          
          if (tabIndex == 0)
          {
            
            
          }
          if (tabIndex == 1)
          {
            ct_HOA_DON_BAN_GUI.resetHDB();
            ct_HOA_DON_BAN_GUI.resetCTHDB();
          }
          
        
        }
    }); 


    this.setBackground(new java.awt.Color(204, 255, 255));
    this.setLayout(null);
    this.add(jLabel_textKhoXeMay);
    this.add(jButton_exitHDB);
    this.add(tabbedPaneHDB);
    }

   public void Dispose (java.awt.event.ActionEvent evt)
   {
     this.dispose();
   }







    public static void main(String[] args) {
        new TaskBar_HoaDonBan_GUI();
    }



}

package GUI;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TaskBar_QLXe_GUI extends JFrame
{
    private JTabbedPane tabbedPane;
    private XE_MAY_GUI xe_MAY_GUI;
    private JButton jButton_exit;
    private HANG_XE_GUI hang_XE_GUI;
    private LOAI_XE_GUI loai_XE_GUI;
    private MAU_XE_GUI mau_XE_GUI;
    private HOA_DON_NHAP_GUI hoa_DON_NHAP_GUI;
    private XeDaXoa_GUI xeDaXoa_GUI;
    private CT_HOA_DON_NHAP_GUI ct_HOA_DON_NHAP_GUI;

    public TaskBar_QLXe_GUI()
    {
        xe_MAY_GUI = new XE_MAY_GUI();
        hang_XE_GUI = new HANG_XE_GUI();
        loai_XE_GUI = new LOAI_XE_GUI();
        mau_XE_GUI = new MAU_XE_GUI();
        hoa_DON_NHAP_GUI = new HOA_DON_NHAP_GUI();
        xeDaXoa_GUI = new XeDaXoa_GUI();
        ct_HOA_DON_NHAP_GUI = new CT_HOA_DON_NHAP_GUI();
        this.init();
        this.setVisible(true);
    }

     public void init ()
     {
        this.setTitle("Quản lý xe máy");
        this.setSize(1415,740);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tiêu đề "KHO XE MÁY"
        JLabel jLabel_textKhoXeMay = new JLabel("QUẢN LÝ XE MÁY", JLabel.CENTER);
        Font font_textKhoXeMay  = new Font("Arial", Font.BOLD, 40);
        jLabel_textKhoXeMay.setFont(font_textKhoXeMay);
        jLabel_textKhoXeMay.setBounds(508, 12, 383, 50);


        // NÚT QUAY LẠI
        ImageIcon Icon_exit = new javax.swing.ImageIcon(getClass().getResource("/IMG/exit.png"));
        jButton_exit = new JButton("EXIT");
        jButton_exit.setIcon(Icon_exit);
        jButton_exit.setBounds(14, 12, 100, 50);
        jButton_exit.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
             Dispose(evt);
          }
      });
        
        // THANH TASKBAR
        tabbedPane = new JTabbedPane(); 
        tabbedPane.addTab("KHO XE", xe_MAY_GUI );
        tabbedPane.addTab("NHẬP XE", hoa_DON_NHAP_GUI );
        tabbedPane.addTab("HÓA ĐƠN NHẬP XE",ct_HOA_DON_NHAP_GUI);
        tabbedPane.addTab("HÃNG XE", hang_XE_GUI );
        tabbedPane.addTab("LOẠI XE", loai_XE_GUI );
        tabbedPane.addTab("MÀU XE", mau_XE_GUI );
        tabbedPane.addTab("XE ĐÃ XÓA", xeDaXoa_GUI );
        tabbedPane.setBounds(0, 70,1400,630);
        
        tabbedPane.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            int tabIndex = tabbedPane.getSelectedIndex(); 
            
            if (tabIndex == 0)
            {
              xe_MAY_GUI.loadAllXeMay();
              xe_MAY_GUI.loadKhoaNgoai();
              xe_MAY_GUI.resetXeMay();
              
            }
            if (tabIndex == 1)
            {
             hoa_DON_NHAP_GUI.loadKhoaNgoaiHDN();
             hoa_DON_NHAP_GUI.resetXeMayHDN();
             hoa_DON_NHAP_GUI.deleteAllXeMay();
            }
            if (tabIndex == 2)
            {
              ct_HOA_DON_NHAP_GUI.resetHDN();
              ct_HOA_DON_NHAP_GUI.resetCTHDN();
            }
            if (tabIndex == 3)
            {
              hang_XE_GUI.resetHangXe();
            }
            if (tabIndex == 4)
            {
              loai_XE_GUI.resetLoaiXe();
            }
            if(tabIndex == 5)
            {
              mau_XE_GUI.resetMauXe();
            }
            if (tabIndex == 6)
            {
              xeDaXoa_GUI.resetXeDaXoa();
            }
          
          }
      }); 
         
      this.setLayout(null);
      this.setBackground(new java.awt.Color(204, 255, 255));
      this.add(jButton_exit);
      this.add(jLabel_textKhoXeMay);
      this.add(tabbedPane);
        
     }

    public void Dispose (java.awt.event.ActionEvent evt)
    {
      this.dispose();
    } 

    public static void main(String[] args) {
     new TaskBar_QLXe_GUI();  

    }


}

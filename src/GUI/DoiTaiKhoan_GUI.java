package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DoiTaiKhoan_GUI extends JFrame
{
    private AbstractButton jButton_exitDTK;
    // private JTextField jtextFiled_TKCu;
    private JTextField jtextFiled_TKMoi;
    private JButton jButton_resetDTK;
    private JButton jButton_luuDTK;

    public DoiTaiKhoan_GUI ()
    {
        this.init_DoiTaiKhoan();;
        this.setVisible(true);
    }

    public void init_DoiTaiKhoan ()
    {
        this.setTitle("Đổi tài khoản");
       this.setSize(500,500);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    


    //    JBUTTON EXIT 
    ImageIcon Icon_exitDTK= new ImageIcon("D:\\HocKy4\\Java\\JAVAPROJECT\\src\\IMG\\exit24.png");
    jButton_exitDTK = new JButton("EXIT TK");
    jButton_exitDTK.setIcon(Icon_exitDTK);
    jButton_exitDTK.setBounds(13, 12, 125, 30);
    jButton_exitDTK.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Dispose(evt);
        }
    });
   


    // FONT TIÊU ĐỀ ĐỔI TÀI KHOẢN 
    Font font_tieuDe = new Font("Arial", Font.BOLD, 25);

    // font đổi tài khoản
    Font font_DTK = new Font("Arial", Font.BOLD, 14); 


    // JLABLE TIÊU ĐỀ ĐỔI TÀI KHOẢN 
    JLabel jLabel_DTK = new JLabel("ĐỔI TÀI KHOẢN", JLabel.CENTER);
    jLabel_DTK.setFont(font_tieuDe);
    jLabel_DTK.setBounds(107, 16, 184, 30);


    // // jlable text nhập tài khoản cũ 
    // JLabel jLabel_textNTKC = new JLabel("NHẬP TÀI KHOẢN CŨ:", JLabel.CENTER);
    // jLabel_textNTKC.setFont(font_DTK);
    // jLabel_textNTKC.setBounds(2, 106, 155, 16);

    // // jtextfile tài khoản cũ
    //  jtextFiled_TKCu = new JTextField();
    // jtextFiled_TKCu.setFont(font_DTK);
    // jtextFiled_TKCu.setBounds(170, 102, 223, 24);

    // jlable text nhập tài khoản mới 
    JLabel jLabel_textNTKM = new JLabel("NHẬP TÀI KHOẢN MỚI:", JLabel.CENTER);
    jLabel_textNTKM.setFont(font_DTK);
    jLabel_textNTKM.setBounds(2, 177, 165, 16);

    // jtextfiled nhập tài khoản mới
    jtextFiled_TKMoi = new JTextField();
    jtextFiled_TKMoi.setFont(font_DTK);
    jtextFiled_TKMoi.setBounds(170, 180, 223, 24);
    
    // jbutton reset
    ImageIcon Icon_resetDTK= new ImageIcon("D:\\HocKy4\\Java\\JAVAPROJECT\\src\\IMG\\redo.png");
    jButton_resetDTK = new JButton("RESET TK");
    jButton_resetDTK.setIcon(Icon_resetDTK);
    jButton_resetDTK.setBounds(47, 282, 125, 31);

    // jbutton lưu
    ImageIcon Icon_luuDTK= new ImageIcon("D:\\HocKy4\\Java\\JAVAPROJECT\\src\\IMG\\save.png");
    jButton_luuDTK = new JButton("LƯU TK");
    jButton_luuDTK.setIcon(Icon_luuDTK);
    jButton_luuDTK.setBounds(239, 282, 125, 31);



    JPanel jPanel_DTK = new JPanel();
    jPanel_DTK.setLayout(null);
    
    jPanel_DTK.add(jLabel_DTK);
    // jPanel_DTK.add(jLabel_textNTKC);
    // jPanel_DTK.add(jtextFiled_TKCu);
    jPanel_DTK.add(jLabel_textNTKM);
    jPanel_DTK.add(jtextFiled_TKMoi);
    jPanel_DTK.add(jButton_resetDTK);
    jPanel_DTK.add(jButton_luuDTK);
    
    jPanel_DTK.setBackground(Color.LIGHT_GRAY);
    jPanel_DTK.setBounds(51, 65, 397, 367);


    this.setLayout(null);
    this.add(jButton_exitDTK);
    this.add(jPanel_DTK);
    }









    public void Dispose(java.awt.event.ActionEvent evt)
    {
        this.dispose();
    }


    public static void main(String[] args) {
        new DoiTaiKhoan_GUI();
    }


}

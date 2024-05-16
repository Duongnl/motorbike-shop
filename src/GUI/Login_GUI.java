package GUI;

import BUS.NHAN_VIEN_BUS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Login_GUI extends JFrame {
    JLabel fr, icon, user, pass, fg;
    JTextField User;
    JPasswordField Pass;
    JCheckBox remem;
    JButton DNhap;
    JPanel p1, p2, p3;
    private NHAN_VIEN_BUS nhan_VIEN_BUS = new NHAN_VIEN_BUS();
    public static String ten_ad;
    public static String id_user;
    public static String pass_id;
    public static String id_role;
    public static String name;
    public static String address;
    public static String numphone;
    public static String email;
    public static String note;
    public static String sex;
    
    public Login_GUI(){
        init_Login(); 
    }
    
    public void init_Login(){
        setSize(320,530);
        setLayout(null);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr = new JLabel();
        fr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/background.png")));
        fr.setBounds(0,0,400,580);
        
        p1 = new JPanel();
        p1.setBackground(new java.awt.Color(255, 153, 255));
        p1.setBounds(10, 180, 100, 30);
        Font font = new Font("Segoe UI Plain", 0 ,14);
        user = new JLabel("Tên tài khoản:");
        user.setFont(font);
        user.setForeground(Color.yellow);
        user.setBounds(10, 180, 100, 30);
        
        p2 = new JPanel();
        p2.setBackground(new java.awt.Color(255, 153, 255));
        p2.setBounds(10, 250, 100, 30);
        pass = new JLabel("Mật khẩu:");
        pass.setFont(font);
        pass.setForeground(Color.yellow);
        pass.setBounds(10, 250, 100, 30);
        
        User = new JTextField();
        User.setBounds(120, 180, 180, 30);
        Pass = new JPasswordField();
        Pass.setBounds(120, 250, 180, 30);
        Pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNVMouseClicked(evt);
            }
        });
        
        p3 = new JPanel();
        p3.setBackground(new java.awt.Color(153, 255, 102));
        p3.setBounds(140,300,150,30);
        fg = new JLabel("Quên Mật Khẩu?");
        fg.setForeground(Color.blue);
        fg.setFont(font);
        fg.setBounds(150,300,200,30);
        fg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                init_Forgot(e);
            }
        });


        ImageIcon ic = new javax.swing.ImageIcon(getClass().getResource("/IMG/ei.png"));
        icon = new JLabel(ic);
        icon.setPreferredSize(new Dimension(150,150));
//        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ei.png")));
        icon.setBounds(100,30,120,120);
        
        DNhap = new JButton("Đăng nhập");
        DNhap.setBounds(85,370,150,40);
//        DNhap.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                init_Login(e);
//            }
//        });
        DNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                init_Login(evt);
            }
        });

        add(fr);
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(User);
        fr.add(Pass);
        fr.add(icon);
        fr.add(DNhap);
        p1.add(user);
        p2.add(pass);
        p3.add(fg);
        
        setVisible(true);
    }
     
    public void init_Forgot(MouseEvent e)
    {
        ForgotPass_GUI forgotPass_GUI = new ForgotPass_GUI();
    }

    private void init_Login(java.awt.event.ActionEvent evt) {                                            
        if (User.getText().equals("") || Pass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Thông tin Tài Khoản Hoặc Mật Khẩu", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        
        }else if(nhan_VIEN_BUS.checkTK(User.getText(), Pass.getText()) == true){
                    nhan_VIEN_BUS.getAllTaiKhoan(User.getText().trim());
                    JOptionPane.showMessageDialog(this, "Đăng Nhập Thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    TrangChu_GUI main = new TrangChu_GUI();
                    main.setVisible(true);
                    this.setVisible(false);
                    
                } else {
                    
                    JOptionPane.showMessageDialog(this, "Tên Tài Khoản Hoặc Mật Khẩu Không Đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
        
    }

    private void TableNVMouseClicked(java.awt.event.MouseEvent evt) {  
      if (nhan_VIEN_BUS.checkUser(User.getText().trim()))
      {
        JOptionPane.showMessageDialog(this, "Tài khoản này không thể sử dụng !", "Lỗi", JOptionPane.ERROR_MESSAGE);
      }
    }



    public static void main(String[] args){
        new Login_GUI();
    }
}

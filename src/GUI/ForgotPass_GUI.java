/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import BUS.NHAN_VIEN_BUS;
import CHECK.mail;
import DTO.NHAN_VIEN_DTO;
import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class ForgotPass_GUI extends JFrame {
    JLabel mail, pass, conpass, tieude;
    JTextField Mail, Checkpass;
    JPasswordField Pass, Conpass;
    JButton luu, ret, gui;
    mail checkmail = new mail();
    NHAN_VIEN_BUS nhan_VIEN_BUS = new NHAN_VIEN_BUS();
    
    public ForgotPass_GUI(){
        design();
    }
    
    public void design(){
        setSize(400,370);
        setLayout(null);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tieude = new JLabel("Đổi mật khẩu");
        tieude.setBackground(new java.awt.Color(204, 255, 255));
        tieude.setFont(new java.awt.Font("Segoe UI Black", 0, 24));
        tieude.setForeground(new java.awt.Color(0, 204, 204));
        tieude.setBounds(115, 5, 250, 50);
        
        Font font = new Font("Segoe UI Plain", 0 ,14);
        mail = new JLabel("Email:");
        mail.setFont(font);
        mail.setBounds(30,55,100,30);
        pass = new JLabel("Mật khẩu mới:");
        pass.setFont(font);
        pass.setBounds(30,155,100,30);
        conpass = new JLabel("Nhập lại mật khẩu:");
        conpass.setFont(font);
        conpass.setBounds(30,205,200,30);
        
        Mail = new JTextField();
        Mail.setFont(font);
        Mail.setBounds(160,55,200,30);
        Pass = new JPasswordField();
        Pass.setFont(font);
        Pass.setBounds(160,155,200,30);
        Conpass = new JPasswordField();
        Conpass.setFont(font);
        Conpass.setBounds(160,205,200,30);
        Conpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Checklen(evt);
            }
        });
        Checkpass = new JTextField();
        Checkpass.setFont(font);
        Checkpass.setBounds(160,105,120,30);
        
        luu = new JButton("Lưu");
        luu.setBounds(120,255,150,40);
       luu.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               Save(evt);
             
           }
       });
        gui = new JButton("Gửi mã");
        gui.setBounds(280,105,80,30);
        gui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Gui_ma(evt);
                } catch (MessagingException ex) {
                    Logger.getLogger(ForgotPass_GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ForgotPass_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ret = new JButton();
        ret.setBounds(5,5,50,30);
        ret.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logout-icon-16.png")));
        ret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dispose(evt);
              
            }
        });
        
        add(tieude);
        add(mail);
        add(pass);
        add(conpass);
        add(Mail);
        add(Pass);
        add(Conpass);
        add(Checkpass);
        add(luu);
        add(ret);
        add(gui);
        setVisible(true);
    }

    public void Dispose(java.awt.event.ActionEvent evt)
    {
        this.dispose();
    }

    public void Gui_ma(java.awt.event.ActionEvent evt) throws MessagingException, UnsupportedEncodingException{
        if(nhan_VIEN_BUS.checkMail(Mail.getText().trim())){
            checkmail.Mail(Mail.getText().trim());
            JOptionPane.showMessageDialog(this, "Gửi mã thành công", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gửi mã thất bại", "FAIL", JOptionPane.INFORMATION_MESSAGE);
        }
    }

   public void Save(java.awt.event.ActionEvent evt){
       if (Pass.getText().equals(Conpass.getText()) && Checkpass.getText().equals(checkmail.body)  ) {
           NHAN_VIEN_DTO nv = new NHAN_VIEN_DTO();
           nv.setPASS(Pass.getText().trim());
           nhan_VIEN_BUS.editPass(nv);
           JOptionPane.showMessageDialog(this, "Mật khẩu đã thay đổi thành công", "thành công", JOptionPane.INFORMATION_MESSAGE);
           this.setVisible(false);  
       } else {
           JOptionPane.showMessageDialog(this, "Mật khẩu mới không khớp", "lỗi", JOptionPane.ERROR_MESSAGE);
       }                
   }
    
    public void Checklen(java.awt.event.MouseEvent evt){
        if (Pass.getText().length() < 8){
            JOptionPane.showMessageDialog(this, "Mật khẩu mới ít nhất 8 kí tự", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args){
        new ForgotPass_GUI();
    }
}

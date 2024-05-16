package GUI;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BUS.DoiMatKhau_BUS;

public class DoiMatKhau_GUI extends JFrame
{

    private JButton jButton_exitDMK;
    private JLabel txt_mkcu;
    private JLabel txt_mkmoi;
    private JLabel txt_nhapmkmoi;
    private JPasswordField mkcu;
    private JPasswordField mkmoi;
    private JPasswordField nhapmkmoi;
    private JButton save;
    private JButton reset;
    private DoiMatKhau_BUS doiMatKhau_BUS = new DoiMatKhau_BUS();




    public DoiMatKhau_GUI ()
    {
        this.init_DoiMatKhau();
        this.setVisible(true);
    }
    
    public void init_DoiMatKhau()
    {
        this.setTitle("Đổi mật khẩu");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //  JBUTTON EXIT 
    ImageIcon Icon_exitDMK= new javax.swing.ImageIcon(getClass().getResource("/IMG/exit.png"));
    ImageIcon save_icon= new javax.swing.ImageIcon(getClass().getResource("/IMG/save.png"));
    ImageIcon reset_icon= new javax.swing.ImageIcon(getClass().getResource("/IMG/redo.png"));


    jButton_exitDMK = new JButton("EXIT");
    jButton_exitDMK.setIcon(Icon_exitDMK);
    jButton_exitDMK.setBounds(13, 12, 125, 30);
    jButton_exitDMK.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
           Dispose (evt);
        }
    });
    
     save = new JButton("SAVE");
    save.setBounds(50,280,115,31);
    save.setIcon(save_icon);
    save.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       save(evt);
      }
  });

    JButton reset = new JButton("RESET");
    reset.setBounds(240,280,115,31);
    reset.setIcon(reset_icon);
    reset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       reset();
      }
  });



    // FONT TIÊU ĐỀ ĐỔI mật khẩu
    Font font_tieuDe = new Font("Arial", Font.BOLD, 25);
    Font font1 = new Font("Arial", Font.BOLD, 14);


    
     // JLABLE TIÊU ĐỀ ĐỔI MẬT KHẨU
     JLabel jLabel_DMK = new JLabel("ĐỔI MẬT KHẨU", JLabel.CENTER);
     jLabel_DMK.setFont(font_tieuDe);
     jLabel_DMK.setBounds(113, 16, 181, 30);

    JLabel txt_mkcu = new JLabel("NHẬP MẬT KHẨU CŨ");
    txt_mkcu.setBounds(3  , 76, 165, 16);
    txt_mkcu.setFont(font1);

    JLabel txt_mkmoi = new JLabel("NHẬP MẬT KHẨU MỚI");
    txt_mkmoi.setBounds(3  , 140, 170, 16);
    txt_mkmoi.setFont(font1);


    JLabel txt_nhapmkmoi = new JLabel("NHẬP LẠI MẬT KHẨU MỚI");
    txt_nhapmkmoi.setBounds(3  , 200, 185, 16);
    txt_nhapmkmoi.setFont(font1);


     mkcu = new JPasswordField();
    mkcu.setBounds(190   , 72  , 220, 24);
    mkcu.setFont(font1);

     mkmoi = new JPasswordField();
    mkmoi.setBounds(190    , 140  , 220, 24);
    mkmoi.setFont(font1);


     nhapmkmoi = new JPasswordField();
    nhapmkmoi.setBounds(190   , 200  , 220, 24);
    nhapmkmoi.setFont(font1);

   



    JPanel jPanel_DMK = new JPanel();
    jPanel_DMK.setLayout(null);
    jPanel_DMK.add(jLabel_DMK);

    jPanel_DMK.add(save);
    jPanel_DMK.add(reset);


    jPanel_DMK.setForeground(Color.LIGHT_GRAY);
    jPanel_DMK.setBounds(41, 68, 416, 367);
    
    jPanel_DMK.add(txt_mkcu);
    jPanel_DMK.add(txt_mkmoi);
    jPanel_DMK.add(txt_nhapmkmoi);

    jPanel_DMK.add(mkcu);
    jPanel_DMK.add(mkmoi);
    jPanel_DMK.add(nhapmkmoi);

    jPanel_DMK.setBackground(Color.LIGHT_GRAY);
    this.setLayout(null);
    this.add(jButton_exitDMK);
    this.add(jPanel_DMK);
 
    }

    public void save (java.awt.event.ActionEvent evt)
    {
      if (mkcu.getText().equals("") || mkmoi.getText().equals("") || nhapmkmoi.getText().equals(""))
      {
        JOptionPane.showMessageDialog(this, "Các trường không được để trống !");
      }
      else {
        if (doiMatKhau_BUS.checkMK(mkcu.getText().trim(), Login_GUI.id_user.trim()) == false)
        {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ không chính xác !");
        } 
        else {
          if (mkmoi.getText().trim().length() <8)
          {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải lớn hơn 8 ký tự");
          }
           else if (mkmoi.getText().trim().equals(nhapmkmoi.getText().trim()) == false)
           {
            JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại sai !");
           }
           else{
            doiMatKhau_BUS.doiMK(Login_GUI.id_user, mkmoi.getText().trim());
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
            reset(); 
          }
        }

      }
    }


    public void reset()
    {
      mkcu.setText("");
      mkmoi.setText("");
      nhapmkmoi.setText("");
    }

  
    public void Dispose(java.awt.event.ActionEvent evt)
    {
            this.dispose();
    }


    // public static void main(String[] args) {
    //     new DoiMatKhau_GUI();
    // }

}

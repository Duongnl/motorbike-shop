
package CHECK;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;

public class mail {
    private int a;
    
     public  String body;
    
     

    public void Mail(String to) throws MessagingException, UnsupportedEncodingException {

        final String fromEmail = "khoa9102003@gmail.com";
        // Mat khai email cua ban
        final String password = "lvsluujfvtzpafka";
        // dia chi email nguoi nhan
        final String toEmail = to;
        
        final String subject = "Mã xác thực reset mật khẩu";
         a=0;
        Random generator = new Random();
        for(int i=1;i<=6;i++) {
            int value = generator.nextInt(9) + 1;
            a=a*10+value;
        }
       
        // final String body = String.valueOf(a);
         body = String.valueOf(a);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);


        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
//        System.out.println("Gui mail thanh cong");
        System.out.println(body);
    }
}

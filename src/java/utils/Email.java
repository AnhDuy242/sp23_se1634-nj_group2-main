/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author asus
 */
public class Email {
    private String username = "ntkien651@gmail.com";
  // Note : sau  1 tgian ko su dung phai thay doi ma cua google
    private String password = "esiabbtqjicyiqna";

    public boolean sendMail(String mail, String title, String content){
         boolean status = false;
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
//           
         MimeMessage message = new MimeMessage(session);

         // Set From: header field.
         message.setFrom(new InternetAddress("ntkien651@gmail.com"));

         // Set To: header field.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(mail));

         // Set Subject: header field
         message.setSubject(title);

         // Send the actual HTML message, as big as you like
         message.setContent(content,
                 
                             "text/html;charset=UTF-8"); //  cho noi dung la 1 doan ma HTML 

         // Send message
         Transport.send(message);
         System.out.println("Gui message thanh cong....");
            status = true;
        } catch (MessagingException e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }
     public String randomCode() {
        String character = "ABCDEFHIJKLMNOPQRSTUVWXYZ0123456789";
        String code = "";
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * (character.length() - 1 - 0 + 1) + 0);
            code += character.charAt(index) + "";
        }
        return code;
    }
//    
//    public static void main(String[] args) {
//        Email emails = new Email();
//         String message_register = " <div style=\"text-align: justify;\n"
//            + "       background-color: #d3d3d3;\n"
//            + "       padding: 10px;    font-size: 20px;"
//            + "Bạn hoặc ai đó đã sử dụng email để tạo tài khoản có tên " + "<h1>display_name</h1>" + "\n"
//            + "\n"
//            + "Ðây là mà code để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
//            + "\n"
//            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
//            + "\n"
//            + "\n"
//            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
//            + "</div>";
//   boolean status = emails.sendMail("kien0965824602@gmail.com", "Code Active", message_register);
//        System.out.println(status);
//    }
}

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
//            + "B???n ho???c ai ???? ???? s??? d???ng email ????? t???o t??i kho???n c?? t??n " + "<h1>display_name</h1>" + "\n"
//            + "\n"
//            + "????y l?? m?? code ????? k??ch ho???t t??i kho???n : <h1 style=\"color: red;\">otp_code</h1>\n"
//            + "\n"
//            + " <p style=\"font-style: italic;\"> L??u ??: M?? code n??y ch??? c?? th??? s??? d???ng  trong v??ng 2 ph??t k??? t??? th???i gian  g???i . Sau th???i gian tr??n h??y s??? d???ng ch???c n??ng qu??n m???t kh???u ????? ti???n h??nh t???o m???i m???t kh???u v?? k??ch ho???t t??i kho???n. </p>\n"
//            + "\n"
//            + "\n"
//            + "<p style=\"font-weight: 800;\">Tr??n tr???ng c???m ??n!!</p>"
//            + "</div>";
//   boolean status = emails.sendMail("kien0965824602@gmail.com", "Code Active", message_register);
//        System.out.println(status);
//    }
}

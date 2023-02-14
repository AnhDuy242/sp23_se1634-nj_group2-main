/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Email;

/**
 *
 * @author asus
 */
public class OTPRequestDBContext extends DBContext {

    String message_register = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;;\">"
            + "Bạn hoặc ai đó đã sử dụng email để kích hoạt tài khoản khi đăng ký có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
    String message_login
            = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email để kích hoạt tài khoản khi đăng nhập  có tên  " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
    String message_payment
            = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email để giao dịch chuyển khoản thông qua tài khoản có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
    String message_forgotPassword
            = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email khi quên mật khẩu với tài khoản có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";
//    String message_ChangePassword = 
//             " <div style=\"text-align: center;\n"
//            + "       background-color: #d3d3d3;\n"
//            + "       padding: 10px;    font-size: 20px;\">"
//            +"Bạn hoặc ai đó đã sử dụng email để thay đổi mật khẩu  với tài khoản có tên " + "<h1>display_name</h1>" + "\n"
//            + "\n"
//            + "Ðây là  code để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
//            + "\n"
//            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
//            + "\n"
//            + "\n"
//            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
//             + "</div>";

    public String createNewOTP_For_User(int user_id, int type_otp, int isVerify) {
        Email emails = new Email();
        String message = null;

         if (type_otp == 1) {
            message = "Login";
        }
        if (type_otp == 2) {
            message = "Register";
        }
        if (type_otp == 3) {
            message = "ForgotPassword";
        }
        if (type_otp == 4) {
            message = "Payment";
        }
        String code = emails.randomCode();
        String sql_user
                = "INSERT INTO [dbo].[OTPRequest]\n"
                + "           ([user_id]\n"
                + "           ,[code]\n"
                + "           ,[type_name]\n"
                + "           ,[expired_time]\n"
                + "           ,[isVerify])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GetDate()\n"
                + "           ,?)";

        try {

            PreparedStatement st = connection.prepareCall(sql_user);
            st.setInt(1, user_id);
            st.setString(2, code);
            st.setString(3, message);
            st.setInt(4, isVerify);
            st.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    public void createNewSentEmail_For_User(int user_id, int isSent, int type, String code) {
  String message = null;

        if (type == 1) {
            message = "Login";
        }
        if (type == 2) {
            message = "Register";
        }
        if (type == 3) {
            message = "ForgotPassword";
        }
        if (type == 4) {
            message = "Payment";
        }
        String sql_user
                = "INSERT INTO [dbo].[EmailRequest]\n"
                + "           ([user_id]\n"
                + "           ,[content]\n"
                + "           ,[isSend])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        String content = message + "- Code : " + code;
        try {

            PreparedStatement st = connection.prepareCall(sql_user);
            st.setInt(1, user_id);
            st.setString(2, content);
            st.setInt(3, isSent);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User findUserByEmail(String email) {
        String sql = "	SELECT [user_id]\n"
                + "      ,[display_name]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User] where email = ?";
        User us = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                us.setUser_id(rs.getInt("user_id"));
                us.setDisplay_name(rs.getString("display_name"));
                us.setEmail(rs.getString("email"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return us;
    }

//    public String findOTP_By_Type(int type) {
//        String type_content = null;
//        String sql = "select  [type_id],[type_name] from OTPType where type_id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, type);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                type_content = rs.getString("type_name");
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return type_content;
//    }

    public String messageType(int type, String code, String name) {
        String message = "";
//        switch (type) {
//            case 1:
//                message = message_login;
//            case 2:
//                message = message_register;
//            case 3:
//                message = message_forgotPassword;
////            case 4:
////                message = message_payment;
//
//        }
        if (type == 1) {
            message = message_login;
        }
        if (type == 2) {
            message = message_register;
        }
        if (type == 3) {
            message = message_forgotPassword;
        }
        if (type == 4) {
            message = message_payment;
        }
        String replaceName = message.replace("display_name", name);
        String replacedCode = replaceName.replace("otp_code", code);

        return replacedCode;
    }

    public static void main(String[] args) {
//        OTPRequestDBContext ot = new OTPRequestDBContext();
//        Date date = new Date();
//        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy - HH-mm-ss");
//        SimpleDateFormat ds = new SimpleDateFormat("ss");
//
//        System.out.println(d.format(date));
//        System.out.println(ds.format(date));
//        System.out.println(ot.messageType(1, "aa", "bbb"));
    }
}

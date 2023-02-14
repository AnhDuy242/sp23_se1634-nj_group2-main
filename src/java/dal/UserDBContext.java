/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.OTPRequest;
import model.User;
import utils.MD5;

/**
 *
 * @author asus
 */
public class UserDBContext extends DBContext {

    public List<User> getAllUserInformation() {
        List<User> list = new ArrayList<User>();
        String sql = "SELECT [user_id]\n"
                + "      ,[display_name]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[gender]\n"
                + "      ,[image]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User us = new User();
                us.setUser_id(rs.getInt("user_id"));
                us.setDisplay_name(rs.getString("display_name"));
                us.setEmail(rs.getString("email"));
                us.setAdr(rs.getString("address"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setGender(rs.getInt("gender"));
                us.setImg(rs.getString("image"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
                list.add(us);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public User findUserByEmail(String email) {
        String sql = "SELECT [user_id]\n"
                + "      ,[display_name]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[gender]\n"
                + "      ,[image]\n"
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
                us.setAdr(rs.getString("address"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setGender(rs.getInt("gender"));
                us.setImg(rs.getString("image"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return us;
    }

    public User findUserByID(int id) {
        String sql = "SELECT [user_id]\n"
                + "      ,[display_name]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "      ,[gender]\n"
                + "      ,[image]\n"
                + "      ,[isActive]\n"
                + "      ,[isAdmin]\n"
                + "  FROM [dbo].[User] where [user_id] = ?";
        User us = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                us.setUser_id(rs.getInt("user_id"));
                us.setDisplay_name(rs.getString("display_name"));
                us.setEmail(rs.getString("email"));
                us.setAdr(rs.getString("address"));
                us.setPhone_number(rs.getString("phone_number"));
                us.setGender(rs.getInt("gender"));
                us.setImg(rs.getString("image"));
                us.setIsActive(rs.getBoolean("isActive"));
                us.setIsAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return us;
    }

    public void registerNewUser(User us) {
        MD5 md5 = new MD5();
        String sql_user
                = "INSERT INTO [dbo].[User]\n"
                + "           ([display_name]\n"
                + "           ,[email]\n"
                + "           ,[address]\n"
                + "           ,[phone_number]\n"
                + "           ,[gender]\n"
                + "           ,[image]\n"
                + "           ,[isActive]\n"
                + "           ,[isAdmin])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st1 = connection.prepareCall(sql_user);
            st1.setString(2, us.getEmail());
            st1.setString(1, us.getDisplay_name());
            st1.setString(3, us.getAdr());
            st1.setString(4, us.getPhone_number());
            st1.setInt(5, us.getGender());
            st1.setString(6, us.getImg());
            st1.setInt(7, 0);
            st1.setInt(8, 0);

            st1.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void registerNewAccount(User us) {
        MD5 md5 = new MD5();
        String sql_account
                = "INSERT INTO Account(username, [password])\n"
                + "VALUES  (?,?)";

        try {
            PreparedStatement st = connection.prepareCall(sql_account);
            st.setString(1, us.getEmail());
            st.setString(2, md5.encodeMD5(us.getPassword()));
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int registerNewUserAndAccount(User uss) {
        UserDBContext ud = new UserDBContext();
        int status;
        if (ud.findUserByEmail(uss.getEmail()).getUser_id() == 0) {
            //Ko ton tai email , register dc
            ud.registerNewAccount(uss);
            ud.registerNewUser(uss);
            String sql = "SELECT [user_id]\n"
                    + "      ,[display_name]\n"
                    + "      ,[email]\n"
                    + "      ,[address]\n"
                    + "      ,[phone_number]\n"
                    + "      ,[gender]\n"
                    + "      ,[image]\n"
                    + "      ,[isActive]\n"
                    + "      ,[isAdmin]\n"
                    + "  FROM [dbo].[User] where email = ?";
            User us = new User();
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, uss.getEmail());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    us.setUser_id(rs.getInt("user_id"));
                    us.setDisplay_name(rs.getString("display_name"));
                    us.setEmail(rs.getString("email"));
                    us.setAdr(rs.getString("address"));
                    us.setPhone_number(rs.getString("phone_number"));
                    us.setGender(rs.getInt("gender"));
                    us.setImg(rs.getString("image"));
                    us.setIsActive(rs.getBoolean("isActive"));
                    us.setIsAdmin(rs.getBoolean("isAdmin"));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
//            User us = findUserByEmail(uss.getEmail());
            status = us.getUser_id();
        } else {
            //ton tai roi ko register
            status = -1;
        }
        return status;
    }

    public OTPRequest getCodeNotActive(String code, int user_id) {
        String sql_account
                = "SELECT [otp_id]\n"
                + "      ,[user_id]\n"
                + "      ,[code]\n"
                + "      ,[type_name]\n"
                + "      ,[expired_time]\n"
                + "      ,[isVerify]\n"
                + "  FROM [dbo].[OTPRequest] where [code] = ? and isVerify = 0 and [user_id] = ?";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setString(1, code);
            st.setInt(2, user_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                co.setOtp_id(rs.getInt("otp_id"));
                co.setUser_id(rs.getInt("user_id"));
                co.setCode(rs.getString("code"));
                co.setType_name(rs.getString("type_name"));
                co.setExp_time(rs.getTimestamp("expired_time"));
                co.setIsVerify(rs.getBoolean("isVerify"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return co;
    }

    public OTPRequest checkCodeActive(String code, int user_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "SELECT [otp_id]\n"
                + "      ,[user_id]\n"
                + "      ,[code]\n"
                + "      ,[type_name]\n"
                + "      ,[expired_time]\n"
                + "      ,[isVerify]\n"
                + "  FROM [dbo].[OTPRequest] where [otp_id] = ? and isVerify = 0 and [user_id] = ?";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, getCodeNotActive(code, user_id).getOtp_id());
            st.setInt(2, user_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                co.setOtp_id(rs.getInt("otp_id"));
                co.setUser_id(rs.getInt("user_id"));
                co.setCode(rs.getString("code"));
                co.setType_name(rs.getString("type_name"));
                co.setExp_time(rs.getTimestamp("expired_time"));
                co.setIsVerify(rs.getBoolean("isVerify"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (co.getCode().toLowerCase().equals(code.toLowerCase())) {
            return co;
        } else {
            return null;
        }
    }

    public String getTimeCodeCreate(int user_id, int otp_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "SELECT [otp_id]\n"
                + "      ,[user_id]\n"
                + "      ,[code]\n"
                + "      ,[type_name]\n"
                + "      ,[expired_time]\n"
                + "      ,[isVerify]\n"
                + "  FROM [dbo].[OTPRequest] where [user_id] = ? and isVerify = 0 and [otp_id] = ?";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, user_id);
            st.setInt(2, otp_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                co.setOtp_id(rs.getInt("otp_id"));
                co.setUser_id(rs.getInt("user_id"));
                co.setCode(rs.getString("code"));
                co.setType_name(rs.getString("type_name"));
                co.setExp_time(rs.getTimestamp("expired_time"));
                co.setIsVerify(rs.getBoolean("isVerify"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String time = d.format(co.getExp_time());
        return time;
    }

    public void VerifyCodeActive(int otp_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "UPDATE [dbo].[OTPRequest]\n"
                + "   SET [isVerify] = ?\n"
                + " WHERE [otp_id] = ?";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, 1);
            st.setInt(2, otp_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void ActiveUser(int user_id) {
        MD5 md5 = new MD5();
        String sql_account
                = "UPDATE [dbo].[User]\n"
                + "   SET [isActive] = ?\n"
                + " WHERE [user_id] = ?";
        OTPRequest co = new OTPRequest();
        try {
            PreparedStatement st = connection.prepareStatement(sql_account);
            st.setInt(1, 1);
            st.setInt(2, user_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public boolean checkTimeCode(Date dateCode) {
        Date dateNow = new Date();
        long result = dateNow.getTime() - dateCode.getTime();
        int second = (int) (result / 1000);
        if (second > 120) {
            return false;
        } else {
            return true;
        }
    }

//    public static void main(String[] args) {
//        UserDao us = new UserDao();
////        List<User> list = us.getAllUserInformation();
////        for (User user : list) {
////            System.out.println(user.getDisplay_name() + "/" + user.isIsActive() + " / " + user.isIsAdmin());
////        }
////
////        User us1 = new User("ntkien651@gmail.com", "Nguyen Trung Kien", "0965824602", "kien14112002", true, false, "Hn");
//////        us.registerNewAccount(us1);
//////        us.registerNewUser(us1);
////
////        System.out.println(us.findUserByEmail("kien0965824602@gmail.com").getUser_id());
////        System.out.println(us.findUserByID(11).getUser_id());
//
////        ActiveUser
////                VerifyCodeActive
//        Date dateNow = new Date();
////        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy - HH-mm-ss");
////        SimpleDateFormat ds1 = new SimpleDateFormat("ss");
////        SimpleDateFormat ds = new SimpleDateFormat("HH-mm");
////        
////        System.out.println(d.format(VerifyCode.getExp_time()));
////         System.out.println(d.format(dateNow));
//
////         System.out.println(VerifyCode.getExp_time().getTime());
////         System.out.println(dateNow.getTime());
////        
////         System.out.println(result);
////         System.out.println(d.format(VerifyCode.getExp_time()));
////         System.out.println(d.format(dateNow));
////        if (VerifyCode != null) { // nhap ma code dung
////            //verify code
////            us.VerifyCodeActive(VerifyCode.getOtp_id());
////            // active user   
////            us.ActiveUser(VerifyCode.getUser_id());
////            System.out.println("11");
////        } else { // nhap ma code sai 
////            System.out.println("22");
////        }
//    }
}

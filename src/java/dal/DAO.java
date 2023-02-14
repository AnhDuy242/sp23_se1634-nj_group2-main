/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.security.NoSuchAlgorithmException;
import model.Account;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import utils.MD5;


/**
 *
 * @author ngoan
 */
public class DAO extends DBContext {

    public DAO() {
    }

    PreparedStatement ps;
    ResultSet rs;

    public void Update(Account ac) throws NoSuchAlgorithmException {
        MD5 md = new MD5();
        String sql = "UPDATE Account "
                + "SET password = '" + md.encodeMD5(ac.getPassword()) + "' "
                + "WHERE username= '" + ac.getUsername() + "'";

        try {
            ps = connection.prepareStatement(sql);
            ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public User getAll(String email) {
        User us = new User();

        String sql = "select u.[user_id], u.display_name, u.email, u.[address], u.phone_number from [User] u join Account a on u.email=a.username\n"
                + "where a.username = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                us = new User( rs.getInt("user_id"),rs.getString("email"),rs.getString("display_name"), rs.getString("phone_number"),rs.getString("password"), rs.getString("address"));

            }
        } catch (Exception e) {

        }
        return us;
    }

    public boolean update(User u) {
        try {

            String sql1 = "UPDATE [User]\n"
                    + "SET display_name = ?,[address] = ?, phone_number = ?\n"
                    + "WHERE email = ?";
            ps = connection.prepareStatement(sql1);
            ps.setString(1, u.getDisplay_name());
            ps.setString(2, u.getAdr());
            ps.setString(3, u.getPhone_number());
            ps.setString(4, u.getEmail());
            ps.execute();
            //
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }
    
    public boolean update2(User u) {
        try {

           String sql2 = "UPDATE [Debtor]\n"
                    + "SET debtor_name = ?,[address] = ?, phone_number = ?\n"
                    + "WHERE email = ?";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, u.getDisplay_name());
            ps.setString(2, u.getAdr());
            ps.setString(3, u.getPhone_number());
            ps.setString(4, u.getEmail());
            ps.execute();
            //
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        User a = d.getAll("bahoann@gmail.com");
        System.out.println(a.getEmail());
    }

}

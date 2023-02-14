/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class User {
    private int user_id;
   private String email;
   private String display_name;
   private String phone_number;
    private String password;
   private boolean isActive;
   private boolean  isAdmin;
   private String adr;
   private String img;
   private int gender;

    public User(int userID, String email, String name, String phoneNumber, String password, String address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getImg() {
        return img;
    }

    public int getGender() {
        return gender;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public User(String email, String display_name, String phone_number, String password, boolean isActive, boolean isAdmin, String adr, String img, int gender) {
        this.email = email;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.password = password;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.adr = adr;
        this.img = img;
        this.gender = gender;
    }
   
   

    public User(String email, String display_name, String phone_number, String password, boolean isActive, boolean isAdmin, String adr) {
        this.email = email;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.password = password;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.adr = adr;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }
   
    public User() {
    }

    public User(int user_id, String email, String display_name, String phone_number, boolean isActive, boolean isAdmin) {
        this.user_id = user_id;
        this.email = email;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }

    public User(int user_id, String email, String display_name, String phone_number, String password, boolean isActive, boolean isAdmin) {
        this.user_id = user_id;
        this.email = email;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.password = password;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }
    public User(String email, String display_name, String phone_number, String password, boolean isActive, boolean isAdmin) {
        this.email = email;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.password = password;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
    public String getEmail() {
        return email;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
   
}

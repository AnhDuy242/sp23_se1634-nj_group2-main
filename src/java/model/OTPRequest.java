/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author asus
 */
public class OTPRequest {
     private int otp_id;
    private int user_id;
    private String code;
    private String type_name;
    private Date exp_time;
    private boolean isVerify;

    public void setOtp_id(int otp_id) {
        this.otp_id = otp_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCode(String code) {
        this.code = code;
    }

   
    public void setExp_time(Date exp_time) {
        this.exp_time = exp_time;
    }

    public void setIsVerify(boolean isVerify) {
        this.isVerify = isVerify;
    }

    public OTPRequest() {
    }

    public OTPRequest(int otp_id, int user_id, String code, String type_name, Date exp_time, boolean isVerify) {
        this.otp_id = otp_id;
        this.user_id = user_id;
        this.code = code;
        this.type_name = type_name;
        this.exp_time = exp_time;
        this.isVerify = isVerify;
    }

    public int getOtp_id() {
        return otp_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getCode() {
        return code;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

  

    public Date getExp_time() {
        return exp_time;
    }

    public boolean isIsVerify() {
        return isVerify;
    }
    
}

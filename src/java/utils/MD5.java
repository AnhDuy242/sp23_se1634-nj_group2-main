/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author asus
 */
public class MD5 {
    public String encodeMD5(String code) throws NoSuchAlgorithmException{
        //Set sang mã hóa MD5
        MessageDigest m = MessageDigest.getInstance("MD5"); 
        //Đặt lại thông báo để sử dụng tiếp.
        m.reset();
        // update : Cập nhật thông báo bằng cách sử dụng mảng byte đã chỉ định.
        // getByte : mã hóa chuỗi thành chuỗi byte và giữ nó trong một mảng byte.
        m.update(code.getBytes());
        //digest : Completes the hash computation by performing final operations such as padding.
        byte[] digest = m.digest(); 
        System.out.println("");
        for (int i = 0; i < digest.length; i++) {
                     System.out.print(digest[i] + " ");
        }
        //Khoi tao bi biginteger v?i 
        BigInteger bigInt = new BigInteger(1, digest);
        // chuyen bigint sang string 
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    
}

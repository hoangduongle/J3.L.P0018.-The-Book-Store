/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class UserDTO implements Serializable{
    int UserID;
    String UserName;
    String PassWord;
    int RoleID;

    public UserDTO() {
    }

    public UserDTO(int UserID, String UserName, String PassWord, int RoleID) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.RoleID = RoleID;
    }

    

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    
    
}

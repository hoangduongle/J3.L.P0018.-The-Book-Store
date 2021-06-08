/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UserDTO checkLogin(String username, String password) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select UserID,UserName,RoleID\n"
                        + "from tblUsers\n"
                        + "where UserName = ? and PassWord = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    UserDTO u = new UserDTO(rs.getInt("UserID"), rs.getString("UserName"), "****", rs.getInt("RoleID"));
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        try {
            System.out.println();
            dao.checkLogin("admin", "1");
        } catch (Exception e) {
        }
    }

}

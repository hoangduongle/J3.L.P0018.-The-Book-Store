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
public class OrderDTO implements Serializable{
    int OrderID;
    String DateOrder;
    float total;
    int UserID;

    public OrderDTO() {
    }

    public OrderDTO(int OrderID, String DateOrder, float total, int UserID) {
        this.OrderID = OrderID;
        this.DateOrder = DateOrder;
        this.total = total;
        this.UserID = UserID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(String DateOrder) {
        this.DateOrder = DateOrder;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    
    
}

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
public class DetailDTO implements Serializable{
    int DetailID;
    float Price;
    int quantity;
    int OrderID;
    BookDTO book;

    public DetailDTO() {
    }

    public DetailDTO(int DetailID, float Price, int quantity, int OrderID, BookDTO book) {
        this.DetailID = DetailID;
        this.Price = Price;
        this.quantity = quantity;
        this.OrderID = OrderID;
        this.book = book;
    }

    public int getDetailID() {
        return DetailID;
    }

    public void setDetailID(int DetailID) {
        this.DetailID = DetailID;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

   
}

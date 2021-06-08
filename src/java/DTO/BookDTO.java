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
public class BookDTO implements Serializable{
    int BookID;
    String BookName;
    String image;
    float price;
    int quantity;
    String author;
    String CurrentDate;
    boolean Status;
    int CategoryID;

    public BookDTO() {
    }

    public BookDTO(int BookID, String BookName, String image, float price, int quantity, String author, String CurrentDate, boolean Status, int CategoryID) {
        this.BookID = BookID;
        this.BookName = BookName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
        this.CurrentDate = CurrentDate;
        this.Status = Status;
        this.CategoryID = CategoryID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String CurrentDate) {
        this.CurrentDate = CurrentDate;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "BookID=" + BookID + ", BookName=" + BookName + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", author=" + author + ", CurrentDate=" + CurrentDate + ", Status=" + Status + ", CategoryID=" + CategoryID + '}';
    }

    
    
    
    
}

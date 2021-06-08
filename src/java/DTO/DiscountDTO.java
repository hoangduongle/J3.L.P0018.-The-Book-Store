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
public class DiscountDTO implements Serializable{
    int DiscountID;
    String DName;
    int DPercent;
    String CodeName;
    String Begindate;
    String Enddate;

    public DiscountDTO() {
    }

    public DiscountDTO(int DiscountID, String DName, int DPercent, String CodeName, String Begindate, String Enddate) {
        this.DiscountID = DiscountID;
        this.DName = DName;
        this.DPercent = DPercent;
        this.CodeName = CodeName;
        this.Begindate = Begindate;
        this.Enddate = Enddate;
    }

    public int getDiscountID() {
        return DiscountID;
    }

    public void setDiscountID(int DiscountID) {
        this.DiscountID = DiscountID;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public int getDPercent() {
        return DPercent;
    }

    public void setDPercent(int DPercent) {
        this.DPercent = DPercent;
    }

    public String getCodeName() {
        return CodeName;
    }

    public void setCodeName(String CodeName) {
        this.CodeName = CodeName;
    }

    public String getBegindate() {
        return Begindate;
    }

    public void setBegindate(String Begindate) {
        this.Begindate = Begindate;
    }

    public String getEnddate() {
        return Enddate;
    }

    public void setEnddate(String Enddate) {
        this.Enddate = Enddate;
    }

    @Override
    public String toString() {
        return "DiscountDTO{" + "DiscountID=" + DiscountID + ", DName=" + DName + ", DPercent=" + DPercent + ", CodeName=" + CodeName + ", Begindate=" + Begindate + ", Enddate=" + Enddate + '}';
    }
    
    
}

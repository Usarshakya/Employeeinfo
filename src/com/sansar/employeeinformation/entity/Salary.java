/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation.entity;

import java.sql.Date;

/**
 *
 * @author Rasna
 */
public class Salary {
    private int id;
    private String amount;
    private Date addedDate;

    public Salary() {
    }

    public Salary(int id, String amount, Date addedDate) {
        this.id = id;
        this.amount = amount;
        this.addedDate = addedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "Salary{" + "id=" + id + ", amount=" + amount + ", addedDate=" + addedDate + '}';
    }
    
    
    
}

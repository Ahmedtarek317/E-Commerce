package com.example.e_commerce.Model;

public class CreditCard implements Payment{

    private String number, expireDateMonth, expireDateYear ,status;
    private double amount = 1000;
    public CreditCard() {

    }

    public CreditCard(String number, String expireDateMonth, String expireDateYear, String status) {
        this.number = number;
        this.expireDateMonth = expireDateMonth;
        this.expireDateYear = expireDateYear;
        this.status = status;
    }
    public CreditCard(String number, String expireDateMonth, String expireDateYear) {
        this.number = number;
        this.expireDateMonth = expireDateMonth;
        this.expireDateYear = expireDateYear;
        this.status = "Waiting";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireDateMonth() {
        return expireDateMonth;
    }

    public void setExpireDateMonth(String expireDateMonth) {
        this.expireDateMonth = expireDateMonth;
    }

    public String getExpireDateYear() {
        return expireDateYear;
    }

    public void setExpireDateYear(String expireDateYear) {
        this.expireDateYear = expireDateYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public boolean withdraw(double amount) {
        return true;
    }

}

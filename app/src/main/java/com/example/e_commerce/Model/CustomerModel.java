package com.example.e_commerce.Model;

import java.util.Date;

public class CustomerModel implements Cloneable {

    private int id;
    private String username,email,password,birthdate;

    public CustomerModel(int id, String username, String email, String password, String birthdate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate=birthdate;
    }
    private static CustomerModel user = null;

    public CustomerModel() {}

    public static CustomerModel getInstance(){
        if(user == null)
            user = new CustomerModel();
        return user;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public CustomerModel clone() {
        try {
            return (CustomerModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

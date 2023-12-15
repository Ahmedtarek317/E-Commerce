package com.example.e_commerce.Model;

import android.content.Context;


import com.example.e_commerce.Database.MyDatabase;

public class ProductModel {
    private MyDatabase db;
    private int pro_id;
    private int pro_quantity;
    private int catId;
    private int quantitySelected;
    private String proName;
    private byte[] proImage;
    private double price;

    public ProductModel(ProductModelBuilder builder) {
        this.db = builder.db;
        this.pro_id = builder.pro_id;
        this.pro_quantity = builder.pro_quantity;
        this.catId = builder.catId;
        this.quantitySelected = builder.quantitySelected;
        this.proName = builder.proName;
        this.proImage = builder.proImage;
        this.price = builder.price;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public byte[] getProImage() {
        return proImage;
    }

    public void setProImage(byte[] proImage) {
        this.proImage = proImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getSelectedQuantity(String prodName) {
        int i=db.getProductSelected(prodName);
        return i;
    }

    public void setQuantitySelected(int quantitySelected) {
        this.quantitySelected = quantitySelected;
    }
}

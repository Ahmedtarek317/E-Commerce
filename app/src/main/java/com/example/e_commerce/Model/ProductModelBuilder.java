package com.example.e_commerce.Model;

import android.content.Context;

import com.example.e_commerce.Database.MyDatabase;

public class ProductModelBuilder {
    public MyDatabase db;
    public int pro_id;
    public int pro_quantity;
    public int catId;
    public int quantitySelected;
    public String proName;
    public byte[] proImage;
    public double price;

    public ProductModelBuilder(Context context) {
        this.db = MyDatabase.getInstance(context);
    }

    public ProductModelBuilder setPro_id(int pro_id) {
        this.pro_id = pro_id;
        return this;
    }

    public ProductModelBuilder setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
        return this;
    }

    public ProductModelBuilder setCatId(int catId) {
        this.catId = catId;
        return this;
    }

    public ProductModelBuilder setQuantitySelected(int quantitySelected) {
        this.quantitySelected = quantitySelected;
        return this;
    }

    public ProductModelBuilder setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public ProductModelBuilder setProImage(byte[] proImage) {
        this.proImage = proImage;
        return this;
    }

    public ProductModelBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductModel build() {
        return new ProductModel(this);
    }


}



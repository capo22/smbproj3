package com.example.jarek.smbproj3;

public class Product {
    private String productName;
    private float price;
    private int quantity;
    private boolean is_checked;

    public Product(String productName, float price, int quantity, boolean is_checked) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.is_checked = is_checked;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isIs_checked() {
        return is_checked;
    }
}

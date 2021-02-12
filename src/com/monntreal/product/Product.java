package com.monntreal.product;

public class Product  {
    private String productId;
    private double currentPrice;
    //private int quantity;

    public Product(String id, double currentPrice) {
        this.productId = id;
        this.currentPrice = currentPrice;

    }

    public String getId() {
        return productId;
    }

    public void setId(String id) {
        productId = id;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}

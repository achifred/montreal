package com.monntreal.product;

import com.monntreal.interfaces.ProductPricingService;

import java.util.Objects;

public abstract class Product  {
    private String productId;
    private double currentPrice;

    public Product(String id) {
        this.productId = id;



    }

    public abstract Double price();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}

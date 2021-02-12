package com.monntreal.interfaces;

import com.monntreal.Exceptions.ProductAlreadyRegisteredException;
import com.monntreal.product.Product;

public interface MontrealTradedProducts {


    void addNewProduct(Product product) throws ProductAlreadyRegisteredException;


    void trade(Product product, int quantity);


    int totalTradeQuantityForDay();


    double totalValueOfDaysTradedProducts();
}

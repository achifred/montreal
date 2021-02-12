package com.monntreal.trade;

import com.monntreal.Exceptions.ProductAlreadyRegisteredException;
import com.monntreal.interfaces.MontrealTradedProducts;
import com.monntreal.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MontrealTrade implements MontrealTradedProducts {
    List<Product> productList = new ArrayList<>();
    Map<Product,Integer>productQuantityTraded = new HashMap<>();
    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if (productList.contains(product)){
            throw new ProductAlreadyRegisteredException();
        }
        productList.add(product);
    }

    @Override
    public void trade(Product product, int quantity) {
        productQuantityTraded.put(product,quantity);

    }

    @Override
    public int totalTradeQuantityForDay() {

         return productQuantityTraded.values().stream().reduce(0,Integer::sum);

    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = 0;
        for (Product key: productQuantityTraded.keySet())
            totalValue += productQuantityTraded.get(key)*key.getCurrentPrice();
        return totalValue;
    }
}

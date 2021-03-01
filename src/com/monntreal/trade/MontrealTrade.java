package com.monntreal.trade;

import com.monntreal.Exceptions.ProductAlreadyRegisteredException;
import com.monntreal.interfaces.MontrealTradedProducts;
import com.monntreal.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        if(!productList.contains(product))
            productQuantityTraded.put(product,0);
        int newQuantity = productQuantityTraded.get(product)!=null?productQuantityTraded.get(product)+quantity:quantity;
        productQuantityTraded.put(product,newQuantity);

    }

    @Override
    public int totalTradeQuantityForDay() {

         return productQuantityTraded.values().stream().reduce(0,Integer::sum);

    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = 0;
        for (Product product: productQuantityTraded.keySet())
            totalValue += productQuantityTraded.get(product)*product.price();
        return totalValue;
    }

    public int getLengthOfProductList(){
        return productList.size();
    }
}

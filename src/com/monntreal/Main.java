package com.monntreal;

import com.monntreal.Exceptions.ProductAlreadyRegisteredException;
import com.monntreal.product.Product;
import com.monntreal.product.Stock;
import com.monntreal.trade.MontrealTrade;

public class Main {
    public static void main(String[] args) {
        MontrealTrade montrealTrade = new MontrealTrade();
        Product stock = new Stock("prod1","LON","APPL");
        try {
            montrealTrade.addNewProduct(stock);
        }catch (ProductAlreadyRegisteredException e){
            System.out.println(e.getMessage());
        }


    }
}

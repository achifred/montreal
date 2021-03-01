package com.monntreal.product;

import com.monntreal.interfaces.ProductPricingService;

public class Futures extends Product {
    private String exchange;
    private String contractCode;
    private int contractMonth;
    private int contractYear;
    ProductPricingService productPricingService;

    public Futures(String productId, String exchange, String contractCode, int contractMonth, int contractYear) {
        super(productId);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.contractMonth = contractMonth;
        this.contractYear = contractYear;
    }

    public  Double price(){
       return productPricingService.price(exchange,contractCode,contractMonth,contractYear);
    }


}

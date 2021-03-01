package com.monntreal.product;

import com.monntreal.interfaces.ProductPricingService;

public class Stock extends Product  {
    private String stockTicker;
    private String exchange;
    ProductPricingService productPricingService;
    public Stock(String productId,   String stockTicker,String exchange) {
        super(productId);
        this.stockTicker = stockTicker;
        this.exchange = exchange;
    }
    public Double price(){
       return productPricingService.price(stockTicker,exchange);
    }


}

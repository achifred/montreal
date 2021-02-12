package com.monntreal.product;

import com.monntreal.interfaces.ProductPricingService;

public class Stock extends Product implements ProductPricingService {
    private String stockTicker;
    private String exchange;
    public Stock(String productId, double currentPrice,  String stockTicker,String exchange) {
        super(productId, currentPrice);
        this.stockTicker = stockTicker;
        this.exchange = exchange;
    }

    @Override
    public double price(String exchange, String ticker) {
        return this.getCurrentPrice();
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        return 0;
    }
}

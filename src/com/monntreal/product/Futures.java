package com.monntreal.product;

import com.monntreal.interfaces.ProductPricingService;

public class Futures extends Product implements ProductPricingService {
    private String exchange;
    private String contractCode;
    private int contractMonth;
    private int contractYear;

    public Futures(String productId, double currentPrice, String exchange, String contractCode, int contractMonth, int contractYear) {
        super(productId, currentPrice);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.contractMonth = contractMonth;
        this.contractYear = contractYear;
    }

    @Override
    public double price(String exchange, String ticker) {
        return 0;
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        return this.getCurrentPrice();
    }
}

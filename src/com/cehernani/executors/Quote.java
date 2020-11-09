package com.cehernani.executors;


public class Quote {

    private final String site;
    private final double price;

    public Quote(String site, double price) {
        this.site = site;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Quote{site='%s', price=%.2f}", site, price);
    }

}

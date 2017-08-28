package com.example;

import java.io.Serializable;
import java.text.NumberFormat;

public class Stock implements Serializable {

    private static final long serialVersionUID = 100L;
    private String symbol;
    private int shares;
    private double purchasePrice;
    private double currPrice;

    public Stock(String symbol, int shares, double purchasePrice, double currPrice) {
        this.symbol = symbol;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
        this.currPrice = currPrice;
         
    }
 

    public double getValue() {
        return shares * currPrice;
    }
 

    @Override
    public String toString() {
        double value = getValue();
        return "Stock:  " + symbol + "\n"
                + "Shares: " + shares + " @ " + NumberFormat.getCurrencyInstance().format(purchasePrice) + "\n"
                + "Curr $: " + NumberFormat.getCurrencyInstance().format(currPrice) + "\n"
                + "Value:  " + NumberFormat.getCurrencyInstance().format(value) + "\n";
    }
}

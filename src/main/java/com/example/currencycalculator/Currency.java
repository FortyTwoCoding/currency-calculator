package com.example.currencycalculator;

public class Currency {

    private String name;
    private double currency;


    public Currency(String name, double currency) {
        this.name = name;
        this.currency = currency;

    }

    public double getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

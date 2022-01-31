package com.example.currencycalculator;

public class Currency {

   private String name;
   private double usd;
   private double chf;
   private double yen;
   private double rmb;

    public Currency(String name, double usd, double chf, double yen, double rmb){
        this.name = name;
        this.usd = usd;
        this.chf = chf;
        this.yen = yen;
        this.rmb = rmb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getChf() {
        return chf;
    }

    public void setChf(double chf) {
        this.chf = chf;
    }

    public double getYen() {
        return yen;
    }

    public void setYen(double yen) {
        this.yen = yen;
    }

    public double getRmb() {
        return rmb;
    }

    public void setRmb(double rmb) {
        this.rmb = rmb;
    }
}

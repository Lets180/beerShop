package com.lets.beerShop.models;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Bottle {
    private String typeBottle;
    private double buyPrice;
    private double sellPrice;
    private int remainingQuantity;

    public Bottle(String typeBottle, double buyPrice, double sellPrice, int remainingQuantity) {
        this.typeBottle = typeBottle;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.remainingQuantity = remainingQuantity;
    }

    public String getTypeBottle() {
        return typeBottle;
    }

    public void setTypeBottle(String typeBottle) {
        this.typeBottle = typeBottle;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
}

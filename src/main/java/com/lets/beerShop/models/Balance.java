package com.lets.beerShop.models;

import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class Balance {
    private double currentBalance;
    private double volumeDebts;
    private double drinkMoney;
    private double overheads;

    public Balance(double currentBalance, double volumeDebts, double drinkMoney, double overheads) {
        this.currentBalance = currentBalance;
        this.volumeDebts = volumeDebts;
        this.drinkMoney = drinkMoney;
        this.overheads = overheads;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getVolumeDebts() {
        return volumeDebts;
    }

    public void setVolumeDebts(double volumeDebts) {
        this.volumeDebts = volumeDebts;
    }

    public double getDrinkMoney() {
        return drinkMoney;
    }

    public void setDrinkMoney(double drinkMoney) {
        this.drinkMoney = drinkMoney;
    }

    public double getOverheads() {
        return overheads;
    }

    public void setOverheads(double overheads) {
        this.overheads = overheads;
    }
}

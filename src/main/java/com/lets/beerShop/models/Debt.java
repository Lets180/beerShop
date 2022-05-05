package com.lets.beerShop.models;

import org.springframework.context.annotation.Scope;

import java.util.Date;

@Scope("prototype")
public class Debt {
    private int id;
    private String debtorName;
    private Date debtDate;
    private String beerBrand;
    private double amountBeer;
    private double debtAmount;

    public Debt(int id, String debtorName, Date debtDate,
                String beerBrand, double amountBeer, double debtAmount) {
        this.id = id;
        this.debtorName = debtorName;
        this.debtDate = debtDate;
        this.beerBrand = beerBrand;
        this.amountBeer = amountBeer;
        this.debtAmount = debtAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public Date getDebtDate() {
        return debtDate;
    }

    public void setDebtDate(Date debtDate) {
        this.debtDate = debtDate;
    }

    public String getBeerBrand() {
        return beerBrand;
    }

    public void setBeerBrand(String beerBrand) {
        this.beerBrand = beerBrand;
    }

    public double getAmountBeer() {
        return amountBeer;
    }

    public void setAmountBeer(double amountBeer) {
        this.amountBeer = amountBeer;
    }

    public double getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }
}

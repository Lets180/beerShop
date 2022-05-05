package com.lets.beerShop.models;

import org.springframework.context.annotation.Scope;

import java.util.Date;

@Scope("prototype")
public class Operation {
    private int id;
    private String operationName;
    private Date operationDate;
    private String beerBrand;
    private double amountBeer;
    private double operationAmount;

    public Operation(int id, String operationName, Date operationDate,
                     String beerBrand, double amountBeer, double operationAmount) {
        this.id = id;
        this.operationName = operationName;
        this.operationDate = operationDate;
        this.beerBrand = beerBrand;
        this.amountBeer = amountBeer;
        this.operationAmount = operationAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getBeerBrand() {
        return beerBrand;
    }

    public void setBeerBrand(String beerBrand) {
        this.beerBrand = beerBrand;
    }

    public Double getAmountBeer() {
        return amountBeer;
    }

    public void setAmountBeer(Double amountBeer) {
        this.amountBeer = amountBeer;
    }

    public Double getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(Double operationAmount) {
        this.operationAmount = operationAmount;
    }
}

package com.lets.beerShop.models;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//@Scope("prototype")

@Entity
@Table(name = "beer")
@NamedQuery(name = "Beer.getAll", query = "SELECT c from Beer c")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Enter a new brand name")
    @Size(min = 2,max = 30,message = "Enter a true brand")
    @Column(name = "brand", length = 32)
    private String brand;

    @Column(name = "typeBeer", length = 32)
    private String typeBeer;

    //@Min(value = 0,message = "O.G. must above zero")
    @Column(name = "originalGravity", length = 7)
    private String originalGravity;


    //@Min(value = 0,message = "Alc. must above zero")
    @Column(name = "alcoholVolume", length = 7)
    private String alcoholVolume;

    @NotEmpty(message = "Enter buy price")
    @Min(value = 0,message = "Buy price must above zero")
    @Column(name = "buyPrice", length = 7)
    private double buyPrice;

    @Column(name = "cellPrice", length = 7)
    @NotEmpty(message = "Enter a cell price")
    @Min(value = 0,message = "Cell price must above zero")
    private double cellPrice;

    @Column(name = "currentAmount", length = 7)
    private double currentAmount;

    @Column(name = "salesVolume", length = 7)
    private double salesVolume;

    @Column(name = "revenue", length = 7)
    private double revenue;

    public Beer(int id, String brand,
                String typeBeer, String originalGravity,
                String alcoholVolume, double buyPrice,
                double cellPrice, double currentAmount,
                double salesVolume, double revenue) {
        this.id = id;
        this.brand = brand;
        this.typeBeer = typeBeer;
        this.originalGravity = originalGravity;
        this.alcoholVolume = alcoholVolume;
        this.buyPrice = buyPrice;
        this.cellPrice = cellPrice;
        this.currentAmount = currentAmount;
        this.salesVolume = salesVolume;
        this.revenue = revenue;
    }

    public Beer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypeBeer() {
        return typeBeer;
    }

    public void setTypeBeer(String typeBeer) {
        this.typeBeer = typeBeer;
    }

    public String getOriginalGravity() {
        return originalGravity;
    }

    public void setOriginalGravity(String originalGravity) {
        this.originalGravity = originalGravity;
    }

    public String getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(String alcoholVolume) {
        this.alcoholVolume = alcoholVolume;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getCellPrice() {
        return cellPrice;
    }

    public void setCellPrice(double cellPrice) {
        this.cellPrice = cellPrice;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

}

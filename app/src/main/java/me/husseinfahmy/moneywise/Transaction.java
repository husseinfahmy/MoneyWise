package me.husseinfahmy.moneywise;

import java.util.Date;

/**
 * Created by Salma on 2016-10-15.
 */

public class Transaction {

    private String name;
    private String category;
    private float cost;
    private Date date;


    public Transaction(String name, String category, String cost) {
        this.name = name;
        this.category = category;
        this.cost = Float.parseFloat(cost);
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(String costStr) {
        float costf = Float.valueOf(costStr);
        this.cost = costf;
    }
}
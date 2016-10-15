package me.husseinfahmy.moneywise;

import java.util.ArrayList;

/**
 * Created by Mohamed on 2016-10-15.
 */

public class Category {
    private String name;
    private float totalSpent;
    private int totalCount;
    private float priority;
    private float avgCost;
    private ArrayList<Transaction> transactions;

    public Category(String name) {
        this.name = name;
    }

    public Category(float totalSpent, int totalCount, float priority, float avgCost, ArrayList<Transaction> transactions) {
        this.totalSpent = totalSpent;
        this.totalCount = totalCount;
        this.priority = priority;
        this.avgCost = avgCost;
        this.transactions = transactions;
    }

    //    GETTERS AND SETTERS
    public float getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(float avgCost) {
        this.avgCost = avgCost;
    }

    public float getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(float totalSpent) {
        this.totalSpent = totalSpent;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public float getPriority() {
        return priority;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
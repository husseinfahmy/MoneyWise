package me.husseinfahmy.moneywise;

/**
 * Created by Mohamed on 2016-10-15.
 */

public class Profile {

    String name;
    float balance;
    float income;
    int totalCount;
    float totalSpent;
    float educationFees;
    final int NUM_OF_MONTHS = 12;
    final double SAVING_FACTOR = 0.85;
    float surplus;
    double budget;

    public Profile(float balance, float income, float educationFees, float surplus, String name, int totalCount, float totalSpent) {
        this.balance = balance;
        this.income = income;
        this.educationFees = educationFees;
        this.surplus = surplus;
        this.name = name;
        this.totalCount = totalCount;
        this.totalSpent = totalSpent;

        this.budget = getSAVING_FACTOR()*((balance+income-educationFees)/getNUM_OF_MONTHS());
    }

    //    GETTERS AND SETTERS:

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public float getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(float totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setEducationFees(float educationFees) {
        this.educationFees = educationFees;
    }

    public void setSurplus(float surplus) {
        this.surplus = surplus;
    }

    public float getBalance() {
        return balance;
    }

    public float getIncome() {
        return income;
    }

    public float getEducationFees() {
        return educationFees;
    }

    public int getNUM_OF_MONTHS() {
        return NUM_OF_MONTHS;
    }

    public double getSAVING_FACTOR() {
        return SAVING_FACTOR;
    }

    public float getSurplus() {
        return surplus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }
}
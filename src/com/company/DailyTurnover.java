package com.company;

/**
 * Created by cleitgeb on 05.07.16.
 */
public class DailyTurnover {

    int date;
    double amount;
    double vatLow;
    double vatNormal;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void addAmount(double amount) {
        this.amount = this.amount +amount;
    }

    public double getVatLow() {
        return vatLow;
    }

    public void setVatLow(double vatLow) {
        this.vatLow = this.vatLow + vatLow;
    }

    public double getVatNormal() {
        return vatNormal;
    }

    public void setVatNormal(double vatNormal) {
        this.vatNormal = this.vatNormal + vatNormal;
    }
}

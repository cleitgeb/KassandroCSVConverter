package com.company;

/**
 * Created by cleitgeb on 05.07.16.
 */
public class Kassapos {

    int date;
    String name;
    int voucherID;
    int vatRate;
    double vatAmount;
    double bruttoPrice;
    double nettoPrice;

    public Kassapos(int date, String name, int voucherID, int vatRate, double vatAmount, double nettoPrice) {
        this.date = date;
        this.name = name;
        this.voucherID = voucherID;
        this.vatRate = vatRate;
        this.vatAmount = vatAmount;
        this.bruttoPrice = nettoPrice + vatAmount;
        this.nettoPrice = nettoPrice;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(double bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }
}

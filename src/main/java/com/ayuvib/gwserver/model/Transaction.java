package com.ayuvib.gwserver.model;

public class Transaction {
    
    private double amount;
    private int cIndex;
    private String label;

    public Transaction() {
    }

    public Transaction(double amount, int cIndex) {
        this.amount = amount;
        this.cIndex = cIndex;
    }

    public Transaction(double amount, int cIndex, String label) {
        this.amount = amount;
        this.cIndex = cIndex;
        this.label = label;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getcIndex() {
        return cIndex;
    }

    public void setcIndex(int cIndex) {
        this.cIndex = cIndex;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", cIndex=" + cIndex + ", label=" + label + "]";
    }
}

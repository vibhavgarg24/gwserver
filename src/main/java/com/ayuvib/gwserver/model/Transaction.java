package com.ayuvib.gwserver.model;

public class Transaction {
    
    private double amount;
    private long timestamp;
    private String label;
    private Category category;

    public Transaction() {
    }

    public Transaction(double amount, long timestamp, String label) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.label = label;
        this.category = null;
    }

    public Transaction(double amount, long timestamp, String label, Category category) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.label = label;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", timestamp=" + timestamp + ", label=" + label + ", category="
                + category + "]";
    }

}

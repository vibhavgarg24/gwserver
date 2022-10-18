package com.ayuvib.gwserver.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    private String name;
    private double sum;
    private List<Transaction> txns;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.sum = 0;
        this.txns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<Transaction> getTxns() {
        return txns;
    }

    public void setTxns(List<Transaction> txns) {
        this.txns = txns;
    }

    @Override
    public String toString() {
        return "Category [name=" + name + ", sum=" + sum + ", txns=" + txns + "]";
    }

}

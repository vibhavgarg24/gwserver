package com.ayuvib.gwserver.model;

public class Category {
    
    private String name;
    private double sum;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.sum = 0;
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

    @Override
    public String toString() {
        return "Category [name=" + name + ", sum=" + sum + "]";
    }
}

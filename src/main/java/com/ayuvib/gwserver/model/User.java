package com.ayuvib.gwserver.model;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    private String id;
    private String email;
    private List<String> categories;
    private List<Transaction> transactions;
    private List<Double> categorySum;
    private double totalSum;

    public User() {
    }

    public User(String id, String email, List<String> categories, List<Transaction> transactions,
            List<Double> categorySum, double totalSum) {
        this.id = id;
        this.email = email;
        this.categories = categories;
        this.transactions = transactions;
        this.categorySum = categorySum;
        this.totalSum = totalSum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Double> getCategorySum() {
        return categorySum;
    }

    public void setCategorySum(List<Double> categorySum) {
        this.categorySum = categorySum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "User [categories=" + categories + ", categorySum=" + categorySum + ", email=" + email + ", id=" + id
                + ", totalSum=" + totalSum + ", transactions=" + transactions + "]";
    }
}

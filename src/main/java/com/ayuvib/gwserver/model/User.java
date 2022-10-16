package com.ayuvib.gwserver.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    private String id;
    private String email;
    private List<Category> categories;
    private List<Transaction> transactions;
    private double totalSum;

    public User() {
    }

    public User(String email) {
        this.email = email;
        categories = new ArrayList<>();
        transactions = new ArrayList<>();
        totalSum = 0;
    }

    public User(String id, String email, List<Category> categories, List<Transaction> transactions, double totalSum) {
        this.id = id;
        this.email = email;
        this.categories = categories;
        this.transactions = transactions;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", categories=" + categories + ", transactions=" + transactions
                + ", totalSum=" + totalSum + "]";
    }   
}

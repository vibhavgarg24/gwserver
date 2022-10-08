package com.ayuvib.gwserver.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test {

    private int key;
    private int value;

    public Test() {
    }

    public Test(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test [key=" + key + ", value=" + value + "]";
    }
}

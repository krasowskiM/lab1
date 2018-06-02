package com.example.maciej_krasowski.lab1.model;

import java.io.Serializable;

public class Grade implements Serializable {
    private final String name;
    private int value;

    public Grade(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}

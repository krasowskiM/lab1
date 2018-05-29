package com.example.maciej_krasowski.lab1.model;

import java.io.Serializable;

public class Grade implements Serializable {
    private final String name;
    private final int value;

    public Grade(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}

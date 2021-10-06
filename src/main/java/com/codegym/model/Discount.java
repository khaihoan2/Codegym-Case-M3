package com.codegym.model;

public class Discount {
    private int id;
    private int percentage;

    public Discount() {
    }

    public Discount(int percentage) {
        this.percentage = percentage;
    }

    public Discount(int id, int percentage) {
        this.id = id;
        this.percentage = percentage;
    }

    public Discount(int percentage) {
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}

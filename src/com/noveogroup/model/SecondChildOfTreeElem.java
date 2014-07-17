package com.noveogroup.model;

public class SecondChildOfTreeElem extends TreeElem {
    private double price;

    public SecondChildOfTreeElem(int id, double price) {
        super(id);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Id = " + super.toString() + ";Price = " + String.valueOf(price);
    }
}

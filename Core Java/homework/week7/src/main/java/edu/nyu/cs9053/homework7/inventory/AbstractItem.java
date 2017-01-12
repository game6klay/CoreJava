package edu.nyu.cs9053.homework7.inventory;


public abstract class AbstractItem implements Item {

    private final Double price;

    protected AbstractItem(Double price) {

        this.price = price;
    }

    @Override public Double getPrice() {

        return price;
    }
}
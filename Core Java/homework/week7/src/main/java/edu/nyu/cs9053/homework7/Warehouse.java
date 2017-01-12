package edu.nyu.cs9053.homework7;

import java.util.*;

import edu.nyu.cs9053.homework7.inventory.*;


public class Warehouse {

    private final Bin<? extends Item> items;

    public Warehouse(Bin<? extends Item> items) {

        this.items = items;
    }

    private static void copy(Bin<? extends Item> from, Bin<? super Item> into) {
        for (Item items : from) {
            into.add(items);
        }
    }

    public Bin getItems() {

        return items;
    }


    public Warehouse copy() {
        Bin<Item> into = new Bin<Item>();
        Warehouse.copy(items, into);
        return new Warehouse(into);
    }

}

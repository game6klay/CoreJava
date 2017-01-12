package edu.nyu.cs9053.homework7.inventory.gadgets;

import edu.nyu.cs9053.homework7.inventory.Electronic;
import edu.nyu.cs9053.homework7.inventory.GadgetStore;

public class Tablet<T extends GadgetStore> extends ElectronicType<T> {

    protected Tablet(Double price, T type) {

        super(price, type);
    }
}


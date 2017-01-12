package edu.nyu.cs9053.homework7.inventory.gadgets;

import edu.nyu.cs9053.homework7.inventory.Electronic;
import edu.nyu.cs9053.homework7.inventory.GadgetStore;

public abstract class ElectronicType<T extends GadgetStore> extends Electronic {

    private final T type;

    protected ElectronicType(Double price, T type) {
        super(price);
        this.type = type;
    }

    public T getType() {
        return type;
    }
}

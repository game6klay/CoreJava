package edu.nyu.cs9053.homework7;

import java.util.*;
import edu.nyu.cs9053.homework7.inventory.*;

public class WarehouseInventoryAuditor {

    public static void printPrices(Bin<? extends Item> items) {
        if (items == null ) {
            return;
        }

        Iterator<? extends Item> iterator=items.iterator();
        while(iterator.hasNext() ){
            if ((iterator == null) || (iterator.next().getPrice() == null)){
                continue;
            }
            System.out.println(iterator.next().getPrice()+" ");
        }
    }


    public static void printElectronicPrices(Bin<? extends Electronic> electronics) {

        printPrices(electronics);

        }


    public static void printBookPrices(Bin<? extends Book> books) {

        printPrices(books);
    }



}

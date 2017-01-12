
package edu.nyu.cs9053.homework7.inventory;

public class Book extends AbstractItem{

    protected Book(double price, String title){
        super(price);
        this.title=title;
    }

    private final String title;

    public String getTitle() {

        return title;
    }

}
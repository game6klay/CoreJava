package edu.nyu.cs9053.homework7.inventory;

public class Bookcover<T extends Book> extends AbstractItem {

    private final T book;

    protected Bookcover(Double price, T book) {
        super(price);
        this.book = book;
    }

    public T getBook() {

        return book;
    }
}
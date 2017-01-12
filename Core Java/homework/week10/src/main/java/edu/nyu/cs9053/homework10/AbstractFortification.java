package edu.nyu.cs9053.homework10;

/**
 * Created by jay on 4/20/16.
 */
public abstract class AbstractFortification<T> implements Fortification<T>, ConcurrencyFactorProvider {

    private final int concurrencyFactor;

    public AbstractFortification(int concurrencyFactor) {
        this.concurrencyFactor=concurrencyFactor;
    }

    @Override
    public int getConcurrencyFactor() {
        return concurrencyFactor;
    }

    public abstract void handleAttack(AttackHandler handler);

    public abstract void surrender();

}



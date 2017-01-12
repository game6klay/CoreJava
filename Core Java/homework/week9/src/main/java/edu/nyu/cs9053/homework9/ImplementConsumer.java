package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;
import java.util.Random;

/**
 * Created by jay on 4/13/16.
 */
public class ImplementConsumer implements Consumer{

    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public Seltzer consume(VendingMachine from){

        Seltzer seltzer = new Seltzer(selectRandomFlavor());
        try {

            semaphore.acquire();

            if (!from.isEmpty()) {
                    seltzer = from.remove();
            }

            else
                return null;
        }

        catch (InterruptedException ie){
            return null;
        }

        finally {
            semaphore.release();
        }

        return seltzer;

    }

    public Flavor selectRandomFlavor(){

        int select = new Random().nextInt(Flavor.values().length);
        return Flavor.values()[select];
    }


}

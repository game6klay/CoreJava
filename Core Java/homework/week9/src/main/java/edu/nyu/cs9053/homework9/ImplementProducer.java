package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;
import java.util.Random;

/**
 * Created by jay on 4/13/16.
 */
public class ImplementProducer implements Producer{

    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public Seltzer produce(VendingMachine into){

        Seltzer seltzer = new Seltzer(selectRandom());

        try {

            semaphore.acquire();

            if (!into.atCapacity()){

                into.add(seltzer);
            }

            else
                return  null;
        }

        catch (InterruptedException ie){
            return null;
        }

        finally {
            semaphore.release();
        }

        return seltzer;


    }


    public Flavor selectRandom(){

        int select = new Random().nextInt(Flavor.values().length);
        return Flavor.values()[select];
    }
}

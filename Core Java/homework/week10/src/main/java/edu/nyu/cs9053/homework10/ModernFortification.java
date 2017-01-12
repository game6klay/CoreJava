package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:27 PM
 */
public class ModernFortification extends AbstractFortification<ExecutorService> {

    private final int concurrentRateForModern;
    private final ExecutorService executorService;

    public ModernFortification(int concurrencyFactor, int concurrentRateForModern, ExecutorService executorService){
        super(concurrencyFactor);
        this.concurrentRateForModern = concurrentRateForModern;
        this.executorService =  Executors.newFixedThreadPool(concurrencyFactor);

    }

    @Override
    public void handleAttack(AttackHandler handler) {


        this.executorService.execute(new Runnable() {
            @Override public void run() {
                handler.soldiersReady();
            }
        });

    }

    @Override
    public void surrender() {
        executorService.shutdown();

    }
}

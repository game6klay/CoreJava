package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:31 PM
 */
public class FortificationFactory {

    private static int concurrentRateForMiddleAges;
    private static int concurrentRateForModern;
    private static ExecutorService executorService;

    public FortificationFactory(int concurrentRateForMiddleAges, int concurrentRateForModern, ExecutorService executorService) {
        this.concurrentRateForMiddleAges = concurrentRateForMiddleAges;
        this.concurrentRateForModern = concurrentRateForModern;
        this.executorService = executorService;
    }

    public static Fortification<Thread> createMiddleAges(int concurrencyFactor) {

        ExecutorService executor = Executors.newFixedThreadPool(concurrencyFactor);

        MiddleAgesFortification guard = new MiddleAgesFortification(concurrencyFactor,concurrentRateForMiddleAges);
        return guard;
    }

    public static Fortification<ExecutorService> createModern(final int concurrencyFactor) {

        ExecutorService executor = Executors.newFixedThreadPool(concurrencyFactor);

        ModernFortification guard = new ModernFortification(concurrencyFactor, concurrentRateForModern, executorService);
        return guard;
    }


}

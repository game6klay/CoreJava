package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:28 PM
 */
public class MiddleAgesFortification extends AbstractFortification<Thread> {


    private final int concurrentRateForMiddleAges;
    ExecutorService executorService;

    public MiddleAgesFortification(int concurrencyFactor,int concurrentRateForMiddleAges){
        super(concurrencyFactor);
        this.concurrentRateForMiddleAges = concurrentRateForMiddleAges;
        executorService =  Executors.newFixedThreadPool(concurrencyFactor);

    }

    @Override
    public void handleAttack(AttackHandler handler) {

        this.executorService = Executors.newScheduledThreadPool(getConcurrencyFactor(), new ThreadFactory() {
            private final AtomicInteger poolNumber = new AtomicInteger(1);
            private final ThreadGroup group;
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            private final String namePrefix;

            {
                SecurityManager s = System.getSecurityManager();
                group = (s != null) ? s.getThreadGroup() :
                        Thread.currentThread().getThreadGroup();
                namePrefix = "protection army" +
                        poolNumber.getAndIncrement() +
                        "-thread-";
            }

            public Thread newThread(Runnable work) {
                Thread thread = new Thread(group, work, namePrefix + threadNumber.getAndIncrement(), 0);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                if (thread.getPriority() != Thread.NORM_PRIORITY) {
                    thread.setPriority(Thread.NORM_PRIORITY);
                }
                return thread;
            }
        });

        handler.soldiersReady();

    }

    @Override
    public void surrender() {
        executorService.shutdown();

    }
}

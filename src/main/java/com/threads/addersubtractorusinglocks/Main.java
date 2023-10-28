package com.threads.addersubtractorusinglocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// using locks - allows to executes the multiple threads one after the other
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        count.count =0;

        Lock lock = new ReentrantLock();

        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(adder);
        executorService.submit(subtractor);

        executorService.shutdown();
        executorService.awaitTermination(100L, TimeUnit.MINUTES);
        System.out.println("in main " + count.count);
    }
}

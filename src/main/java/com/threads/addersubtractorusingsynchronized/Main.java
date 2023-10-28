package com.threads.addersubtractorusingsynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// using implicit lock (synchronized block) - it is same as locks but syntactically different

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        count.count =0;

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(adder);
        executorService.submit(subtractor);

        executorService.shutdown();
        executorService.awaitTermination(100L, TimeUnit.MINUTES);
        System.out.println("in main " + count.count);
    }
}

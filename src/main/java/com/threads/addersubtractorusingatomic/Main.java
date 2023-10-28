package com.threads.addersubtractorusingatomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//using atomic types - atomic type will take care of locks internally no need to specify externally
//and it uses volatile keyword because to make sure all the cache threads will have same data
// two threads are running in parallel and one of the thread is updated a value and the other threads local cache can still point to old value.
// to resolve these kind of issues it uses volatile keyword
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

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

package com.threads.addersubtractorusinglocks;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lock;
    public Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=0;i<=100;i++) {
            lock.lock();
            // this line is critical section where the shared variable is getting updated
            count.count += 1;
            lock.unlock();
        }
    }
}

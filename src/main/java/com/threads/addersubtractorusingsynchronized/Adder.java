package com.threads.addersubtractorusingsynchronized;

public class Adder implements Runnable{
    private Count count;
    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=0;i<=100;i++) {
            synchronized (count) {
                count.count += 1;
            }
        }
    }
}

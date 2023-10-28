package com.threads.printtillhundred;

public class NumberPrinter implements Runnable{
    private final int count;
    public NumberPrinter(int i){
        this.count = i;
    }
    @Override
    public void run() {
        try {
        //we may get out of memory error when we call sleep()
            // based on milliseconds and number of threads that are going to create
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(count == 9){
            System.out.println("Break here");
        }
        System.out.println("In number printer "+ this.count + " thread " +Thread.currentThread().getName());
    }
}

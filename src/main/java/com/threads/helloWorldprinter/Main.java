package com.threads.helloWorldprinter;

//single thread application
//main thread is always faster than the custom thread
//CPU scheduler will take care of which thread to run
public class Main {
    public static void main(String[] args) {
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        Thread thread = new Thread(hwp);
        thread.start();
        System.out.println("In main class "+ Thread.currentThread().getName());

    }
}

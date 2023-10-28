package com.threads.printtillhundredusingexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//using executors we don't need to create any thread objects as it will take care of creation and execution of threads
//best way is to use executors for a multi thread application
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<=100;i++) {
            if(i== 99){
                System.out.println("Break");
            }
            NumberPrinter np = new NumberPrinter(i);
            //initially it creates 10 threads and main thread will contain rest of 90
            //once the job is done by these 10 threads executor service will pick another 10 from main and executes those threads and so on
            //here fixed thread pool size can be any number
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.submit(np);
            System.out.println("In main " + Thread.currentThread().getName());
        }
    }
}

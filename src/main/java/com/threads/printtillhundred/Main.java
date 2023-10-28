package com.threads.printtillhundred;

//multi threaded application using Threads
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<=1000;i++) {
            if(i== 100){
                System.out.println("Break");
            }
            NumberPrinter np = new NumberPrinter(i);
            Thread thread = new Thread(np);
            thread.start();
            System.out.println("In main " + Thread.currentThread().getName());
        }
    }
}

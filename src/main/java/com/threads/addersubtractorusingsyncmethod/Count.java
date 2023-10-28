package com.threads.addersubtractorusingsyncmethod;

public class Count {
    int count;

    synchronized public void add(int i){
        count += i;
    }
    synchronized public void subtract(int i){
        count -= i;
    }
}

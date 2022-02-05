package com.fouo.lock;


public class SynDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        synchronized (o){
            System.out.println("Hello Lock");
        }
    }
}

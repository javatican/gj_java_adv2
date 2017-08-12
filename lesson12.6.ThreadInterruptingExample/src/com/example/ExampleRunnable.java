package com.example;

public class ExampleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread started");
        //busy checking interrupt flag
        while(!Thread.interrupted()) {
            // ...
        }
        System.out.println("Thread finishing");
    }
}
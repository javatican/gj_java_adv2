package com.example;

public class ExampleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ex) {
            //can decide what to do or do nothing...
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Slept for " + time + " ms");
        System.out.println("Thread finishing");
    }
}

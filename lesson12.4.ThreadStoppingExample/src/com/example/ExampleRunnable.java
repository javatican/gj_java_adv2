package com.example;

public class ExampleRunnable implements Runnable {

    //public volatile boolean timeToQuit = false;
    public boolean timeToQuit = false;

    @Override
    public void run() {
        System.out.println("Thread started");
        while (!timeToQuit) {
            // ...
        }
        System.out.println("Thread finishing");
    }
}

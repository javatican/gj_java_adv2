package com.example;

public class ThreadInterruptingMain {

    public static void main(String[] args) {
        ExampleRunnable r1 = new ExampleRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        // interrupt t1 thread(send it an interrupt signal)
        t1.interrupt();
    }
}
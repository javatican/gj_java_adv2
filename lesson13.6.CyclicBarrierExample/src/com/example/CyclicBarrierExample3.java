package com.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample3 {

    public static void main(String[] args) {
        
        Runnable r2 = new Runnable() {
            public void run() {
                String thread_name = Thread.currentThread().getName();
                System.out.println(thread_name + " starting...  ");
            }
        };
        final CyclicBarrier barrier = new CyclicBarrier(3, r2);

        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    String thread_name = Thread.currentThread().getName();
                    System.out.println(thread_name + " before await  ");
                    barrier.await();
                    System.out.println(thread_name + " after await  ");
                } catch (BrokenBarrierException | InterruptedException ex) {

                }
            }
        };
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
    }
}

package com.example;
 

public class ExampleRunnable implements Runnable {

    private int i; //shared data

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            //System.out.println("i:" + i);
            System.out.println(Thread.currentThread().getName() + "\t" + "i:" + i);
            try{
                Thread.sleep((long)(Math.random()*10+1));
            } catch (InterruptedException ex) {
                 
            } 
        }
    }
}

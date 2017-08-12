package com.example;
 

public class ThreadStoppingMain {

    public static void main(String[] args) {
        ExampleRunnable r1 = new ExampleRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        // ...
        long time_start=System.currentTimeMillis();
        try{
            Thread.sleep(100);
        } catch (InterruptedException ex) { 
             
        }
        
        long time_lapse=System.currentTimeMillis()-time_start;
        System.out.println("sleep for "+ time_lapse +"ms");
        r1.timeToQuit = true;
    }
}
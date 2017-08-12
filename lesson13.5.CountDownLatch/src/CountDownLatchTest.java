

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        Runnable r = new Runnable() {
            public void run() {
                try {
                    System.out.println("Thread:" + Thread.currentThread().getName() + " is running!");
                    Thread.sleep(3000);
                    System.out.println("Thread:" + Thread.currentThread().getName() + " finishes!");
                    latch.countDown();
                } catch (InterruptedException e) {
                   
                }
            }
        };
        new Thread(r).start();
        new Thread(r).start();

        try {
            System.out.println("Waiting the other two threads...");
            latch.await();
            System.out.println("Other threads finish!");
            System.out.println("Continue the main thread...");
        } catch (InterruptedException e) {
            
        }
    }
}

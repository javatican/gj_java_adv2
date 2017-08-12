
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleRunnable2 implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            //the printing of counter may be out of order.
            System.out.println(Thread.currentThread().getName() + "\t counter:" + counter.getAndIncrement());
            try {
                Thread.sleep((int) (Math.random() * 10 + 1));
            } catch (InterruptedException ex) {
                //
            }
        }
    }

    public static void main(String[] args) {
        ExampleRunnable2 r1 = new ExampleRunnable2();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r1);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            //
        }
        System.out.println("main: done!");
    }
}

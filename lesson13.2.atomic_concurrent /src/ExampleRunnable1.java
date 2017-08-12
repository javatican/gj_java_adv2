

public class ExampleRunnable1 implements Runnable {

    private int counter=0;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "\t counter: " + counter++);
            }
            try {
                Thread.sleep((int) (Math.random() * 10 + 1));
            } catch (InterruptedException ex) {
                //
            }
        }
    }

    public static void main(String[] args) {
        ExampleRunnable1 r1 = new ExampleRunnable1();
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


import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

    //fair lock mode
    private static  final​ ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String message = "a"; //data to be accessed by multiple threads

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Read(), "read_thread");
        Thread t2 = new Thread(new WriteA(), "write_thread 1");
        Thread t3 = new Thread(new WriteB(), "write_thread 2");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    static class Read implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                if (lock.isWriteLocked​()) {
                    System.out.println("I'll take the lock from Write");
                }
                try {
                    lock.readLock().lock();
                    System.out.println("ReadThread " + Thread.currentThread().getName() + " --->Message is " + message);
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                    }
                } finally {
                    lock.readLock().unlock();
                }
            }
        }
    }

    static class WriteA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.writeLock().lock();
                    message = message.concat("a");
                    System.out.println("WriteThread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 3000));
                    } catch (InterruptedException e) {

                    }
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }

    static class WriteB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.writeLock().lock();
                    message = message.concat("b");
                    System.out.println("WriteThread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 2000));
                    } catch (InterruptedException e) {
                    }
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }
}

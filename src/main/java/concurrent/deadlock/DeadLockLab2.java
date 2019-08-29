package concurrent.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockLab2 {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            lock1.lock();
            try {
                sleep(2000);
                System.out.println("Thread1 is waiting for lock2");
                lock2.lock();
                try {
                    System.out.println("Thread1 completes");
                } finally {
                    lock2.unlock();
                }
            } finally {
                lock1.unlock();
            }
        }).start();
        new Thread(() -> {
            lock2.lock();
            try {
                sleep(2000);
                System.out.println("Thread2 is waiting for lock1");
                lock1.lock();
                try {
                    System.out.println("Thread2 completes");
                } finally {
                    lock1.unlock();
                }
            } finally {
                lock2.unlock();
            }
        }).start();
    }
}

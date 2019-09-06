package concurrent.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Guo-hao Zhang
 */
public class ReentrantLockLab1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("holdCount: " + lock.getHoldCount() + " in layers 0");
            try {
                lock.lock();
                System.out.println("holdCount: " + lock.getHoldCount() + " in layers 1");
                try {
                    lock.lock();
                    System.out.println("holdCount: " + lock.getHoldCount() + " in layers 2");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}

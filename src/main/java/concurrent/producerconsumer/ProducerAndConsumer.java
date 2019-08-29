package concurrent.producerconsumer;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Guo-hao Zhang
 */
// TODO: 是不是做了多余的同步？
public class ProducerAndConsumer {
    private final int QUEUE_CAPACITY = 5;

    private final ArrayBlockingQueue<LocalTime> queue;

    public static final int CONSUMERS = 3;

    public static final int PRODUCERS = 1;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    public ProducerAndConsumer() {
        this.queue = new ArrayBlockingQueue<LocalTime>(QUEUE_CAPACITY);
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while(queue.isEmpty()) {
                condition.await();
            }
            LocalTime itemName = queue.take();
            System.out.println(Thread.currentThread().getName() + " consume " + itemName + ", buffer: " + queue.toString());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= QUEUE_CAPACITY) {
                condition.await();
            }
            LocalTime now = LocalTime.now();
            queue.put(now);
            System.out.println(Thread.currentThread().getName() + " produce " + now + ", buffer: " + queue.toString());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        producerAndConsumer.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        producerAndConsumer.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 1; i <= ProducerAndConsumer.PRODUCERS; i++) {
            Thread thread = new Thread(producer);
            thread.setName("Producer No." + i);
            thread.start();
        }

        for (int i = 1; i <= ProducerAndConsumer.CONSUMERS; i++) {
            Thread thread = new Thread(consumer);
            thread.setName("Consumer No." + i);
            thread.start();
        }
    }
}

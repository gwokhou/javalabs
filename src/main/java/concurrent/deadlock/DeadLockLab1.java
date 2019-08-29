package concurrent.deadlock;

/**
 * @author Guo-hao Zhang
 */
public class DeadLockLab1 {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                sleep(2000);
                System.out.println("Thread1 is waiting for resource2");
                synchronized (resource2) {
                    System.out.println("Thread1 completes");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (resource2) {
                sleep(2000);
                System.out.println("Thread2 is waiting for resource1");
                synchronized (resource1) {
                    System.out.println("Thread2 completes");
                }
            }
        }).start();
    }
}

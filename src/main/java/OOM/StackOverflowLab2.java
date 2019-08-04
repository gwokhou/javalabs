package OOM;

/**
 * @author Gwok-hou
 */
public class StackOverflowLab2 {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) {
        StackOverflowLab2 lab2 = new StackOverflowLab2();
        lab2.stackLeakByThread();
    }
    // VM Options: -Xss2M
}

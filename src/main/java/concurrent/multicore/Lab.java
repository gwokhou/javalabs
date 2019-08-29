package concurrent.multicore;

public class Lab {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.setName("Thread-" + i);
            thread.start();
        }
    }
}

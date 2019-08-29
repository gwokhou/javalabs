package concurrent.threadlocal;

public class Lab {
    public static void main(String[] args) {
        ThreadLocal<String> name = new ThreadLocal<>();
        name.set("hello");
        System.out.println(name.get() + " in " + Thread.currentThread().getName());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(name.get() + " in " + Thread.currentThread().getName());
            }
        }).start();
    }
}

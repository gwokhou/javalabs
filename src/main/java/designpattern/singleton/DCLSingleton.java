package designpattern.singleton;

/**
 * Double-checked Locking Singleton
 * @author Guo-hao Zhang
 */
public class DCLSingleton {
    private static volatile DCLSingleton instance;

    private DCLSingleton() {
        System.out.println("生成了一个实例");
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}

package designpattern.singleton;

/**
 * Static Holder Singleton
 * @author Guo-hao Zhang
 */
public class StaticHolderSingleton {
    private StaticHolderSingleton() {
        System.out.println("生成了一个实例");
    }

    private static class InstanceHolder {
        final static StaticHolderSingleton INSTANCE = new StaticHolderSingleton();
    }

    public static StaticHolderSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}

package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Guo-hao Zhang
 */
public class ReflectionLab2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(23);
        // 有编译器类型检查，不能通过编译
//        list.add("hello");

//        最终你会发现我们从整型容器中取出一个字符串，因为虚拟机只管在运行时从方法区找到 ArrayList 这个类的类型信息并解析出它的 add 方法，接着执行这个方法。
//        它不像一般的方法调用，调用之前编译器会检测这个方法存在不存在，参数类型是否匹配等，所以没了编译器的这层安全检查，反射地调用方法更容易遇到问题。
//        除此之外，之前我们说过的泛型在经过编译期之后会被类型擦除，但实际上代表该类型的 Class 类型信息中是保存有一些基本的泛型信息的，这一点我们可以通过反射得到。
//
//        作者：YangAM
//        链接：https://juejin.im/post/5b2f8bd2f265da59b457cf47
//        来源：掘金
        Class<?> cls = list.getClass();
        Method add = cls.getMethod("add", Object.class);
        add.invoke(list, "hello");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}

package typeerasure;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TypeErasureLab4 {
//    public static String method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }

//    public static Integer method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//        return 1;
//    }

    public static void main(String[] args) throws NoSuchMethodException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        Method method = TypeErasureLab4.class.getMethod("method", List.class);
        System.out.println(method.toString());
    }
}

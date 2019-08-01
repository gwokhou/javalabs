package typeerasure;

import java.util.*;

/**
 * @author Guo-hao Zhang
 */
public class TypeErasureLab1 {
    public static void main(String[] args) {
        /*
            不管是ArrayList<Integer>()还是new ArrayList<String>()，都在编译器被编译器擦除成了ArrayList。
            Java的泛型先天存在非常难受的缺点：在泛型代码内部，无法获得任何有关泛型参数类型的信息。
         */
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        // expected: true
        System.out.println(c1 == c2);


        /*
            我们期待得到泛型参数的类型，但实际上我们只得到了一堆占位符。
         */
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
    }
}

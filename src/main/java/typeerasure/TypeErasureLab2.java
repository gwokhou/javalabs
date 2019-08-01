package typeerasure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo-hao Zhang
 *
 * 虽然有类型擦除的存在，使得编译器在泛型内部其实完全无法知道有关T的任何信息，但是编译器可以保证重要的一点：
 * 内部一致性，也是我们放进去的是什么类型的对象，取出来还是相同类型的对象，这一点让Java的泛型起码还是有用武之地的。
 */
public class TypeErasureLab2<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public List<T> fillList(T t, int size) {
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        TypeErasureLab2<String> lab2 = new TypeErasureLab2<String>();
        lab2.set("hello");
        String s = lab2.get();
        System.out.println(s);
        // expected: hello

        List<String> list = lab2.fillList("hello", 5);
        System.out.println(list.toString());
        // expected: [hello, hello, hello, hello, hello]
    }
}

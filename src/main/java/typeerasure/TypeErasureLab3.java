package typeerasure;

/**
 * @author Guo-hao Zhang
 *
 * 如上看到的，但凡是涉及到确切类型信息的操作，在泛型内部都是无法共工作的。
 * 那是否有办法绕过这个问题来编程，答案就是显示地传递类型标签。
 */
public class TypeErasureLab3<T> {
    public T create(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TypeErasureLab3<Integer> lab3 = new TypeErasureLab3<Integer>();
        Integer i = lab3.create(Integer.class);
        // expected: 当类型为Integer时会抛出异常，因为这种生成新对象的方法要求类必须有默认构造方法。
    }
}

package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author Guo-hao Zhang
 */
public class ReflectionLab1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Student student = new Student();
        Class<Student> studentClass = Student.class;
        Field[] fields = studentClass.getFields();
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }
        System.out.println("---------------------");
        for (Field field : declaredFields) {
            System.out.println(field.toString());
        }
        Constructor<Student> constructor = studentClass.getConstructor();
        Student student1 = constructor.newInstance();
        student1.gradeName = "grade 1";
        System.out.println(student1.gradeName);
    }
}

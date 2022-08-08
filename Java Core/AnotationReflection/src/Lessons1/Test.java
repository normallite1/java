package Lessons1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {


        Class<?> cls = MyTest.class;

           Method method = cls.getDeclaredMethod("summ", int.class, int.class);
           if(method.isAnnotationPresent(MyAnnotation.class)) {
               MyAnnotation myTests = method.getAnnotation(MyAnnotation.class);
               int a = (Integer) method.invoke(null, myTests.a(), myTests.b());
               System.out.println(a);
           }



    }
}

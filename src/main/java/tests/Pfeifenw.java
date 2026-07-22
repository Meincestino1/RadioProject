package tests;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class Pfeifenw {

    static <T> T firstOrElse(List<T> list, T defaultValue) {
        if (list == null || list.isEmpty()) {
            return defaultValue;
        }
        //return list.getFirst();
        return null;
    }

    public static void main(String[] args) throws ReflectiveOperationException {

        Class<String> clazz1 = String.class;
        String newInstance = clazz1.getConstructor().newInstance();
        Constructor<String> testset = clazz1.getConstructor();
        System.out.println("construktorstring: " + testset);
        Class<? extends String> clazz2 = newInstance.getClass();
        Class<? extends String> clazz = "Simulatte".getClass();
        System.out.println(clazz1.equals(clazz));
        Container<String> container = new Container<>();
        ParameterizedType superclass = (ParameterizedType) container.getClass().getGenericSuperclass();

        //T[] array = (T[]) Array.newInstance( clazz, 2 );



    }



}

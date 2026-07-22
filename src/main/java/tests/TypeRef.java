package tests;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;

public class TypeRef<T> {

    public final Type type;

    protected TypeRef() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        type = superclass.getActualTypeArguments()[0];
    }

    public static <T> void main(String[] args) {

        TypeRef<Rocket<String>> ref1 = new TypeRef<>(){};
        TypeRef<Rocket<Byte>> ref2 = new TypeRef<>(){};

        System.out.println(ref1.type);
        System.out.println(ref2.type);

        Class<T> clazz = (Class<T>) String.class;
        T[] array = (T[]) Array.newInstance(clazz, 2);

        //Collections.addAll();

    }


}

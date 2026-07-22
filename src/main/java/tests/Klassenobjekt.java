package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Klassenobjekt<T> {


    public void doSomethingWithClass(Class<T> clazz) throws Exception { // vorher
        T instance = clazz.newInstance();
    }
    public void doSomethingWithFactory(Supplier<T> factory) { // nachher
        T instance = factory.get(); //
    }



    public static void main(String[] args) throws Exception {

        Klassenobjekt<String> obj1 = new Klassenobjekt<>(); // vorher
        obj1.doSomethingWithClass(String.class);

        Klassenobjekt<String> obj2 = new Klassenobjekt<>(); // nachher
        obj2.doSomethingWithFactory(String::new);




    }



}

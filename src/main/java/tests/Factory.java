package tests;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public class Factory {

    interface DateFactory {
        Date create();
    }

    public static void main(String[] args) {

        DateFactory factory = Date::new;
        System.out.println(factory.create());
        System.out.println("warten");
        System.out.println("warten");
        System.out.println("warten");
        System.out.println("warten");
        System.out.println("warten");
        System.out.println(factory.create());

        Supplier<Date> fac = Date::new;
        System.out.println(fac.get());

        List<Package> list = Arrays.asList( Package.getPackages() );
        Collections.sort( list, Comparator.comparing( Package::getName ) );
        System.out.println(list);


        Function<List<Integer>, Integer> max = listu -> Collections.max(listu);
        int result = max.apply(Arrays.asList(1, 5, 7));
        System.out.println(result);

        IntUnaryOperator addu = i -> i * 2;
        System.out.println(addu.applyAsInt(5));


        int boh = Optional.ofNullable("Wolter").filter(s -> s.length() >= 7).map(String::length).orElse(33);
        System.out.println(boh);

    }

}

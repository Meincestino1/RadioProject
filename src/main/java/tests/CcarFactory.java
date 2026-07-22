package tests;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CcarFactory {

    public static <T> T createDefault(Supplier<T> factory) {
        return factory.get();
    }

    public static <P, T> T createWithParam(Function<P, T> factory, P p) {
        return factory.apply(p);
    }

    public static <P1, P2, T> T  createWithParams(BiFunction<P1, P2, T> factory, P1 p1, P2 p2) {
        return factory.apply(p1, p2);
    }

    public static void main(String[] args) {

        Ccar c1 = createDefault(Ccar::new);
        System.out.println(c1);

        Ccar c2 = createWithParam(Ccar::new, "Ford");
        System.out.println(c2);

        Ccar c3 = createWithParams(Ccar::new, "Bmw", 2011);
        System.out.println(c3);

    }

}

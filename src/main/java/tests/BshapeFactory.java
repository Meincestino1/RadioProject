package tests;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BshapeFactory {

    // T ist hier immer vom Typ Brectangle

    public static <T> T createDefault(Supplier<T> factory) {                // 0:1 - ohne Parameter
        return factory.get();
    }

    public static <P, T> T createWithParam(Function<P, T> factory, P p) {   // 1:1 - 1 Parameter
        return factory.apply(p);
    }

    public static <P1, P2, T> T createWithParams(BiFunction<P1, P2, T> factory, P1 p1, P2 p2) {    // 2:1 - 2 Parameter
        return factory.apply(p1, p2);

    }

    public static void main(String[] args) {

        Brectangle rechteck1 = createDefault(Brectangle::new);                     // 0:1 - ohne Parameter
        System.out.println(rechteck1);

        Brectangle rechteck2 = createWithParam(h -> new Brectangle(h, h), 7);   // 1:1 - 1 Parameter
        System.out.println(rechteck2);

        Brectangle rechteck3 = createWithParams(Brectangle::new, 4, 5);     // 2:1 - 2 Parameter
        System.out.println(rechteck3);

    }

}

package tests;

import java.net.URI;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;


public class UriStringTest {


    @FunctionalInterface
    interface CheckedFunction<T, R> {   // T in diesem Fall String und R wäre URI
        R apply(T t) throws Exception;
    }

    static <T, R> Function<T, R> asUncheckedFunction(CheckedFunction<T, R> function) {
        return t -> {

        try {
            return function.apply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        };
    }


    public static void main(String[] args) {

        //CheckedFunction<String, URI> safeUriFactory = URI::new;
        //safeUriFactory.apply("www.test.de"); // so müsste man es mit try catch sorrounden oder throws in main schreiben

        Function<String, URI> safeUriFactory = asUncheckedFunction(str -> new URI(str));
        System.out.println(safeUriFactory.apply("www.test.it"));

        Supplier<Date> factory = Date::new;
        Supplier<Date> factoryLam = () -> new Date();
        System.out.println(factory.get());

    }

}

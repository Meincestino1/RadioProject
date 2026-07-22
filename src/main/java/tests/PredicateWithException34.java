package tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateWithException34 {

    interface ExceptionalPredicate<T, E extends Exception> {
        boolean test(T t) throws E;
    }

    static <T> Predicate<T> asUncheckedPredicate(ExceptionalPredicate<T, Exception> predicate) {

        return t -> {
            try {
                return predicate.test(t);
            }
            catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
                }
            };
        }

    public static void main(String... args) {

        Predicate<Path> isEmptyFile = asUncheckedPredicate(path -> Files.isRegularFile(path) && Files.size(path) == 0);
        System.out.println(isEmptyFile.test(Paths.get("c:/")));

        List<String> namen = Arrays.asList("Lena", "Thomas", "Anna", "Bernd");

        namen.sort((a,b) -> a.compareTo(b));

        Supplier<Long> time = System::currentTimeMillis;


        //RunnableTest r = PredicateWithException34::main;
        // r.run();

        Object[] worrds = {" ", '3', null, "2", 1, ""};
        Arrays.stream(worrds)
                .filter(Objects::nonNull)
                .map(Objects::toString)
                .map(String::trim)
                .filter(s -> ! s.isEmpty())
                .forEach(System.out::println);

        interface Datefactory {
            Date create();
        }

        Datefactory factory = Date::new;
        System.out.println(factory.create());

        Date datum = new Date();
        System.out.println("boh: " + datum);


        System.out.println("Mit supplier");

        Supplier<Date> datum1 = Date::new;
        System.out.println(datum1.get());


    }
    }



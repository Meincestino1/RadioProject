package tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class PredicateWithException2 {

    @FunctionalInterface
    interface ExceptionalPredicate<T, E extends Exception> {
        boolean test(T t) throws E;
    }

    static <T> Predicate<T> asUncheckedPredicate (ExceptionalPredicate<T, Exception> predicate) {

        return t -> {
            try {
                return predicate.test(t);
            }
            catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        };

    }

    public static void main(String[] args) {

        Predicate<Path> isEmptyFile = asUncheckedPredicate(path -> Files.isRegularFile(path) && Files.size(path) == 0);
        System.out.println(isEmptyFile.test(Path.of("c:\\")));

    }

}

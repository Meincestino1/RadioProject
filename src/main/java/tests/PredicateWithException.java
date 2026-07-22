package tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class PredicateWithException {

    @FunctionalInterface
    public interface ExceptionalPredicate<T, E extends Exception> {
        boolean test( T t ) throws E;
    }

    public static <T> Predicate<T> asUncheckedPredicate( ExceptionalPredicate<T,Exception> predicate ) {
         return t -> {
            try {
                return predicate.test(t);
            }
            catch (Exception e){
                throw new RuntimeException(e.getMessage(), e );
            }
        };
    }
    public static void main( String[] args ) {
        Predicate<Path> isEmptyFile = asUncheckedPredicate( path-> Files.size( path ) == 0 );
        System.out.println( isEmptyFile.test( Paths.get( "c:/" )));
    }
}

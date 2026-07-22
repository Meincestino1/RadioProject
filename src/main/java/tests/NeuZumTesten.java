package tests;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Optional;

public class NeuZumTesten {

    public static void printUppercase(Optional<String> optional) {
        optional.map(String::toUpperCase).ifPresent(System.out::println);
    }

    public static void doubleAndPrint(Optional<Integer> optional) {
        optional.filter(o -> o % 2 == 0).map(o -> o*2).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Optional<String> op = Optional.of("Hallo du");
        Optional<String> ot = Optional.empty();
        ot = Optional.of("Merda");
        System.out.println(op.get());
        ot.ifPresent(System.out::println);

        Optional<String> op7 = Optional.of("Hallo");
        printUppercase(Optional.of("sieben"));

        doubleAndPrint(Optional.of(8));


        try {
            Optional.ofNullable( NetworkInterface.getByIndex( 2 ) )
                    .map( NetworkInterface::getDisplayName )
                    .map( String::toUpperCase )
                    .ifPresent( System.out::println );
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }


    }
}

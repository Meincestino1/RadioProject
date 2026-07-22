package tests;

import java.util.Optional;

public class FuckingTest {

    static int i = 1;

    public static void change(int change) {
        Optional.ofNullable(change)
                .ifPresent(c -> i += c);
    }

    public static void printI() {
        System.out.println(i);
    }

    public static void main(String[] args) {

        change(1);
        printI();
        change(5);
        printI();

    }

}

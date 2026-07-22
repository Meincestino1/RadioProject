package tests;

import java.util.function.Predicate;

public class JavaFunctional {

    public static void main(String[] args) {

        Predicate<String> empty = isEmpty(true);

    }

    static Predicate<String> isEmpty(boolean shouldTrim) {
        return (String s) -> shouldTrim ? s.trim().isEmpty() : s.isEmpty();
    }

}

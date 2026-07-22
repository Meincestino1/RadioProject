package tests;

import java.util.Optional;

public class fuTest {

    public static Optional<String> createEmptyOptional() {
        return Optional.empty();
    }

    public static Optional<String> createOptionalWithValue(String input) {
        try {
            return Optional.of(input);
        } catch (NullPointerException e) {
            return Optional.empty();
        }

    }

    public static String createOptionalWithDefault(String input) {
        return Optional.ofNullable(input).orElse("Standard");
    }

    public static Optional<String> filterLongNames(Optional<String> name) {
        return name.filter(n -> n.length() >= 5);
    }

    public static String getNameOrDefault(Optional<String> name) {
        return name.orElse("Unbekannt");
    }

    public static String getNameOrGenerate(Optional<String> name) {
        return name.orElseGet(() -> "Gast");
    }

    public static String getNameOrThrow(Optional<String> name) {
        return name.orElseThrow(() -> new IllegalStateException());
    }

    public static void main(String[] args) {

        System.out.println(getNameOrGenerate(Optional.of("Susi")));
        System.out.println(getNameOrGenerate(Optional.empty()));

        System.out.println(getNameOrDefault(Optional.of("")));
        System.out.println(getNameOrDefault(Optional.empty()));

        System.out.println(filterLongNames(Optional.of("Cord")));

        Optional<String> emptional = createEmptyOptional();
        if (emptional.isPresent()) {
            System.out.println("Wert: " + emptional.get());
        } else {
            System.out.println("Kein Wert vorhanden");
        }

        Optional<String> result = createOptionalWithValue("Hallo Werner");
        System.out.println(result.get());

        System.out.println(createOptionalWithDefault("Ben"));
        System.out.println(createOptionalWithDefault(null));

    }

}

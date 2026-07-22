package tests;

import java.util.List;
import java.util.Optional;

public class NeuZumTesten2 {


    public static Optional<String> findUserWithMinLength(List<String> users, int minLength) {
        for (String user : users) {
            Optional<String> userName = Optional.of(user);
            if (userName.filter(s -> s.length() >= minLength).isPresent()) {
                return userName;  // erster User mit mindestens minLength Zeichen
            }
        }
        return Optional.empty();
    }

    public static Optional<Integer> parsePositiveInt(String input) {

        try {
            int value = Integer.parseInt(input);
            if (value > 0) {
                return Optional.of(value);
            } else {
                return Optional.empty();
            }
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

    }

    public static String getValueOrThrow(Optional<String> opt) {

        if (! opt.isEmpty()) {
            return opt.get();
        } else {
            throw new IllegalStateException("Kein Wert vorhanden");
        }
    }

    public static String getValueOrThrow2(Optional<String> opt) {
        return opt.orElseThrow(() -> new IllegalStateException("kein Wert vorhanden"));
    }

    public static Optional<String> convertToUpper(Optional<String> input) {
        return input.map(String::toUpperCase);
    }




    public static void main(String[] args) {

        List<String> users = List.of("Mau", "Her", "Kar", "Mar");
        System.out.println(findUserWithMinLength(users, 4));

        parsePositiveInt("a4");

        System.out.println(getValueOrThrow(Optional.of("HansiFlick")));
        //getValueOrThrow(Optional.empty());

        System.out.println(convertToUpper(Optional.of("Woswoasni")).get());
        System.out.println(convertToUpper(Optional.empty()));

    }


}

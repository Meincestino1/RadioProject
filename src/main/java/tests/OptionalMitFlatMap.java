package tests;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalMitFlatMap {


    public static String verifyProductName(String name) {
        return Optional.ofNullable(name)
                .map(String::trim)
                // Prüfe: mindestens 4 Zeichen und beginnt mit Großbuchstaben
                .filter(s -> s.length() >= 4 && Character.isUpperCase(s.charAt(0)))
                // Fallback nur, wenn obiges leer/ungültig war
                .or(() -> getFallbackName()
                        .filter(s -> s.length() >= 4 && Character.isUpperCase(s.charAt(0))))
                // Jetzt haben wir garantiert einen gültigen Namen
                .map(s -> "Produktname akzeptiert: <" + s + ">")
                // Wenn immer noch nichts da ist, werfe Exception
                .orElseThrow(() -> new IllegalArgumentException("Kein gültiger Produktname verfügbar"));
    }

    // Hilfsmethode zum Testen
    public static Optional<String> getFallbackName() {
        return Math.random() > 0.5
                ? Optional.of("Standard123")
                : Optional.empty();
    }







    public static void main(String[] args) {



    }

}

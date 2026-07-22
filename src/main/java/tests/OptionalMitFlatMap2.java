package tests;

import java.util.Optional;

public class OptionalMitFlatMap2 {


    public static String retrieveConfig(String key) {
        String cleanedKey = Optional.ofNullable(key)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("Konfigurations‑Schlüssel fehlt"));

        return Optional.of(cleanedKey)
                // flatMap springt in die Quellen-Logik, die ein Optional zurückgibt
                .flatMap(k -> getPrimaryConfig(k)
                        .or(() -> getSecondaryConfig(k))
                )
                .map(value -> String.format("Config für '<%s>': <%s>", cleanedKey, value))
                .orElseThrow(() -> new IllegalStateException("Keine Konfiguration für '" + cleanedKey + "' verfügbar"));
    }





    public static Optional<String> getPrimaryConfig(String key) {
        // Liefert manchmal einen Wert, manchmal nicht
        return key.equalsIgnoreCase("timeout") ? Optional.of("30s") : Optional.empty();
    }

    public static Optional<String> getSecondaryConfig(String key) {
        // Liefert manchmal einen Wert, manchmal nicht
        return key.equalsIgnoreCase("timeout") || key.equalsIgnoreCase("retry")
                ? Optional.of("default") : Optional.empty();
    }



    public static void main(String[] args) {

        System.out.println(retrieveConfig("retry"));

    }

}

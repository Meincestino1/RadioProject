package tests;

import java.util.Optional;

public class OptionalMitFlatMap3 {

    public static String fetchUserSetting(String userId) {
        String cleaned = Optional.ofNullable(userId)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("User‑ID fehlt"));

        return Optional.of(cleaned)
                .flatMap(s ->
                        getUserSettingFromDb(s)
                                .or(() -> getDefaultSetting())
                        )
                .map(s -> String.format("Setting für '<%s>': <%s>", cleaned, s))
                .orElseThrow(() -> new IllegalStateException("Kein Setting für '" + cleaned + "' verfügbar")
                );
    }


    public static Optional<String> getUserSettingFromDb(String userId) {
        // Simulation: liefert nur für "user1" einen Wert
        return "user1".equals(userId) ? Optional.of("dark-mode") : Optional.empty();
    }

    public static Optional<String> getDefaultSetting() {
        // Simulation: liefert zufällig einen Default oder leer
        return Math.random() > 0.5 ? Optional.of("light-mode") : Optional.empty();
    }


    public static void main(String[] args) {

        System.out.println(fetchUserSetting("us1"));
    }

}

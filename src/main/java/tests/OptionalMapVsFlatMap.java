package tests;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalMapVsFlatMap {

    // Diese Methode gibt ein Optional<Integer> zurück
    public static Optional<Integer> parseToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Integer> parsePositiveNumber(Optional<String> input) {
        return input.flatMap(s -> {
            try {
                Integer value = Integer.parseInt(input.get());
                return value >= 1 ? Optional.of(value) : Optional.empty();
            } catch (NumberFormatException e) {
                return Optional.empty();
            }

        });
    }

    public static Optional<Integer> doubleValue(Optional<Integer> input) {
        return input.map(s -> s * 2);
    }

    public static Optional<Integer> getLengthIfPresent(Optional<String> input) {
        return input.map(s -> s.length());
    }

    public static Optional<String> appendExclamation(Optional<String> input) {
        return input.map(s -> new StringBuilder(s).append("!").toString());
    }

    public static Optional<String> appendExclamation1(Optional<String> input) {
        return input.map(s -> s + "!");
    }

    public static Optional<String> toUpperCaseIfPresent(Optional<String> input) {
        return input.map(s -> s.toUpperCase());
    }

    public static Optional<Integer> getFirstWordLength(Optional<String> input) {
        return input
                .map(String::trim)
                .map(s -> {
                    int index = s.indexOf(" ");
                    String firstWord = (index == -1) ? s : s.substring(0, index);
                    return firstWord;
                })
                .map(String::length);
    }

    public static Optional<String> maskEmailUsername(Optional<String> input) {
        return input

                .map(s -> s.replace(" ", ""))
                .filter(s -> s.contains("@"))
                .map(s -> {
                    int index = s.indexOf("@");
                    String firstPart = "*".repeat(index);
                    String output = firstPart + s.substring(index, s.length());
                    return output;
                });
    }


    public static String extractDomain(String email) {
        return Optional.ofNullable(email)
                .filter(s -> s.contains("@"))
                .map(s -> s.substring(s.indexOf("@") + 1))
                .orElse("ungültig");
    }


    public static String formatPhoneNumber(String rawInput) {
        return Optional.ofNullable(rawInput)
                .map(String::trim)
                .filter(s -> s.length() == 10 && s.chars().allMatch(Character::isDigit))
                .map(s -> String.format("(%s) %s-%s", s.substring(0, 3), s.substring(3, 6), s.substring(6)))
                .orElse("ungültig");

    }

    public static String checkPasswordStrength(String password) {
        return Optional.ofNullable(password)
                .map(String::trim)
                .filter(s -> s.length() >= 8 && s.chars().anyMatch(Character::isUpperCase) && s.chars().anyMatch(Character::isDigit))
                .map(s -> "gültig")
                .orElse("ungültig");
    }


    public static String parseAge(String input) {
        return Optional.ofNullable(input)
                .map(s2 -> s2.trim())
                .filter(s -> s.matches("\\d+"))
                .map(s1 -> Integer.valueOf(s1))
                .filter(age -> age > 0)
                .map(s -> "Alter: " + s)
                .orElse("ungültig");
    }

    public static String validateProductCode(String code) {
        return Optional.ofNullable(code)
                .map(String::trim)
                .filter(s -> s.matches("^[A-Z]{3}[0-9]{3}$"))
                .map(s -> String.format("gültig: <%s>", s))
                .orElse("ungültig");
    }

    public static String validateOrGenerateCustomerId(String input) {
        return Optional.ofNullable(input)
                .filter(s -> s.matches("^KND[0-9]{6}$"))
                .orElseGet(() -> {
                    Random random = new Random();
                    StringBuilder digit = new StringBuilder("KND");
                    for (int i = 0; i < 6; i++) {
                        digit.append(random.nextInt(10));
                    }
                    return digit.toString();
                });
    }

    public static String getUsernameOrDefault(String username) {
        return Optional.ofNullable(username)
                .map(String::trim)
                .filter(s -> !s.isEmpty() && s.length() >= 5 )
                .map(s -> String.format("<%s>", s))
                .orElse("Gast");
    }

    public static String displayFirstName(String input) {
        return Optional.ofNullable(input)
                .map(String::trim)
                .filter(s -> s.length() >= 2)
                .map(s ->  String.format("Vorname: <%s>", s))
                .orElseGet(() -> "Unbekannt");
    }

    private static Optional<String> getPromotionalDiscountHelperMethod() {
        return Optional.of("Promotionsrabatt: 15%");
    }


    public static String getDiscount(String input) {
        return Optional.ofNullable(input)
                .map(String::trim)
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .filter(i -> i >= 1 && i <= 50)
                .map(i -> String.format("Rabatt: %d%%", i))
                .or(() -> getPromotionalDiscountHelperMethod())
                .orElseGet(() -> "Rabatt: 5%");
    }

    public static String validateUserAccess(String role) {
        return Optional.ofNullable(role)
                .map(String::trim)
                .filter(s1 -> !s1.isEmpty())
                .filter(s -> s.equals("ADMIN") || s.equals("USER") )
                .map(s -> String.format("Zugriff gewährt: <%s>", s))
                .orElseThrow(() -> new IllegalArgumentException("Ungültige Rolle: " + role));
    }

    public static String validateOrGenerateRegCode(String input) {
        String cleaned = Optional.ofNullable(input)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("Kein Code angegeben"));

        return Optional.of(cleaned)
                .filter(s -> s.matches("[A-Z0-9]{8}"))
                .map(s -> String.format("Code gültig: <%s>", s))
                .or(() -> getBackupRegCode())
                .orElseGet(() -> {
                    StringBuilder sb = new StringBuilder();
                    Random random = new Random();
                    for (int i = 0; i < 8; i++) {
                        char c = (char) ('A' + random.nextInt(26));
                        sb.append(c);
                    }
                    return "Code generiert: <" + sb.toString() + ">";
                });
    }

    public static Optional<String> getBackupRegCode() {
        // Simuliere manchmal leeres Ergebnis
        return Math.random() > 0.5 ? Optional.of("AB12CD34") : Optional.empty();
    }


    public static String validateOrGenerateArticleNumber(String input) {
        String cleaned = Optional.ofNullable(input)
                .filter(s -> !s.isEmpty())
                .or(() -> getBackupArticleNumber())
                .orElseThrow(() -> new IllegalArgumentException("Keine Artikelnummer angegeben"));

        return Optional.of(cleaned)
                .filter(s -> s.matches("[A-Z0-9]{10}"))
                .map(s -> String.format("Artikelnummer gültig: <%s>", s))
                .orElseGet(() -> produceRandomArticleNumber().get());
    }

    public static Optional<String> getBackupArticleNumber() {
        return Math.random() > 0.5 ? Optional.of(produceRandomArticleNumber().get()) : Optional.empty();

    }

    public static Optional<String> produceRandomArticleNumber() {
        StringBuilder article = new StringBuilder();
        String zeichenMenge = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < 10; i++) {
            char zufall = zeichenMenge.charAt(ThreadLocalRandom.current().nextInt(zeichenMenge.length()));
            article.append(zufall);
        }
        return Optional.of(article.toString());

    }


    public static String validateOrCreateUserProfile(String username, String email, String phone) {
        String cleanedUsername =  Optional.ofNullable(username)
                .map(String::trim)
                .orElseThrow(() -> new IllegalArgumentException("Username ungültig"));

        String returnUser = Optional.of(cleanedUsername)
                .filter(s -> s.matches("[a-zA-Z0-9]{5,}"))
                .or(() ->getBackupUsername())
                .orElse("Gast123");

        String cleanedEmail = Optional.ofNullable(email)
                .map(s -> s.trim())
                .orElse(getBackupEmail().get());

        String returnEmail = Optional.of(cleanedEmail)
                .filter(s -> s.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$"))
                .orElse("keine-email@beispiel.de");


        String returnPhone = Optional.ofNullable(phone)
                .map(String::trim)
                .filter(s -> s.length() == 10)
                .or(() -> getBackupPhone())
                .orElse("0000000000");

        return String.format("<%s>, Email: <%s>, Telefon: <%s>", returnUser, returnEmail, returnPhone);
    }



    public static Optional<String> getBackupUsername()
    { /* gib evtl. Optional.of("BackupUser") oder Optional.empty() zurück */
        return Math.random() > 0.5 ? Optional.of("BackupUser") : Optional.empty();
    }

    public static Optional<String> getBackupEmail() {
        /* ähnlich */
        return Math.random() > 0.5 ? Optional.of("lala@lele.backupmail") : Optional.empty();
    }

    public static Optional<String> getBackupPhone() {
        /* ähnlich */
        return Math.random() > 0.5 ? Optional.of("3333333333") : Optional.empty();
    }




    public static Optional<String> findNickname(String username) {
        return username != null && username.length() >= 4
                ? Optional.of(username.substring(0, 3).toUpperCase())
                : Optional.empty();
    }

    public static String getUserNickname(String input) {
        return Optional.ofNullable(input)
                .flatMap(OptionalMapVsFlatMap::findNickname)
                .orElse("NO_NICK");
    }

    public static String generateWelcomeMessage(String userRegion) {
        return Optional.ofNullable(userRegion)
                .map(String::trim)
                .filter(code -> code.matches("[A-Z]{2}"))
                .flatMap(OptionalMapVsFlatMap::findLocalizedGreeting)
                .or(() -> getFallbackGreeting())
                .orElseGet(() -> "Hello");

    }

    public static Optional<String> findLocalizedGreeting(String regionCode) {
        String result = switch (regionCode){

            case "DE" -> "Willkommen";
            case "US" -> "Welcome";
            case "FR" -> "Bienvenue";
            default -> null;
        };
        return Optional.ofNullable(result);
    }

    public static Optional<String> getFallbackGreeting() {
        return Math.random() > 0.5 ? Optional.of("Servus Hoi") : Optional.empty();
    }


    public static String checkOrResetPassword(String input) {
        return Optional.ofNullable(input)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .flatMap(s ->
                        Optional.of(s)
                                .filter(pw -> pw.length() > 8 && pw.matches(".*\\d.*"))
                                .map(pw -> String.format("Passwort akzeptiert: <%s>", pw))
                                .or(() -> getBackupPassword())
                                .or(() -> createPassword())
                )
                .orElseThrow(() -> new IllegalArgumentException("Kein Passwort angegeben"));
    }



    public static Optional<String> createPassword() {
        final String ZEICHEN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!?&%$*'<>";
        final Random random = new Random();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            output.append(ZEICHEN.charAt(random.nextInt(ZEICHEN.length())));
        }
        return Optional.of(output.toString());
    }

    public static Optional<String> getBackupPassword() {
        return Math.random() > 0.2 ? Optional.empty() : Optional.of("B@ckUpP@ssword?");
    }


    public static String activateUser(String token) {
        return Optional.of(token)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .flatMap(s ->
                        findUserByToken(s)
                                .or(() -> getBackupToken())
                                .or(() -> createDummyUser())
                )
                .orElseThrow(() -> new IllegalStateException("Aktivierung fehlgeschlagen"));
    }

    private static List<String> userList = List.of("SuperUser", "ItalianUser", "InternationalUser", "GermanUser");
    public static Optional<String> findUserByToken(String user) {
        for (String userOfList : userList) {
            if (user.equalsIgnoreCase(userOfList)) {
                return Optional.of(String.format("User aktiviert: <%s>", user));
            }
        }
        return Optional.empty();
    }

    public static Optional<String> getBackupToken() {
        return Optional.of(Math.random() < 0.9 ? "" : "Walter");
    }

    public static Optional<String> createDummyUser() {
        Random random = new Random();
        final String SIGNS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!?=)(&%$*#";
        StringBuilder output = new StringBuilder();
        int length = 5 + random.nextInt(3);
        for (int i = 0; i < length; i++) {
            output.append(SIGNS.charAt(random.nextInt(SIGNS.length())));
        }
        return Optional.of(output.toString());
    }





    public static void main(String[] args) {

        System.out.println(activateUser("SuperUserX"));

        //System.out.println(checkOrResetPassword("  "));

        System.out.println(generateWelcomeMessage("AT"));

        System.out.println(getUserNickname("Petta"));

        System.out.println(validateOrCreateUserProfile("Walter", "micky@lele.mumu", "8968785632"));

        System.out.println(validateOrGenerateArticleNumber("ABDCE7894"));

        //System.out.println(validateUserAccess("   user"));

        System.out.println(getDiscount("20"));
        System.out.println(getDiscount("abc"));
        System.out.println(getDiscount(null));

        System.out.println(displayFirstName("Jo"));

        System.out.println(getUsernameOrDefault("Karl"));

        System.out.println(validateOrGenerateCustomerId("KND23456"));

        System.out.println(validateProductCode("ABX456"));

        System.out.println(parseAge("x"));

        System.out.println(checkPasswordStrength("0012345678A"));

        String b = null;
        System.out.println(formatPhoneNumber("3470738409"));

        System.out.println(extractDomain("gas@hotmail.com"));
        System.out.println(extractDomain("invalidEmail"));
        System.out.println(extractDomain(null));

        System.out.println(maskEmailUsername(Optional.of("superUser@email.it")));

        System.out.println(appendExclamation1(Optional.of("Hallo")));

        System.out.println(getLengthIfPresent(Optional.of("Kakadu")));
        System.out.println(getLengthIfPresent(Optional.empty()));

        System.out.println(doubleValue(Optional.of(10)));
        System.out.println(doubleValue(Optional.empty()));

        System.out.println(parsePositiveNumber(Optional.of("0")));


        Optional<String> id = Optional.of("123");

        // Mit map: Liefert Optional<Optional<Integer>>
        Optional<Optional<Integer>> withMap = id.map(s -> parseToInt(s));
        System.out.println("Mit map:        " + withMap);

        // Mit flatMap: Liefert direkt Optional<Integer>
        Optional<Integer> withFlatMap = id.flatMap(s -> parseToInt(s));
        System.out.println("Mit flatMap:    " + withFlatMap);

        // Zugriff auf Wert bei map-Variante (mühsam)
        if (withMap.isPresent() && withMap.get().isPresent()) {
            System.out.println("Wert mit map:   " + withMap.get().get());
        }

        // Zugriff auf Wert bei flatMap-Variante (einfacher)
        withFlatMap.ifPresent(val -> System.out.println("Wert mit flatMap: " + val));
    }
}

package uebungen.Kapitel10BesondereTypen;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Heroes {

    private Heroes() {
    }

    // Klasse Hero in Klasse Heroes geschachtelt
    public static class Hero {

        public enum Sex {MALE, FEMALE}
        public final String name;
        public final Sex sex;
        public final int yearFirstAppearance;

        public Hero(String name, Sex sex, int yearFirstAppearance) {
            this.name = Objects.requireNonNull(name);
            this.sex = Objects.requireNonNull(sex);
            this.yearFirstAppearance = yearFirstAppearance;
        }

        @Override
        public String toString() {
            return String.format("Hero[name=%s, sex=%s, yearFirstAppearance=%s]", name, sex, yearFirstAppearance);
        }
    }

    // Klasse Universe in Klasse Heroes geschachtelt
    public static class Universe {

        private final String name;
        private final List<Hero> heroes;

        public Universe(String name, List<Hero> heroes) {
            this.name = Objects.requireNonNull(name);
            this.heroes = Objects.requireNonNull(heroes);
        }

        public String name() {
            return name;
        }

        public Stream<Hero> heroes() {
            return heroes.stream();
        }
    }

    // https://github.com/fivethirtyeight/data/tree/master/comic-characters

    private static final Hero DEADPOOL = new Hero("Deadpool (Wade Wilson)",
            Hero.Sex.MALE, 1991);

    private static final Hero LANA_LANG = new Hero("Lana Lang",
            Hero.Sex.FEMALE, 1950);

    private static final Hero THOR = new Hero("Thor (Thor Odinson)",
            Hero.Sex.MALE, 1950);

    private static final Hero IRON_MAN = new Hero("Iron Man (Anthony 'Tony' Stark)", Hero.Sex.MALE, 1963);


    private static final Hero SPIDERMAN = new Hero("Spider-Man (Peter Parker)",
            Hero.Sex.MALE, 1962);

    private static final Hero WONDER_WOMAN = new Hero("Wonder Woman (Diana " +
            "Prince)", Hero.Sex.FEMALE, 1941);


    private static final Hero CAPTAIN_AMERICA = new Hero("Captain America " +
            "(Steven Rogers)", Hero.Sex.MALE, 1941);


    private static final Hero SUPERMAN = new Hero("Superman (Clark Kent)",
            Hero.Sex.MALE, 1938);

    private static final Hero BATMAN = new Hero("Batman (Bruce Wayne)",
            Hero.Sex.MALE, 1939);

    public static final List<Hero> DC =
            Collections.unmodifiableList(Arrays.asList(SUPERMAN, LANA_LANG, WONDER_WOMAN, BATMAN));


    public static final List<Hero> MARVEL =
            Collections.unmodifiableList(Arrays.asList(DEADPOOL, CAPTAIN_AMERICA, THOR, IRON_MAN, SPIDERMAN));


    public static final List<Hero> ALL =
            Collections.unmodifiableList(
                    Stream.concat(DC.stream(), MARVEL.stream()).collect(Collectors.toList())
            );


    public static final List<Universe> UNIVERSES =
            Collections.unmodifiableList(Arrays.asList(
                    new Universe("DC", DC),
                    new Universe("Marvel", MARVEL)
            ));


    // Comparator mit Lokaler Klasse
    class YearFirstAppearanceComparator implements Comparator<Hero> {
        @Override
        public int compare(Hero h1, Hero h2) {
            return Integer.compare(h1.yearFirstAppearance, h2.yearFirstAppearance);
        }
    }


    // Comparator mit anonymer Klasse
    Comparator<Hero> yearFirstAppearanceComparatorAnonym = new Comparator<Hero>() {
        @Override
        public int compare(Hero h1, Hero h2) {
            return Integer.compare(h1.yearFirstAppearance, h2.yearFirstAppearance);
        }
    };

    // Comparator mit Lambda
    Comparator<Hero> yearFirstAppearanceComparatorLambda = (h1, h2) -> Integer.compare(h1.yearFirstAppearance, h2.yearFirstAppearance);


    // YearFirstAppearanceAndNameComparator mit Lambda
    Comparator<Hero> yearFirstAndNameComparator = Comparator.comparing( (Hero h) -> h.yearFirstAppearance).thenComparing(h -> h.name);


    // Im Übungsbuch wird der Comparator mit 2 Kriterien so umgesetzt:
    // wird von GPT als veraltet erklärt
    Comparator<Hero> combinedComparator = (h1, h2) -> {
        int yearComparison = Integer.compare(h1.yearFirstAppearance, h2.yearFirstAppearance);
        return (yearComparison != 0) ? yearComparison : h1.name.compareTo(h2.name);
    };


    // 10.2.4
    // Comparator nach Namen:
    Comparator<Hero> namenComparatorLambda = Comparator.comparing(h -> h.name, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    // Im Übungsbuch wird diese Variante vorgeschlagen, aber laut Chatty ist meine (die obere) die bessere und modernere
    Comparator<Hero> nameComparator = (h1, h2) -> h1.name.compareTo(h2.name);

    // Comparator nach Erscheinungsjahr:
    Comparator<Hero> yearFirstAppearanceComparatorLambda1024 = Comparator.comparingInt(h -> h.yearFirstAppearance);
    // Im Übungsbuch wird diese Variante vorgeschlagen aber laut Chatty ist meine (die obere) die bessere und modernere
    Comparator<Hero> yearComparator = (h1, h2) -> Integer.compare(h1.yearFirstAppearance, h2.yearFirstAppearance);

    // Kombinierter Comparator erst nach Erscheiungsjahr und dann nach Namen
    Comparator<Hero> yearFirstAppearanceAndThenNameComparator = Comparator.comparingInt((Hero h) -> h.yearFirstAppearance).thenComparing(h -> h.name);
    // Im Übungsbuch werden einfach beide vorderen Comparatoren verkettet, das hatte ich so nicht verstanden
    Comparator<Hero> combinedComparatorBuch = nameComparator.thenComparing(yearComparator);

    // Aufgabe 10.2.5
    Comparator<Hero> testCompi = Comparator.comparing((Hero h) -> h.sex).thenComparingInt(h -> h.yearFirstAppearance).thenComparing(h -> h.name, String.CASE_INSENSITIVE_ORDER);



    public static void main(String[] args) {

        Heroes heroes = new Heroes();
        List<Hero> allheroes = new ArrayList<>(Heroes.ALL);

        // Aufruf Comparator lokale Klasse
        //allheroes.sort(heroes.new YearFirstAppearanceComparator());
        //allheroes.forEach(System.out::println);
        System.out.println();

        // Aufruf Comparator der anonymen Klasse
        //allheroes.sort(heroes.yearFirstAppearanceComparatorAnonym);
        //allheroes.forEach(System.out::println);
        System.out.println();

        // Aufruf Comparator des Lambdaausdruckes
        //allheroes.sort(heroes.yearFirstAppearanceComparatorLambda);
        //allheroes.forEach(System.out::println);
        System.out.println();

        //allheroes.sort(heroes.yearFirstAndNameComparator);
        //allheroes.forEach(System.out::println);

        // Aufruf des NamenComparators:
        //allheroes.sort(heroes.namenComparatorLambda);
        //allheroes.forEach(System.out::println);

        // Aufruf des YearfirstAppearanceComparators von Aufgabe 10.2.4:
        //allheroes.sort(heroes.yearFirstAppearanceComparatorLambda1024);
        //allheroes.forEach(System.out::println);

        allheroes.sort(heroes.yearFirstAppearanceAndThenNameComparator);
        allheroes.forEach(System.out::println);
    }





    }
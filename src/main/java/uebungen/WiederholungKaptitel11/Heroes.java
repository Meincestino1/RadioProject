package uebungen.WiederholungKaptitel11;

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

    private static final Hero WONDER_WOMAN = new Hero("Wonder Woman (Diana " + "Prince)", Hero.Sex.FEMALE, 1941);


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



    // 10.2.3
    class yearFirstAppearenceComparatorWithLocalClass implements Comparator<Hero> {
        @Override
        public int compare(Hero o1, Hero o2) {
            return Integer.compare(o1.yearFirstAppearance, o2.yearFirstAppearance);
        }
    }

    Comparator<Hero> yearFirstAppearenceComparatorWithAnonymousClass = new Comparator<Hero>() {
        @Override
        public int compare(Hero o1, Hero o2) {
            return Integer.compare(o1.yearFirstAppearance, o2.yearFirstAppearance);
        }
    };

    Comparator<Hero> yearFirstAppearenceComparatorWithLambda = Comparator.comparingInt(o -> o.yearFirstAppearance);


    Comparator<Hero> combinedComparator = Comparator.comparingInt((Hero h) -> h.yearFirstAppearance).thenComparing(h -> h.name);


    //10.2.4
    Comparator<Hero> nameComparatorWithLambda = (h1, h2) -> h1.name.compareTo(h2.name);
    Comparator<Hero> yearComparatorWithLambda = (h1, h2) -> Integer.compare(h1.yearFirstAppearance, h2.yearFirstAppearance);
    Comparator<Hero> getCombinedComparator = nameComparatorWithLambda.thenComparing(yearComparatorWithLambda);

    //10.2.5
    Comparator<Hero> heroYearComparatorWithLambda = Comparator.comparingInt(h -> h.yearFirstAppearance);
    Comparator<Hero> heroNameComparatorWithLambda = Comparator.comparing(h -> h.name);
    Comparator<Hero> combinedComparator1025 = heroNameComparatorWithLambda.thenComparing(heroYearComparatorWithLambda);
    Comparator<Hero> heroNameCaseInsensitiveComparator = Comparator.comparing(h -> h.name.toUpperCase()); // <-- SCHLECHT
    Comparator<Hero> insensitiveNameComparator = Comparator.comparing(h -> h.name, String.CASE_INSENSITIVE_ORDER);

    //





    public static void main(String[] args) {

        Heroes heroes = new Heroes();
        List<Hero> allHeroes = new ArrayList<>(Heroes.ALL);

        allHeroes.forEach(System.out::println);
        System.out.println("trennung:");
        allHeroes.sort(heroes.yearFirstAppearenceComparatorWithLambda);
        allHeroes.forEach(System.out::println);
        System.out.println("trennung: ");

        allHeroes.sort(heroes.nameComparatorWithLambda);
        allHeroes.forEach(System.out::println);

        allHeroes.sort(heroes.yearComparatorWithLambda.thenComparing(heroes.nameComparatorWithLambda));



    }


}
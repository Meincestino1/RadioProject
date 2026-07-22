package uebungen.Kapitel9_Lambda_Ausdrücke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class City {

    public final String name;
    public final int    population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return name + ',' +  population;
    }

    public static void main(String[] args) {

        List<City> cityTour = new ArrayList<>();
        City g = new City("Gotham (cathedral)", 8_000_000);
        City m = new City("Metropolis (pleasure garden)", 1_000_000);
        City h = new City("Hogsmeade (Shopping Street)", 1_124);
        Collections.addAll(cityTour, g, m, h);

        cityTour.removeIf(city -> city.population < 10_000);
        cityTour.forEach(System.out::println);
        System.out.println();

        cityTour.replaceAll(city -> new City(city.name.substring(0, city.name.indexOf('(')).trim(), city.population));
        cityTour.forEach(System.out::println);

        cityTour.replaceAll(city -> new City( city.name.replaceAll("\\s*\\(.*\\)$", ""), city.population));
        cityTour.forEach(System.out::println);

    }

}

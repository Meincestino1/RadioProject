package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class DVehicleFactory {

    public <P1, P2, T> T createWithParams(BiFunction<P1, P2, T> factory, P1 p1, P2 p2) {
        return factory.apply(p1, p2);
    }

    public List<DCar> createFleet(int count, BiFunction<String, Integer, DCar> factory) {
        List<DCar> fleet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fleet.add(factory.apply("Car #" + (i + 1), 2020 + i));
        }
        return fleet;
    }

    public static void main(String[] args) {

        DVehicleFactory factory = new DVehicleFactory();
        List<DCar> cars = factory.createFleet(3, DCar::new);
        cars.forEach(System.out::println);

    }

}

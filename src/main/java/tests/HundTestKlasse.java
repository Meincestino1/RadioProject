package tests;

import java.util.function.BiFunction;

public class HundTestKlasse {

    String rasse;
    String farbe;

    public HundTestKlasse(String rasse, String farbe) {
        this.rasse = rasse;
        this.farbe = farbe;
    }

    @Override
    public String toString() {
        return "HundTestKlasse{" + "rasse='" + rasse + '\'' + ", farbe='" + farbe + '\'' + '}';
    }

    public static void main(String[] args) {

        BiFunction<String, String, HundTestKlasse> hund = HundTestKlasse::new;
        System.out.println(hund.apply("Collie", "Braun"));

        double ex = Math.sin(Math.PI);
        System.out.println(ex);

    }

}

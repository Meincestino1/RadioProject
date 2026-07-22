package tests;

import java.util.function.BiFunction;

public class KonstruktorReferenzenTraining {

    public static class Produkt {
        String name;
        double preis;

        private Produkt(String name, double preis) {
            this.name = name;
            this.preis = preis;
        }

        @Override
        public String toString() {
            return "Produkt{name='" + name + "', preis=" + preis + "}";
        }
    }

    public static Produkt erstelleProdukt(BiFunction<String, Double, Produkt> konstruktor, String name, double preis) {
        return konstruktor.apply(name, preis);
    }

    public static void main(String[] args) {
        Produkt p = erstelleProdukt(Produkt::new, "Tastatur", 49.99);
      //Produkt p = erstelleProdukt((name, preis) -> new Produkt(name, preis), "Tastatur", 49.99);
        System.out.println(p);
    }
}

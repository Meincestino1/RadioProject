package tests;

import java.util.function.BiFunction;

public class ProdottoFactory {

    public static <T extends Prodotto> T erstelle (BiFunction<String, Double, T> konstruktor, String name, double preis) {
        return konstruktor.apply(name, preis);
    }

    public static void main(String[] args) {

        Prodotto buch = ProdottoFactory.erstelle(Buch::new, "Java Insel", 22.00);
      //Prodotto buch = ProdottoFactory.erstelle((name, preis) -> new Buch(name, preis), "Java Insel", 22.00);
        Prodotto dvd = ProdottoFactory.erstelle(DVD::new, "Dschava Insel", 33.00);
      //Prodotto dvd  = ProdottoFactory.erstelle((name, preis) -> new DVD(name, preis), "Dschava Insel", 33.00);
        System.out.println(buch);
        System.out.println(dvd);

    }

}

package tests;

public class LagerMain {

    public static void main(String[] args) {

        Lager<Produkt> lager = new Lager<>();
        Produkt laptop = new Produkt(123456);
        Produkt smartphone = new Produkt("789524");

        // Produkte einlagern
        lager.einlagern(laptop);
        lager.einlagern(smartphone);

        // Original-Lager anzeigen
        System.out.println("Original Lager:");
        lager.zeigeAlle();

        // Lager kopieren
        Lager<Produkt> kopie = LagerUtils.kopiereLager(lager);

        // Kopiertes Lager anzeigen
        System.out.println("\nKopiertes Lager:");
        kopie.zeigeAlle();
    }
}

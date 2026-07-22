import java.util.function.Supplier;

public class Printdrink {

    @FunctionalInterface
    interface Drinkprinter {
        void print();
    }

    Drinkprinter printVodka = () -> System.out.println("Vodka");
    Drinkprinter printWiskey = () -> System.out.println("Whiskey");

    Drinkprinter printDrink = Math.random() > 0.5 ? printVodka : printWiskey;

    Supplier<String> vodkaSupplier = () -> "Vodka";
    Supplier<String> whiskeySupplier = () -> "Whiskey";

    Supplier<String> drinkSupplier = Math.random() > 0.5 ? vodkaSupplier : whiskeySupplier;

    public static void main(String[] args) {

        Printdrink fickDich = new Printdrink();
        System.out.println(fickDich.drinkSupplier.get());

    }


}

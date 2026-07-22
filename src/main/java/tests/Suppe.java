package tests;

import java.util.function.Supplier;

public class Suppe {

    Supplier<String> wasserSupplier = () -> "Wasser";
    Supplier<String> pfefferSupplier = () -> "Pfeffer";

    Supplier<String> zutatenSupplier = Math.random() > 0.5? wasserSupplier : pfefferSupplier;

    public static void main(String[] args) {
        Suppe suppe = new Suppe();
        System.out.println(suppe.zutatenSupplier.get());
    }

}

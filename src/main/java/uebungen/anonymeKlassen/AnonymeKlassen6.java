package uebungen.anonymeKlassen;

import java.util.ArrayList;
import java.util.List;


public class AnonymeKlassen6 {

    interface Discount {
        double applyDiscount(double price, double percent);
    }

    public static void main(String[] args) {

        List<Double> prices = new ArrayList<Double>();
        prices.add(100.00);
        prices.add(26.00);
        prices.add(1000.00);
        prices.add(77.00);
        prices.add(150.00);

        Discount discount = new Discount() {
            @Override
            public double applyDiscount(double price, double percent) {
                return price * (1 - percent / 100);

            }
        };

        System.out.println("Preise mit 10% Rabatt:");
        for (double price : prices) {
            double discountedPrice = discount.applyDiscount(price, 10); // Rabatt berechnen
            System.out.printf("Original: %.2f, Rabattiert: %.2f\n", price, discountedPrice);

        }

    }
}

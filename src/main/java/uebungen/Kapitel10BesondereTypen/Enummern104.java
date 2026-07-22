package uebungen.Kapitel10BesondereTypen;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Enummern104  {


    // 10.4.4
    public enum Distances implements Distance {
        EUCLIDEAN {
            @Override
            public double distance(double x1, double y1, double x2, double y2) {
                return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            }

            @Override
            public double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
                return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
            }
        },
        MANHATTAN {
            @Override
            public double distance(double x1, double y1, double x2, double y2) {
                return Math.abs(x1 - x2) + Math.abs(y1 - y2);
            }

            @Override
            public double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
                return Math.abs(x1 - x2) + Math.abs(y1 - y2) + Math.abs(z1 - z2);
            }

        }







    }

    public enum CandyType {
     CARAMELS(9),
        CHOCOLATE(5),
        GUMMIES(4),
        LICORICE(3),
        LOLLIPOPS(2),
        CHEWING_GUMS(3),
        COTTON_CANDY(1);

     private final int addictiveQuality;

        CandyType(int addictiveQuality) {
            this.addictiveQuality = addictiveQuality;
        }

        public int addictiveQuality() {
            return addictiveQuality;
        }


        public CandyType next() {
            return switch (this) {
                case COTTON_CANDY -> LOLLIPOPS;
                case LOLLIPOPS -> Math.random() > 0.5 ? CHEWING_GUMS : LICORICE;
                case CHEWING_GUMS -> GUMMIES;
                case LICORICE -> GUMMIES;
                case GUMMIES -> CHOCOLATE;
                case CHOCOLATE -> CARAMELS;
                case CARAMELS -> CARAMELS;
            };
        }

        private static CandyType[] NEXT1 = {
                CARAMELS, CARAMELS, CHOCOLATE, GUMMIES, null, GUMMIES, LOLLIPOPS
        };

        public CandyType next1() {
            if (this == LOLLIPOPS) {
                return Math.random() > 0.5 ? LICORICE : CHEWING_GUMS;
            }
            System.out.println("Ordinalkacke: " + this.ordinal());
            return NEXT1[ordinal()];
        }

        interface CandyTypeSupplier extends Supplier<CandyType> {}
        private static CandyTypeSupplier[] NEXT2 = {
                () -> CARAMELS,
                () -> CARAMELS,         // Das ist ein Array aus 7 kleinen Funktionen,
                () -> CHOCOLATE,        // je eine pro Enum-Wert, in der Reihenfolge der Enum-Deklaration
                () -> GUMMIES,
                () -> Math.random() > 0.5 ? LICORICE : CHEWING_GUMS,
                () -> GUMMIES,
                () -> LOLLIPOPS
        };
        public CandyType next2() {
            return NEXT2[ordinal()].get();
        }


        public static Optional<CandyType> fromName(String input) {
            try {
                input = input.trim().toUpperCase().replace(' ', '_');
                return Optional.of(CandyType.valueOf(input));
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        }




        // 10.4.2 NOCH LÖSUNG IN BUCH LESEN UND DAS ALLES NOCHMAL ANSCHAUEN
        public static CandyType random() {

            //CandyType[] values = values();
            //return values[ThreadLocalRandom.current().nextInt(values.length)];
            return values()[ThreadLocalRandom.current().nextInt(values().length)];
            // Du darfst das in einem Ausdruck kombinieren, weil Java erst die Klammern von innen nach außen auswertet.
            // Also:
            // erst values(),
            // dann .length,
            // dann nextInt(...),
            // dann values()[...]
            // Das sieht komprimiert aus, ist aber nur eine geschachtelte Funktionsauswertung –
            // syntaktisch völlig normal in Java.

        }

    }

    public static void main(String[] args) {
        System.out.println("Name a candy");
        String input = new Scanner(System.in).nextLine();
        CandyType.fromName(input).ifPresentOrElse(i -> System.out.println(i), () -> System.out.println("Unknown"));
        System.out.println(CandyType.random().name());

        System.out.println(CandyType.COTTON_CANDY.next());


    }

}

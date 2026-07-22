package uebungen.WiederholungKaptitel11;

import uebungen.Kapitel10BesondereTypen.Enummern104;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public enum CandyType {

    CARAMELS(9),
    CHOCOLATE(5),
    GUMMIES(4),
    LICORICE(3),
    LOLLIPOPS(2),
    CHEWING_GUMS(3),
    COTTON_CANDY(1);

    private final int addictiveQuality;

    CandyType (int addictiveQuality) {
        this.addictiveQuality = addictiveQuality;
    }

    public int addictiveQuality() {
        return addictiveQuality;
    }

    static Optional<CandyType> fromName(String input) {
        try {
            input = input.toUpperCase().trim().replace(" ", "_");
            return Optional.of(CandyType.valueOf(input));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }

    }

    static CandyType random() {
        //int random = ThreadLocalRandom.current().nextInt(0, CandyType.values().length);
        //return CandyType.values()[random];
        return values()[(int) (Math.random() * values().length)];
    }

    // diese next methode noch fertig machen
    CandyType next() {
        return switch (this) {
            case COTTON_CANDY -> LOLLIPOPS;
            case LOLLIPOPS -> Math.random() > 0.5 ? CHEWING_GUMS : LICORICE;
            case CHEWING_GUMS -> GUMMIES;
            case LICORICE -> GUMMIES;
            case GUMMIES -> CHOCOLATE;
            case CHOCOLATE -> CARAMELS;
            default -> CARAMELS;
        };
    }

    // Lambdalösung 10.4.3
    interface CandyTypeSupplier extends Supplier<CandyType> {}
    private static CandyTypeSupplier[] NEXT = {
            () -> CARAMELS, () -> CARAMELS, () -> CHOCOLATE, () -> GUMMIES,
            () -> Math.random() > 0.5 ? LICORICE : CHEWING_GUMS,
            () -> GUMMIES, () -> LOLLIPOPS
    };
    public CandyType nextLambda() {
        return NEXT[ordinal()].get();
    }



    public static void main(String[] args) {
        System.out.println(fromName("chewing gums "));
        System.out.println(random());
        System.out.println(CandyType.LOLLIPOPS.addictiveQuality());
        System.out.println(CandyType.GUMMIES.next());
        System.out.println(CandyType.LICORICE.nextLambda());

        System.out.printf("%s%n", 7.777);
        String format = String.format("%S", "wsnf" );
        System.out.printf(format);
        System.out.println();
        System.out.printf("%-+5d|%+5d%n", 12, -12);

        System.out.printf("%2$s <> %2$s", "!", "%");

    }

}

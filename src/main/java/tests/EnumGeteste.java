package tests;



import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;

import java.util.Arrays;

public class EnumGeteste {

    public enum Tiere {
        HUND("HND"),
        WOLF("W"),
        WOLTEMADE;

        private String abkuerzung;

        Tiere(@Nullable String abkuerzung) {
            this.abkuerzung = abkuerzung;
        }

        Tiere() {}
        };

    public static void main(String[] args) {

        for (Tiere t : Tiere.values()) {
            System.out.println(t);
        }

        System.out.println("getEnumConstants:");

        System.out.println(Arrays.asList(Tiere.class.getEnumConstants()));

        System.out.println("meinTest:");

        System.out.println(Arrays.asList(Tiere.values()));

        System.out.println("nächsterTest:");

        System.out.println(Tiere.valueOf("Woltemade".toUpperCase()));

        System.out.println("UndnoatestNOchOrdinal:");

        int ordinal = Tiere.valueOf("Hund".toUpperCase()).ordinal();
        System.out.println(ordinal);
        System.exit(1);

        int guggu = Integer.parseInt("Woltemade");

    }

}

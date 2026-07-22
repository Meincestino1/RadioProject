package tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

public class Testersetter {





    public static void main(String[] args) {

        String[] words = {"M", "\nSkyfall", " Q", "\t\tAdele\t"};
        Comparator<String> compi = (s1, s2) -> {
            return s1.trim().compareTo(s2.trim());
        };

        //Arrays.sort(words, compi);
        System.out.println(Arrays.toString(words));
        System.out.println("-------");

        Arrays.sort(words, (s1, s2) -> s1.trim().compareTo(s2.trim()));
        System.out.println(Arrays.toString(words));


        System.out.println("randomzeug:");
        Supplier<Double> negOrPositive = Math.random() > 0.5 ?  () ->  {return Math.random(); } : () ->  {return -Math.random(); };
        System.out.println(negOrPositive.get());



        System.out.println("randomzeug2:");
        Supplier<Double> randomNegOrPos2 = Math.random() > 0.5 ? () -> {return Math.random();} : () -> {return -Math.random();};
        System.out.println(randomNegOrPos2.get());





    }
}


package tests;

import java.io.Serializable;
import java.util.List;

public class Tsereteja {

    public static <T extends CharSequence> int random(T m, T n){
        return Math.random() > 0.5 ? m.length() : n.length();
    }



    public static void main(String[] args) {

        List<Number> list = List.of(12, 17.5, 1000000L);
        for (Number number : list) {
            System.out.println(number);
        }

    }

}

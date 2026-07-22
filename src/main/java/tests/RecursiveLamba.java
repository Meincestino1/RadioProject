package tests;

import java.util.concurrent.Callable;
import java.util.function.IntFunction;

public class RecursiveLamba {

    public static IntFunction<Integer> fact = n -> n == 0 ? 1 : n * RecursiveLamba.fact.apply(n - 1);

    static Callable<Integer> randomdice = () -> (int) (Math.random() * 6) + 1;



    public static void main(String[] args) {
        System.out.println(fact.apply(5));

        try {
            System.out.println(randomdice.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}

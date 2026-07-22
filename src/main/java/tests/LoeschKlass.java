package tests;

import java.sql.Time;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class LoeschKlass {

    int wal = 7;

    public  void trys(int wal) {
        wal += 1;
    }

    static void print(Supplier<?> suppe) {
        System.out.println(suppe.get());
    }






    public static void main(String[] args) {
        LoeschKlass lk = new LoeschKlass();
        //lk.trys();
        //System.out.println(lk.wal);

        //Supplier<Long> langeSuppe = () -> System.currentTimeMillis();
        //Supplier<Long> langeSuppe = System::currentTimeMillis;

        BiFunction<Integer, Integer, Integer> max = Math::max;
        System.out.println(max.apply(10, 11));

        System.out.println(Math.max(22, 33));

    }





}

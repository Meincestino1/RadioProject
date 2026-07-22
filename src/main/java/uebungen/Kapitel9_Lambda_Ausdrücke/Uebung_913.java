package uebungen.Kapitel9_Lambda_Ausdrücke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.function.*;

public class Uebung_913 {




    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Du Hampelmann");
        runnable.run();

        Function<String, String> machdas = (String w) -> { return w;};
        Consumer<String> cons = (String u) -> System.out.println(u);
        Runnable sjf = () -> {System.out.println(); return; };
        Runnable lkjsda = () -> System.out.println();
        Runnable lkjksdf = System.out::println;;


        ActionListener listener = ae -> System.out.println(ae);
        listener.actionPerformed(new ActionEvent("boh", 5, "boh2"));

        Supplier<String> supplier = () -> "Ich bin der Supplier";
        System.out.println(supplier.get());

        Consumer<Point> consumer = p -> System.out.println("X= " + p.x + " Y= " + p.y);
        consumer.accept(new Point(5, 6));

        Comparator<Rectangle> comparator = Comparator.comparingInt((Rectangle r) -> r.x).thenComparingInt((Rectangle r) -> r.y);
        System.out.println(comparator.compare(new Rectangle(2, 2, 1, 1), new Rectangle(2, 2, 1, 1)));


        DoubleSupplier ds = () -> 2;
        System.out.println(ds.getAsDouble());

        LongToDoubleFunction ltdf = l -> l;
        System.out.println(ltdf.applyAsDouble(566L));

        UnaryOperator<String> up = s -> "Output: " + s;
        System.out.println(up.apply("wsnf"));

        




    }

}

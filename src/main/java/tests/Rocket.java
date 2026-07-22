package tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Rocket<T> {

    private T value;
    public Rocket() {}
    public Rocket( T value ) { this.value = value; }
    public void set( T value ) { this.value = value; }
    public T get() { return value; }
    public boolean isEmpty() { return value == null;}
    public void empty() { value = null; }

    Class clazz = String.class;
    T[] arrayXX = (T[]) Array.newInstance(clazz, 2);
    
    public static <T> Rocket<T> newInstance() {
        return new Rocket<T>();
    }

    public static void main(String[] args) {
        Rocket<String> rakete = new Rocket<>("Helmut");
        Rocket<String> rakete2 = new Rocket<>("s");
        System.out.println(rakete.toString());


        Rocket<Rocket<String>> rocketOfRockets = new Rocket<Rocket<String>>();
        Rocket<ArrayList<String>> rocketOfRockets2 = new Rocket<ArrayList<String>>();
        rocketOfRockets.set( new Rocket<String>() );
        rocketOfRockets.get().set( "Inner Rocket<String>" );
        rocketOfRockets2.set(new ArrayList<String>());
        rocketOfRockets2.get().add("Innere Rakete2");
        System.out.println( rocketOfRockets.get().get() ); // Inner Rocket<String>
        System.out.println( rocketOfRockets2.get().get(0) ); // Inner Rocket<String>

        List<Map<Date,String>> listOfMaps = new ArrayList<Map<Date,String>>();
        listOfMaps = new ArrayList<Map<Date,String>>();

        //List<String>list=new ArrayList<String>().subList( 0, 1 );

        Rocket<?> r1 = new Rocket<Integer>();
        r1.get();
        r1.set(null);

        System.out.println("Hier");
        List<Double> nummern = new ArrayList<>();
        List<Number> list15 = new ArrayList<Number>();
        // list15 = nummern;
        list15.add(27);
        list15.add(2.2);
        for (Number number : list15) {
            System.out.println(number);
        }

        Rocket<Map<String, List<Integer>>> r178 = Rocket.newInstance();
        System.out.println(r178);

        
        Supplier<Double> randomNegOrPos = Math.random() > 0.5 ? () -> { return Math.random(); } : () -> { return -Math.random(); };

        //Supplier<Double> randomNegOrPos = Math.random() > 0.5 ? () -> Math.random() : () -> -Math.random();




    }

}

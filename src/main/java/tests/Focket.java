package tests;

import java.util.ArrayList;
import java.util.List;

public class Focket<T> {

    private T value;

    public Focket() {
        // leerer Konstruktor
    }

    public Focket(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        // Focket von Fockets
        //Focket<Focket<String>> focketOfFockets = new Focket<>();
        //focketOfFockets.set(new Focket<String>());
        //focketOfFockets.get().set("Inner Rocket<String>");

        //System.out.println(focketOfFockets.get().get()); // Inner Focket<String>

        //List<String> list = new ArrayList<String>().subList(0, 1);
        var lista = new ArrayList<String>(List.of("Kull"));
        System.out.println(lista);
    }
}

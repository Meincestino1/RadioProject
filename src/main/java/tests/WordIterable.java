package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class WordIterable implements Iterable<String>, Iterator<String>{

    @SuppressWarnings("all")  // Alle Warnungen in der Methode werden unterdrückt
    public static void main(String[] args) {

        @SuppressWarnings("all")
        ArrayList list;
        list = new ArrayList();
        list.add( "SuppressWarnings" );

    }



    private StringTokenizer tokenizer;

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return "";
    }
}

package tests;

import java.util.Arrays;
import java.util.List;

public class Getestetet {

    public static void main(String[] args) {
        List<String> list11 = Arrays.asList( new String[] { "A", "B" });
        List<String> list12 = Arrays.asList( "A", "B" ); // Parameter ist als Vararg definiert
        System.out.println( list11 ); // [A, B]
        System.out.println( list12 ); // [A, B]
        List<String> list21 = Arrays.<String>asList( new String[] { "A", "B" });
        List<String> list22 = Arrays.<String>asList( "A", "B" );
        System.out.println( list21 ); // [A, B]
        System.out.println( list22 ); // [A, B]

        List<String[]> list31 = Arrays.<String[]>asList( new String[] { "A", "B" });
        // List<String[]> list32 = Arrays.<String[]>asList( "A", "B" );
        System.out.println( list31 ); // [[Ljava.lang.String;@69b332]

        Class<Object> objectClass = Object.class;
        Class<String> stringClass = String.class;
        //Class<String> testClass = Integer.class;

    }


}

package tests;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Portable {
    double weight;

    public double getWeight() {
        return weight;
    }
}



class Pen extends Portable{}

class Cup extends Portable{}


public class PortableUtils {

    public static void copyLighterThan( List<? extends Portable> src,
                                        List<? super Portable> dest, double maxWeight ) {
        for ( Portable portable : src )
            if ( portable.getWeight() < maxWeight )
                dest.add( portable );
    }

    public static void main(String[] args) {
        Pen pen = new Pen();
        Cup cup = new Cup();
        Object boh = "123";
        Portable fuckingPortable = new Portable();
        Object object = new Object();
        List<? extends Portable> src = Arrays.asList( pen, cup );
        src.get(0);
        List<? super Portable> dest = new ArrayList<>();
        PortableUtils.copyLighterThan( src, dest, 20 );
        //dest.add(boh);
        System.out.println( dest.size() ); // 1
        Object result = dest.get( 0 );
        System.out.println( result ); // com.tutego.insel.generic.Pen[weight=10.0]

        Class<String> clazz1 = String.class;
        String newInstance = null;
        try {
            newInstance = clazz1.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Class<? extends String> clazz2 = newInstance.getClass();



    }

}

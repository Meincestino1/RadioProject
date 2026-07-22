package tests;

import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Comparator;
import java.util.Objects;

public class Outer2 {






    public Outer2() throws MalformedURLException, UnknownHostException {
    }

    public static void main(String[] args) throws MalformedURLException, UnknownHostException {

        System.out.println(Objects.toString(1));

        System.out.println(Objects.toString(null));
        System.out.println(String.valueOf(null));



        WeakReference<String> weichei = new WeakReference<String>("Werner");
        System.out.println(weichei.get());
        Outer2 a2 = new Outer2();
        WeakReference<Outer2> wa2 = new WeakReference<>(a2);
        System.out.println(a2);
        System.out.println(wa2.get());

        System.out.println(Objects.hash(new String("wsnf")));
        System.out.println(Objects.equals(new String("wsnf"), new String("wsnf")));
        System.out.println(Objects.equals(null, true));


        System.out.println(Objects.compare(new String("sRob"), new String("rob"), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }));


        System.out.println(Objects.compare("sRob", "fffrob", (s1, s2) -> Integer.compare(s1.length(), s2.length())));

    }




}

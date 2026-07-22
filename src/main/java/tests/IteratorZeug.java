package tests;

import com.drew.lang.annotations.NotNull;

import javax.annotation.processing.Generated;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class IteratorZeug  {

    @Deprecated
    public static void fubar() {
        System.out.println("Furchtbar");
    }


    public static void main(String[] args) {


        List<String> wsnfList = List.of("Mia", "Liam", "Sara");
        Iterator<String> it = wsnfList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        @Generated("klo")
        String ws = "H";

       IteratorZeug.fubar();
       String op = ws;




    }


}

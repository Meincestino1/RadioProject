package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringToIntListMap extends HashMap<String, List<Integer>> {

    public static void main(String[] args) {

        StringToIntListMap map = new StringToIntListMap();
        map.put("Zahlen", Arrays.asList(1,2,3));
        System.out.println(map);

    }

}

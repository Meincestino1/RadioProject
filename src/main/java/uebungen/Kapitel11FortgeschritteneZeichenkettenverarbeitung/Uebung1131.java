package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1131 {



    public static String extractValues(String string) {

        StringTokenizer line = new StringTokenizer(string, "\n\r");

        String name = line.nextToken();
        String street = line.nextToken();
        String city = line.nextToken();
        final String DEFAULT_COUNTRY = "Drusselstein";
        String country = line.hasMoreTokens() ? line.nextToken() : DEFAULT_COUNTRY;

        // Stringtokenizer  kaum mehr verwendet  laut  gpt auch weil keine regex unterstützung
        // laut GPT besser und moderner so:
        /*String[] lines = string.split("\\R");
        String name = lines.length > 0 ? lines[0] : "";
        String street = lines.length > 1 ? lines[1] : "";
        String city = lines.length > 2 ? lines[2] : "";
        String country = lines.length > 3 ? lines[3] : DEFAULT_COUNTRY;*/

        // oder so mit scanner:
        /*Scanner sc = new Scanner(input);
        sc.useDelimiter("\\R"); // trennt bei \n, \r oder \r\n
        String name = sc.hasNext() ? sc.next() : "";
        String street = sc.hasNext() ? sc.next() : "";
        String city = sc.hasNext() ? sc.next() : DEFAULT_CITY;
        String country = sc.hasNext() ? sc.next() : DEFAULT_COUNTRY;
        sc.close();*/
        

        return name + ";" + street + ";" + city + ";" + country;
    }


    public static void main(String[] args) {

        String adresses = "Doofenshmirtz Evil Inc.\r\nStrudelkuschel 4427\nGimmelstump\r\nPimmelland";
        System.out.println(extractValues(adresses));


    }

}

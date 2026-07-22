package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1122 {

    public static int countCiaos(String input) {
        int count = 0;
        Pattern p1 = Pattern.compile("[#@]CaptainCiaoCiao", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(input);
        while (m1.find()) {
            count++;
        }
        return count;
    }



    public static void main(String[] args) {

        String input = """
            Make me a baby #CaptainCiaoCiao
            Hey @CaptainCiaoCiao, where is the recruitment test?
            What is a hacker's favorite pop group? The Black IP's.""";

        System.out.println(countCiaos(input));

        //oder so mit streams:
        Pattern pattern = Pattern.compile("[#@]CaptainCiaoCiao", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        System.out.println(pattern.matcher(input).results().count());

    }

}

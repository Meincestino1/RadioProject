package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1125 {





    public static String replaceDigits(String text) {

        Matcher match = Pattern.compile("\\d+").matcher(text);
        StringBuilder result = new StringBuilder();

        while (match.find()) {
            match.appendReplacement(result, EnglishNumberToWords.convert(Integer.parseInt(match.group())));
            // System.out.println("Match.group: " + match.group());
        }
        match.appendTail(result);
        return result.toString();
    }




    public static void main(String[] args) {
        String words = "99 bottles of beer make CaptainCiaoCiao happy for 10 years";
        System.out.println(replaceDigits(words));
    }

}

package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1136 {

    private int count(String string) {
        return 0;
    }

    public static String compress(String string) {
        StringBuilder input = new StringBuilder(string);
        Matcher matcher = Pattern.compile("[^0-9]").matcher(input.toString());
        StringBuilder output = new StringBuilder();

        String first = String.valueOf(string.charAt(0));
        StringBuilder sameLetters = new StringBuilder();
        int length = 0;

        matcher.find();
        List<String> matches = new ArrayList<>(); // Matches anstatt mit while in Liste speichern und dann mit for.. Liste durchlaufen
        while (matcher.find()) {
            matches.add(matcher.group());
        }

        for (int i = 0; i < matches.size(); i++) {
            String current = matches.get(i);
            boolean isLast = i == matches.size() - 1;
            if (first.equals(current)){
                sameLetters.append(current);
            }
            else {

                System.out.println("Sameletters.length() vor append: " + sameLetters.length());
                System.out.println("In Sameletters steht: " + sameLetters);

                if (!sameLetters.isEmpty()) {
                    System.out.println("SamelettersImIfVorAppend: " + sameLetters);
                    sameLetters.append(first).append(sameLetters.length());
                    System.out.println("SamelettersImIfNachAppend: " + sameLetters);
                } else {
                    sameLetters.append(first).append(1);
                }
                System.out.println("OutputNachElseVorAppend: " + output);
                length = sameLetters.length();
                first = String.valueOf(input.charAt(length -1));  // hier war zuerst input.charAT...
                output.append(sameLetters.charAt(0)).append(sameLetters.charAt(sameLetters.length() -1));
                System.out.println("OutputNachElseNachAppend: " + output);
                sameLetters.delete(0, length);
                //System.out.println("Was grad interessiert, output.charAt..." + String.valueOf(output.charAt(length - 1)));

                input.delete(1, length);

                System.out.println("das neue first: " + first);
                if (isLast) {
                    output.append(first).append(1);
                }
                //length = 0;

            }
                        /// Zahl muss ausbleiben wenn zeichen nur 1x
                        /// jedes zeichen soll natürlich nur 1x geschrieben werden
        }
        System.out.println(output);


        return output.toString();
    }

    public static String decompress(String string) {


        return "";
    }


    public static void main(String[] args) {

        String string = "--....--------..-";
        compress("LLLLLLLxaaalellle");

    }

}

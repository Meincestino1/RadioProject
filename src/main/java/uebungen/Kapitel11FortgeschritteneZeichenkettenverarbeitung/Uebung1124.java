package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.regex.Pattern;

public class Uebung1124 {

    public static String silentShoutingWords(String words) {
        return Pattern.compile("\\p{javaUpperCase}{3,}") // \\p{javaUpperCase} matcht alle Gr.Buchstaben (\p{javaDigit} alle Ziffern)
                .matcher(words)
                .replaceAll(matcherResult -> matcherResult.group().toLowerCase()); //.group() extrahiert den string aus dem matcher
    }

    public static void main(String[] args) {

        String words = "AY Captain! Smutje MUSS WEG!";
        System.out.println(silentShoutingWords(words));
    }

}

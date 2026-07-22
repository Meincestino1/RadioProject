package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1126 {

    public static String converter(String string) {
        // Regex: ein- oder zweistündige Zeiten mit Minuten, optional Punkte bei am/pm
        Pattern pattern = Pattern.compile("\\d{1,2}:\\d{2}\\s?(a\\.?m\\.?|p\\.?m\\.?)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        StringBuilder result = new StringBuilder();

        DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("h:mm a"); // 12-Stunden-Format, parsebar ohne führende Null
        DateTimeFormatter formatterMilitary = DateTimeFormatter.ofPattern("HHmm"); // Military Time

        while (matcher.find()) {
            String cleanTime = matcher.group().replace(".", "").toUpperCase(); // Punkte entfernen, AM/PM groß
            LocalTime time = LocalTime.parse(cleanTime, formatter12);          // parsen
            String military = time.format(formatterMilitary) + " Uhr";         // formatieren als Military Time
            matcher.appendReplacement(result, military);
        }
        matcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Wir überfallen den Hafen um 11:00 PM und treffen uns auf der Amüsiermeile um 1:30 a.m. und 1:00 am";
        System.out.println(converter(text));

    }
}

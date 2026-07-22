package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1126Buch {

    private static final Pattern AM_PM_PATTERN =
            Pattern.compile("(?<hours>\\d\\d?)" + // das ? vor <hours> bedeutet spezielle gruppe, in dem fall benannte Gruppe
                                  "(?::(?<minutes>\\d\\d))?" + // minutes - // non capturing group nur der doppelpunkt
                                  "\\s?" +                  // optional whitespace
                                  "(?<ampm>[ap])[.]?m[.]?", // AM/PM
                                  Pattern.CASE_INSENSITIVE );

    public static String convertToMilitaryTime(String string) {
        StringBuffer result = new StringBuffer(string.length());
        Matcher matcher = AM_PM_PATTERN.matcher(string);

        while (matcher.find()) {
            int hours = Integer.parseInt(matcher.group("hours"));
            int minutes = matcher.group("minutes") == null ?
                    0 :
                    Integer.parseInt(matcher.group("minutes"));
            boolean isTimeInPm = "pP".contains(matcher.group("ampm")); // prüft ob p oder P in ampm vorkommen
            if (isTimeInPm && hours < 12) {
                hours += 12;
            } else if (!isTimeInPm && hours == 12) {
                hours -= 12;
            }
            matcher.appendReplacement(result, String.format("%02d%02d Uhr", hours, minutes));
        }
        matcher.appendTail(result);
        return result.toString();
    }


}

package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

public class EnglishNumberToWords {

    public static String convert(int number) {
        if (number < 0 || number > 999)
            throw new IllegalArgumentException("Number must be 0–999");

        return switch (number) {
            // 0–19
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            case 13 -> "thirteen";
            case 14 -> "fourteen";
            case 15 -> "fifteen";
            case 16 -> "sixteen";
            case 17 -> "seventeen";
            case 18 -> "eighteen";
            case 19 -> "nineteen";

            // volle Zehner
            case 20 -> "twenty";
            case 30 -> "thirty";
            case 40 -> "forty";
            case 50 -> "fifty";
            case 60 -> "sixty";
            case 70 -> "seventy";
            case 80 -> "eighty";
            case 90 -> "ninety";

            // alles andere 21–99
            default -> {
                if (number < 100) {
                    int tens = (number / 10) * 10;
                    int ones = number % 10;
                    yield convert(tens) + " " + convert(ones);
                } else { // 100–999
                    int hundreds = number / 100;
                    int rest = number % 100;
                    String result = convert(hundreds) + " hundred";
                    if (rest != 0) {
                        result += " " + convert(rest);
                    }
                    yield result;
                }
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(convert(0));    // zero
        System.out.println(convert(42));   // forty two
        System.out.println(convert(100));  // one hundred
        System.out.println(convert(219));  // two hundred nineteen
        System.out.println(convert(999));  // nine hundred ninety nine
    }
}

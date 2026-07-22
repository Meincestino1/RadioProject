package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

public class tesejr {

    public static void main(String[] args) {
        String time = "1:30";
        if (time.length() < 5) {
            time = "0" + time;
        }
        System.out.println(time);
    }
}

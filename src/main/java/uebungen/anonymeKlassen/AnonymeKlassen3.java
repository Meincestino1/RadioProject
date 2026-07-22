package uebungen.anonymeKlassen;

import java.util.Timer;
import java.util.TimerTask;

public class AnonymeKlassen3 {

    public static void main(String[] args) {

        Timer timer = new Timer();

        // Aufgabe für den Countdown
        TimerTask countdownTask = new TimerTask() {
            int i = 10; // Startwert für den Countdown

            @Override
            public void run() {
                if (i >= 0) {
                    System.out.println(i);
                    i--;
                } else {
                    timer.cancel();  // Stoppt den Timer, wenn der Countdown vorbei ist
                    System.out.println("Countdown abgeschlossen!");
                }
            }
        };

        // Timer startet die Aufgabe alle 1000ms, stoppt aber nach dem Countdown
        timer.schedule(countdownTask, 0, 1000);  // Alle 1 Sekunde wird eine Zahl ausgegeben
    }
}
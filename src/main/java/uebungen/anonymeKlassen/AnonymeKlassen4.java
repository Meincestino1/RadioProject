package uebungen.anonymeKlassen;

import java.util.Timer;
import java.util.TimerTask;

public class AnonymeKlassen4 {

    public static void main(String[] args) {


        Timer timer = new Timer();


        TimerTask rememberTask = new TimerTask() { // <----INNERE ANONYME KLASSE
            int elapsedTime = 0;
            @Override
            public void run() {
                System.out.println("Zeit für eine Pause");
                elapsedTime += 3;

                if (elapsedTime >= 15) {
                    timer.cancel();
                    System.out.println("Pause empfohlen");
                }


            }
        };

        timer.schedule(rememberTask, 0, 3000);
    }
}

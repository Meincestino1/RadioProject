package tests;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAndTimerTaskDemo {

    public static void main(String[] args) {

        class myTimerTask extends TimerTask {

            @Override
            public void run() {
                System.out.println("TimerTask: " + LocalTime.now());
            }
        }

        Timer timer = new Timer();
        //timer.schedule(new myTimerTask(), 2000);
        timer.schedule(new myTimerTask(), 0, 2000);
        System.out.println("main " + LocalTime.now());


    }


}

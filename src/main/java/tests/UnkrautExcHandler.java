package tests;

import java.time.LocalTime;

public class UnkrautExcHandler {

    public static void main(String[] args) {

        Runnable runnable = () -> {


            while (true) {
                System.out.println("Ich bin das Runnable");
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
package tests;

import java.time.LocalTime;

public class UnkrautExcHandler {

    // Git test änderung unkraut zugleich mit änderung 6 newcachedthreadpooltest
    // Git test unkraut 2

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
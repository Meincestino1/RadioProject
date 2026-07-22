package uebungen.anonymeKlassen;

public class anonymeKlassen7 {

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int timer = 5; timer >= 1; timer--) {
                    System.out.println(timer);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Timer has ended");

            }
        }).start();


    }

}

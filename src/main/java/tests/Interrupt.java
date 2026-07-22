package tests;

public class Interrupt {



    public static void main(String[] args) throws InterruptedException {

        Runnable killingMeSoftly = () -> {
            System.out.println("There is life before dead");


            while (!Thread.currentThread().isInterrupted()) {

                System.out.println("It runs, and runs, and runs...");
                System.out.println("isInterrupted= " + Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(1000);
                    System.out.println("isInterruptedTry= " + Thread.currentThread().isInterrupted());
                } catch (InterruptedException e) {

                    //Thread.currentThread().interrupt();
                    System.out.println("isInterruptedCatch= " + Thread.currentThread().isInterrupted());
                    System.out.println("Interruption in sleep");
                }
            }
            System.out.println("There is the end, beautiful friend");
        };

        Thread t = new Thread(killingMeSoftly);
        t.start();
        System.out.println("Jetzt schläft der Thread 2000 ms lang");
        Thread.sleep(2000);
        System.out.println("Jetzt interrputed der main thread");
        t.interrupt();


    }

}

package tests;

public class FredTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println("Des isch dr current Fred: " + Thread.currentThread());
            System.out.println(1/0);
        },"Waiting for the summer rain");
        t.start();
        System.out.println(t.isAlive());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread());
        System.out.println(t.isAlive());
    }

}

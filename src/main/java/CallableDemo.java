import java.io.File;
import java.util.Arrays;

public class CallableDemo {


    public static void main(String[] args) {
        new Thread(new ListDirectoryCommand()).start();
    }

    static class ListDirectoryCommand implements Runnable {
        @Override
        public void run() {
            String[] list = new File("c:/").list();
            System.out.println(Arrays.toString(list));
        }
    }

}

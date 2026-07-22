package uebungen.anonymeKlassen;

import java.util.ArrayList;
import java.util.List;

public class AnonymeKlassen8 {

    public static void main(String[] args) {

        List<String> messageList = new ArrayList<>( );
        messageList.add("Gib niemals auf");
        messageList.add("Bleib motiviert");
        messageList.add("Denk positiv");
        messageList.add("Der Erfolg kommt mit der Zeit");
        messageList.add("Du schaffst das");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int numberOfElements = messageList.size();

                while (true) {
                    int random = (int) (Math.random() * numberOfElements);
                    String output = messageList.get(random);
                    System.out.println(output);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}

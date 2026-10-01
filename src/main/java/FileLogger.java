public class FileLogger implements Logger {

    public void log(String message) {

        System.out.println("Würde jetzt in eine Datei schreiben: " + message);

    }

}
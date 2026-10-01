import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int memory = 0;
    private List<Integer> history = new ArrayList<>();   // merkt sich alle add-Ergebnisse
    private final Logger logger;
    private final RandomProvider randomProvider;

    // Konstruktor
    public Calculator(Logger logger, RandomProvider randomProvider) {
        this.logger = logger;
        this.randomProvider = randomProvider;
    }

    public Calculator(Logger logger) {
        this(logger, new RealRandomProvider());
    }

    public Calculator() {                             // bestehender, parameterloser Konstruktor bleibt
        this(new FileLogger());                        // ruft den anderen Konstruktor auf, mit Standard-Logger
    }

    // liefert eine "gewürfelte" Zahl zwischen 1 und bound (inklusive)
    public int rollDice(int bound) {
        return randomProvider.nextInt(bound) + 1;
    }

    // gibt etwas zurück
    public int add(int a, int b) {
        int result = a + b;
        history.add(result);   // Ergebnis zusätzlich im Verlauf speichern
        logger.log("add(" + a + ", " + b + ") = " + result);
        return result;
    }

    // gibt etwas zurück
    public int divide(int a, int b) {
        return a / b;
    }

    // gibt NICHTS zurück (void), verändert aber den Zustand des Objekts
    public void store(int value) {
        memory = value;
    }

    // gibt den gespeicherten Wert zurück
    public int recall() {
        return memory;
    }

    // gibt NICHTS zurück, druckt nur auf die Konsole
    public void printResult(int value) {
        System.out.println("Ergebnis: " + value);
    }

    // gibt eine Liste zurück (wie recall, nur mit mehreren Werten statt einem)
    public List<Integer> getHistory() {
        return history;
    }

    // NEU: gibt einen boolean zurück (Ja/Nein-Entscheidung)
    public boolean isEven(int value) {
        return value % 2 == 0;
    }

    // NEU: gibt einen double zurück (Kommazahl), z. B. percent(1, 4) = 25.0
    public double percent(int part, int total) {
        return part * 100.0 / total;
    }


    // gibt den größten Wert aus history zurück, oder null wenn history leer ist
    public Integer maxFromHistory() {
        if (history.isEmpty()) {
            return null;
        }
        Integer max = history.getFirst();
        for (Integer value : history) {
            if (value > max) {
                max = value;
            }
        }
        return  max;
    }




}
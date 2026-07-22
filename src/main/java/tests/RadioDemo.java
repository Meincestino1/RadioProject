package tests;

import java.util.*;
import javax.swing.event.EventListenerList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Collections;  // nur zu Demozwecken und einfacherem Verständniss in einer einzigen Kompilationseinheit


// --------------------- AdEvent --------------------- (Werbe-Ereignis)
/*Enthält die Information, dass Werbung passiert ist und welcher Slogan es ist.
  Wird vom Radio erzeugt und an alle Listener weitergereicht.*/

class AdEvent extends EventObject {         // EventObjekt deutsch: Ereignis-Objekt
    private final String slogan;

    public AdEvent(Object source, String slogan) {
        super(source); // source ist hier this, also das TimerTask Objekt In diesem Code: new AdEvent(this, ads.get(0))
        this.slogan = slogan; // slogan ist der konkrete Werbespruch, z.B.: "A Bite of Heaven."
    }
    /*Allgemein in Java: source ist ein fester Bestandteil aller EventObjects, weil Listener so die Quelle des Events
    kennen können. Bei mehreren Radios: source wird relevant, um zu unterscheiden, welches Radio das Event ausgelöst hat.
    In deinem aktuellen Demo-Code: source ist für die Funktion irrelevant, weil nur der slogan aber nicht source benutzt wird.*/

    public String getSlogan() {
        return slogan;
    }
}

// --------------------- AdListener --------------------- (Werbe-Zuhörer / Werbe-Beobachter)
/*Definiert wie man auf Werbung reagiert.
  Jede Klasse oder Lambda, die Werbung hören will, muss diese Methode bereitstellen.*/
interface AdListener extends EventListener {  //Ereignis-Zuhörer
    void advertisement(AdEvent e);
    /* EventListener ist ein Marker-Interface in Java, also ein Interface ohne Methoden.
       Sinn: eigene Event-Interfaces, wie AdListener, darauf aufbauen.
       Vorteil: dadurch kann z.B. EventListenerList alle Listener einheitlich verwalten.
       Praktisch: Radio kann alle angemeldeten Listener auf einmal abrufen und benachrichtigen, ohne zu wissen,
       welche konkreten Klassen es sind. */
}


// --------------------- Radio ---------------------
/*Erzeugt regelmäßig Werbung und informiert alle registrierten Listener darüber.
  Verwaltet die Listener-Liste und ruft sie bei neuer Werbung auf.*/

class Radio {

    private final EventListenerList listeners = new EventListenerList(); // Liste von Ereignis-Zuhörern
    // Durch diese lose Koppelung kennt Radio nur die verschiedenen AdListener, worauf dann durch das gleichnamige
    // Interface über Polymorphie die Methode advertisement aufgerufen wird, und nicht dessen spezifische
    // Implementierungen wie ComplainingAdListener.

    private final List<String> ads = new ArrayList<>(List.of(
            "A Bite of Heaven.",
            "Bag the sweets and run.",
            "Chew on this, for a while.",
            "Taste the explosion."
    ));


    public Radio() {
        new Timer().schedule(new TimerTask() { // Timer sorgt dafür, dass in festen Zeitabständen etwas passiert. Hier: alle 500 ms wird Werbung ausgelöst.
            @Override // TimerTask Enthält den Code, der bei jedem Timer-Tick ausgeführt wird. Hier: Werbung mischen und ein Werbe-Event auslösen.
            public void run() {
                Collections.shuffle(ads);
                notifyAdvertisement(new AdEvent(this, ads.get(0))); // this ist hier das TimerTask Objekt
                // Besser wäre es Radio.this zu übergeben, weil Radio die Quelle des Events ist und Listener später unterscheiden
                // könnten, welches Radio wirbt. Es ist so aber nur placeholder-information, weil surce im code nicht verwendet
                // wird. source wird nur vom  EventObjekt vorgeschrieben. man könnte anstatt this oder Radio.this
                // theoretisch also auch "Scheissdreck" übergeben, da EventObjekt nur ein Object erwartet
            }
        }, 0, 500);
    }

    public void addAdListener(AdListener listener) {
        listeners.add(AdListener.class, listener);
    }

    public void removeAdListener(AdListener listener) {
        listeners.remove(AdListener.class, listener);
    }

    protected synchronized void notifyAdvertisement(AdEvent event) {
        // Diese Methode wird aufgerufen, sobald das Radio-Objekt erstellt ist (und dann regelmäßig durch den Timer)
        for (AdListener l : listeners.getListeners(AdListener.class))
            l.advertisement(event);
    }
}

// --------------------- Demo ---------------------
/* Startet das Programm und verkabelt alles.
   Erzeugt das Radio, meldet Listener an und lässt die Demo laufen.*/
public class RadioDemo {
    public static void main(String[] args) {

        

        Radio r = new Radio(); // hierdurch startet Timer sofort - Werbung wird sofort, und dann alle 500ms ausgesendet
        // Detailablauf:
        // 1. new Radio startet im Konstruktor von Radio folgendes:
        // 2. new Timer() erstellt Timer-Thread (im Konstruktor von Radio) (Timer läuft paralell zum main Thread)
        // 3. schedule() startet TimerTask.run() sofort und wiederholt alle 500ms (im Konstruktor von Radio)
        // 4. run() mischt Werbesprüche und ruft notifyAdvertisement() (im Konstruktor von Radio)
        // 5. notifyAdvertisement() iteriert über alle registrierten AdListener (innerhalb der Klasse Radio)
        //    (ABER: Zu Beginn sind keine Listener registriert!)
        // 6. Nach Radio-Erstellung werden Listener registriert:
        //    r.addAdListener(new ComplainingAdListener()); (steht hier in der main)
        //    r.addAdListener(e -> System.out.println("I hear nothing: " + e.getSlogan())); (steht hier in der main)
        // 7. Ab jetzt: Für jeden Listener wird advertisement() aufgerufen, welche hier in main einmal durch innere Klasse und einmal durch Lambda realisiert wird:
        //    - Bei ComplainingAdListener: Gibt "Oh no, advertising again: ..." aus
        //    - Bei Lambda-Listener: Gibt "I hear nothing: ..." aus

        // Anmerkung, es könnte zu Race Conditions führen:
        //     Zu Beginn sind keine Listener registriert!
        //     Da der Timer sofort startet, könnten erste Werbe-Events verloren gehen,
        //     bevor die Listener in Schritt 6 registriert sind.


        // klassischer Listener über innere Klasse
        class ComplainingAdListener implements AdListener {  // Sich beschwerender Werbe-Zuhörer
            /* Reagiert auf Werbung, indem er genervt einen Text ausgibt.
               Ist ein konkreter Listener als innere Klasse.*/
            @Override
            public void advertisement(AdEvent e) {
                System.out.println("Oh no, advertising again: " + e.getSlogan());
            }
        }

        r.addAdListener(new ComplainingAdListener()); // Listener werden registriert, dadurch hat Radio 1 Listener

        // Listener über Lambda-Ausdruck
        /* Reagiert auf Werbung mit einer einfachen Ausgabe.
           Ist funktional identisch zu ComplainingAdListener, nur kürzer geschrieben.*/
        r.addAdListener(e -> System.out.println("I hear nothing: " + e.getSlogan())); // Listener werden registriert, dad. hat Radio 2 Listener

        // Demo für angegebene millis (Zeit) laufen lassen
        try {
            // das gibt dem Programm 3 Sekunden Zeit, seine Werbung zu senden bevor die Main Methode beendet wird
            Thread.sleep(3000); // 3 Sekunden Werbung anzeigen
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Demo beendet.");
        System.exit(0);
    }
}

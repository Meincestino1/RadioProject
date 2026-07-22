package tests;

import com.tutego.eigeneKlassenSchreiben.Radio;

import javax.swing.event.EventListenerList;
import java.util.*;

public class XRadio {

    private final EventListenerList listeners = new EventListenerList();

    private final List<String> ads = new ArrayList<>(List.of(   "A Bite of Heaven.",
                                                                "Bag the Sweets an run.",
                                                                "Chew on this, for a while",
                                                                "Taste the explosion"));

    public XRadio() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Collections.shuffle(ads);
                notifyAdvertisement(new XAdEvent(this, ads.get(0)));
            }
        }, 0, 500);
    }

    public void addAdListener(XAdListener listener){
        listeners.add(XAdListener.class, listener);
    }

    public void removeListener(XAdListener listener) {
        listeners.remove(XAdListener.class, listener);
    }

    protected synchronized void notifyAdvertisement(XAdEvent event) {
        for (XAdListener l : listeners.getListeners(XAdListener.class)) {
            l.advertisement(event);
        }
    }

    public static void main(String[] args) {
        //XRadio r = new XRadio();
        class ComplainingAdListener implements XAdListener {
            @Override
            public void advertisement(XAdEvent e) {
                System.out.println("Oh no, advertising again: " + e.getSlogan());
            }
        }
        //r.addAdListener( new ComplainingAdListener() );
        //r.addAdListener( e -> System.out.println( "I hear nothing" ));

        System.out.println("Ausgabe:");
        System.out.println(System.getProperty("java.class.path"));
    }

}

package com.tutego.eigeneKlassenSchreiben;
//import EigeneKlassenSchreiben.Radio.*; // Lösung 2: Enum-Import
import static com.tutego.eigeneKlassenSchreiben.Radio.Modulation.*; // Lösung 3: statischer Import
//Lösung 3: da Enum Konstanten implizit static und final sind, ist ein statischer Import notwendig, um nur AM/FM angeben zu müssen

public class Application {

    public static void main(String[] args) {
        Radio grandmasOldRadio = new Radio();

        grandmasOldRadio.on();
        grandmasOldRadio.volumeUp();

        System.out.println("Current volume: " + grandmasOldRadio.getVolume());

        // Aufgabe 7.1.1 AM-FM-MODULATIONEN IN DEN RADIO-TYP SETZEN
        //grandmasOldRadio.setModulation(Radio.Modulation.AM); // Lösung 1: Vollständige Qualifizierung
        //grandmasOldRadio.setModulation(Modulation.AM); // Lösung 2: Enum-Import (siehe dazu Importdeklaration oben)
        grandmasOldRadio.setModulation(AM); // Lösung 3: statischer Import (siehe dazu Importdeklaration oben)


    }

}

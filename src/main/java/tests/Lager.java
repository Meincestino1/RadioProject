package tests;

import java.util.ArrayList;
import java.util.List;

public class Lager<T> {

    private final List<T> elements = new ArrayList<>();

    public void einlagern(T element) {
        elements.add(element);
    }

    public T entnehmen() {
        if (!elements.isEmpty()) {
            return elements.remove(elements.size() - 1);
        }
        return null;
    }

    public List<T> getAlle() {
        return new ArrayList<>(elements); // Gibt eine Kopie der Liste zurück
    }

    // Methode, um alle Elemente im Lager anzuzeigen
    public void zeigeAlle() {
        if (elements.isEmpty()) {
            System.out.println("Das Lager ist leer.");
        } else {
            for (T element : elements) {
                System.out.println(element);
            }
        }
    }
}

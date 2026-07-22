package photoManagementSystem;

import java.io.File;
import java.io.IOException;

public class PhotoManagerApp {

    public static void main(String[] args) {
        try {
            // Der Pfad zum Ordner mit den Fotos
            String folderPath = "C:\\Users\\Micha\\Desktop\\Testpicks"; // Beispiel: "C:\\Users\\Micha\\Pictures\\Fotos"

            // Alle Fotos im Ordner einlesen
            File folder = new File(folderPath);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("Der angegebene Ordner existiert nicht oder ist kein Verzeichnis.");
                return;
            }

            // Alle Bilddateien im Ordner finden
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));
            if (files != null && files.length > 0) {
                for (File file : files) {
                    try {
                        // Foto einlesen und Metadaten extrahieren
                        Photo photo = PhotoManager.loadPhoto(file.getAbsolutePath());

                        // Metadaten des Fotos ausgeben
                        System.out.println("Details für Foto: " + file.getName());
                        photo.printDetails();  // Details aus dem Photo-Objekt ausgeben
                    } catch (IOException e) {
                        System.out.println("Fehler beim Einlesen des Fotos " + file.getName() + ": " + e.getMessage());
                    }
                }
            } else {
                System.out.println("Es wurden keine Bilder im Ordner gefunden.");
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}

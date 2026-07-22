package photoManagementSystem;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.ExifIFD0Directory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MetadataExtractor {

    // Methode zum Einlesen eines Fotos und Extrahieren aller verfügbaren Metadaten
    public static Metadata extractMetadata(File imageFile) {
        try {
            return ImageMetadataReader.readMetadata(imageFile);
        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Methode zum Extrahieren des Aufnahmedatums aus den Metadaten
    public static LocalDate extractDateTaken(Metadata metadata) {
        if (metadata != null) {
            // Iteriere durch alle Verzeichnisse, die in den Metadaten enthalten sind
            for (Directory directory : metadata.getDirectories()) {
                // Prüfe, ob das Verzeichnis vom Typ ExifSubIFDDirectory ist
                if (directory instanceof ExifSubIFDDirectory) {
                    ExifSubIFDDirectory subIFDDirectory = (ExifSubIFDDirectory) directory;
                    String dateStr = subIFDDirectory.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
                    if (dateStr != null) {
                        try {
                            // Datum in LocalDate umwandeln
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
                            return LocalDate.parse(dateStr, formatter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    // Methode zum Extrahieren des Kameramodells aus den Metadaten
    public static String extractCameraModel(Metadata metadata) {
        if (metadata != null) {
            // Iteriere durch alle Verzeichnisse
            for (Directory directory : metadata.getDirectories()) {
                // Prüfe, ob das Verzeichnis vom Typ ExifIFD0Directory ist
                if (directory instanceof ExifIFD0Directory) {
                    ExifIFD0Directory exifIFD0Directory = (ExifIFD0Directory) directory;
                    return exifIFD0Directory.getString(ExifIFD0Directory.TAG_MODEL);
                }
            }
        }
        return "Unbekannt";
    }

    // Methode zum Auslesen der Metadaten und Ausgabe
    public static void printMetadata(Metadata metadata) {
        if (metadata != null) {
            // Iteriere durch alle Verzeichnisse
            for (Directory directory : metadata.getDirectories()) {
                System.out.println("Metadaten aus dem Verzeichnis: " + directory.getClass().getSimpleName());

                // Alle Tags ausgeben
                directory.getTags().forEach(tag -> System.out.println(tag.getTagName() + ": " + tag.getDescription()));
            }
        }
    }
}

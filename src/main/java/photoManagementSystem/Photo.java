package photoManagementSystem;

import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.ExifIFD0Directory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Photo {
    private String filename;
    private LocalDate dateTaken;
    private String cameraModel;
    private String resolution;

    public Photo(String filename, Metadata metadata) {
        this.filename = filename;
        extractMetadata(metadata);
    }

    private void extractMetadata(Metadata metadata) {
        if (metadata != null) {
            this.dateTaken = extractDateTaken(metadata);
            this.cameraModel = extractCameraModel(metadata);
            this.resolution = extractResolution(metadata);
        }
    }

    private LocalDate extractDateTaken(Metadata metadata) {
        for (com.drew.metadata.Directory directory : metadata.getDirectories()) {
            if (directory instanceof ExifSubIFDDirectory) {
                ExifSubIFDDirectory subIFDDirectory = (ExifSubIFDDirectory) directory;
                String dateStr = subIFDDirectory.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
                if (dateStr != null) {
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
                        return LocalDate.parse(dateStr, formatter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private String extractCameraModel(Metadata metadata) {
        for (com.drew.metadata.Directory directory : metadata.getDirectories()) {
            if (directory instanceof ExifIFD0Directory) {
                ExifIFD0Directory ifd0Directory = (ExifIFD0Directory) directory;
                return ifd0Directory.getString(ExifIFD0Directory.TAG_MODEL);
            }
        }
        return "Unbekannt";
    }

    private String extractResolution(Metadata metadata) {
        // Implementiere die Auflösungsextraktion hier
        return "Unbekannt";
    }

    public String getFilename() {
        return filename;
    }

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public String getResolution() {
        return resolution;
    }

    public void printDetails() {
        System.out.println("Dateiname: " + filename);
        System.out.println("Aufnahmedatum: " + dateTaken);
        System.out.println("Kameramodell: " + cameraModel);
        System.out.println("Auflösung: " + resolution);
    }

    public void rename(String newName) {
        this.filename = newName;
    }
}

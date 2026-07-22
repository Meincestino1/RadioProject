package photoManagementSystem;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

import java.io.File;
import java.io.IOException;

public class PhotoManager {

    // Methode zum Einlesen eines Fotos und Erstellen des Photo-Objekts
    public static Photo loadPhoto(String filePath) throws IOException {
        File imageFile = new File(filePath);
        Metadata metadata = extractMetadata(imageFile);
        return new Photo(imageFile.getName(), metadata);
    }

    private static Metadata extractMetadata(File imageFile) {
        try {
            return ImageMetadataReader.readMetadata(imageFile);
        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

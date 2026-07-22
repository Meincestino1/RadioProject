package photoManagementSystem;

import java.util.Comparator;

public class PhotoDateComparator implements Comparator<Photo> {

    @Override
    public int compare(Photo p1, Photo p2) {
        return p1.getDateTaken().compareTo(p2.getDateTaken());
    }
}

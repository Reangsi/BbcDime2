package bbcag.ch.dime.dal;

import java.util.ArrayList;
import java.util.List;
import bbcag.ch.dime.model.Gallery;

public class GalleryDao {

    public static List<Gallery> getAll() {
        List<Gallery> availableBadis = new ArrayList<>();
        availableBadis.add(new Gallery(71, "Schwimmbad", "Aarberg", "BE"));
        availableBadis.add(new Gallery(27, "Schwimmbad Gruebi", "Adelboden", "BE"));
        availableBadis.add(new Gallery(6, "Stadtberner Baeder", "Bern", "BE"));
        availableBadis.add(new Gallery(55, "Zürichsee", "", "ZH"));

        return availableBadis;
    }
}

package bbcag.ch.dime.helper;

import android.media.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import bbcag.ch.dime.model.Gallery;

public class ImagesJsonParser {

    public static Gallery createBadiFromJsonString(String badiJsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(badiJsonString);
        return createImageFromJsonObject(jsonObject);
    }

    public static List<Gallery> createBadisFromJsonString(String badiJsonString) throws JSONException {
        JSONArray jsonArray = new JSONArray(badiJsonString);
        List<Gallery> badis = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            badis.add(createImageFromJsonObject(jsonArray.getJSONObject(i)));
        }
        Collections.sort(badis, new Comparator<Gallery>() {
            @Override
            public int compare(Gallery o1, Gallery o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return badis;
    }

    private static Gallery createImageFromJsonObject(JSONObject jsonObject) throws JSONException {
        Gallery gallery = new Gallery();
        gallery.setName(jsonObject.getString("imagename"));
        gallery.setDate(jsonObject.getString("date"));
        return gallery;
    }
}
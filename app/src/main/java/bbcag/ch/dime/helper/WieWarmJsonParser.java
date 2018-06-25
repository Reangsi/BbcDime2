package bbcag.ch.dime.helper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import bbcag.ch.dime.model.Editor;
import bbcag.ch.dime.model.Gallery;

public class WieWarmJsonParser {
    public static Gallery createBadiFromJsonString(String badiJsonString) throws JSONException {
        Gallery badi = new Gallery();
        JSONObject jsonObj = new JSONObject(badiJsonString);
        badi.setId(Integer.parseInt(jsonObj.getString("badid")));
        badi.setName(jsonObj.getString("badname"));
        badi.setKanton(jsonObj.getString("kanton"));
        badi.setOrt(jsonObj.getString("ort"));
        JSONObject beckenJson = jsonObj.getJSONObject("becken");
        Iterator keys = beckenJson.keys();
        while (keys.hasNext()) {
            Editor becken = new Editor();
            String key = (String) keys.next();
            JSONObject subObj = beckenJson.getJSONObject(key);
            becken.setName(subObj.getString("beckenname"));
            becken.setTemperature(Double.parseDouble(subObj.getString("temp")));
            badi.addBecken(becken);
        }
        return badi;
    }
}
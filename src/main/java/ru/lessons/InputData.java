package ru.lessons;

import java.util.HashMap;

public class InputData {
    protected static HashMap createJSONObjectTSC() {
        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("instrument_id", "TCS_SPBXM");
        jsonObject.put("sec_name", "TCS");
        jsonObject.put("sec_type", "equity");
        jsonObject.put("price_alert", 17);
        return jsonObject;
    }
    protected static HashMap createJSONObjectFail() {
        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("instrument_id", "none");
        jsonObject.put("sec_name", "TCS");
        jsonObject.put("sec_type", "equity");
        jsonObject.put("price_alert", 47);
        return jsonObject;
    }
    protected static HashMap createJSONObjectGetId() {
        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("instrument_id", "LKOH_TQBR");
        jsonObject.put("sec_name", "LKOH");
        jsonObject.put("sec_type", "equity");
        jsonObject.put("price_alert", 47);
        return jsonObject;
    }
}
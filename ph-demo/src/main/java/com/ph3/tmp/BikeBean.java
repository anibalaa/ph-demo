package com.ph3.tmp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BikeBean {

    private static Map<String, String> BIKE_INFO;
    static {
        BIKE_INFO = Collections.synchronizedMap(new HashMap<String, String>());
        BIKE_INFO.put("", "");
        BIKE_INFO.put("10", "10");
        BIKE_INFO.put("6", "6");
    }

    public String[] getDesignerInfo() {
        return BIKE_INFO.keySet().toArray(new String[] {});
    }

    public static Map<String, String> getBikeInfo() {
        return BIKE_INFO;
    }
}

package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.Map;

public class Player {

    static final String VERSION = "0.0.1";


    public static int betRequest(JsonElement request) {
        Map<String,Object> result = new Gson().fromJson(request, Map.class);
        return 50;
    }

    public static void showdown(JsonElement game) {
    }
}

package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class Player {

    static final String VERSION = "0.0.1";


    public static int betRequest(JsonElement request) {
        JsonElement root = new JsonParser().parse(request);
        return 50;
    }

    public static void showdown(JsonElement game) {
    }
}

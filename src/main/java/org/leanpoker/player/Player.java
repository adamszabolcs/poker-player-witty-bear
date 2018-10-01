package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.Map;

public class Player {

    static final String VERSION = "0.0.4";


    public static int betRequest(JsonElement request) {
        Map<String,Object> result = new Gson().fromJson(request, Map.class);
        Double currentBuyIn = (Double) result.get("current_buy_in");
        System.err.println(result.get("players"));
        return currentBuyIn.intValue() + 50;
    }

    public static void showdown(JsonElement game) {
        Map<String,Object> result = new Gson().fromJson(game, Map.class);
    }
}

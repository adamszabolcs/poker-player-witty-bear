package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "nullapontegypontketto";


    public static int betRequest(JsonElement request) {
        JsonObject object = request.getAsJsonObject();
        JsonArray players = object.getAsJsonArray("players");
        for (JsonElement player: players){
            if (player.getAsJsonObject().get("name").getAsString().equals("Witty Bear") && player.getAsJsonObject().get("hole_cards").getAsJsonArray().size() == 2){
                JsonArray playerHand = player.getAsJsonObject().get("hole_cards").getAsJsonArray();
                if (playerHand.get(0).getAsJsonObject().get("rank").equals(playerHand.get(1).getAsJsonObject().get("rank"))) {
                    return player.getAsJsonObject().get("stack").getAsInt();
                }
            }
            System.err.println("\n Player: " + player + "\n");
        }
        int currentBuyIn = object.getAsJsonObject().get("current_buy_in").getAsInt();


        return 0;
    }

    public static void showdown(JsonElement game) {
        Map<String,Object> result = new Gson().fromJson(game, Map.class);
    }
}

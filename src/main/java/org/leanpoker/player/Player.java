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
            JsonArray playerHand = player.getAsJsonObject().get("hole_cards").getAsJsonArray();
            if (player.getAsJsonObject().get("name").getAsString().equals("Player 1") && playerHand.size() == 2){
                System.err.println("\nPlayer hand: " + player.getAsJsonObject().get("hole_cards") + "\n\n");
                if (playerHand.get(0).getAsJsonObject().get("rank").equals(playerHand.get(1).getAsJsonObject().get("rank"))) {
                    int stack = (int) player.getAsJsonObject().get("stack").getAsInt();
                    return stack;
                }
            }
        }
        int currentBuyIn = (int) object.getAsJsonObject().get("current_buy_in").getAsInt();


        return currentBuyIn + 50;
    }

    public static void showdown(JsonElement game) {
        Map<String,Object> result = new Gson().fromJson(game, Map.class);
    }
}

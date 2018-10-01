package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "nullapontkettopontegy";


    public static int betRequest(JsonElement request) {
        JsonObject object = request.getAsJsonObject();
        int currentBuyIn = object.getAsJsonObject().get("current_buy_in").getAsInt();
        JsonArray players = object.getAsJsonArray("players");
        for (JsonElement player: players){
            if (player.getAsJsonObject().get("name").getAsString().equals("Witty Bear") && player.getAsJsonObject().get("hole_cards").getAsJsonArray().size() == 2){
                JsonArray playerHand = player.getAsJsonObject().get("hole_cards").getAsJsonArray();
                if (playerHand.get(0).getAsJsonObject().get("rank").equals(playerHand.get(1).getAsJsonObject().get("rank"))) {
                    return player.getAsJsonObject().get("stack").getAsInt();
                }
                JsonArray communityCards = object.getAsJsonArray("community_cards");
                for (JsonElement cardInHand : playerHand) {
                    for (JsonElement cardDown : communityCards) {
                        if (cardInHand.getAsJsonObject().get("rank").equals(cardDown.getAsJsonObject().get("rank"))) {
                            currentBuyIn += 50;
                        }
                    }
                }
                if (currentBuyIn >= player.getAsJsonObject().get("stack").getAsInt()) {
                    currentBuyIn = 0;
                }
            }
            System.err.println("\n Player: " + player + "\n");
        }
        return currentBuyIn;
    }

    public static void showdown(JsonElement game) {
        Map<String,Object> result = new Gson().fromJson(game, Map.class);
    }
}

package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Game {

  protected Map<String, Integer> players = new HashMap<>();

  public void register(Player player) {
    players.put(player.name, player.strength);
  }

  public int round(String playerName1, String playerName2) {
    String player1 = null;
    String player2 = null;

    for (String ignored : players.keySet()) {
      if (players.containsKey(playerName1)) {
        player1 = playerName1;
      }
      if (players.containsKey(playerName2)) {
        player2 = playerName2;
      }
    }
    if (player1 == null) {
      throw new NotRegisteredException(
              "Игрок " + playerName1 + " не зарегистрирован"
      );
    }

    if (player2 == null) {
      throw new NotRegisteredException(
              "Игрок " + playerName2 + " не зарегистрирован"
      );
    }

    if (players.get(player1).intValue() == players.get(player2).intValue()) {
      return 0;
    }

    if (players.get(player1) > players.get(player2)) {
      return 1;
    } else {
      return 2;
    }
  }

  public Map<String, Integer> getAllPlayers() {
    return players;
  }
}

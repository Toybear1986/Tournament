package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GameTest {
  Player player1 = new Player("Vasya", 100);
  Player player2 = new Player("Kolya", 50);
  Player player3 = new Player("Kostya", 75);
  Player player4 = new Player( "Olya", 50);
  Player player5 = new Player("Vanya", 75);
  Player player6 = new Player("Nastya", 25);

  @Test
  public void testAddPlayer() {
    Game game = new Game();
    game.register(player1);
    game.register(player2);
    game.register(player3);
    game.register(player4);
    game.register(player5);
    game.register(player6);

    Map<String, Integer> actual = game.getAllPlayers();
    Map<String, Integer> expected = new HashMap<>();
    expected.put("Vasya",100);
    expected.put("Kolya", 50);
    expected.put("Kostya", 75);
    expected.put("Olya", 50);
    expected.put("Vanya", 75);
    expected.put("Nastya", 25);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testThrowExceptionForPlayer2() {
    Game game = new Game();
    game.register(player1);

    Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Vasya", "Olya"));
  }

  @Test
  public void testThrowExceptionForPlayer1() {
    Game game = new Game();
    game.register(player4);

    Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Vasya", "Olya"));
  }

  @Test
  public void testGameRoundWinPlayer1() {
    Game game = new Game();
    game.register(player1);
    game.register(player4);

    int expectedWinPlayer1 = 1;
    Assertions.assertEquals(expectedWinPlayer1, game.round("Vasya", "Olya"));
  }

  @Test
  public void testGamesRoundWithDrawResult() {
    Game game = new Game();
    game.register(player2);
    game.register(player4);

    int expectedDrawResult = 0;
    Assertions.assertEquals(expectedDrawResult, game.round("Kolya", "Olya"));
  }

  @Test
  public void testGameRoundWinPlayer2() {
    Game game = new Game();
    game.register(player1);
    game.register(player4);

    int expectedWinPlayer1 = 2;
    Assertions.assertEquals(expectedWinPlayer1, game.round("Olya", "Vasya"));
  }
}

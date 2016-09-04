package com.ekchang.tictactoe.model;

/**
 * A Player in the game.
 */
public class Player {

  public final String name;
  public final char piece;

  /**
   * Constructor.
   *
   * @param name the player's name
   * @param piece the character that represents the player's piece on the board
   */
  public Player(String name, char piece) {
    this.name = name;
    this.piece = piece;
  }

  /**
   * Builder for the Player.
   */
  public static class PlayerBuilder {
    private String name;
    private char piece;

    public PlayerBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public PlayerBuilder setPiece(char piece) {
      this.piece = piece;
      return this;
    }

    public Player buildPlayer() {
      return new Player(name, piece);
    }
  }
}

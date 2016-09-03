package com.ekchang.tictactoe.model;

public class Player {

  public final String name;
  public final char piece;

  public Player(String name, char piece) {
    this.name = name;
    this.piece = piece;
  }

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

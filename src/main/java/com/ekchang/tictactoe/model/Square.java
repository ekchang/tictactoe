package com.ekchang.tictactoe.model;

import static com.ekchang.tictactoe.util.Printer.showf;

/**
 * Represents a single tile on the board.
 */
public class Square {
  char square = ' ';

  public Square() {
  }

  public boolean markSquare(char piece) {
    if (square == ' ') {
      square = piece;
      return true;
    } else {
      showf("Cannot set piece to '%s', already set to '%s'\n", piece, square);
      return false;
    }
  }

  public char getSquare() {
    return square;
  }

  @Override public String toString() {
    return String.valueOf(square);
  }
}

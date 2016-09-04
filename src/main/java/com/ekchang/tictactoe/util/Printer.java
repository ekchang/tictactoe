package com.ekchang.tictactoe.util;

import com.ekchang.tictactoe.model.Player;

/**
 * Convenience console logger to show commonly reused elements in the game. Or just to avoid writing
 * System.out.print everywhere.
 */
public final class Printer {
  private Printer() {
  }

  /**
   * Essentially System.out.printf
   *
   * @param format the String format to print to console
   * @param args the arguments to be formatted
   */
  public static void showf(String format, Object... args) {
    System.out.printf(format, args);
  }

  /**
   * Essentially System.out.println for String input
   *
   * @param input the String to print to console
   */
  public static void show(String input) {
    System.out.println(input);
  }

  /**
   * Line break on console.
   */
  public static void lineBreak() {
    System.out.println();
  }

  /**
   * Show a line separator with hash symbols of fixed length.
   */
  public static void showLine() {
    show("##################################");
  }

  /**
   * Show vertical ellipses to create a gap in console.
   */
  public static void showEllipse() {
    show("\n.\n.\n.\n");
  }

  /**
   * Show the Stalemate message when the game is over.
   */
  public static void showStalemate() {
    show("Stalemate!");
    showLine();
    lineBreak();
  }

  /**
   * Show the winner of the game when the game is over.
   *
   * @param player the player who won that we want to celebrate
   */
  public static void showWinner(Player player) {
    showf("%s wins!\n", player.name);
  }
}

package com.ekchang.tictactoe.util;

import com.ekchang.tictactoe.model.Player;

public final class Printer {
  private Printer() {
  }

  public static void showf(String format, Object... args) {
    System.out.printf(format, args);
  }

  public static void show(String input) {
    System.out.println(input);
  }

  public static void lineBreak() {
    System.out.println();
  }

  public static void showLine() {
    show("##################################");
  }

  public static void showEllipse() {
    lineBreak();
    show(".\n.\n.");
    lineBreak();
  }

  public static void showStalemate() {
    show("Stalemate!");
    showLine();
    lineBreak();
  }

  public static void showWinner(Player player) {
    showf("%s wins!\n", player.name);
  }
}

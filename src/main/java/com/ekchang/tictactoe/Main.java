package com.ekchang.tictactoe;

import java.util.Scanner;

import static com.ekchang.tictactoe.TicTacToe.Builder.buildGameWithDefaults;
import static com.ekchang.tictactoe.TicTacToe.CONSOLE_INPUT;
import static com.ekchang.tictactoe.util.Printer.lineBreak;
import static com.ekchang.tictactoe.util.Printer.show;
import static com.ekchang.tictactoe.util.Printer.showf;

public class Main {
  private Main() {
  }

  public static void main(String[] args) {
    showFancyTitle();
    Scanner scanner = new Scanner(System.in);
    TicTacToe ticTacToe = askCustomGame(scanner)
        ? makeCustomBoard(scanner)
        : buildGameWithDefaults();

    ticTacToe.startGame();
  }

  private static void showFancyTitle() {
    show(
        "      ___                   ___                 ___         ___         ___                 ___         ___         ___     \n"
            + "     /\\  \\        ___      /\\  \\               /\\  \\       /\\  \\       /\\  \\               /\\  \\       /\\  \\       /\\  \\    \n"
            + "     \\:\\  \\      /\\  \\    /::\\  \\              \\:\\  \\     /::\\  \\     /::\\  \\              \\:\\  \\     /::\\  \\     /::\\  \\   \n"
            + "      \\:\\  \\     \\:\\  \\  /:/\\:\\  \\              \\:\\  \\   /:/\\:\\  \\   /:/\\:\\  \\              \\:\\  \\   /:/\\:\\  \\   /:/\\:\\  \\  \n"
            + "      /::\\  \\    /::\\__\\/:/  \\:\\  \\             /::\\  \\ /::\\~\\:\\  \\ /:/  \\:\\  \\             /::\\  \\ /:/  \\:\\  \\ /::\\~\\:\\  \\ \n"
            + "     /:/\\:\\__\\__/:/\\/__/:/__/ \\:\\__\\           /:/\\:\\__/:/\\:\\ \\:\\__/:/__/ \\:\\__\\           /:/\\:\\__/:/__/ \\:\\__/:/\\:\\ \\:\\__\\\n"
            + "    /:/  \\/__/\\/:/  /  \\:\\  \\  \\/__/          /:/  \\/__\\/__\\:\\/:/  \\:\\  \\  \\/__/          /:/  \\/__\\:\\  \\ /:/  \\:\\~\\:\\ \\/__/\n"
            + "   /:/  /    \\::/__/    \\:\\  \\               /:/  /         \\::/  / \\:\\  \\               /:/  /     \\:\\  /:/  / \\:\\ \\:\\__\\  \n"
            + "   \\/__/      \\:\\__\\     \\:\\  \\              \\/__/          /:/  /   \\:\\  \\              \\/__/       \\:\\/:/  /   \\:\\ \\/__/  \n"
            + "               \\/__/      \\:\\__\\                           /:/  /     \\:\\__\\                          \\::/  /     \\:\\__\\    \n"
            + "                           \\/__/                           \\/__/       \\/__/                           \\/__/       \\/__/    ");
    lineBreak();
    lineBreak();
  }

  public static boolean askCustomGame(Scanner scanner) {
    show("Custom game settings or classic tic-tac-toe? (Enter 'custom' or anything for default)");
    showf(CONSOLE_INPUT);
    return scanner.next().toLowerCase().equals("custom");
  }

  public static TicTacToe makeCustomBoard(Scanner scanner) {
    int numPlayers;
    numPlayers = getNumPlayers(scanner);

    show("Enter board size.");
    int width = getDimension(scanner, "Width");
    int height = getDimension(scanner, "Height");
    int winCondition = getWinCondition(scanner);

    return TicTacToe.Builder.builder()
        .setPlayers(numPlayers)
        .setWidth(width)
        .setHeight(height)
        .setWinCondition(winCondition)
        .build();
  }

  private static int getNumPlayers(Scanner scanner) {
    int numPlayers;
    do {
      showf("Enter number of players: ");
      numPlayers = scanner.nextInt();

      if (numPlayers < 2) {
        show("I'm sorry, the minimum number of players is 2. Enter number of players: ");
      }
    } while (numPlayers <= 1);
    return numPlayers;
  }

  private static int getDimension(Scanner scanner, String dimension) {
    int value;
    do {
      showf("%s: ", dimension);
      value = scanner.nextInt();
      if (value < 1) {
        showf("I'm sorry, the %s cannot be less than 1.\n", dimension);
      }
    } while (value <= 0);
    return value;
  }

  private static int getWinCondition(Scanner scanner) {
    int winCondition;
    do {
      showf("Enter # in a row to win: ");
      winCondition = scanner.nextInt();

      if (winCondition < 3) {
        show("I'm sorry, the win condition cannot be less than 3. Enter the # of rows to win: ");
      }
    } while (winCondition < 3);
    return winCondition;
  }
}

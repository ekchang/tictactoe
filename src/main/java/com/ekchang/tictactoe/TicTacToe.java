package com.ekchang.tictactoe;

import com.ekchang.tictactoe.model.Board;
import com.ekchang.tictactoe.model.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ekchang.tictactoe.model.Board.DEFAULT_BOARD_HEIGHT;
import static com.ekchang.tictactoe.model.Board.DEFAULT_BOARD_WIDTH;
import static com.ekchang.tictactoe.model.Board.DEFAULT_NUM_PLAYERS;
import static com.ekchang.tictactoe.model.Board.DEFAULT_WIN_CONDITION;
import static com.ekchang.tictactoe.util.Printer.lineBreak;
import static com.ekchang.tictactoe.util.Printer.show;
import static com.ekchang.tictactoe.util.Printer.showEllipse;
import static com.ekchang.tictactoe.util.Printer.showLine;
import static com.ekchang.tictactoe.util.Printer.showf;

public class TicTacToe {
  public static final int MIN_PLAYERS = 2;
  public static final int MIN_BOARD_WIDTH = 1;
  public static final int MIN_BOARD_HEIGHT = 1;
  public static final int MIN_WIN_CONDITION = 3;
  public static final String CONSOLE_INPUT = "> ";

  private final int numPlayers;
  private final Board board;
  private final List<Player> players;
  private final Scanner scanner;

  public TicTacToe(int numPlayers, Board board, Scanner scanner, List<Player> players) {
    this.numPlayers = numPlayers;
    this.board = board;
    this.scanner = scanner;
    this.players = players;
  }

  private String getInput() {
    showf(CONSOLE_INPUT);
    return scanner.next();
  }

  private int getBoardInput() {
    return scanner.nextInt();
  }

  private char getSingleCharInput() {
    showf(CONSOLE_INPUT);
    return scanner.next().charAt(0);
  }

  public void startGame() {
    show("Starting game...");
    boolean play = true;
    while (play) {
      reset();

      lineBreak();
      showf("Players: %d\n", numPlayers);
      showf("Board: %d x %d\n", board.getWidth(), board.getHeight());
      lineBreak();

      initPlayers();

      show("Start game!");
      showEllipse();
      while (!board.gameOver()) {
        showf("Turn %d\n", board.getNumTurns() + 1);
        showLine();
        lineBreak();
        board.showBoard();
        lineBreak();
        Player player = nextPlayer();
        showf("%s's turn.\n", player.name);

        int row;
        int column;

        do {
          showf("Row: ");
          row = getBoardInput();
          showf("Column: ");
          column = getBoardInput();
          lineBreak();
        } while (!board.takeTurn(row, column, player));
      }

      board.showBoard();
      showEllipse();
      show("Game over! Play again? (y/n)");

      char input = getSingleCharInput();
      while (input != 'y' && input != 'n') {
        show("I'm sorry, could you repeat that? (y/n)");
        input = getSingleCharInput();
      }
      play = input == 'y';
    }

    show("Goodbye. Thanks for playing.");
  }

  private void initPlayers() {
    for (int i = 0; i < numPlayers; i++) {
      Player.PlayerBuilder builder = new Player.PlayerBuilder();

      showf("Enter Player %d's name: \n", i + 1);
      builder.setName(getInput());

      showf("Enter their piece letter (eg. x, o, or other): \n");
      builder.setPiece(getSingleCharInput());

      Player player = builder.buildPlayer();
      players.add(player);
      showf("%s was successfully registered.\n", player.name);
      showLine();
      lineBreak();
      lineBreak();
    }
  }

  private void reset() {
    players.clear();
    board.reset();
  }

  private Player nextPlayer() {
    return players.get(board.getNumTurns() % players.size());
  }

  static class Builder {
    private int numPlayers;
    private int width;
    private int height;
    private int winCondition;

    static Builder builder() {
      return new Builder();
    }

    public static TicTacToe buildGameWithDefaults() {
      return builder()
          .setPlayers(DEFAULT_NUM_PLAYERS)
          .setWidth(DEFAULT_BOARD_WIDTH)
          .setHeight(DEFAULT_BOARD_HEIGHT)
          .setWinCondition(DEFAULT_WIN_CONDITION)
          .build();
    }

    Builder setPlayers(int numPlayers) {
      if (numPlayers < MIN_PLAYERS) {
        throw new IllegalArgumentException("Number of players in game cannot be less than 2");
      }

      this.numPlayers = numPlayers;
      return this;
    }

    Builder setWidth(int width) {
      if (width < MIN_BOARD_WIDTH) {
        throw new IllegalArgumentException("Width cannot be less than 1");
      }

      this.width = width;
      return this;
    }

    Builder setHeight(int height) {
      if (height < MIN_BOARD_HEIGHT) {
        throw new IllegalArgumentException("Height cannot be less than 1");
      }

      this.height = height;
      return this;
    }

    Builder setWinCondition(int winCondition) {
      if (winCondition < MIN_WIN_CONDITION) {
        throw new IllegalArgumentException("Win condition cannot be less than 3");
      }

      this.winCondition = winCondition;
      return this;
    }

    TicTacToe build() {
      if (winCondition == 0) {
        winCondition = DEFAULT_WIN_CONDITION;
      }
      return new TicTacToe(numPlayers,
          Board.makeBoard(width, height, winCondition),
          new Scanner(System.in),
          new ArrayList<>());
    }
  }
}

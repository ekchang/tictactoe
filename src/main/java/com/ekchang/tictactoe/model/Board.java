package com.ekchang.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

import static com.ekchang.tictactoe.util.Printer.lineBreak;
import static com.ekchang.tictactoe.util.Printer.show;
import static com.ekchang.tictactoe.util.Printer.showStalemate;
import static com.ekchang.tictactoe.util.Printer.showWinner;
import static com.ekchang.tictactoe.util.Printer.showf;

public class Board {
  public static final int DEFAULT_BOARD_WIDTH = 3;
  public static final int DEFAULT_BOARD_HEIGHT = 3;
  public static final int DEFAULT_NUM_PLAYERS = 2;
  public static final int DEFAULT_WIN_CONDITION = 3;

  private final int width;
  private final int height;
  private final int winCondition;
  private boolean isGameOver;
  private int numTurns;
  private final List<List<Square>> grid;

  public Board(int width, int height, List<List<Square>> grid, int winCondition) {
    this.width = width;
    this.height = height;
    this.grid = grid;
    this.winCondition = winCondition;
  }

  public static Board makeBoard(int width, int height, int winCondition) {
    return new Board(width,
        height,
        makeGrid(width, height),
        winCondition);
  }

  private static List<List<Square>> makeGrid(int width, int height) {
    List<List<Square>> grid = new ArrayList<>(height);
    for (int i = 0; i < height; i++) {
      List<Square> row = new ArrayList<>();
      for (int j = 0; j < width; j++) {
        row.add(new Square());
      }
      grid.add(row);
    }

    return grid;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getNumTurns() {
    return numTurns;
  }

  public boolean gameOver() {
    return isGameOver;
  }

  private Square squareAt(int row, int column) {
    return grid.get(row).get(column);
  }

  public void showBoard() {
    showf(" ");
    for (int i = 0; i < width; i++) {
      showf(" %d  ", i);
    }
    lineBreak();

    for (int i = 0; i < grid.size(); i++) {
      List<Square> row = grid.get(i);
      for (int j = 0; j < row.size(); j++) {
        Square column = row.get(j);
        if (j == 0) {
          showf("%d %s |", i, column);
        } else if (j < row.size() - 1) {
          showf(" %s |", column);
        } else {
          showf(" %s\n", column);
        }
      }

      if (i < grid.size() - 1) {
        showf(" ");
        showf(new String(new char[width - 1]).replace("\0", "----"));
        show("---");
      }
    }
  }

  public boolean takeTurn(int row, int column, Player player) {
    if (row < 0 || row >= height) {
      showf("Row cannot be less than 0 or greater than %d\n", height - 1);
      return false;
    }

    if (column < 0 || column >= width) {
      showf("Column cannot be less than 0 or greater than %d\n", column - 1);
      return false;
    }

    boolean markSquare = grid.get(row).get(column).markSquare(player.piece);
    isGameOver = checkGameOver(row, column, player);
    if (markSquare) {
      numTurns++;
    }
    return markSquare;
  }

  private boolean checkGameOver(int row, int column, Player player) {
    if (checkVertical(row, column, player)
        || checkHorizontal(row, column, player)
        || checkDiagonal(row, column, player)) {
      showWinner(player);
      return true;
    }
    if (checkStalemate()) {
      showStalemate();
      return true;
    }

    return false;
  }

  private boolean checkStalemate() {
    return numTurns >= width * height - 1;
  }

  private boolean checkVertical(int row, int column, Player player) {
    int countVertical = 0;

    int minRow = Math.max(0, row - winCondition + 1);
    int maxRow = Math.min(height - 1, row + winCondition - 1);
    for (int i = minRow; i <= maxRow; i++) {
      if (squareAt(i, column).getSquare() == player.piece) {
        countVertical++;
        if (countVertical == winCondition) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean checkHorizontal(int row, int column, Player player) {
    int countHorizontal = 0;

    int minCol = Math.max(0, column - winCondition + 1);
    int maxCol = Math.min(width - 1, column + winCondition - 1);

    for (int j = minCol; j <= maxCol; j++) {
      if (squareAt(row, j).getSquare() == player.piece) {
        countHorizontal++;
      }
      if (countHorizontal == winCondition) {
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonal(int row, int column, Player player) {
    int countDiagonal = 0;

    int minRow = Math.max(0, row - winCondition + 1);
    int maxRow = Math.min(height - 1, row + winCondition - 1);
    int minCol = Math.max(0, column - winCondition + 1);
    int maxCol = Math.min(width - 1, column + winCondition - 1);

    int i = minRow;
    int j = minCol;

    // top left to bottom right
    while (i <= maxRow && j <= maxCol) {
      if (squareAt(i, j).getSquare() == player.piece) {
        countDiagonal++;
      }

      if (countDiagonal == winCondition) {
        return true;
      }

      i++;
      j++;
    }

    // top right to bottom left
    i = minRow;
    j = maxCol;
    countDiagonal = 0;
    while (i <= maxRow && j >= minCol) {
      if (squareAt(i, j).getSquare() == player.piece) {
        countDiagonal++;
      }

      if (countDiagonal == winCondition) {
        return true;
      }

      i++;
      j--;
    }

    return false;
  }

  public void reset() {
    numTurns = 0;
    isGameOver = false;
    grid.clear();
    grid.addAll(makeGrid(width, height));
  }
}

package Game;

import GameLogic.Board;
import GameLogic.Square;

public class Controller {

  protected boolean firstClick;
  private int starting_x, starting_y, ending_x, ending_y = -1;
  private final Game game;
  private boolean whiteTurn;

  public Controller(Game game) {
    this.firstClick = true;
    this.whiteTurn = true;
    this.game = game;
  }

  public void resetState() {
    this.firstClick = true;
    this.whiteTurn = true;
  }

  public Game getGame() {
    return this.game;
  }

  public boolean tryMove() {
    Board board = game.getBoard();
    Square startingSquare = board.getSquare(this.starting_x, this.starting_y);
    Square endingSquare = board.getSquare(this.ending_x, this.ending_y);
    if ((startingSquare.getPiece() != null) && (startingSquare.getPiece().isWhite() == this.whiteTurn)) {
      if (startingSquare.getPiece().isAllowed(board, startingSquare, endingSquare)) {
        game.executeMove(startingSquare, endingSquare);
        changeTurn();
        return true;
      }
    }
    return false;
  }

  private void changeTurn() {
    this.whiteTurn = !this.whiteTurn;
  }

  public boolean getFirstClick() {
    return this.firstClick;
  }

  public void toggleFirstClick() {
    this.firstClick = !this.firstClick;
  }

  public int getStartingX() {
    return this.starting_x;
  }

  public int getStartingY() {
    return this.starting_y;
  }

  public int getEndingX() {
    return this.ending_x;
  }

  public int getEndingY() {
    return this.ending_y;
  }

  public void setStartingCoordinates(int[] coordinates) {
    this.starting_x = coordinates[0];
    this.starting_y = coordinates[1];
  }

  public void setEndingCoordinates(int[] coordinates) {
    this.ending_x = coordinates[0];
    this.ending_y = coordinates[1];
  }
}
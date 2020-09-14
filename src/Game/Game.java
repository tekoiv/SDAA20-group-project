package Game;

import GameLogic.Board;
import GameLogic.Square;

public class Game {

  private final Board board;

  public Game() {
    board = new Board();
  }

  public Board getBoard() {
    return this.board;
  }

  public void executeMove(Square startingSquare, Square endingSquare) {
    // Kill if opponent's piece in square
    if(endingSquare.getPiece() != null) endingSquare.getPiece().kill();

    endingSquare.setPiece(startingSquare.getPiece());
    startingSquare.setPiece(null);
  }
}
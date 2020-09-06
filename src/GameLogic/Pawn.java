package GameLogic;

public class Pawn extends ChessPiece {

  private boolean startingMove = true;

  public Pawn(boolean white) {
    super(white);
  }

  @Override
  public boolean isAllowed(Board board, Square start, Square finish) {
    if (finish.getPiece() != null && finish.getPiece().isWhite() == this.isWhite()) {
      return false;
    }
    // Check for allowed moves
    return true;
  }
}

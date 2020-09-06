package GameLogic;

public abstract class ChessPiece {

  private boolean dead = false;
  private boolean white = false;

  public ChessPiece(boolean white) {
    this.white = white;
  }

  public boolean isWhite() {
    return this.white;
  }

  public boolean isDead() {
    return this.dead;
  }

  public void kill() {
    this.dead = true;
  }

  public abstract boolean isAllowed(Board board, Square start, Square finish);

}

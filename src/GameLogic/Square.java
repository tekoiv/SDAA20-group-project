package GameLogic;

public class Square {

  private ChessPiece chessPiece;
  private int x;
  private int y;

  public Square(int x, int y, ChessPiece chessPiece) {
    this.setPiece(chessPiece);
    this.set_x(x);
    this.set_y(y);
  }

  public ChessPiece getPiece() {
    return this.chessPiece;
  }

  public void setPiece(ChessPiece piece) {
    this.chessPiece = piece;
  }

  public void set_x(int x) {
    this.x = x;
  }

  public int get_x() {
    return this.x;
  }

  public void set_y(int y) {
    this.y = y;
  }

  public int get_y() {
    return this.y;
  }
}

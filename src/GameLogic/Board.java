package GameLogic;

public class Board {

  Square[][] squares;

  public Board() {
    this.initBoard();
  }

  public void initBoard() {
    this.squares = new Square[8][8];
    // Set pieces to their starting positions

    // Black pieces
    // Pawns
    for(int i = 0; i < 8; i++) {
      this.squares[i][1] = new Square(i, 1, new Pawn(false));
    }

    // White pieces
    // Pawns
    for(int i = 0; i < 8; i++) {
      this.squares[i][6] = new Square(i, 6, new Pawn(true));
    }

    // Black pieces
    // Knight
    for(int i = 1; i < 7; i+=5) {
      this.squares[i][0] = new Square(i, 0, new Knight(false));
    }

    // White pieces
    // Knight
    for(int i = 1; i < 7; i+=5) {
      this.squares[i][7] = new Square(i, 7, new Knight(true));
    }

    // Black pieces
    // King
    this.squares[4][0] = new Square(4, 0, new King(false));

    //White pieces
    // King
    this.squares[4][7] = new Square(4, 7, new King(true));
    

    // Remaining squares (with no pieces)
    for(int i = 2; i < 6; i++) {
      for(int j = 0; j < 8; j++) {
        squares[j][i] = new Square(j, i, null);
      }
    }
  }

  public Square getSquare(int x, int y) {
    return this.squares[x][y];
  }
}

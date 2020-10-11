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
    // Rooks
    this.squares[0][0] = new Square(0, 0, new Rook(false));
    this.squares[7][0] = new Square(7, 0, new Rook(false));

    // White pieces
    // Rooks
    this.squares[0][7] = new Square(0, 7, new Rook(true));
    this.squares[7][7] = new Square(7, 7, new Rook(true));

    // Black pieces
    // Bishops
    this.squares[2][0] = new Square(0, 0, new Bishop(false));
    this.squares[5][0] = new Square(7, 0, new Bishop(false));

    // White pieces
    // Bishops
    this.squares[2][7] = new Square(0, 7, new Bishop(true));
    this.squares[5][7] = new Square(7, 7, new Bishop(true));
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

    //Black Pieces
    // Queen
    this.squares[3][0] = new Square(3, 0, new Queen(false));

    //White Pieces
    // Queen
    this.squares[3][7] = new Square(3, 7, new Queen(true));


    

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

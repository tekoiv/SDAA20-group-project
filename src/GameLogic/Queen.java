package GameLogic;

public class Queen extends ChessPiece {
    
    public Queen(boolean white){
        super(white);
    }

    public Rook rookmoves = new Rook(this.isWhite());
    public Bishop bishopmoves = new Bishop(this.isWhite());

    @Override
    public boolean isAllowed(Board board, Square start, Square finish) {
        if (finish.getPiece() != null && finish.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int dist_x = Math.abs(start.get_x() - finish.get_x());
        int dist_y = Math.abs(start.get_y() - finish.get_y());

        return(rookmoves.moveRook(board, start, finish) || bishopmoves.moveBishop(board, start, finish));
        
        //return ((dist_x == 1 && dist_y == 0) || (dist_x == 0 && dist_y == 1) || (dist_x == 1 && dist_y == 1));
    }
}

  
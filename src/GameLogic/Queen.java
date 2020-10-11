package GameLogic;

public class Queen extends ChessPiece {
    
    public Queen(boolean white){
        super(white);
    }

    @Override
    public boolean isAllowed(Board board, Square start, Square finish) {
        if (finish.getPiece() != null && finish.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        System.out.println("Onko valkone" + this.isWhite());
        int dist_x = Math.abs(start.get_x() - finish.get_x());
        int dist_y = Math.abs(start.get_y() - finish.get_y());
        
        return ((dist_x == 1 && dist_y == 0) || (dist_x == 0 && dist_y == 1) || (dist_x == 1 && dist_y == 1));
    }
}

  
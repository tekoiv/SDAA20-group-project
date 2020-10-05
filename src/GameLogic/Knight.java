package GameLogic;

public class Knight extends ChessPiece {
    
    public Knight(boolean white){
        super(white);
    }

    public boolean moves (Square start, Square finish, int x, int y){
        if ((start.get_y() - finish.get_y() == y || start.get_y() - finish.get_y() == -y) && ((start.get_x() - finish.get_x() == x)||(start.get_x() - finish.get_x() == -x))) {
            return true;
          }
        else if ((start.get_x() - finish.get_x() == y || start.get_x() - finish.get_x() == -y) && ((start.get_y() - finish.get_y() == x)||(start.get_y() - finish.get_y() == -x))) {
        return true;
        }
        return false;
    }

    @Override
    public boolean isAllowed(Board board, Square start, Square finish) {

        if (finish.getPiece() != null && finish.getPiece().isWhite() == this.isWhite()) {
        return false;
        }

        // Check for allowed moves
        // White check, then black check
        if (start.getPiece().isWhite()) {
            if (finish.getPiece() == null) {
                // White knight moves
                if (moves(start, finish, 2, 1)){
                    return true;
                }
                // White knight killing
            } else {
                if(moves(start,finish,2,1)){
                    return true;
                }
            }
        } else {
            if (finish.getPiece() == null) {
                // Black knight moves
                if(moves(start,finish,2,1)){
                return true;
            }
                // Black knight killing
            } else {
                if(moves(start,finish,2,1)){
                    return true;
                }
            }
        }
        return false;
    }
}
      
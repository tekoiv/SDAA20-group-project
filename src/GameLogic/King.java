package GameLogic;

public class King extends ChessPiece {
    
    public King(boolean white){
        super(white);
    }

    public boolean moves(Square start, Square finish, int x, int y){
        // Moving forward 1 step either to up-left, forward or up-right
        if ((start.get_y() - finish.get_y() == y && ((start.get_x() - finish.get_x() == y) || (start.get_x() - finish.get_x() == x ||(start.get_x() - finish.get_x() == -y))))) {
            return true;
        }
        // Moving left or right
        else if ((start.get_y() - finish.get_y() == x && ((start.get_x() - finish.get_x() == y) || (start.get_x() - finish.get_x() == -y)))) {
        return true;
        }
        // Moving down-left, backwards, down-right
        else if ((start.get_y() - finish.get_y() == -y && ((start.get_x() - finish.get_x() == y) || (start.get_x() - finish.get_x() == x ||(start.get_x() - finish.get_x() == -y))))) {
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
                //White king moves
                if(moves(start,finish,0,1)){
                    return true;
                }
                // White king killing
            } else {
                if(moves(start,finish,0,1)){
                return true;
                }                 
            }
        } else {
            if (finish.getPiece() == null) {
                //Black king moves
                if(moves(start,finish,0,1)){
                return true;
            }
                // Black king killing
            } else {
                if(moves(start,finish,0,1)){
                    return true;
                }
            }
        }
        return false;
    }
}

      
      
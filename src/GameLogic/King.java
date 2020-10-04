package GameLogic;

public class King extends ChessPiece {

    private boolean startingMove = true;

    public King(boolean white){
        super(white);
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
                // Moving forward 1 step either to up-left, forward or up-right
                if ((start.get_y() - finish.get_y() == 1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                this.startingMove = false;
                return true;
                 }
                // Moving left or right
                if ((start.get_y() - finish.get_y() == 0 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == -1)))) {
                this.startingMove = false;
                return true;
                    }
                // Moving down-left, backwards, down-right
                if ((start.get_y() - finish.get_y() == -1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                    this.startingMove = false;
                    return true;
                        }
              // Killing
            } else {
               // Moving forward 1 step either to up-left, forward or up-right
               if ((start.get_y() - finish.get_y() == 1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                this.startingMove = false;
                return true;
                 }
                // Moving left or right
                if ((start.get_y() - finish.get_y() == 0 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == -1)))) {
                this.startingMove = false;
                return true;
                    }
                // Moving down-left, backwards, down-right
                if ((start.get_y() - finish.get_y() == -1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                    this.startingMove = false;
                    return true;
                        }
            }
          } else {
            if (finish.getPiece() == null) {
              // Normal forward moves
              if ((start.get_y() - finish.get_y() == 1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                this.startingMove = false;
                return true;
                 }
                if ((start.get_y() - finish.get_y() == 0 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == -1)))) {
                this.startingMove = false;
                return true;
                    }
                if ((start.get_y() - finish.get_y() == -1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                    this.startingMove = false;
                    return true;
                        }
              // Killing
            } else {
                if ((start.get_y() - finish.get_y() == 1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                    this.startingMove = false;
                    return true;
                     }
                    if ((start.get_y() - finish.get_y() == 0 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == -1)))) {
                    this.startingMove = false;
                    return true;
                        }
                    if ((start.get_y() - finish.get_y() == -1 && ((start.get_x() - finish.get_x() == 1) || (start.get_x() - finish.get_x() == 0 ||(start.get_x() - finish.get_x() == -1))))) {
                        this.startingMove = false;
                        return true;
                            }
            }
          }
          return false;
        }
}

      
      
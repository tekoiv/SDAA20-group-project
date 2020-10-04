package GameLogic;

public class Knight extends ChessPiece {
    
    private boolean startingMove = true;

    public Knight(boolean white){
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
              // Normal forward moves
              if ((start.get_y() - finish.get_y() == 1 || (this.startingMove && (start.get_y() - finish.get_y() == 2))) && start.get_x() - finish.get_x() == 0) {
                this.startingMove = false;
                return true;
              }
              // Killing
            } else {
              if (start.get_y() - finish.get_y() == 1 && Math.abs(start.get_x() - finish.get_x()) == 1) {
                this.startingMove = false;
                return true;
              }
            }
          } else {
            if (finish.getPiece() == null) {
              // Normal forward moves
              if ((start.get_y() - finish.get_y() == -1 || (this.startingMove && (start.get_y() - finish.get_y() == -2))) && start.get_x() - finish.get_x() == 0) {
                this.startingMove = false;
                return true;
              }
              // Killing
            } else {
              if (start.get_y() - finish.get_y() == -1 && Math.abs(start.get_x() - finish.get_x()) == 1) {
                this.startingMove = false;
                return true;
              }
            }
          }
          return false;
        }
      }
      
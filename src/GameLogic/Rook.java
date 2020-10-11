package GameLogic;


public class Rook extends ChessPiece {

  public Rook(boolean white) {
    super(white);
  }

  @Override
  public boolean isAllowed(Board board, Square start, Square finish) {
    if (finish.getPiece() != null && finish.getPiece().isWhite() == this.isWhite()) {
      return false;
    }
    // Check for allowed moves
        if(start.get_x()- finish.get_x() == 0 || start.get_y()- finish.get_y() == 0){
          //Move up or down
          if(start.get_x()- finish.get_x() == 0){
            int diff = Math.abs(finish.get_y() - start.get_y());
            int a = 0;
            for (int i=1; i <= diff; i++){
              a = i;
              if(start.get_y() < finish.get_y()){
                a *= -1;
              }
              if(board.getSquare(start.get_x(), (start.get_y()-a)).getPiece() != null){
                if(i == diff){
                  return true;
                }
                System.out.println("Ei sallittu");
                return false;
              }
            }
          //Move left or right
          }else{
            int diff = Math.abs(finish.get_x() - start.get_x());
            int a = 0;
            for (int i=1; i <= diff; i++){
              a = i;
              if(start.get_x() < finish.get_x()){
                a *= -1;
              }
              if(board.getSquare((start.get_x()-a), start.get_y()).getPiece() != null){
                if(i == diff){
                  return true;
                }
                System.out.println("Ei sallittu");
                return false;
              }
            }
          }
          return true;
        }
    return false;
  }
}

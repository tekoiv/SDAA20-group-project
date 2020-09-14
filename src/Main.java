import Game.Game;
import Game.Controller;
import Graphical.GUI;

import javax.swing.*;

public class Main {
  // Init board + start game
  public static void main(String[] args) {
    Runnable r = () -> {
      Game game = new Game();
      Controller controller = new Controller(game);
      GUI chessBoardGUI = new GUI(controller);

      JFrame frame = new JFrame("JavaChess");
      frame.add(chessBoardGUI.initializeBoard());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationByPlatform(true);
      frame.pack();
      frame.setMinimumSize(frame.getSize());
      frame.setVisible(true);
    };
    SwingUtilities.invokeLater(r);
  }
}
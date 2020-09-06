package Graphical;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GUI {

  // Buttons
  private final JButton[][] chessBoardSquares = new JButton[8][8];
  // Sprites
  private Image[][] chessSprites = new Image[2][6];
  // Piece variables
  private final int QUEEN = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
  private final int[] STARTING_ROW = {
          ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
  };
  private final int BLACK = 0, WHITE = 1;


  public GUI() {
  }

  private Image[][] fetchSprites() {
    final int SPRITE_SIZE = 64;
    chessSprites = new Image[2][6];

    try {
      BufferedImage bi = ImageIO.read(new URL("http://i.stack.imgur.com/memI0.png"));
      for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 6; j++) {
          chessSprites[i][j] = bi.getSubimage(j * SPRITE_SIZE, i * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return chessSprites;
  }

  public JPanel initializeBoard() {
    // Base
    JPanel boardPanel = new JPanel(new BorderLayout(3, 3));
    boardPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    // Toolbar
    JToolBar toolbar = new JToolBar();
    toolbar.setFloatable(false);
    // Actual chessboard layout
    JPanel chessBoard = new JPanel(new GridLayout(0, 9));
    chessBoard.setBorder(new LineBorder(Color.BLACK));
    // Sticking these together
    boardPanel.add(toolbar, BorderLayout.PAGE_START);
    boardPanel.add(chessBoard);
    // Button for starting the game
    Action startGameButton = new AbstractAction("Start game") {
      @Override
      public void actionPerformed(ActionEvent e) {
        initialIcons();
      }
    };
    toolbar.add(startGameButton);

    // Add squares to the board
    Insets buttonMargin = new Insets(0, 0, 0, 0);

    for(int i = 0; i < chessBoardSquares.length; i++) {
      for (int j = 0; j < chessBoardSquares[i].length; j++) {

        JButton square = new JButton();
        square.setMargin(buttonMargin);

        ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        square.setIcon(icon);

        if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
          square.setBackground(Color.WHITE);
        } else {
          square.setBackground(Color.BLACK);
        }

        chessBoardSquares[j][i] = square;

        square.addActionListener(e -> {
          // Square action listeners
        });
      }
    }

    // Setting the letters row
    String letters = "ABCDEFGH";
    chessBoard.add(new JLabel(""));
    for(int i = 0; i < 8; i++) {
      chessBoard.add(new JLabel(letters.substring(i, i+1), SwingConstants.CENTER));
    }

    // Setting the chessboard squares and the number column
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        if (j == 0) {
          chessBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
        }

        chessBoard.add(chessBoardSquares[j][i]);
      }
    }

    return boardPanel;
  }

  private void initialIcons() {
    Image[][] chessPieceSprites = fetchSprites();

    // Non-pawns
    for (int i = 0; i < STARTING_ROW.length; i++) {
      chessBoardSquares[i][0].setIcon(new ImageIcon(chessPieceSprites[BLACK][STARTING_ROW[i]]));
      chessBoardSquares[i][7].setIcon(new ImageIcon(chessPieceSprites[WHITE][STARTING_ROW[i]]));
    }
    // Pawns
    for(int i = 0; i < STARTING_ROW.length; i++) {
      chessBoardSquares[i][1].setIcon(new ImageIcon(chessPieceSprites[BLACK][PAWN]));
      chessBoardSquares[i][6].setIcon(new ImageIcon(chessPieceSprites[WHITE][PAWN]));
    }
    // Null others
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        chessBoardSquares[j][i].setIcon(null);
      }
    }
  }
}

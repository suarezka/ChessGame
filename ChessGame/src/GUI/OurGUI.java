package GUI;

import gvprojects.chess.model.IChessModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/************************************************************
 * CIS 163-07
 * Chess Project
 * GUI For the chess game
 *
 * @author Kaye Suarez
 * @author DaiLynn Dietz
 * @version Mar 15, 2014
 ************************************************************/
public class OurGUI implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JButton[][] chessBoard;
	private JLabel status;
	IChessModel game;
	
	private static final int IMAGE_SIZE = 64;
	
	//Images for black pieces
	private ImageIcon b_Rook = loadIcon("images\\b_rook.png");
	private ImageIcon b_Knight = loadIcon("images\\b_knight.png");
	private ImageIcon b_Bish = loadIcon("images\\b_bish.png");
	private ImageIcon b_Queen = loadIcon("images\\b_queen.png");
	private ImageIcon b_King = loadIcon("images\\b_king.png");
	private ImageIcon b_Pawn = loadIcon("images\\b_pawn.png");
	
	//Images for white pieces
	private ImageIcon w_Rook = loadIcon("images\\w_rook.png");
	private ImageIcon w_Knight = loadIcon("images\\w_knight.png");
	private ImageIcon w_Bish = loadIcon("images\\w_bish.png");
	private ImageIcon w_Queen = loadIcon("images\\w_queen.png");
	private ImageIcon w_King = loadIcon("images\\w_king.png");
	private ImageIcon w_Pawn = loadIcon("images\\w_pawn.png");
	
	
	public OurGUI() {
		frame = new JFrame();
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(8,8));
		chessBoard = new JButton[8][8];
		
		for (int k = 0; k < chessBoard.length; k++) {
			for (int m = 0; m < chessBoard[k].length; m++) {
				chessBoard[k][m] = new JButton();
				chessBoard[k][m].setPreferredSize(new Dimension(IMAGE_SIZE + 5, IMAGE_SIZE + 5));
				chessBoard[k][m].addActionListener(this);
				if ((k + m) % 2 == 0) {
					chessBoard[k][m].setBackground(new Color(120, 40, 84));
				} else {
					chessBoard[k][m].setBackground(new Color(200, 200, 50));
				}
				panel.add(chessBoard[k][m]);
			}
		}
		
		setPieces(chessBoard);
		game = new ChessModel();
		
		frame.add(panel, BorderLayout.CENTER);
		status = new JLabel("Welcome! Let's play CHESS!");
		frame.add(status, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void setPieces(JButton[][] board) {
		
		//Set black pieces
		chessBoard[0][0].setIcon(b_Rook);
		chessBoard[0][1].setIcon(b_Knight);
		chessBoard[0][2].setIcon(b_Bish);
		chessBoard[0][3].setIcon(b_Queen);
		chessBoard[0][4].setIcon(b_King);
		chessBoard[0][5].setIcon(b_Bish);
		chessBoard[0][6].setIcon(b_Knight);
		chessBoard[0][7].setIcon(b_Rook);
		chessBoard[1][0].setIcon(b_Pawn);
		chessBoard[1][1].setIcon(b_Pawn);
		chessBoard[1][2].setIcon(b_Pawn);
		chessBoard[1][3].setIcon(b_Pawn);
		chessBoard[1][4].setIcon(b_Pawn);
		chessBoard[1][5].setIcon(b_Pawn);
		chessBoard[1][6].setIcon(b_Pawn);
		chessBoard[1][7].setIcon(b_Pawn);
		
		//Set white pieces
		chessBoard[7][0].setIcon(w_Rook);
		chessBoard[7][1].setIcon(w_Knight);
		chessBoard[7][2].setIcon(w_Bish);
		chessBoard[7][3].setIcon(w_Queen);
		chessBoard[7][4].setIcon(w_King);
		chessBoard[7][5].setIcon(w_Bish);
		chessBoard[7][6].setIcon(w_Knight);
		chessBoard[7][7].setIcon(w_Rook);
		chessBoard[6][0].setIcon(w_Pawn);
		chessBoard[6][1].setIcon(w_Pawn);
		chessBoard[6][2].setIcon(w_Pawn);
		chessBoard[6][3].setIcon(w_Pawn);
		chessBoard[6][4].setIcon(w_Pawn);
		chessBoard[6][5].setIcon(w_Pawn);
		chessBoard[6][6].setIcon(w_Pawn);
		chessBoard[6][7].setIcon(w_Pawn);
	}
	
	public static void main(String[] args) {
		new OurGUI();
	}
	

	
	/****************************************************************
     * Static method to load the ImageIcon from the given location.
     *
     * TODO you might not need this
     *
     * @param name Name of the file.
     * @return the requested image.
     ***************************************************************/
    public static ImageIcon loadIcon(String name) {
    	java.net.URL imgURL = ChessGUI.class.getResource(name);
    	if (imgURL == null) {
    		throw new RuntimeException("Icon resource not found.");
    	}

    	ImageIcon icon = new ImageIcon(imgURL);
    	Image img = icon.getImage();
    	Image resize = img.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, 
    			Image.SCALE_AREA_AVERAGING);
    	
    	return new ImageIcon(resize);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

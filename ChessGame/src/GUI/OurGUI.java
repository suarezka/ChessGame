package GUI;

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
	
	private static final int IMAGE_SIZE = 64;
	
	//Images for black pieces
	private ImageIcon w_Bish = loadIcon("images\\w_bish.png");
	
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
		
		frame.add(panel, BorderLayout.CENTER);
		status = new JLabel("Welcome! Let's play CHESS!");
		frame.add(status, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.GVTile.ImageType;


public class ChessGUI implements ActionListener {
	private JFrame top;
	private JButton[][] chessBoard;
	private int firstRow, firstCol, secondRow, secondCol;
	private JLabel status;

	private ImageIcon bBish = loadIcon("images\\b_bish.png");

	public ChessGUI()
	{
		firstRow = firstCol = -1;
		top = new JFrame();
		JPanel pan = new JPanel();

		pan.setLayout(new GridLayout(8, 8));
		chessBoard = new JButton[8][8];
		for (int k = 0; k < chessBoard.length; k++)
			for (int m = 0; m < chessBoard[k].length; m++)
			{
				chessBoard[k][m] = new JButton();
				chessBoard[k][m].addActionListener(this);
				chessBoard[k][m].setIcon(bBish);
				pan.add(chessBoard[k][m]);
			}

		top.add(pan, BorderLayout.CENTER);
		status = new JLabel(" Hi ");
		top.add (status, BorderLayout.SOUTH);
		top.pack();
		top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		top.setVisible(true);
	}

	public static void main(String[] args) {
		new ChessGUI();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object which = ae.getSource();
		for (int k = 0; k < chessBoard.length; k++)
		{
			for (int m = 0; m < chessBoard[k].length; m++)
			{
				if (which == chessBoard[k][m]) {
					if (firstCol == -1) {
						firstRow = k;
						firstCol = m;
						status.setText(String.format ("Move from (%d,%d) to?",
								firstRow, firstCol));
					}
					else {
						secondRow = k;
						secondCol = m;
						status.setText(String.format ("(%d,%d) ==> (%d,%d)",
								firstRow, firstCol, secondRow, secondCol));
					}
				}
			}
		}
	}

	/****************************************************************
	 * Static method to load the ImageIcon from the given location.
	 *
	 * @param name Name of the file.
	 * @return the requested image.
	 ***************************************************************/
	public static ImageIcon loadIcon(String name) {
		java.net.URL imgURL = ChessGUI.class.getResource(name);
		if (imgURL == null) {
			throw new RuntimeException("Icon resource not found.");
		}

		return new ImageIcon(imgURL);
	}
}

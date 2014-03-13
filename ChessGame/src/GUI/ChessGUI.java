package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.GVTile.ImageType;


public class ChessGUI implements ActionListener {
    private JFrame top;
    private GVTile[][] chessBoard;
    private int firstRow, firstCol, secondRow, secondCol;
    private JLabel status;
    //private HansButton doit;
    
    public ChessGUI()
    {
        firstRow = firstCol = -1;
        top = new JFrame();
        JPanel pan = new JPanel();
        top.add(pan, BorderLayout.CENTER);
        
        //doit = new HansButton("Hello");
        //top.add(doit, BorderLayout.NORTH);
        pan.setLayout(new GridLayout(8, 8));
        chessBoard = new GVTile[8][8];
        for (int k = 0; k < chessBoard.length; k++)
            for (int m = 0; m < chessBoard[k].length; m++)
            {
                chessBoard[k][m] = new GVTile((k + m) % 2 == 0 ? true : false);
                pan.add(chessBoard[k][m]);
                chessBoard[k][m].addActionListener(this);
               // chessBoard[k][m].setBackground(Color.yellow);
                //chessBoard[k][m].showImage(ImageType.BISHOP);
                if (k == m)
                    chessBoard[k][m].showImage (GVTile.ImageType.BISHOP, true);
            }
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
                        BufferedImage img = chessBoard[firstRow][firstCol].getImage();
                        chessBoard[firstRow][firstCol].setImage(null);
                        chessBoard[secondRow][secondCol].setImage(img);
                        firstRow = firstCol = -1;
                    }
                }
            }
        }
    }
}
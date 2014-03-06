package project3;

/************
 * Class that controls the Rook chess piece.
 * 
 * @author Dailynn Dietz and Kaye Suarez
 * @version 2/18/14
 ************/

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Feb 26, 2014
 ************************************************************/
public class Rook extends ChessPiece {

	/************************************************************
	 * Constructor for the rook class
	 * 
	 * @param p Player to be owning this rook
	 ************************************************************/
	protected Rook(Player p) {
		super(p);
	}

	/************************************************************
	 * Returns the type of this piece, "Rook"
	 *  
	 * @return  String word that describes type of piece (rook)
	 ************************************************************/
	@Override
	public String type() {
		return "Rook";
	}
	
	/************************************************************
	 * Determines if a rook can make the desired move
	 * 
	 * @param move Move desired to be made by rook
	 * @return  True if is valid move
	 ************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board){
			
			//Getting move data for Rook piece
			int fromC = move.fromColumn;
			int fromR = move.fromRow;
			int toC = move.toColumn;
			int toR = move.toRow;
			
			//Parent isValidMove method
			super.isValidMove(move, board);
			
			//Check if move is either front/back or side to side
			if (fromC != toC || fromR != toR) {
				return false;
			}
			
			//Check if other pieces in path going right
			if (fromR == toR && fromC < toC) {
				//Loop through path to see if piece is in the way
				while (fromC <= toC) {
					if (board[fromC][fromR] != null) {
						return false;
					}
					fromC++;
				}
			}
			
			
			return true;
		}
}

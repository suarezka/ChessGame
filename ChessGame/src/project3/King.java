package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project 
 * Controls behavior of the king Piece
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class King extends ChessPiece {

	/************************************************************
	 * Constructor for the King Class
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	protected King(Player p) {
		super(p);
	}

	/************************************************************
	 * Returns that this piece is a king
	 * 
	 * @return  Returns word king in string form
	 ************************************************************/
	@Override
	public String type() {
		return "King";
	}
	
	/************************************************************
	 * Returns if this is a valid move for a king or not
	 * 
	 * @param move Desired move
	 * @param board Board being played on
	 * @return  True if is a valid move
	 ************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board){
		
		//Consulting parent class
		if(!super.isValidMove(move, board)){
			return false;
		}
		
		//Getting move data for King piece
		int fromC = move.fromColumn;
		int fromR = move.fromRow;
		int toC = move.toColumn;
		int toR = move.toRow;
		
		//TODO: Decide if this method is better or other ones
		
		//Coordinates for possible moves by a king object
		final int[] MOVE_ROW = {-1, -1, 0, 1, 1, 1, 0, -1};
		final int[] MOVE_COL = {0, 1, 1, 1, 0, -1, -1, -1};
		
		//Checks only possible moves for match with desired move
		//Returns true if all previous conditions met as well as this
		for(int k = 0; k < MOVE_ROW.length; k++){
			if(fromR + MOVE_ROW[k] == toR && fromC + MOVE_COL[k] == toC){
				return true;
			}
		}
		
		//Checks if one space up or down
		if (toR != fromR - 1 || toR != fromR + 1) {
			return false;
		}
		
		//Checks if one space left or right
		if (toC != fromC + 1 || toC != fromC - 1) {
			return false;
		}
		
		//Checks if one space diagonal up
		if (toR != fromR - 1 && (toC != fromC - 1 || toC != fromC + 1)) {
			return false;
		}
		
		//Checks if one space diagonal down
		if (toR != fromR + 1 && (toC != fromC - 1 || toC != fromC + 1)) {
			return false;
		}
		
		//Checks if horizontal and vertical path is clear
		if (!isPathClear(fromR, fromC, toR, toC, board)) {
			return false;
		}
		
		//Checks if diagonal path is clear
		if (!isPathClearDiagonal(fromR, fromC, toR, toC, board)) {
			return false;
		}
		
		return true;
	}

}

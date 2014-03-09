package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project
 * Class to handle the behavior of a pawn
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class Pawn extends ChessPiece {

	/************************************************************
	 * Constructor for Pawn Class
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	protected Pawn(Player p) {
		super(p);
	}

	/************************************************************
	 * Returns the piece type, pawn
	 * 
	 * @return  Returns "Pawn"
	 ************************************************************/
	@Override
	public String type() {
		return "Pawn";
	}
	
	/************************************************************
	 * Returns if is a valid move for a pawn
	 * 
	 * @param move Desired move
	 * @param board Board being played on
	 * @return  True if is a valid move for a pawn
	 ************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board){
		
		//Consulting parent class
		if(!super.isValidMove(move, board)){
			return false;
		}
		
		
		return true;
	}

}

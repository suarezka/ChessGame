package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project 
 * Controls behavior of the Bishop Piece
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class Bishop extends ChessPiece {

	/************************************************************
	 * Constructor for the Bishop Class
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	protected Bishop(Player p) {
		super(p);
	}

	/************************************************************
	 * Returns that this piece is a Bishop
	 * 
	 * @return  Returns word Bishop in string form
	 ************************************************************/
	@Override
	public String type() {
		return "Bishop";
	}
	
	/************************************************************
	 * Returns if this is a valid move for a Bishop or not
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
		
		return true;
	}

}

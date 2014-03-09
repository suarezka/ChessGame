package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project
 * Class to handle the behavior for the Queen Chess Piece
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class Queen extends ChessPiece{

	/************************************************************
	 * Constructor for the Queen class
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	protected Queen(Player p) {
		super(p);
	}

	/************************************************************
	 * Returns the type of piece this is, which is Queen
	 * 
	 * @return  Returns "Queen"
	 ************************************************************/
	@Override
	public String type() {
		return "Queen";
	}
	
	/************************************************************
	 * Returns whether or not a move is valid for the queen piece
	 * 
	 * @param move Desired move
	 * @param board Board played on
	 * @return  True if the move is valid for a queen
	 ************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board){
	
		//Checking with parent class
		if(!super.isValidMove(move, board)){
			return false;
		}
		
		return true;
	}

}

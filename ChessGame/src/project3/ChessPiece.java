package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project
 * Parent class to all other chess piece classes
 *
 * @author Kaye Suarez
 * @author DaiLynn Dietz
 * @version Feb 24, 2014
 ************************************************************/
public abstract class ChessPiece implements IChessPiece {
	
	/** Owner of the ChessPiece */
	private Player owner;
	
	/************************************************************
	 * Constructor for ChessPiece
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	protected ChessPiece (Player p) {
		owner = p;
	}
	
	/************************************************************
	 * Abstract method that determines if a move is valid or not
	 * for the most general case
	 * 
	 * @param move The move to be taken by the piece
	 * @param board The game board occupied with chess pieces
	 * @return  true if move is valid
	 ************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		
		//Gathering move data
		int fromC = move.fromColumn;
		int fromR = move.fromRow;
		int toC = move.toColumn;
		int toR = move.toRow;
		
		//Makes sure a move is happening
		if(toC == fromC && toR == fromR)
			return false;
		
		//Checking if destination is occupied by same team
		if(board[toR][toC].player() == owner)
			return false;
		
		//Ensuring that the piece is at the from location
		if(board[fromR][fromC] != this)
			return false;
		
		return true;
	}

	/************************************************************
	 * Returns the current owner of the piece in question
	 * 
	 * @return  Owner team of the ChessPiece
	 ************************************************************/
	@Override
	public Player player() {
		return owner;
	}

	/************************************************************
	 * Abstract method that returns the type of piece made
	 * 
	 * @return  Type of piece (rook, bishop, king etc)
	 ************************************************************/
	@Override
	public abstract String type();

}

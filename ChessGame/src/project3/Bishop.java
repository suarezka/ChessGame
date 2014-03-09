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

		//Getting move data for Rook piece
		int fromC = move.fromColumn;
		int fromR = move.fromRow;
		int toC = move.toColumn;
		int toR = move.toRow;


		//makes sure its a true diagonal path
		if(Math.abs(fromC - toC) != Math.abs(fromR - toR)){
			return false;
		}

		return true;
	}

	/************************************************************
	 * Helper method to allow queen to use same logic as bishop
	 * 
	 * @param fromR Starting row
	 * @param fromC Starting column
	 * @param toR ending row
	 * @param toC ending column
	 * @param board Board being played on
	 * @return  True if path between points is clear
	 ************************************************************/
	public static boolean isPathClear(int fromR, int fromC, int toR,
			int toC, IChessPiece[][] board){
		//TODO: Make this work in two directions and add to queen class
		return true;
	}

}

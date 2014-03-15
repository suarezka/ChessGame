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
	public King(Player p) {
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

		//Disallows moving into a check position
		if(isInCheck(toR, toC, board)){
			return false;
		}

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

		return false;
	}

	/************************************************************
	 * Returns true when the king is in check
	 * 
	 * @param row Row of the king
	 * @param col Column of the king
	 * @param board Board being played on
	 * @return  True when the king is in check
	 ************************************************************/
	public boolean isInCheck(int row, int col, IChessPiece[][] board){

		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[0].length; c++){
				if(board[r][c] != null && board[r][c].player() != this.player()){
					Move move = new Move(r, c, row, col);
					if(board[r][c].isValidMove(move, board)){
						return true;
					}
				}
			}
		}

		return false;
	}

}

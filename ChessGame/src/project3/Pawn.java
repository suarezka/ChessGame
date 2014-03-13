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
		
		int fromC = move.fromColumn;
		int fromR = move.fromRow;
		int toC = move.toColumn;
		int toR = move.toRow;
		
		final int WHITE_START = 6;
		final int BLACK_START = 1;
			
		//Checking if is starting from colors starting row
		if((fromR == WHITE_START && player() == Player.WHITE) || 
				(fromR == BLACK_START && player() == Player.BLACK)){
			
			//Seeing if move is bigger than two squares
			if(Math.abs(fromR - toR) > 2){
				return false;
			}
		}else{

			//Checking if move is bigger than one square 
			//for not first moves
			if(Math.abs(fromR - toR) > 1){
				return false;
			}
		}
		
		if(Math.abs(fromC - toC) > 1 ){
			return false;
		}
		
		//Capture stuff
		if(Math.abs(fromC - toC) > 0 && board[toR][toC].player() != 
				this.player().next()){
			return false;
		}
		
		//Doesnt allow double more no row movement when attacking
		if(Math.abs(fromC - toC) > 0 && Math.abs(fromR - toR) != 1){
			return false;
		}
		
		if(Player.WHITE == player() && fromR - toR < 0){
			return false;
		}
		
		if(Player.BLACK == player() && fromR - toR > 0){
			return false;
		}
		
		return true;
	}

}

